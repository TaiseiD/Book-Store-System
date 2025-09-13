package functions;

import database.DBConnection;
import java.sql.*;
import java.util.Scanner;

public class Add {
    public static void addBook() {
        try (Connection conn = DBConnection.getConnection();
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter title: ");
            String title = scanner.nextLine();
            System.out.print("Enter author: ");
            String author = scanner.nextLine();
            System.out.print("Enter stock quantity: ");
            int qty = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter tag (popular/new): ");
            String tag = scanner.nextLine();

            String sql = "INSERT INTO books (title, author, quantity, tag) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, title);
            ps.setString(2, author);
            ps.setInt(3, qty);
            ps.setString(4, tag);
            ps.executeUpdate();

            System.out.println("✅ Book added successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
