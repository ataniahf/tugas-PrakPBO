import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ATANIA
 */
public class Koneksi {
        public Connection getKoneksi() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        
        String url = "jdbc:mysql://localhost/dbcontact";
        Connection con = DriverManager.getConnection(url, "root", ""); 
        
        return con;
    }
}
