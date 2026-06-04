import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update extends GalaSystem {

    public boolean updatePassword(int userId, String oldPassword, String newPassword) {
        String query = "UPDATE users SET password = ? WHERE password = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setInt(1, userId);
            stmt.setString(1, newPassword);
            stmt.setString(2, oldPassword);
            
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0; 
            
        } catch (SQLException e) {
            System.out.println("Error updating credentials: " + e.getMessage());
            return false;
        }
    }
}