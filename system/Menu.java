package system;

import java.util.Scanner;
import database.BookDAO;

public class Menu {
    public static void userMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nUser Menu:");
            System.out.println("1. Search Book");
            System.out.println("2. View Popular Books");
            System.out.println("3. View Newly Stocked Books");
            System.out.println("4. Exit");
            System.out.print("Choice: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (option) {
                    case 1 -> {
                        System.out.print("Enter keyword: ");
                        String keyword = scanner.nextLine();
                        BookDAO.searchBooks(keyword);
                    }
                    case 2 -> BookDAO.showPopularBooks();
                    case 3 -> BookDAO.showNewlyStockedBooks();
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
