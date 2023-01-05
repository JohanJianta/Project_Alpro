package UserInterface;

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
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_folder = new javax.swing.JTextField();
        txt_kunci = new javax.swing.JTextField();
        txt_extension = new javax.swing.JTextField();
        btn_cari = new javax.swing.JButton();
        btn_mulai = new javax.swing.JButton();
        btn_extension = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        JListArray = new javax.swing.JList<>();
        LabelPeringatan = new javax.swing.JLabel();
        LabelLokasi = new javax.swing.JLabel();
        PanelLokasi = new UserInterface.CurvedPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_folder.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_folder.setBorder(null);
        getContentPane().add(txt_folder, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 606, 582, 30));

        txt_kunci.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_kunci.setBorder(null);
        getContentPane().add(txt_kunci, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 740, 582, 30));

        txt_extension.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_extension.setText("All");
        txt_extension.setBorder(null);
        getContentPane().add(txt_extension, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 673, 140, 30));

        btn_cari.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_cari.setText("Cari");
        btn_cari.setBorder(null);
        btn_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cariActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(793, 604, 82, 33));

        btn_mulai.setFont(new java.awt.Font("Segoe UI Black", 0, 16)); // NOI18N
        btn_mulai.setText("Mulai");
        btn_mulai.setBorder(null);
        btn_mulai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mulaiActionPerformed(evt);
            }
        });
        getContentPane().add(btn_mulai, new org.netbeans.lib.awtextra.AbsoluteConstraints(793, 738, 82, 33));

        btn_extension.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_extension.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Word", "Excel", "PPT" }));
        btn_extension.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_extensionActionPerformed(evt);
            }
        });
        getContentPane().add(btn_extension, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 671, 82, 33));

        JListArray.setBorder(null);
        JListArray.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        JListArray.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(JListArray);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 40, 900, 480));
        jScrollPane1.setBorder(null);

        LabelPeringatan.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        LabelPeringatan.setForeground(new java.awt.Color(255, 255, 255));
        LabelPeringatan.setText("Location:");
        getContentPane().add(LabelPeringatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 525, 110, -1));
        LabelPeringatan.setVisible(false);

        LabelLokasi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        LabelLokasi.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(LabelLokasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 525, 582, 30));
        LabelLokasi.setVisible(false);

        PanelLokasi.setBackground(new java.awt.Color(0, 51, 255));
        PanelLokasi.setRoundBottomLeft(70);
        PanelLokasi.setRoundBottomRight(70);
        getContentPane().add(PanelLokasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 520, 900, 44));
        PanelLokasi.setVisible(false);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setText("Short Preview");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 10, 235, 45));

        textArea.setColumns(20);
        textArea.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textArea.setRows(5);
        jScrollPane2.setViewportView(textArea);
        textArea.setLineWrap(true);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 70, 360, 710));
        jScrollPane2.setBorder(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Aset_Gambar/Frame 2.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cariActionPerformed
        // TODO add your handling code here:
        JFileChooser pilih_file = new JFileChooser();
        pilih_file.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = pilih_file.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file_terpilih = pilih_file.getSelectedFile();
            String nama_folder = file_terpilih.getAbsolutePath();
            txt_folder.setText(nama_folder);
        }
    }//GEN-LAST:event_btn_cariActionPerformed

    ArrayList<ArrayList<Object>> array_hasil = new ArrayList<>();
    ArrayList<ArrayList<Object>> dataTextArea = new ArrayList<>();

    ListSelectionListener selectList = new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            int index = JListArray.getSelectedIndex();
            LabelLokasi.setText((String) array_hasil.get(index).get(2));
            StringBuilder sb = new StringBuilder();

            for (Object str : dataTextArea.get(index)) {
                sb.append(str).append("\n").append("\n");
            }

            textArea.setText(sb.toString());
        }
    };

    MouseListener doubleClick = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent jumlahClick) {
            if (jumlahClick.getClickCount() == 2) {
                try {
                    int index = JListArray.getSelectedIndex();
                    Desktop.getDesktop().open(new File((String) array_hasil.get(index).get(2)));
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

    private void btn_mulaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mulaiActionPerformed
        // TODO add your handling code here:

//        int start;
//        try {
//            start = textArea.getLineStartOffset(1);
//            textArea.setTabSize(start);
//        } catch (BadLocationException ex) {
//            Logger.getLogger(FrameUtama.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        int end = textArea.getLineEndOffset(1);
        String lokasi = txt_folder.getText();
        String extension = txt_extension.getText().toLowerCase();
        String kunci = txt_kunci.getText().toLowerCase();

        JListArray.removeListSelectionListener(selectList);
        LabelLokasi.setText(null);
        textArea.setText(null);
        dataTextArea.clear();
        array_hasil.clear();
        array_hasil.add(new ArrayList<>());
        array_hasil.get(0).add(0);

        CodeUtama Summon = new CodeUtama();

        try {
            Summon.cek_folder(lokasi, extension, kunci, array_hasil);
        } catch (IOException ex) {
            Logger.getLogger(FrameUtama.class.getName()).log(Level.SEVERE, null, ex);
        }

        array_hasil.remove(0);
        setElementList();

        if (!listModel.isEmpty()) {
            PanelLokasi.setVisible(true);
            LabelPeringatan.setVisible(true);
            LabelLokasi.setVisible(true);
            JListArray.addListSelectionListener(selectList);
            JListArray.addMouseListener(doubleClick);

        } else {
            PanelLokasi.setVisible(false);
            LabelPeringatan.setVisible(false);
            LabelLokasi.setVisible(false);
        }

    }//GEN-LAST:event_btn_mulaiActionPerformed

    DefaultListModel listModel = new DefaultListModel();

    private void setElementList() {
        listModel.removeAllElements();

        for (int i = 1; i < array_hasil.size(); i++) {
            String text = (String) array_hasil.get(i).get(0);
            ImageIcon icon = (ImageIcon) array_hasil.get(i).get(1);
            listModel.addElement(new JLabelItem(text, icon));

            dataTextArea.add(array_hasil.get(i - 1));
            array_hasil.remove(i - 1);
        }

        JListArray.setModel(listModel);
        JListArray.setFixedCellHeight(40);
        JListArray.setCellRenderer(new JLabelModel());
    }

    private void btn_extensionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_extensionActionPerformed
        // TODO add your handling code here:
        String selectedItem = (String) btn_extension.getSelectedItem();

        txt_extension.setText(selectedItem);
    }//GEN-LAST:event_btn_extensionActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
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
    private javax.swing.JLabel LabelLokasi;
    private javax.swing.JLabel LabelPeringatan;
    private UserInterface.CurvedPanel PanelLokasi;
    private javax.swing.JButton btn_cari;
    private javax.swing.JComboBox<String> btn_extension;
    private javax.swing.JButton btn_mulai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea textArea;
    private javax.swing.JTextField txt_extension;
    private javax.swing.JTextField txt_folder;
    private javax.swing.JTextField txt_kunci;
    // End of variables declaration//GEN-END:variables
}
