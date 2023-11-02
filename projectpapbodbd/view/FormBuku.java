/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projectpapbodbd.view;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import projectpapbodbd.ConnectionDatabase;
import projectpapbodbd.objek.Buku;

public class FormBuku extends javax.swing.JFrame {
    Statement st;
    ResultSet rs;
    Connection conn;
    DefaultTableModel model;
    private FormMenu formMenu;
    private String kodeuser;
    private String role;

    public FormBuku(FormMenu formMenu, String kodeuser, String role) {
        this.formMenu = formMenu;
        initComponents();
        
        this.kodeuser = kodeuser;
        this.role = role;

        ConnectionDatabase database = new ConnectionDatabase();
        conn = database.openConnection();

        model = new DefaultTableModel();
        tablebuku.setModel(model);

        model.addColumn("No");
        model.addColumn("Kode Buku");
        model.addColumn("Judul Buku");
        model.addColumn("Penulis");
        model.addColumn("Stok");

        showData();
        txtuser.setText(this.kodeuser);
    }

    private void showData() {
        try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT kodebuku, judulbuku, penulis, stok FROM buku");

            int no = 1;

            while (rs.next()) {
                Object[] data = {
                    no++,
                    rs.getString("kodebuku"),
                    rs.getString("judulbuku"),
                    rs.getString("penulis"),
                    rs.getInt("stok")
                };

                model.addRow(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + e.getMessage(), "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtjudul = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtpenulis = new javax.swing.JTextField();
        txtstok = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablebuku = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtkodebuku = new javax.swing.JTextField();
        txtuser = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnhapus = new javax.swing.JButton();
        btnsimpan = new javax.swing.JButton();
        btnubah = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnbatal = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Data Buku");

        jLabel2.setText("Judul Buku");

        jLabel3.setText("Penulis");

        jLabel4.setText("Stok");

        tablebuku.setBackground(new java.awt.Color(204, 204, 204));
        tablebuku.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Kode buku", "Judul buku", "Penulis", "Stok"
            }
        ));
        tablebuku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablebukuMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablebuku);

        jLabel5.setText("Kode Buku");

        txtkodebuku.setEditable(false);
        txtkodebuku.setText("--tidak perlu diisi--");

        txtuser.setEditable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        btnhapus.setText("Hapus");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });

        btnsimpan.setText("Simpan");
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });

        btnubah.setText("Ubah");
        btnubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnubahActionPerformed(evt);
            }
        });

        jLabel6.setText("Tombol");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addComponent(btnsimpan)
                .addGap(18, 18, 18)
                .addComponent(btnubah)
                .addGap(18, 18, 18)
                .addComponent(btnhapus)
                .addGap(31, 31, 31))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsimpan)
                    .addComponent(btnubah)
                    .addComponent(btnhapus))
                .addGap(25, 25, 25))
        );

        btnbatal.setText("Batal");
        btnbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbatalActionPerformed(evt);
            }
        });

        jLabel7.setText("User");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 34, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(143, 143, 143)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtuser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel5))
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtpenulis, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtjudul, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtkodebuku, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtstok, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(162, 162, 162))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnbatal)
                        .addGap(25, 25, 25))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtuser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtkodebuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtjudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtpenulis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtstok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(29, 29, 29)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnbatal)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbatalActionPerformed
    this.dispose();
    formMenu.setVisible(true);
    }//GEN-LAST:event_btnbatalActionPerformed

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        String judulbuku = txtjudul.getText();
        String penulis = txtpenulis.getText();
        String kodeuser = txtuser.getText();
        int stok = Integer.parseInt(txtstok.getText());

        Buku newBuku = new Buku(judulbuku, penulis, stok, kodeuser);

        String nextBukuCode = newBuku.getKodeBuku();

        if (nextBukuCode != null) {
            boolean isSuccess = newBuku.tambahBuku();

            if (isSuccess) {
                 JOptionPane.showMessageDialog(null, "Berhasil menambahkan data");
                model.setRowCount(0); // Hapus semua baris dalam tabel
                showData();
                txtkodebuku.setText("");
                txtjudul.setText("");
                txtpenulis.setText("");
                txtstok.setText("");
            } else {
                 JOptionPane.showMessageDialog(null, "Gagal menambahkan data");
                txtkodebuku.setText("");
                txtjudul.setText("");
                txtpenulis.setText("");
                txtstok.setText("");
            }
        } else {
             JOptionPane.showMessageDialog(null, "Gagal mendapatkan kodebuku");
        }
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void tablebukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablebukuMouseClicked
        int selectedRow = tablebuku.getSelectedRow(); // Dapatkan indeks baris yang diklik

        if (selectedRow >= 0) {
        String selectedKodeBuku = (String) tablebuku.getValueAt(selectedRow, 1); 
        String selectedJudulBuku = (String) tablebuku.getValueAt(selectedRow, 2);
        String selectedPenulis = (String) tablebuku.getValueAt(selectedRow, 3);
        int selectedStok = (int) tablebuku.getValueAt(selectedRow, 4);
       
        txtkodebuku.setText(selectedKodeBuku);
        txtjudul.setText(selectedJudulBuku);
        txtpenulis.setText(selectedPenulis);
        txtstok.setText(Integer.toString(selectedStok));
        }
    }//GEN-LAST:event_tablebukuMouseClicked

    private void btnubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnubahActionPerformed
    String kodeBuku = txtkodebuku.getText();
    String judulBuku = txtjudul.getText();
    String penulis = txtpenulis.getText();
    int stok = Integer.parseInt(txtstok.getText());
    String kodeuser = txtuser.getText();

    Buku buku = new Buku(judulBuku, penulis, stok, kodeuser);
    buku.setKodeBuku(kodeBuku);

    boolean updated = buku.updateBuku();

    if (updated) {
        JOptionPane.showMessageDialog(this, "Buku telah diubah.", "Berhasil", JOptionPane.INFORMATION_MESSAGE);
        txtkodebuku.setText("");
        txtjudul.setText("");
        txtpenulis.setText("");
        txtstok.setText("");
        model.setRowCount(0); // Hapus semua baris dalam tabel
        showData(); // Tampilkan data yang sudah diperbarui
    } else {
        JOptionPane.showMessageDialog(this, "Gagal mengubah buku.", "Gagal", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnubahActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
    String kodeBuku = txtkodebuku.getText();
    String judulBuku = txtjudul.getText();
    String penulis = txtpenulis.getText();
    int stok = Integer.parseInt(txtstok.getText());
    String kodeuser = txtuser.getText();

    Buku buku = new Buku(judulBuku, penulis, stok, kodeuser);
     buku.setKodeBuku(kodeBuku);

    boolean updated = buku.deleteBuku();

    if (updated) {
        JOptionPane.showMessageDialog(this, "Buku telah dihapus.", "Berhasil", JOptionPane.INFORMATION_MESSAGE);
        txtkodebuku.setText("");
        txtjudul.setText("");
        txtpenulis.setText("");
        txtstok.setText("");
        model.setRowCount(0); // Hapus semua baris dalam tabel
        showData();
    } else {
        JOptionPane.showMessageDialog(this, "Gagal menghapus buku.", "Gagal", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnhapusActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(FormBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            FormMenu formMenu = new FormMenu("", ""); 
            String kodeuser = formMenu.getKodeUser();
            String role = formMenu.getRole();
            new FormBuku(formMenu, kodeuser, role).setVisible(true);
        }
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbatal;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JButton btnubah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tablebuku;
    private javax.swing.JTextField txtjudul;
    private javax.swing.JTextField txtkodebuku;
    private javax.swing.JTextField txtpenulis;
    private javax.swing.JTextField txtstok;
    private javax.swing.JTextField txtuser;
    // End of variables declaration//GEN-END:variables
}
