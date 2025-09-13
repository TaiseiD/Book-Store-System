package system;

import java.util.Scanner;
import database.UserDAO;

public class Login {
    public static boolean authenticate(String role, Scanner scanner) throws Exception {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (UserDAO.authenticate(username, password, role)) {
            System.out.println(role + " login successful!\n");
            return true;
        } else {
            System.out.println("Invalid credentials.");
            return false;
        }
    }
}
