/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Koneksi;
import com.mysql.cj.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
 */
public class Hubung {
    private static Connection menghubungkan;
    public static Connection GetConnection() throws SQLException {
    if(menghubungkan == null) {
        new Driver();
       menghubungkan = DriverManager.getConnection("jdbc:mysql://localhost:3306/sekolah","root",""); 
    }
    return menghubungkan;
    }
}
