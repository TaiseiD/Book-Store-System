package system;

import java.util.Scanner;
import database.BookDAO;

public class KeeperMenu {
    public static void storekeeperMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nStorekeeper Menu:");
            System.out.println("1. Add New Book");
            System.out.println("2. Restock Book");
            System.out.println("3. View Inventory");
            System.out.println("4. Exit");
            System.out.print("Choice: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (option) {
                    case 1 -> {
                        System.out.print("Enter title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter author: ");
                        String author = scanner.nextLine();
                        System.out.print("Enter stock quantity: ");
                        int qty = scanner.nextInt(); scanner.nextLine();
                        System.out.print("Enter tag (popular/new): ");
                        String tag = scanner.nextLine();

                        Book book = new Book(title, author, qty, tag);
                        BookDAO.addBook(book);
                        System.out.println("✅ Book added to database!");
                    }
                    case 2 -> {
                        System.out.print("Enter book ID to restock: ");
                        int id = scanner.nextInt();
                        System.out.print("Enter quantity to add: ");
                        int qty = scanner.nextInt();
                        BookDAO.restockBook(id, qty);
                        System.out.println("✅ Book restocked in database!");
                    }
                    case 3 -> BookDAO.listBooks();
                    case 4 -> {
                        System.out.println("Goodbye!");
                        return;
                    }
                    default -> System.out.println("Invalid option.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
