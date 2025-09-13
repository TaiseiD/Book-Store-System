package functions;

import database.DBConnection;
import java.sql.*;
import java.util.Scanner;

public class Restock {
    public static void restockBook() {
        try (Connection conn = DBConnection.getConnection();
             Scanner scanner = new Scanner(System.in)) {

            // Show books first
            List.listBooks();

            System.out.print("Enter book ID to restock: ");
            int id = scanner.nextInt();
            System.out.print("Enter quantity to add: ");
            int qty = scanner.nextInt();

            String sql = "UPDATE books SET quantity = quantity + ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, qty);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Book restocked successfully!");
            } else {
                System.out.println("⚠️ Invalid book ID.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
