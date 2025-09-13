package functions;

import database.DBConnection;
import java.sql.*;
import java.util.Scanner;

public class Search {
    public static void searchBook() {
        try (Connection conn = DBConnection.getConnection();
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter book title or author: ");
            String keyword = "%" + scanner.nextLine().toLowerCase() + "%";

            String sql = "SELECT * FROM books WHERE LOWER(title) LIKE ? OR LOWER(author) LIKE ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, keyword);
            ps.setString(2, keyword);

            ResultSet rs = ps.executeQuery();

            boolean found = false;
            while (rs.next()) {
                System.out.println("Title: " + rs.getString("title") +
                                   " | Author: " + rs.getString("author") +
                                   " | Stock: " + rs.getInt("quantity") +
                                   " | Tag: " + rs.getString("tag"));
                found = true;
            }

            if (!found) {
                System.out.println("❌ No books found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
