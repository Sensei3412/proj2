import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete extends GalaSystem {

    public boolean deleteUserSecurely(int id, String password) {
        String query = "DELETE FROM users WHERE id = ? AND password = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setInt(1, id);
            stmt.setString(2, password);
            
            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0; 
            
        } catch (SQLException e) {
            System.out.println("Error removing session data: " + e.getMessage());
            return false;
        }
    }
}