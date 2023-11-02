/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectpapbodbd.objek;

import projectpapbodbd.ConnectionDatabase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Buku extends ConnectionDatabase {
    protected String kodebuku;
    public String judulbuku;
    public String penulis;
    public int stok;
    public String kodeuser;
    
    
    public Buku(String judulbuku, String penulis, int stok, String kodeuser) {
    this.judulbuku = judulbuku;
    this.penulis = penulis;
    this.stok = stok;
    this.kodebuku = generateNextBukuCode();
    this.kodeuser = kodeuser;
    }
    
    public String getKodeBuku() {
        return kodebuku;
    }
    
    public void setKodeBuku(String kodeBuku) {
    this.kodebuku = kodeBuku;
    
    }
    
    private String generateNextBukuCode() {
        openConnection();

        try {
            String query = "SELECT MAX(CAST(SUBSTRING(kodebuku, 3) AS SIGNED)) FROM buku";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            int lastBukuId = 0;

            if (resultSet.next()) {
                lastBukuId = resultSet.getInt(1);
            }

            int nextBukuId = lastBukuId + 1;
            return String.format("BK%03d", nextBukuId);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            closeConnection();
        }
    }
    
    public boolean tambahBuku() {
        openConnection();

        try {
            String insertQuery = "INSERT INTO buku (kodebuku, judulbuku, penulis, stok, petugas_kodeuser) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, kodebuku);
            preparedStatement.setString(2, judulbuku);
            preparedStatement.setString(3, penulis);
            preparedStatement.setInt(4, stok); // Menggunakan setInt untuk tipe data integer
            preparedStatement.setString(5, kodeuser);

            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            closeConnection();
        }
    } 
    
    public boolean updateBuku() {
    openConnection();

    try {
        String updateQuery = "UPDATE buku SET judulbuku = ?, penulis = ?, stok = ?, petugas_kodeuser = ? WHERE kodebuku = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
        preparedStatement.setString(1, judulbuku);
        preparedStatement.setString(2, penulis);
        preparedStatement.setInt(3, stok);
        preparedStatement.setString(4, kodeuser); // Gunakan nilai kodeuser yang benar
        preparedStatement.setString(5, kodebuku);

        int rowsAffected = preparedStatement.executeUpdate();

        return rowsAffected > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    } finally {
        closeConnection();
    }
}

    
    public boolean deleteBuku() {
    boolean isOperationSuccess = false;

    try {
        this.openConnection();

        String sql = "DELETE FROM buku WHERE kodebuku = ?";
        this.preparedStatement = this.connection.prepareStatement(sql);

        this.preparedStatement.setString(1, this.kodebuku);

        int result = this.preparedStatement.executeUpdate();

        isOperationSuccess = result > 0;
    } catch (SQLException ex) {
        this.displayErrors(ex);
    } finally {
        this.closeConnection();
    }
    return isOperationSuccess;
}
}