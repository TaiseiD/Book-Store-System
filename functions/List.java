package functions;

import database.DBConnection;
import java.sql.*;

public class List {
    public static void listBooks() {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM books";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("📚 Book Inventory:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                                   " | Title: " + rs.getString("title") +
                                   " | Author: " + rs.getString("author") +
                                   " | Stock: " + rs.getInt("quantity") +
                                   " | Tag: " + rs.getString("tag"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
