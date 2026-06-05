import java.sql.*;

public class Read extends GalaSystem {
    public int verifyLogin(String name, int age, String email, String password) {
        String query = "SELECT id FROM users WHERE name=? AND age=? AND email=? AND password=?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setString(3, email);
            stmt.setString(4, password);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) return rs.getInt("id");
            }
        } catch (SQLException e) { System.out.println("Login Check Error: " + e.getMessage()); }
        return -1;
    }

    public int calculateTotalBill(int id) {
        String query = "SELECT ticket_price, food FROM users WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int ticketBill = rs.getInt("ticket_price");
                    String food = rs.getString("food");
                    int foodBill = 0;
                    if (food != null) {
                        if (food.contains("Premium")) foodBill = 100;
                        else if (food.contains("Regular")) foodBill = 50;
                        else if (food.contains("Budget")) foodBill = 10;
                    }
                    return ticketBill + foodBill;
                }
            }
        } catch (SQLException e) { System.out.println("Billing Calculation Error: " + e.getMessage()); }
        return 0;
    }
}