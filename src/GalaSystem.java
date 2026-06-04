import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GalaSystem {
    protected final String URL = "jdbc:mysql://127.0.0.1:3306/gala_db";
    protected final String USER = "root";      
    protected final String PASSWORD = "";      

    protected Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found: " + e.getMessage());
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}