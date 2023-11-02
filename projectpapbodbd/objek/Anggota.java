/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectpapbodbd.objek;

import projectpapbodbd.ConnectionDatabase;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Anggota extends User {
    private String alamatEmail;

    public Anggota(String kodeuser, String alamatEmail) {
        super("", "", "", ""); // Default values for nama, username, password, and role
        this.kodeuser = kodeuser;
        this.alamatEmail = alamatEmail;
    }

    public String getAlamatEmail() {
        return alamatEmail;
    }

    // Override metode tambah untuk menambahkan data anggota ke tabel Anggota
    @Override
    public boolean tambah() {
        openConnection();

        try {
            String insertQuery = "INSERT INTO Anggota (kodeuser, alamatemail) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, getKodeUser());
            preparedStatement.setString(2, alamatEmail); // Perhatikan bahwa Anda mengganti indeks parameter ke 6

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
