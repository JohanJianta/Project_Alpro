package MainProgram;

import java.io.*;
import java.util.*;
import java.text.*;
import javax.swing.filechooser.FileSystemView;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.*;
import org.apache.poi.xslf.usermodel.*;

public class CodeUtama {

    public ArrayList<ArrayList<Object>> cek_folder(String lokasi, String extension, String kunci, ArrayList<ArrayList<Object>> array_hasil) throws IOException {
        if ((new File(lokasi)).isDirectory()) {             // cek apakah lokasi yang diinput merupakan directory
            File folder = new File(lokasi);                 // deklarasi seluruh isi directory

            for (File fileEntry : folder.listFiles()) {             // looping baca seluruh file dalam direcotry

                switch (extension) {
                    case "word":
                        if (fileEntry.getName().endsWith(".docx") && !fileEntry.isHidden()) {               // cek apakah file merupakan word (docx)
                            cek_word(fileEntry, kunci, array_hasil);
                        } else if (fileEntry.isDirectory()) {
                            cek_folder(fileEntry.getPath(), extension, kunci, array_hasil);
                        }
                        break;
                    case "excel":
                        if (fileEntry.getName().endsWith(".xlsx") && !fileEntry.isHidden()) {               // cek apakah file merupakan word (docx)
                            cek_excel(fileEntry, kunci, array_hasil);
                        } else if (fileEntry.isDirectory()) {
                            cek_folder(fileEntry.getPath(), extension, kunci, array_hasil);
                        }
                        break;
                    case "ppt":
                        if (fileEntry.getName().endsWith(".pptx") && !fileEntry.isHidden()) {               // cek apakah file merupakan word (docx)
                            cek_ppt(fileEntry, kunci, array_hasil);
                        } else if (fileEntry.isDirectory()) {
                            cek_folder(fileEntry.getPath(), extension, kunci, array_hasil);
                        }
                        break;
                    case "all":
                        if (fileEntry.getName().endsWith(".docx") && !fileEntry.isHidden()) {               // cek apakah file merupakan word (docx)
                            cek_word(fileEntry, kunci, array_hasil);
                        } else if (fileEntry.getName().endsWith(".xlsx") && !fileEntry.isHidden()) {               // cek apakah file merupakan word (docx)
                            cek_excel(fileEntry, kunci, array_hasil);
                        } else if (fileEntry.getName().endsWith(".pptx") && !fileEntry.isHidden()) {               // cek apakah file merupakan word (docx)
                            cek_ppt(fileEntry, kunci, array_hasil);
                        } else if (fileEntry.isDirectory()) {
                            cek_folder(fileEntry.getPath(), extension, kunci, array_hasil);
                        }
                        break;
                }
            }
        }
        return array_hasil;
    }

    private static ArrayList<ArrayList<Object>> cek_word(File fileEntry, String kunci, ArrayList<ArrayList<Object>> array_hasil) throws FileNotFoundException, IOException {
        boolean ada = false;
        ArrayList<Object> arrStr = new ArrayList<>();

        FileInputStream fis = new FileInputStream(fileEntry);               // membaca data file
        XWPFDocument docx = new XWPFDocument(fis);                           // membaca file sebagai word docx
        int baris = 1;

        for (XWPFParagraph p : docx.getParagraphs()) {          // looping baca paragraf dalam file
            List<XWPFRun> runs = p.getRuns();                   // menyimpan daftar baris/objek dari paragraf
            StringBuilder builder = new StringBuilder();
            for (XWPFRun value : runs) {
                builder.append(value);
            }
            String text = builder.toString().stripIndent();

            if (text.toLowerCase().contains(kunci) && !text.isBlank()) {             // cek apakah kalimat mengandung kata kunci
                String textBaris = new StringBuilder().append("[Baris ").append(baris).append("] ").append(text).toString();
                arrStr.add(textBaris);
                ada = true;
            }
            baris++;
        }

        if (ada) {
            addNewList(fileEntry, arrStr, array_hasil);
        }
        return array_hasil;
    }

    private static ArrayList<ArrayList<Object>> cek_excel(File fileEntry, String kunci, ArrayList<ArrayList<Object>> array_hasil) throws FileNotFoundException, IOException {
        boolean ada = false;

        String pattern = "MM/dd/yyyy HH:mm:ss";                 // format tanggal dalam bentuk string
        DateFormat df = new SimpleDateFormat(pattern);          // deklarasi format tanggal baru

        ArrayList<Object> arrStr = new ArrayList<>();
        Workbook workbook = new XSSFWorkbook(new FileInputStream(fileEntry));       // membaca data file sebagai excel

        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            boolean hasBeenTrue = false;
            Sheet sheet = workbook.getSheetAt(i);           // membaca data excel pada sheet index ke-i

            for (Row row : sheet) {                 // looping baca tiap baris
                for (Cell cell : row) {             // looping baca tiap cell per baris
                    if (cell.toString().toLowerCase().contains(kunci) && !cell.toString().isBlank()) {
                        int index = cell.getColumnIndex();
                        String textBaris = new StringBuilder().append("[").append(cell.getRowIndex() + 1).append(".").append(CellReference.convertNumToColString(index)).append("] ").append(cell.toString().stripIndent()).toString();
                        if (!hasBeenTrue) {
                            textBaris = new StringBuilder().append("Sheet ").append(i).append("\n").append(textBaris).toString();
                            hasBeenTrue = true;
                        }
                        arrStr.add(textBaris);
                        ada = true;
                    }

                }
            }
        }

        if (ada) {
            addNewList(fileEntry, arrStr, array_hasil);
        }

        return array_hasil;
    }

    private static ArrayList<ArrayList<Object>> cek_ppt(File fileEntry, String kunci, ArrayList<ArrayList<Object>> array_hasil) throws FileNotFoundException, IOException {
        boolean ada = false;

        XMLSlideShow ppt = new XMLSlideShow(new FileInputStream(fileEntry));        // membaca data file sebagai ppt
        List<XSLFSlide> slides = ppt.getSlides();               // menyimpan daftar slide dari ppt
        ArrayList<Object> arrStr = new ArrayList<>();

        for (XSLFSlide slide : slides) {                        // looping baca tiap slides
            boolean hasBeenTrue = false;

            List<XSLFShape> shapes = slide.getShapes();         // menyimpan daftar shape dari file ppt

            for (XSLFShape shape : shapes) {                     // looping baca tiap shapes
                // cek apakah shape merupakan kotak teks dan mengandung kata kunci di dalamnya
                if (shape instanceof XSLFTextShape) {
                    String textBaris = ((XSLFTextShape) shape).getText().stripIndent();
                    if (textBaris.toLowerCase().contains(kunci) && !textBaris.isBlank()) {
                        if (!hasBeenTrue) {
                            textBaris = new StringBuilder().append("[Slide ").append(slide.getSlideNumber()).append("]\n").append(textBaris).toString();
                            hasBeenTrue = true;
                        }
                        arrStr.add(textBaris);
                        ada = true;
                    }
                }
            }
        }
        if (ada) {
            addNewList(fileEntry, arrStr, array_hasil);
        }
        return array_hasil;
    }

    private static ArrayList<ArrayList<Object>> addNewList(File fileEntry, ArrayList<Object> arrStr, ArrayList<ArrayList<Object>> array_hasil) {
        array_hasil.add(arrStr);
        array_hasil.add(new ArrayList<>());
        array_hasil.get(0).set(0, (Integer) array_hasil.get(0).get(0) + 2);
        array_hasil.get((Integer) array_hasil.get(0).get(0)).add(fileEntry.getName());
        array_hasil.get((Integer) array_hasil.get(0).get(0)).add(FileSystemView.getFileSystemView().getSystemIcon(fileEntry));
        array_hasil.get((Integer) array_hasil.get(0).get(0)).add(fileEntry.getAbsolutePath());
        return array_hasil;
    }
}
