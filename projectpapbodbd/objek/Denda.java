/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectpapbodbd.objek;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Date;
import java.util.Calendar;
import projectpapbodbd.ConnectionDatabase;

public class Denda extends ConnectionDatabase {
    private String kodedenda;
    private String kodepinjam;
    private String kodebuku;
    private String kodeuser;
    private String kodeuseranggota;

    public Denda(String kodedenda, String kodepinjam, String kodebuku, String kodeuser, String kodeuseranggota) {
        this.kodedenda = kodedenda;
        this.kodepinjam = kodepinjam;
        this.kodebuku = kodebuku;
        this.kodeuser = kodeuser;
        this.kodeuseranggota = kodeuseranggota;
    }
    
    public boolean simpanDenda() {
        openConnection();

        try {
            Date tanggalHariIni = new Date(Calendar.getInstance().getTime().getTime());

            // Update the 'denda' table
            String updateDendaQuery = "UPDATE denda SET tglbyr = ?, keterangan = 'terkonfimasi' WHERE kodedenda = ?";
            PreparedStatement updateDendaStatement = connection.prepareStatement(updateDendaQuery);
            updateDendaStatement.setDate(1, tanggalHariIni);
            updateDendaStatement.setString(2, kodedenda); 
            updateDendaStatement.executeUpdate();

            // Update the 'peminjamanbuku' table
            String updatePeminjamanQuery = "UPDATE peminjamanbuku SET statuspinjam = 'dikembalikan', tgldikembalikan = ? WHERE anggota_kodeuser = ? AND kodepinjam = ? AND buku_kodebuku = ?";
            PreparedStatement updatePeminjamanStatement = connection.prepareStatement(updatePeminjamanQuery);
            updatePeminjamanStatement.setDate(1, tanggalHariIni);
            updatePeminjamanStatement.setString(2, kodeuseranggota); 
            updatePeminjamanStatement.setString(3, kodepinjam); 
            updatePeminjamanStatement.setString(4, kodebuku); 
            updatePeminjamanStatement.executeUpdate();

            // Update the 'buku' table
            String updateStokQuery = "UPDATE buku SET stok = stok + 1 WHERE kodebuku = ?";
            PreparedStatement updateStokStatement = connection.prepareStatement(updateStokQuery);
            updateStokStatement.setString(1, kodebuku); 
            updateStokStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            
        }
        return true; 
    }
}

