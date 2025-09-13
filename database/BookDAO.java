package database;

import system.Book;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    public static void addBook(Book book) throws SQLException {
        String sql = "INSERT INTO books (title, author, quantity, tag) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, book.title);
            stmt.setString(2, book.author);
            stmt.setInt(3, book.quantity);
            stmt.setString(4, book.tag);
            stmt.executeUpdate();
        }
    }

    public static void listBooks() throws SQLException {
        String sql = "SELECT * FROM books";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(rs.getInt("id") + ". " +
                                   rs.getString("title") + " by " +
                                   rs.getString("author") +
                                   " | Stock: " + rs.getInt("quantity") +
                                   " | Tag: " + rs.getString("tag"));
            }
        }
    }

    public static void restockBook(int id, int qty) throws SQLException {
        String sql = "UPDATE books SET quantity = quantity + ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, qty);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        }
    }

    public static void searchBooks(String keyword) throws SQLException {
        String sql = "SELECT * FROM books WHERE title LIKE ? OR author LIKE ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + keyword + "%");
            stmt.setString(2, "%" + keyword + "%");
            ResultSet rs = stmt.executeQuery();
            boolean found = false;
            while (rs.next()) {
                found = true;
                System.out.println(rs.getString("title") + " by " +
                                   rs.getString("author") +
                                   " | Stock: " + rs.getInt("quantity") +
                                   " | Tag: " + rs.getString("tag"));
            }
            if (!found) System.out.println("No books found.");
        }
    }

    public static void showPopularBooks() throws SQLException {
        String sql = "SELECT * FROM books WHERE tag = 'popular'";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(rs.getString("title") + " by " +
                                   rs.getString("author") +
                                   " | Stock: " + rs.getInt("quantity"));
            }
        }
    }

    public static void showNewlyStockedBooks() throws SQLException {
        String sql = "SELECT * FROM books WHERE tag = 'new'";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(rs.getString("title") + " by " +
                                   rs.getString("author") +
                                   " | Stock: " + rs.getInt("quantity"));
            }
        }
    }
}
