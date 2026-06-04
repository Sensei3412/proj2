
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Create extends GalaSystem {

    public void registerUser(String name, int age, String email, String password, String ticketType) {
        String query = "INSERT INTO users (name, age, email, password, ticket_type) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            
            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setString(3, email);
            stmt.setString(4, password);
            stmt.setString(5, ticketType);

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                int generatedId = -1;
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        generatedId = generatedKeys.getInt(1);
                    }
                }

                System.out.println("\n---- Successfully Log In ----");
                System.out.println("User Info: ");
                System.out.println(generatedId + ", " + name + ", " + age + ", " + email);
            }
        } catch (SQLException e) {
            System.out.println("Error storing user details: " + e.getMessage());
        }
    }
}