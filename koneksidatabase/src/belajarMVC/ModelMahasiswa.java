
package belajarMVC;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ModelMahasiswa {
    //mengkoneksikan ke database
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/dbprak";//nama database kita di slash terakhir
    static final String USER = "root";
    static final String PASS = "";
    
    Connection koneksi;
    Statement statement;//untuk perintah query

    public ModelMahasiswa() {
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }
    public void insertMahasiswa(String nim, String nama, String alamat, String telepon){
        try {
           String query = "INSERT INTO `mahasiswa`(`nim`, `nama`, `alamat`, `telepon`) VALUES ('"+nim+"','"+nama+"','"+alamat+"','"+telepon+"')";//value 1 (id diskip)
           statement = (Statement) koneksi.createStatement();
           statement.executeUpdate(query); //execute querynya
            System.out.println("Berhasil ditambahkan");
            JOptionPane.showMessageDialog(null, "Data Berhasil");
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public String[][] readMahasiswa(){
        try{
            int jmlData = 0;//menampung jumlah data
            
            String data[][] = new String[getBanyakData()][4]; //baris, kolom nya ada 3
            
            String query = "Select * from`mahasiswa`"; //pengambilan dara dalam java dari database
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){ //lanjut kedata selanjutnya jmlData bertambah
                data[jmlData][0] = resultSet.getString("nim"); //kolom nama harus sama besar kecilnya dgn database
                data[jmlData][1] = resultSet.getString("nama");                
                data[jmlData][2] = resultSet.getString("alamat");
                data[jmlData][3] = resultSet.getString("telepon");
                jmlData++; //barisnya berpindah terus
            }
            return data;
               
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public int getBanyakData(){//menghitung jumlah baris
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "Select * from `mahasiswa`"; //pengambilan dara dalam java dari database
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){ //lanjut kedata selanjutnya jmlData bertambah
                jmlData++;
            }
            return jmlData;
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    
    public void deleteMahasiswa (String nim) {
        try{
            String query = "DELETE FROM `mahasiswa` WHERE `nim` = '"+nim+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
            
        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }
}
