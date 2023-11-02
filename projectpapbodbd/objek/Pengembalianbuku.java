/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projectpapbodbd.objek;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.util.Calendar;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import projectpapbodbd.ConnectionDatabase;

public class Pengembalianbuku extends ConnectionDatabase {
    private String kodeuser;
    private String kodepinjam;
    private String kodebuku;

    public Pengembalianbuku(String kodeuser, String kodepinjam, String kodebuku) {
        this.kodeuser = kodeuser;
        this.kodepinjam = kodepinjam;
        this.kodebuku = kodebuku;
    }
    
    public boolean simpanPengembalian() {
        openConnection();

        try {
            // Mendapatkan tanggal hari ini
            Date tanggalHariIni = new Date(Calendar.getInstance().getTime().getTime());

            // Query untuk mendapatkan tanggal kembali dari database
            String selectQuery = "SELECT tglkembali FROM peminjamanbuku WHERE anggota_kodeuser = ? AND kodepinjam = ? AND buku_kodebuku = ?";
            PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
            selectStatement.setString(1, kodeuser);
            selectStatement.setString(2, kodepinjam);
            selectStatement.setString(3, kodebuku);
            ResultSet resultSet = selectStatement.executeQuery();

            if (resultSet.next()) {
                Date tglKembali = resultSet.getDate("tglkembali");

                // Jika tanggal pengembalian melewati tanggal kembali, tambahkan denda
                if (tanggalHariIni.after(tglKembali)) {
                    int jumlahDenda = 10000; // Set denda menjadi 10.000

                    // Query untuk menambahkan data denda ke database
                    String insertDendaQuery = "INSERT INTO denda (kodedenda, jumlahdenda, peminjamanbuku_kodepinjam) VALUES (?, ?, ?)";
                    PreparedStatement insertDendaStatement = connection.prepareStatement(insertDendaQuery);
                    String kodedenda = generateNextDendaCode(); 
                    insertDendaStatement.setString(1, kodedenda);
                    insertDendaStatement.setInt(2, jumlahDenda);
                    insertDendaStatement.setString(3, kodepinjam);
                    insertDendaStatement.executeUpdate();
                    
                }
                else {
                // Set status peminjaman menjadi "dikembalikan" dan tanggal pengembalian menjadi tanggal hari ini
                String updateStatusQuery = "UPDATE peminjamanbuku SET statuspinjam = 'dikembalikan', tgldikembalikan = ? WHERE anggota_kodeuser = ? AND kodepinjam = ? AND buku_kodebuku = ?";
                PreparedStatement updateStatusStatement = connection.prepareStatement(updateStatusQuery);
                updateStatusStatement.setDate(1, tanggalHariIni);
                updateStatusStatement.setString(2, kodeuser);
                updateStatusStatement.setString(3, kodepinjam);
                updateStatusStatement.setString(4, kodebuku);
                updateStatusStatement.executeUpdate();
                
                String updateStokQuery = "UPDATE buku SET stok = stok + 1 WHERE kodebuku = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(updateStokQuery);
                preparedStatement.setString(1, kodebuku);
                preparedStatement.executeUpdate();

                return true;
            }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return false;
    }

    private String generateNextDendaCode() {
        openConnection();

        try {
            String query = "SELECT MAX(CAST(SUBSTRING(kodedenda, 3) AS SIGNED)) FROM denda";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            int lastDendaId = 0;

            if (resultSet.next()) {
                lastDendaId = resultSet.getInt(1);
            }

            int nextDendaId = lastDendaId + 1;
            return String.format("DN%03d", nextDendaId);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            closeConnection();
        }
    }
}

//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.sql.Date;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.sql.ResultSet;
//import javax.swing.JOptionPane; // Import JOptionPane
//import projectpapbodbd.ConnectionDatabase;
//
//public class Pengembalianbuku extends ConnectionDatabase {
//    private String kodeuser;
//    private String kodepinjam;
//    private String kodebuku;
//
//    public Pengembalianbuku(String kodeuser, String kodepinjam, String kodebuku) {
//        this.kodeuser = kodeuser;
//        this.kodepinjam = kodepinjam;
//        this.kodebuku = kodebuku;
//    }
//    
//    public boolean simpanPengembalian() {
//        openConnection();
//
//        try {
//            // Mendapatkan tanggal hari ini
//            Date tanggalHariIni = new Date(Calendar.getInstance().getTime().getTime());
//
//            // Query untuk mendapatkan tanggal kembali dari database
//            String selectQuery = "SELECT tglkembali FROM peminjamanbuku WHERE anggota_kodeuser = ? AND kodepinjam = ? AND buku_kodebuku = ?";
//            PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
//            selectStatement.setString(1, kodeuser);
//            selectStatement.setString(2, kodepinjam);
//            selectStatement.setString(3, kodebuku);
//            ResultSet resultSet = selectStatement.executeQuery();
//
//            if (resultSet.next()) {
//                Date tglKembali = resultSet.getDate("tglkembali");
//
//                // Jika tanggal pengembalian melewati tanggal kembali, tambahkan denda
//                if (tanggalHariIni.after(tglKembali)) {
//                    int jumlahDenda = 10000; // Set denda menjadi 10.000
//
//                    // Query untuk menambahkan data denda ke database
//                    String insertDendaQuery = "INSERT INTO denda (kodedenda, jumlahdenda, peminjamanbuku_kodepinjam) VALUES (?, ?, ?)";
//                    PreparedStatement insertDendaStatement = connection.prepareStatement(insertDendaQuery);
//                    String kodedenda = generateNextDendaCode(); // Generate kode denda
//                    insertDendaStatement.setString(1, kodedenda);
//                    insertDendaStatement.setInt(2, jumlahDenda);
//                    insertDendaStatement.setString(3, kodepinjam);
//                    insertDendaStatement.executeUpdate();
//
//                    JOptionPane.showMessageDialog(null, "Anda terkena denda sebesar Rp 10.000.");
//                }
//
//                // Set status peminjaman menjadi "dikembalikan" dan tanggal pengembalian menjadi tanggal hari ini
//                String updateStatusQuery = "UPDATE peminjamanbuku SET statuspinjam = 'dikembalikan', tgldikembalikan = ? WHERE anggota_kodeuser = ? AND kodepinjam = ? AND buku_kodebuku = ?";
//                PreparedStatement updateStatusStatement = connection.prepareStatement(updateStatusQuery);
//                updateStatusStatement.setDate(1, tanggalHariIni);
//                updateStatusStatement.setString(2, kodeuser);
//                updateStatusStatement.setString(3, kodepinjam);
//                updateStatusStatement.setString(4, kodebuku);
//                updateStatusStatement.executeUpdate();
//
//                JOptionPane.showMessageDialog(null, "Data pengembalian berhasil disimpan.");
//                return true;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            closeConnection();
//        }
//        return false;
//    }
//
//    private String generateNextDendaCode() {
//        openConnection();
//
//        try {
//            String query = "SELECT MAX(CAST(SUBSTRING(kodedenda, 3) AS SIGNED)) FROM denda"; // Mengganti nama tabel
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            java.sql.ResultSet resultSet = preparedStatement.executeQuery();
//            int lastDendaId = 0;
//
//            if (resultSet.next()) {
//                lastDendaId = resultSet.getInt(1);
//            }
//
//            int nextDendaId = lastDendaId + 1;
//            return String.format("DN%03d", nextDendaId);
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return null;
//        } finally {
//            closeConnection();
//        }
//    }
//}
