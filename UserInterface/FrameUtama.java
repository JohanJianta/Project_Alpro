package UserInterface;

import MainProgram.ArrList_Data;
import MainProgram.ArrList_Text;
import MainProgram.CodeUtama;
import java.awt.Desktop;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class FrameUtama extends javax.swing.JFrame {

    public FrameUtama() {
        New_Name();
        setErrorDialog();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelPeringatan = new javax.swing.JLabel();
        LabelLogo = new javax.swing.JLabel();
        txt_folder = new javax.swing.JTextField();
        txt_kunci = new javax.swing.JTextField();
        btn_redirect = new javax.swing.JButton();
        txt_extension = new javax.swing.JTextField();
        LabelPath = new javax.swing.JLabel();
        btn_extension = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        JListArray = new javax.swing.JList<>();
        LabelLocation = new javax.swing.JLabel();
        PanelLokasi = new UserInterface.CurvedPanel();
        LabelHighlight = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        btn_cari = new javax.swing.JButton();
        btn_mulai = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelPeringatan.setFont(new java.awt.Font("Malgun Gothic", 1, 36)); // NOI18N
        getContentPane().add(LabelPeringatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 370, 900, -1));
        LabelPeringatan.setHorizontalAlignment(javax.swing.JLabel.CENTER);
        LabelPeringatan.setVisible(false);
        getContentPane().add(LabelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 120, 900, -1));
        LabelLogo.setHorizontalAlignment(javax.swing.JLabel.CENTER);
        LabelLogo.setVisible(false);

        txt_folder.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_folder.setBorder(null);
        getContentPane().add(txt_folder, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 606, 582, 30));

        txt_kunci.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_kunci.setBorder(null);
        getContentPane().add(txt_kunci, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 740, 582, 30));

        btn_redirect.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_redirect.setText("Go To Folder");
        btn_redirect.setOpaque(true);
        btn_redirect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_redirectActionPerformed(evt);
            }
        });
        getContentPane().add(btn_redirect, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 527, -1, 30));
        btn_redirect.setVisible(false);
        btn_redirect.setOpaque(false);

        txt_extension.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_extension.setText("All");
        txt_extension.setBorder(null);
        getContentPane().add(txt_extension, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 673, 140, 30));

        LabelPath.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        LabelPath.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(LabelPath, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 527, 582, 30));
        LabelPath.setVisible(false);

        btn_extension.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_extension.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Word", "Excel", "PPT", "Text", "PDF" }));
        btn_extension.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_extension.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_extensionActionPerformed(evt);
            }
        });
        getContentPane().add(btn_extension, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 671, 82, 33));
        btn_extension.setOpaque(false);

        JListArray.setBorder(null);
        JListArray.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        JListArray.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(JListArray);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 40, 900, 480));
        jScrollPane1.setBorder(null);

        LabelLocation.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        LabelLocation.setForeground(new java.awt.Color(255, 255, 255));
        LabelLocation.setText("Location:");
        getContentPane().add(LabelLocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 525, 110, -1));
        LabelLocation.setVisible(false);

        PanelLokasi.setBackground(new java.awt.Color(0, 51, 255));
        PanelLokasi.setRoundBottomLeft(70);
        PanelLokasi.setRoundBottomRight(70);
        getContentPane().add(PanelLokasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 520, 900, 44));
        PanelLokasi.setVisible(false);

        LabelHighlight.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        LabelHighlight.setText("HIGHLIGHT");
        getContentPane().add(LabelHighlight, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 10, 200, 45));

        textArea.setEditable(false);
        textArea.setColumns(20);
        textArea.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textArea.setRows(5);
        jScrollPane2.setViewportView(textArea);
        textArea.setLineWrap(true);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 70, 350, 710));
        jScrollPane2.setBorder(null);

        btn_cari.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_cari.setText("Cari");
        btn_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cariActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(793, 604, 82, 33));
        btn_cari.setOpaque(false);

        btn_mulai.setFont(new java.awt.Font("Segoe UI Black", 0, 16)); // NOI18N
        btn_mulai.setText("Mulai");
        btn_mulai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mulaiActionPerformed(evt);
            }
        });
        getContentPane().add(btn_mulai, new org.netbeans.lib.awtextra.AbsoluteConstraints(793, 738, 82, 33));
        btn_mulai.setOpaque(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Aset_Gambar/Frame Model.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void New_Name() {
        this.setTitle("FileSearch");
    }

    ArrList_Data singletonData = ArrList_Data.getInstance();
    ArrList_Text singletonText = ArrList_Text.getInstance();

    SorotTeks openSesame = new SorotTeks();
    CodeUtama Summon = new CodeUtama();

    JDialog errorDialog = new JDialog();
    JLabel errorLabel = new JLabel();

    boolean skipHighlight = false;

    private void setErrorDialog() {
        errorDialog.setTitle("ERROR");
        errorDialog.setSize(300, 200);
        errorDialog.setLocationRelativeTo(null);
        errorLabel.setFont(new java.awt.Font("Segoe UI", 0, 20));
        errorLabel.setHorizontalAlignment(javax.swing.JLabel.CENTER);
        errorDialog.add(errorLabel);
        errorDialog.setVisible(false);
    }

    ListSelectionListener selectList = new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            btn_redirect.setVisible(true);
            int index = JListArray.getSelectedIndex();
            LabelPath.setText((String) singletonData.getList().get(index).get(2));

            if (!skipHighlight) {
                StringBuilder sb = new StringBuilder();

                for (Object str : singletonText.getElement(index)) {
                    sb.append(str).append("\n").append("\n");
                }

                textArea.setText(sb.toString());
                openSesame.Highlight(textArea, txt_kunci.getText().toLowerCase());
            } else {
                textArea.setText("Tidak Ada Text Yang Dapat Disorot");
            }
        }
    };

    MouseListener doubleClick = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent jumlahClick) {
            if (jumlahClick.getClickCount() == 2) {
                try {
                    int index = JListArray.getSelectedIndex();
                    Desktop.getDesktop().open(new File((String) singletonData.getList().get(index).get(2)));
                } catch (IllegalArgumentException ex) {
                    errorLabel.setText("File Tidak Ditemukan");
                    errorDialog.setVisible(true);
                } catch (IOException e) {
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    };

    DefaultListModel listModel = new DefaultListModel();

    private void setElementList() {
        ArrayList<ArrayList<Object>> listData = singletonData.getList();

        for (ArrayList<Object> item : listData) {
            String text = (String) item.get(0);
            ImageIcon icon = (ImageIcon) item.get(1);
            listModel.addElement(new JLabelItem(text, icon));
        }

        JListArray.setModel(listModel);
        JListArray.setFixedCellHeight(40);
        JListArray.setCellRenderer(new JLabelModel());
    }

    private void btn_extensionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_extensionActionPerformed
        String selectedItem = (String) btn_extension.getSelectedItem();
        txt_extension.setText(selectedItem);
    }//GEN-LAST:event_btn_extensionActionPerformed

    private void btn_redirectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_redirectActionPerformed
        File lokasiFile = new File(LabelPath.getText());

        try {
            Desktop.getDesktop().open(lokasiFile.getParentFile());
        } catch (IllegalArgumentException ex) {
            errorLabel.setText("Folder Tidak Ditemukan");
            errorDialog.setVisible(true);
        } catch (IOException ex) {
        }
    }//GEN-LAST:event_btn_redirectActionPerformed

    private void btn_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cariActionPerformed
        JFileChooser pilih_file = new JFileChooser();
        pilih_file.setCurrentDirectory(new java.io.File(txt_folder.getText()));
        pilih_file.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        pilih_file.setDialogTitle("Browse Folder");
        int result = pilih_file.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            txt_folder.setText(pilih_file.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_btn_cariActionPerformed

    private void setLogoAndTextVisible(Boolean kondisi) {
        LabelLogo.setVisible(kondisi);
        LabelPeringatan.setVisible(kondisi);
    }

    private void setLogoAndText(String logoPath, String text) {
        LabelLogo.setIcon(new ImageIcon(getClass().getResource("/Aset_Gambar/" + logoPath)));
        LabelPeringatan.setText(text);
    }

    private void reset() {
        setLogoAndTextVisible(false);
        skipHighlight = false;
        errorDialog.setVisible(false);
        btn_redirect.setVisible(false);
        LabelPath.setText(null);
        textArea.setText(null);
        singletonData.resetList();
        singletonText.resetList();
        JListArray.removeListSelectionListener(selectList);
        listModel.removeAllElements();
    }

    private void btn_mulaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mulaiActionPerformed
        reset();

        String lokasi = txt_folder.getText().stripIndent();
        if (!(new File(lokasi)).isDirectory()) {
            setLogoAndTextVisible(true);
            setLogoAndText("folder error.png", "Folder Tidak Ditemukan");
            return;
        }
        String extension = txt_extension.getText().toLowerCase().stripIndent();
        if (!"all".equals(extension) && !"word".equals(extension)
                && !"excel".equals(extension) && !"ppt".equals(extension)
                && !"text".equals(extension) && !"pdf".equals(extension)) {
            setLogoAndTextVisible(true);
            setLogoAndText("file error.png", "Jenis File Tidak Tersedia");
            return;
        }
        String kunci = txt_kunci.getText().toLowerCase().stripIndent();
        if (kunci.isBlank()) {
            skipHighlight = true;
        }

        try {
            Summon.cek_folder(lokasi, extension, kunci, skipHighlight);
        } catch (IOException ex) {
            Logger.getLogger(FrameUtama.class.getName()).log(Level.SEVERE, null, ex);
        }

        setElementList();

        if (!listModel.isEmpty()) {
            PanelLokasi.setVisible(true);
            LabelLocation.setVisible(true);
            LabelPath.setVisible(true);
            JListArray.addListSelectionListener(selectList);
            JListArray.addMouseListener(doubleClick);
        } else {
            setLogoAndTextVisible(true);
            setLogoAndText("no-results.png", "Kata Kunci Tidak Ditemukan");
            PanelLokasi.setVisible(false);
            LabelLocation.setVisible(false);
            LabelPath.setVisible(false);
        }
    }//GEN-LAST:event_btn_mulaiActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }

            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameUtama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> JListArray;
    private javax.swing.JLabel LabelHighlight;
    private javax.swing.JLabel LabelLocation;
    private javax.swing.JLabel LabelLogo;
    private javax.swing.JLabel LabelPath;
    private javax.swing.JLabel LabelPeringatan;
    private UserInterface.CurvedPanel PanelLokasi;
    private javax.swing.JButton btn_cari;
    private javax.swing.JComboBox<String> btn_extension;
    private javax.swing.JButton btn_mulai;
    private javax.swing.JButton btn_redirect;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea textArea;
    private javax.swing.JTextField txt_extension;
    private javax.swing.JTextField txt_folder;
    private javax.swing.JTextField txt_kunci;
    // End of variables declaration//GEN-END:variables
}
