import java.sql.*;

public class Update extends GalaSystem {
    public void updateTicket(int id, String ticketType, int price) {
        String query = "UPDATE users SET ticket_type = ?, ticket_price = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, ticketType);
            stmt.setInt(2, price);
            stmt.setInt(3, id);
            stmt.executeUpdate();
        } catch (SQLException e) { System.out.println("Ticket Update Error: " + e.getMessage()); }
    }

    public void addMealToUser(int id, String mealName, int price) {
        String query = "UPDATE users SET food = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, mealName);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) { System.out.println("Meal Purchase Error: " + e.getMessage()); }
    }
}