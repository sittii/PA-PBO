/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectpapbodbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDatabase {
    private final static String dbhost = "localhost";
    private final static String dbname = "dbperpustakaan";
    private final static String username = "root";
    private final static String password = "";

    protected Connection connection = null;
    protected Statement statement;
    protected PreparedStatement preparedStatement;
    protected ResultSet resultSet;

    public Connection openConnection() {
    try {
        this.connection = DriverManager.getConnection(
            "jdbc:mysql://" + dbhost + "/" + dbname + "?user=" + username + "&password=" + password);
        return this.connection;
    } catch (SQLException ex) {
        displayErrors(ex);
        return null;
    }
}
    
    public final void closeConnection() {
        try {
            if (this.resultSet != null) this.resultSet.close();
            if (this.statement != null) this.statement.close();
            if (this.preparedStatement != null) this.preparedStatement.close();
            if (this.connection != null) this.connection.close();

            this.resultSet = null;
            this.statement = null;
            this.preparedStatement = null;
            this.connection = null;
        } catch (SQLException ex) {
            displayErrors(ex);
        }
    }

    protected final void displayErrors(SQLException ex) {
        System.out.println("SQLException: " + ex.getMessage());
        System.out.println("SQLstate: " + ex.getSQLState());
        System.out.println("VendorError: " + ex.getErrorCode());
    }
    
public static void main(String[] args) {
        ConnectionDatabase database = new ConnectionDatabase();
        database.openConnection();
        database.closeConnection();
    }
}
