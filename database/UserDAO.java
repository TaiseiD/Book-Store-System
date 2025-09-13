package database;

import java.sql.*;

public class UserDAO {
    public static boolean authenticate(String username, String password, String role) throws SQLException {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ? AND role = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setString(3, role);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        }
    }
}
