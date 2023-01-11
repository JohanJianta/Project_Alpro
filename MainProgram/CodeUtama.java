package MainProgram;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.text.*;
import javax.swing.ImageIcon;
import javax.swing.filechooser.FileSystemView;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.*;
import org.apache.poi.xslf.usermodel.*;

public class CodeUtama {

    ArrList_Data singletonData = ArrList_Data.getInstance();
    ArrList_Text singletonText = ArrList_Text.getInstance();

    public void cek_folder(String lokasi, String extension, String kunci, Boolean skip) throws IOException {

        File folder = new File(lokasi);                 // deklarasi seluruh isi directory

        for (File fileEntry : folder.listFiles()) {             // looping baca seluruh file dalam direcotry
            if (fileEntry.isHidden()) {
                continue;
            }
            switch (extension) {
                case "word":
                    if (fileEntry.getName().endsWith(".docx")) {
                        cek_word(fileEntry, kunci, skip);
                    } else if (fileEntry.isDirectory()) {
                        cek_folder(fileEntry.getPath(), extension, kunci, skip);
                    }
                    break;
                case "excel":
                    if (fileEntry.getName().endsWith(".xlsx")) {
                        cek_excel(fileEntry, kunci, skip);
                    } else if (fileEntry.isDirectory()) {
                        cek_folder(fileEntry.getPath(), extension, kunci, skip);
                    }
                    break;
                case "ppt":
                    if (fileEntry.getName().endsWith(".pptx")) {
                        cek_ppt(fileEntry, kunci, skip);
                    } else if (fileEntry.isDirectory()) {
                        cek_folder(fileEntry.getPath(), extension, kunci, skip);
                    }
                    break;
                case "text":
                    if (fileEntry.getName().endsWith(".txt")) {
                        cek_text(fileEntry, kunci, skip);
                    } else if (fileEntry.isDirectory()) {
                        cek_folder(fileEntry.getPath(), extension, kunci, skip);
                    }
                    break;
                case "pdf":
                    if (fileEntry.getName().endsWith(".pdf")) {
                        cek_pdf(fileEntry, kunci, skip);
                    } else if (fileEntry.isDirectory()) {
                        cek_folder(fileEntry.getPath(), extension, kunci, skip);
                    }
                    break;
                case "all":
                    if (fileEntry.getName().endsWith(".docx")) {
                        cek_word(fileEntry, kunci, skip);
                    } else if (fileEntry.getName().endsWith(".xlsx")) {
                        cek_excel(fileEntry, kunci, skip);
                    } else if (fileEntry.getName().endsWith(".pptx")) {
                        cek_ppt(fileEntry, kunci, skip);
                    } else if (fileEntry.getName().endsWith(".txt")) {
                        cek_text(fileEntry, kunci, skip);
                    } else if (fileEntry.getName().endsWith(".pdf")) {
                        cek_pdf(fileEntry, kunci, skip);
                    } else if (fileEntry.isDirectory()) {
                        cek_folder(fileEntry.getPath(), extension, kunci, skip);
                    }
                    break;
            }
        }
    }

    private void cek_word(File fileEntry, String kunci, Boolean skip) throws FileNotFoundException, IOException {

        if (!skip) {
            boolean ada = false;
            ArrayList<String> arrStr = new ArrayList<>();

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

                if (text.toLowerCase().contains(kunci)) {             // cek apakah kalimat mengandung kata kunci
                    String textBaris = new StringBuilder().append("[Paragraf ").append(baris).append("]\n").append(text).toString();
                    arrStr.add(textBaris);
                    ada = true;
                }
                baris++;
            }
            
            docx.close();

            if (ada) {
                addNewListData(fileEntry, arrStr);
            }

        } else {
            singletonData.addElement(fileEntry.getName(), fileEntry.getAbsolutePath(), (ImageIcon) FileSystemView.getFileSystemView().getSystemIcon(fileEntry));
        }
    }

    private void cek_excel(File fileEntry, String kunci, Boolean skip) throws FileNotFoundException, IOException {
        if (!skip) {
            boolean ada = false;
            String pattern = "MM/dd/yyyy HH:mm:ss";                 // format tanggal dalam bentuk string
            DateFormat df = new SimpleDateFormat(pattern);          // deklarasi format tanggal baru

            ArrayList<String> arrStr = new ArrayList<>();
            Workbook workbook = new XSSFWorkbook(new FileInputStream(fileEntry));       // membaca data file sebagai excel

            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                boolean hasBeenTrue = false;
                Sheet sheet = workbook.getSheetAt(i);           // membaca data excel pada sheet index ke-i

                for (Row row : sheet) {                 // looping baca tiap baris
                    for (Cell cell : row) {             // looping baca tiap cell per baris
                        if (cell.toString().toLowerCase().contains(kunci)) {
                            int index = cell.getColumnIndex();
                            String textBaris = new StringBuilder().append("[").append(cell.getRowIndex() + 1).append(".").append(CellReference.convertNumToColString(index)).append("] ").append(cell.toString().stripIndent()).toString();
                            if (!hasBeenTrue) {
                                textBaris = new StringBuilder().append("Sheet ").append(i + 1).append("\n").append(textBaris).toString();
                                hasBeenTrue = true;
                            }
                            arrStr.add(textBaris);
                            ada = true;
                        }
                    }
                }
            }
            
            workbook.close();

            if (ada) {
                addNewListData(fileEntry, arrStr);
            }

        } else {
            singletonData.addElement(fileEntry.getName(), fileEntry.getAbsolutePath(), (ImageIcon) FileSystemView.getFileSystemView().getSystemIcon(fileEntry));
        }
    }

    private void cek_ppt(File fileEntry, String kunci, Boolean skip) throws FileNotFoundException, IOException {
        if (!skip) {
            boolean ada = false;
            XMLSlideShow ppt = new XMLSlideShow(new FileInputStream(fileEntry));        // membaca data file sebagai ppt
            List<XSLFSlide> slides = ppt.getSlides();               // menyimpan daftar slide dari ppt
            ArrayList<String> arrStr = new ArrayList<>();

            for (XSLFSlide slide : slides) {                        // looping baca tiap slides
                boolean hasBeenTrue = false;

                List<XSLFShape> shapes = slide.getShapes();         // menyimpan daftar shape dari file ppt

                for (XSLFShape shape : shapes) {                     // looping baca tiap shapes
                    // cek apakah shape merupakan kotak teks dan mengandung kata kunci di dalamnya
                    if (shape instanceof XSLFTextShape) {
                        String textBaris = ((XSLFTextShape) shape).getText().stripIndent();
                        if (textBaris.toLowerCase().contains(kunci)) {
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
            
            ppt.close();

            if (ada) {
                addNewListData(fileEntry, arrStr);
            }

        } else {
            singletonData.addElement(fileEntry.getName(), fileEntry.getAbsolutePath(), (ImageIcon) FileSystemView.getFileSystemView().getSystemIcon(fileEntry));
        }
    }

    private void cek_text(File fileEntry, String kunci, Boolean skip) throws IOException {
        if (!skip) {
            boolean ada = false;
            ArrayList<String> arrStr = new ArrayList<>();
            List<String> lines = Files.readAllLines(Paths.get(fileEntry.getAbsolutePath()));

            int baris = 0;
            for (String line : lines) {
                baris++;
                if (!line.toLowerCase().contains(kunci)) {
                    continue;
                }
                String textBaris = new StringBuilder().append("[Baris ").append(baris).append("]\n").append(line).toString();
                arrStr.add(textBaris);
                ada = true;
            }

            if (ada) {
                addNewListData(fileEntry, arrStr);
            }

        } else {
            singletonData.addElement(fileEntry.getName(), fileEntry.getAbsolutePath(), (ImageIcon) FileSystemView.getFileSystemView().getSystemIcon(fileEntry));
        }
    }

    private void cek_pdf(File fileEntry, String kunci, Boolean skip) throws IOException {
        if (!skip) {
            boolean ada = false;
            ArrayList<String> arrStr = new ArrayList<>();
            PDDocument pdf = PDDocument.load(fileEntry);

            PDFTextStripper stripper = new PDFTextStripper();

            stripper.setStartPage(stripper.getStartPage());
            stripper.setEndPage(stripper.getEndPage());
            String text = stripper.getText(pdf);
            String[] lines = text.split("\\r?\\n");
            int baris = 0;

            for (String line : lines) {
                baris++;
                if (!line.toLowerCase().contains(kunci)) {
                    continue;
                }
                String textBaris = new StringBuilder().append("[Baris ").append(baris).append("]\n").append(line).toString();
                arrStr.add(textBaris);
                ada = true;
            }
            
            pdf.close();

            if (ada) {
                addNewListData(fileEntry, arrStr);
            }

        } else {
            singletonData.addElement(fileEntry.getName(), fileEntry.getAbsolutePath(), (ImageIcon) FileSystemView.getFileSystemView().getSystemIcon(fileEntry));
        }
    }

    private void addNewListData(File fileEntry, ArrayList<String> arrStr) {
        singletonData.addElement(fileEntry.getName(), fileEntry.getAbsolutePath(), (ImageIcon) FileSystemView.getFileSystemView().getSystemIcon(fileEntry));
        singletonText.addElement(arrStr);
    }
}
