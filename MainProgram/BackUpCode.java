package MainProgram;

import UserInterface.JLabelItem;
import java.io.*;
import java.util.*;
import java.text.*;
import javax.swing.ImageIcon;
import javax.swing.filechooser.FileSystemView;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.*;
import org.apache.poi.xslf.usermodel.*;

public class BackUpCode {

    public static void main(String[] args) {
//        for (int i = 0; i < array_hasil.size(); i++) {
//            String text = (String) array_hasil.get(i).get(0);
//            ImageIcon icon = (ImageIcon) array_hasil.get(i).get(1);
//            listModel.addElement(new JLabelItem(text, icon));
//            i++;
//        }
//for (Object str : array_hasil.get(index+1)) {
//                textArea.setText((String)str+"\n");
//            }
    }

    public ArrayList<ArrayList<Object>> cek_folder(String lokasi, String extension, String kunci, ArrayList<ArrayList<Object>> array_hasil) throws IOException {
        if ((new File(lokasi)).isDirectory()) {             // cek apakah lokasi yang diinput merupakan directory
            File folder = new File(lokasi);                 // deklarasi seluruh isi directory

            for (File fileEntry : folder.listFiles()) {             // looping baca seluruh file dalam direcotry

                if (fileEntry.getName().endsWith(".docx") && "word".equals(extension) || fileEntry.getName().endsWith(".docx") && "all".equals(extension)) {               // cek apakah file merupakan word (docx)
                    cek_word(fileEntry, kunci, array_hasil);

                } else if (fileEntry.getName().endsWith(".xlsx") && "excel".equals(extension) || fileEntry.getName().endsWith(".xlsx") && "all".equals(extension)) {        // cek apakah file merupakan excel (xlsx)
                    cek_excel(fileEntry, kunci, array_hasil);

                } else if (fileEntry.getName().endsWith(".pptx") && "ppt".equals(extension) || fileEntry.getName().endsWith(".pptx") && "all".equals(extension)) {        // cek apakah file merupakan ppt (pptx)
                    cek_ppt(fileEntry, kunci, array_hasil);

                } else if (fileEntry.isDirectory()) {                            // cek apakah file yang diinput merupakan directory (folder)
                    cek_folder(fileEntry.getPath(), extension, kunci, array_hasil);
                }
            }
        }
        return array_hasil;
    }

    private static ArrayList<ArrayList<Object>> cek_word(File fileEntry, String kunci, ArrayList<ArrayList<Object>> array_hasil) throws FileNotFoundException, IOException {
        boolean cek = true;
        FileInputStream fis = new FileInputStream(fileEntry);               // membaca data file
        XWPFDocument docx = new XWPFDocument(fis);                           // membaca file sebagai word docx
        int baris = 1;

        for (XWPFParagraph p : docx.getParagraphs()) {          // looping baca paragraf dalam file
            List<XWPFRun> runs = p.getRuns();                   // menyimpan daftar baris/objek dari paragraf
            if (runs != null) {                         // cek apakah baris/objek kosong
                String textBaris = "";
                for (XWPFRun r : runs) {                // looping baca baris tiap paragraf
                    String text = r.getText(0);             // mengambil str kalimat dari baris paragraf
                    if (text != null && text.toLowerCase().contains(kunci)) {             // cek apakah kalimat mengandung kata kunci
                        cek = false;
                    }
                    textBaris = textBaris + " " + text;
                }

                if (!cek) {                         // pengecekan file berhenti apabila kata kunci sudah ditemukan
                    addNewList(fileEntry, baris, textBaris, array_hasil);
                    break;
                }
                baris++;
            }
        }
        return array_hasil;
    }

    private static ArrayList<ArrayList<Object>> cek_excel(File fileEntry, String kunci, ArrayList<ArrayList<Object>> array_hasil) throws FileNotFoundException, IOException {
        boolean cek = true;
        String pattern = "MM/dd/yyyy HH:mm:ss";                 // format tanggal dalam bentuk string
        DateFormat df = new SimpleDateFormat(pattern);          // deklarasi format tanggal baru

        Workbook workbook = new XSSFWorkbook(new FileInputStream(fileEntry));       // membaca data file sebagai excel

        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            Sheet sheet = workbook.getSheetAt(i);           // membaca data excel pada sheet index ke-i
            int baris = 1;

            for (Row row : sheet) {                 // looping baca tiap baris
                String textBaris = "";
                for (Cell cell : row) {             // looping baca tiap cell per baris
                    String path = null;             // deklarasi str

                    if (cell != null) {             // cek apakah cell bernilai null

                        switch (cell.getCellType()) {               // switch case menggunakan tipe cell
                            case STRING:
                                path = cell.getRichStringCellValue().getString();                 // inisialisasi path apabila cell bertipe string
                                break;

                            case NUMERIC:
                                if (DateUtil.isCellDateFormatted(cell)) {
                                    path = df.format(cell.getDateCellValue());                // inisialisasi path apabila cell bertipe tanggal (ubah format tanggal menjadi string)
                                } else {
                                    path = Double.toString(cell.getNumericCellValue());         // inisialisasi path apabila cell bertipe double
                                }
                                break;

                            case BOOLEAN:
                                path = String.valueOf(cell.getBooleanCellValue());              // inisialisasi path apabila cell bertipe boolean
                                break;

                            case FORMULA:
                                path = cell.getCellFormula();                                     // inisialisasi path apabila cell bertipe formula
                                break;
                        }

                        if (path != null) {
                            textBaris = textBaris + " " + path;
                            if (path.toLowerCase().contains(kunci)) {       // cek apakah string mengandung kata kunci
                                cek = false;
                            }
                        }
                    }
                }
                if (!cek) {                         // pengecekan file berhenti apabila kata kunci sudah ditemukan
                    addNewList(fileEntry, baris, textBaris, array_hasil);
                    break;
                }
                baris++;
            }
        }

        return array_hasil;
    }

    private static ArrayList<ArrayList<Object>> cek_ppt(File fileEntry, String kunci, ArrayList<ArrayList<Object>> array_hasil) throws FileNotFoundException, IOException {
        boolean cek = true;
        XMLSlideShow ppt = new XMLSlideShow(new FileInputStream(fileEntry));        // membaca data file sebagai ppt
        List<XSLFSlide> slides = ppt.getSlides();               // menyimpan daftar slide dari ppt
        int baris = 1;

        for (XSLFSlide slide : slides) {                        // looping baca tiap slides

            List<XSLFShape> shapes = slide.getShapes();         // mentimpan daftar shape dalam ppt
            String textBaris = "";

            for (XSLFShape shape : shapes) {                     // looping baca tiap shapes
                // cek apakah shape merupakan kotak teks dan mengandung kata kunci di dalamnya
                if (shape instanceof XSLFTextShape) {
                    String textShape = ((XSLFTextShape) shape).getText();
                    if (textShape.toLowerCase().contains(kunci)) {
                        cek = false;
                    }
                    textBaris = textBaris + " " + textShape;
                }
            }

            if (!cek) {                         // pengecekan file berhenti apabila kata kunci sudah ditemukan
                addNewList(fileEntry, baris, textBaris, array_hasil);
                break;
            }
            baris++;
        }
        return array_hasil;
    }

    private static ArrayList<ArrayList<Object>> addNewList(File fileEntry, int baris, String textBaris, ArrayList<ArrayList<Object>> array_hasil) {
        array_hasil.add(new ArrayList<>());
        array_hasil.get(0).set(0, (Integer) array_hasil.get(0).get(0) + 1);
        array_hasil.get((Integer) array_hasil.get(0).get(0)).add(fileEntry.getName());
        array_hasil.get((Integer) array_hasil.get(0).get(0)).add(FileSystemView.getFileSystemView().getSystemIcon(fileEntry));
        array_hasil.get((Integer) array_hasil.get(0).get(0)).add(fileEntry.getAbsolutePath());
        array_hasil.get((Integer) array_hasil.get(0).get(0)).add(baris);
        array_hasil.get((Integer) array_hasil.get(0).get(0)).add(textBaris);
        return array_hasil;
    }
}
