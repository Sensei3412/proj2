import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Read extends GalaSystem {

    public void checkUserInfo(int id, String password) {
        String query = "SELECT * FROM users WHERE id = ? AND password = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setInt(1, id);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("\nUser Info");
                    System.out.println(rs.getInt("id") + ", " + 
                                       rs.getString("name") + ", " + 
                                       rs.getInt("age") + ", " + 
                                       rs.getString("email") + ", " + 
                                       rs.getString("ticket_type"));
                } else {
                    System.out.println("\nAccess Denied: Incorrect ID or Password.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving data records: " + e.getMessage());
        }
    }
}