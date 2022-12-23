package Cobacoba;

import java.io.*;
import java.util.*;
import java.text.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.*;
import org.apache.poi.xslf.usermodel.*;

public class Project_Alpro {

    public static void main(String[] args) throws IOException {
        Scanner ketik = new Scanner(System.in);
        System.out.print("Lokasi : ");
        String lokasi = ketik.nextLine();           // input lokasi directory
        System.out.print("Kata kunci = ");
        String kunci = ketik.nextLine();            // input kata kunci yang akan dicari
        cek_folder(lokasi, kunci);                     // panggil method pengecekan directory
    }

    private static void cek_folder(String lokasi, String kunci) throws IOException {
        if ((new File(lokasi)).isDirectory()) {             // cek apakah lokasi yang diinput merupakan directory
            File folder = new File(lokasi);                 // deklarasi seluruh isi directory

            for (File fileEntry : folder.listFiles()) {             // looping baca seluruh file dalam direcotry

                if (fileEntry.getName().endsWith(".docx")) {               // cek apakah file merupakan word (docx)
                    cek_word(fileEntry, kunci);                                  // jika iya, panggil method pengecekan word

                } else if (fileEntry.getName().endsWith(".xlsx")) {        // cek apakah file merupakan excel (xlsx)
                    cek_excel(fileEntry, kunci);                                 // jika iya, panggil method pengecekan excel

                } else if (fileEntry.getName().endsWith(".pptx")) {        // cek apakah file merupakan ppt (pptx)
                    cek_ppt(fileEntry, kunci);                                   // jika iya, panggil method pengecekan ppt

                } else if (fileEntry.isDirectory()) {                            // cek apakah file yang diinput merupakan directory (folder)
                    cek_folder(fileEntry.getPath(), kunci);                // jika iya, panggil kembali method pengecekan directory (rekursif method)
                }
            }
        }
    }

    private static void cek_word(File fileEntry, String kunci) throws FileNotFoundException, IOException {
        boolean cek = true;
        FileInputStream fis = new FileInputStream(fileEntry);               // membaca data file
        XWPFDocument docx = new XWPFDocument(fis);                           // membaca file sebagai word docx

        for (XWPFParagraph p : docx.getParagraphs()) {          // looping baca paragraf dalam file
            List<XWPFRun> runs = p.getRuns();                   // menyimpan daftar baris/objek dari paragraf
            if (runs != null) {                         // cek apakah baris/objek kosong

                for (XWPFRun r : runs) {                // looping baca baris tiap paragraf
                    String text = r.getText(0);             // mengambil str kalimat dari baris paragraf
                    if (text != null && text.toLowerCase().contains(kunci)) {             // cek apakah kalimat mengandung kata kunci
                        System.out.println(fileEntry);                                    // print lokasi dan nama file apabila valid
                        cek = false;
                        break;
                    }
                }

                if (cek == false) {                         // pengecekan file berhenti apabila kata kunci sudah ditemukan
                    break;
                }
            }
        }
    }

    private static void cek_excel(File fileEntry, String kunci) throws FileNotFoundException, IOException {
        boolean cek = true;
        String pattern = "MM/dd/yyyy HH:mm:ss";                 // format tanggal dalam bentuk string
        DateFormat df = new SimpleDateFormat(pattern);          // deklarasi format tanggal baru

        Workbook workbook = new XSSFWorkbook(new FileInputStream(fileEntry));       // membaca data file sebagai excel

        Sheet sheet = workbook.getSheetAt(0);           // membaca data excel pada sheet pertama

        for (Row row : sheet) {                 // looping baca tiap baris
            for (Cell cell : row) {             // looping baca tiap cell per baris
                String path = null;             // deklarasi

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

                    if (path != null && path.toLowerCase().contains(kunci)) {       // cek apakah string mengandung kata kunci
                        System.out.println(fileEntry);                              // print lokasi dan nama file apabila valid
                        cek = false;
                        break;
                    }
                }
            }
            if (cek == false) {                         // pengecekan file berhenti apabila kata kunci sudah ditemukan
                break;
            }
        }
    }

    private static void cek_ppt(File fileEntry, String kunci) throws FileNotFoundException, IOException {
        boolean cek = true;

        XMLSlideShow ppt = new XMLSlideShow(new FileInputStream(fileEntry));        // membaca data file sebagai ppt

        List<XSLFSlide> slides = ppt.getSlides();               // menyimpan daftar slide dari ppt

        for (XSLFSlide slide : slides) {                        // looping baca tiap slides

            List<XSLFShape> shapes = slide.getShapes();         // mentimpan daftar shape dalam ppt

            for (XSLFShape shape : shapes) {                     // looping baca tiap shapes
                // cek apakah shape merupakan kotak teks dan mengandung kata kunci di dalamnya
                if (shape instanceof XSLFTextShape textShape && textShape.getText().toLowerCase().contains(kunci)) {
                    System.out.println(fileEntry);              // print lokasi dan nama file apabila valid
                    cek = false;
                    break;
                }
            }
            if (cek == false) {                         // pengecekan file berhenti apabila kata kunci sudah ditemukan
                break;
            }
        }
    }
}
