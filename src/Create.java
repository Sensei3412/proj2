import java.sql.*;

public class Create extends GalaSystem {
    public int registerUser(String name, int age, String email, String password, String ticket, int ticketPrice) {
        String query = "INSERT INTO users (name, age, email, password, ticket_type, ticket_price) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setString(3, email);
            stmt.setString(4, password);
            stmt.setString(5, ticket);
            stmt.setInt(6, ticketPrice);
            stmt.executeUpdate();

            try (ResultSet keys = stmt.getGeneratedKeys()) {
                if (keys.next()) return keys.getInt(1); 
            }
        } catch (SQLException e) { System.out.println("Reg Error: " + e.getMessage()); }
        return -1;
    }
}