package functions;

import database.DBConnection;
import java.sql.*;

public class NewStock {
    public static void showNewlyStockedBooks() {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM books WHERE tag = 'new'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("🆕 Newly Stocked Books:");
            while (rs.next()) {
                System.out.println("Title: " + rs.getString("title") +
                                   " | Author: " + rs.getString("author") +
                                   " | Stock: " + rs.getInt("quantity"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
