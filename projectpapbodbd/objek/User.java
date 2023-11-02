/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectpapbodbd.objek;

import projectpapbodbd.ConnectionDatabase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User extends ConnectionDatabase {
    protected String kodeuser;
    public String nama;
    public String username;
    public String password;
    public String role;

    public User(String nama, String username, String password, String role) {
        this.nama = nama;
        this.username = username;
        this.password = password;
        this.role = role;
        this.kodeuser = generateNextUserCode();
    }

    public String getKodeUser() {
        return kodeuser;
    }

    private String generateNextUserCode() {
        openConnection();

        try {
            String query = "SELECT MAX(CAST(SUBSTRING(kodeuser, 3) AS SIGNED)) FROM user";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            int lastUserId = 0;

            if (resultSet.next()) {
                lastUserId = resultSet.getInt(1);
            }

            int nextUserId = lastUserId + 1;
            return String.format("US%03d", nextUserId);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            closeConnection();
        }
    }

    public boolean tambah() {
        openConnection();

        try {
            String insertQuery = "INSERT INTO user (kodeuser, nama, username, password, role) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, kodeuser);
            preparedStatement.setString(2, nama);
            preparedStatement.setString(3, username);
            preparedStatement.setString(4, password);
            preparedStatement.setString(5, role);

            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            closeConnection();
        }
    }

    public class UserLoginResult {
    private String role;
    private String kodeuser;

    public UserLoginResult(String role, String kodeuser) {
        this.role = role;
        this.kodeuser = kodeuser;
    }

    public String getRole() {
        return role;
    }

    public String getKodeuser() {
        return kodeuser;
    }
}

    public UserLoginResult login(String username, String password) {
        openConnection();
        String role = "";
        String kodeuser = "";

        try {
            String sql = "SELECT role FROM user WHERE username = ? AND password = ?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                role = rs.getString("role");

                if ("Anggota".equals(role)) {
                    String anggotaSql = "SELECT kodeuser FROM user WHERE username = ? AND password = ?";
                    PreparedStatement anggotaPst = connection.prepareStatement(anggotaSql);
                    anggotaPst.setString(1, username);
                    anggotaPst.setString(2, password);
                    ResultSet anggotaRs = anggotaPst.executeQuery();

                    if (anggotaRs.next()) {
                        kodeuser = anggotaRs.getString("kodeuser");
                    }
                } else if ("Petugas".equals(role)) {
                    String petugasSql = "SELECT kodeuser FROM user WHERE username = ? AND password = ?";
                    PreparedStatement petugasPst = connection.prepareStatement(petugasSql);
                    petugasPst.setString(1, username);
                    petugasPst.setString(2, password);
                    ResultSet petugasRs = petugasPst.executeQuery();

                    if (petugasRs.next()) {
                        kodeuser = petugasRs.getString("kodeuser");
                    }
                }
            } else {
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Terjadi kesalahan SQL: " + e.getMessage());
        } finally {
            closeConnection();
        }

        return new UserLoginResult(role, kodeuser);
    }
}
