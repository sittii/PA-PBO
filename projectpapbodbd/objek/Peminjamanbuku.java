/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectpapbodbd.objek;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import projectpapbodbd.ConnectionDatabase;

public class Peminjamanbuku extends ConnectionDatabase {
    protected String kodepinjam;
    public Date tglpinjam; 
    public String statuspinjam;
    public Date tglkembali;
    public String kodeuser;
    public String kodebuku;

    public Peminjamanbuku(String statuspinjam, String kodeuser, String kodebuku) {
        this.tglpinjam = gettglpinjam();
        this.statuspinjam = statuspinjam;
        this.tglkembali = gettglkembali();
        this.kodeuser = kodeuser;
        this.kodebuku = kodebuku;
        this.kodepinjam = generateNextPinjamCode();
    }
    
    public String getKodePinjam() {
        return kodepinjam;
    }
    
    public void setKodeBuku(String kodeBuku) {
    this.kodepinjam = kodepinjam;
    
    }

    private String generateNextPinjamCode() {
        openConnection();

        try {
            String query = "SELECT MAX(CAST(SUBSTRING(kodepinjam, 3) AS SIGNED)) FROM peminjamanbuku";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            java.sql.ResultSet resultSet = preparedStatement.executeQuery();
            int lastPinjamId = 0;

            if (resultSet.next()) {
                lastPinjamId = resultSet.getInt(1);
            }

            int nextPinjamId = lastPinjamId + 1;
            return String.format("PJ%03d", nextPinjamId);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            closeConnection();
        }
    }

    public boolean simpanPeminjaman() {
        openConnection();

        try {
            String query = "INSERT INTO peminjamanbuku (kodepinjam, tglpinjam, statuspinjam, tglkembali, anggota_kodeuser, buku_kodebuku) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, kodepinjam);
            preparedStatement.setDate(2, new java.sql.Date(tglpinjam.getTime())); 
            preparedStatement.setString(3, statuspinjam);
            preparedStatement.setDate(4, new java.sql.Date(tglkembali.getTime())); 
            preparedStatement.setString(5, kodeuser);
            preparedStatement.setString(6, kodebuku);

            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            closeConnection();
        }
    }

    private Date gettglpinjam() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }

    private Date gettglkembali() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(tglpinjam);
        calendar.add(Calendar.DAY_OF_YEAR, 7);
        return calendar.getTime();
    }
    
    public boolean kurangiStokBuku() {
        openConnection();

        try {
            String query = "UPDATE buku SET stok = stok - 1 WHERE kodebuku = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, kodebuku);

            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            closeConnection();
        }
    }
    
    public boolean simpanPengembalian() {
    openConnection();

    try {
        String updateQuery = "UPDATE peminjamanbuku SET statuspinjam WHERE kodepinjam = ? AND anggota_kodeuser = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
        preparedStatement.setString(1, statuspinjam);
                preparedStatement.setString(2, kodepinjam);
        preparedStatement.setString(3, kodeuser); 

        int rowsAffected = preparedStatement.executeUpdate();

        return rowsAffected > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    } finally {
        closeConnection();
    }
    }
    
}

