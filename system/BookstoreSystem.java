package system;

import java.util.Scanner;
import database.UserDAO;

public class BookstoreSystem {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Welcome to the Bookstore System ===");
        System.out.print("Login as (1) User or (2) Storekeeper: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        try {
            if (choice == 1) {
                if (Login.authenticate("user", scanner)) {
                    Menu.userMenu();
                }
            } else if (choice == 2) {
                if (Login.authenticate("storekeeper", scanner)) {
                    KeeperMenu.storekeeperMenu();
                }
            } else {
                System.out.println("Invalid choice.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
