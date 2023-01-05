package MainProgram;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import javax.swing.filechooser.FileSystemView;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFShape;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFTextParagraph;
import org.apache.poi.xslf.usermodel.XSLFTextRun;
import org.apache.poi.xslf.usermodel.XSLFTextShape;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class TesSaja {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner input = new Scanner(System.in);
        ArrayList<ArrayList<Object>> array_hasil = new ArrayList<>();

        ArrayList<Object> arrStr = new ArrayList<>();
//        String kunci = input.nextLine();

//        File file = new File("D:/Tugas Kuliah/Religion/Keberagaman Internal - Agama Buddha.docx");
//        FileInputStream fis = new FileInputStream(file);               // membaca data file
//        XWPFDocument docx = new XWPFDocument(fis);                           // membaca file sebagai word docx
//        int baris = 1;
//        boolean ada = false;
//
//        for (XWPFParagraph p : docx.getParagraphs()) {          // looping baca paragraf dalam file
//            List<XWPFRun> runs = p.getRuns();                   // menyimpan daftar baris/objek dari paragraf
//            if (runs != null) {                         // cek apakah baris/objek kosong
//                StringBuilder builder = new StringBuilder();
//                for (XWPFRun value : runs) {
//                    builder.append(value);
//                }
//                String text = builder.toString().stripIndent();
//
//                if (text.toLowerCase().contains(kunci)) {             // cek apakah kalimat mengandung kata kunci
//                    String textBaris = new StringBuilder().append("[Baris ").append(baris).append("] ").append(text).toString();
//                    arrStr.add(textBaris);
//                    ada = true;
//                }
//
//            }
//            baris++;
//        }
//        if (ada) {
//            array_hasil.add(arrStr);
        array_hasil.add(new ArrayList<>());
        array_hasil.add(new ArrayList<>());
        array_hasil.add(new ArrayList<>());
        array_hasil.add(new ArrayList<>());
        array_hasil.add(new ArrayList<>());
        array_hasil.add(new ArrayList<>());
        
//            array_hasil.get(0).add(file.getName());
//            array_hasil.get(0).add(file.getAbsolutePath());

//            for (Object str : array_hasil.get(1)) {
//                System.out.println(str + "\n");
//            }
        array_hasil.get(0).add(Arrays.asList("a", "b", "c", "d", "e"));
        array_hasil.get(1).add(Arrays.asList("1", "2", "3", "4", "5"));
        array_hasil.get(2).add(Arrays.asList("q", "w", "e", "r", "t"));
        array_hasil.get(3).add(Arrays.asList("z", "x", "c", "v", "b"));
        array_hasil.get(4).add(Arrays.asList("y", "u", "i", "o", "p"));
        array_hasil.get(5).add(Arrays.asList("h", "a", "p", "p", "y"));

        for (int i = 0; i < array_hasil.size(); i++) {
            System.out.println(array_hasil.size());
            System.out.println(array_hasil.get(i) + " ");
            array_hasil.remove(i + 1);
        }
//            String [] arr = array_hasil.get(0).get(2).toString().;
//            System.out.println(array_hasil.get(0).get(2));

//        System.out.println(String.join("\n", array_hasil.get(0).get(1).toArray(new String[0])));
//        System.out.println(array_hasil.get(0).get(3));
//        String pattern = "MM/dd/yyyy HH:mm:ss";                 // format tanggal dalam bentuk string
//        DateFormat df = new SimpleDateFormat(pattern);          // deklarasi format tanggal baru
//
//        Workbook workbook = new XSSFWorkbook(new FileInputStream("D:\\Tugas Kuliah\\Alpro\\Time Schedule Alpro.xlsx"));       // membaca data file sebagai excel
//
//        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
//            Sheet sheet = workbook.getSheetAt(i);           // membaca data excel pada sheet index ke-i
//            int baris = 1;
//
//            for (Row row : sheet) {                 // looping baca tiap baris
////                String textBaris = "";
//                for (Cell cell : row) {             // looping baca tiap cell per baris
//                    if (cell.toString().toLowerCase().contains(kunci)) {
//                        int index = cell.getColumnIndex();
//                        String text = ((cell.getRowIndex() + 1) + "." + CellReference.convertNumToColString(index));
//                        String textBaris = new StringBuilder().append("[").append(text).append("] ").append(cell.toString()).toString();
//                        System.out.println(textBaris);
//                    }
//                }
//                baris++;
//            }
//        }
//        XMLSlideShow ppt = new XMLSlideShow(new FileInputStream("D:\\Tugas Kuliah\\Arsikom\\tugas klmpok3.pptx"));        // membaca data file sebagai ppt
//        List<XSLFSlide> slides = ppt.getSlides();               // menyimpan daftar slide dari ppt
//        int baris = 1;
//
//        for (XSLFSlide slide : slides) {                        // looping baca tiap slides
//
//            List<XSLFShape> shapes = slide.getShapes();         // mentimpan daftar shape dalam ppt
////            String textBaris = "";
//            for (XSLFShape shape : shapes) {                     // looping baca tiap shapes
//                // cek apakah shape merupakan kotak teks dan mengandung kata kunci di dalamnya
//                if (shape instanceof XSLFTextShape) {
//                    String textShape = ((XSLFTextShape) shape).getText().stripIndent();
//                    if (textShape.toLowerCase().contains(kunci.toLowerCase())) {
//                        System.out.println(slide.getSlideNumber()+" "+textShape);
//                    }
//                    
//                }
//            }
//            
//            baris++;
//        }
    }
}
