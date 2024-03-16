import TaskPackage.Task;
import UserPackage.User;
import UtilityPackage.Utils;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Taking user input and creating a user
        Scanner scan = new Scanner(System.in);
        char opt;
        System.out.println("Enter your username: ");
        String username = scan.next();
        System.out.println("Enter your password: ");
        String password = scan.next();
        while (!(Utils.isPasswordValid(password))) {
            System.out.println("YOUR PASSWORD IS INVALID !!! AT LEAST USE ONE LETTER AND ONE NUMBER .");
            password = scan.next();
        }
        System.out.println("Enter your full name: ");
        String first_name = scan.next();
        String last_name = scan.next();
        System.out.println("Enter your email: ");
        String email = scan.next();

        User user = new User(username, password, first_name, last_name, email);

        // Displaying the user info
        System.out.println("---User Created---");
        System.out.println("Welcome " + user.getFullName() + "!");
        printUserInfo(user);

        // Creating task for a specific user
        do {
            System.out.println("Would you like to create a task? (y/n)");
            char answer = scan.next().charAt(0);
            if (answer == 'y') {
                System.out.println("Creating task...");
                System.out.println("Enter task name : ");
                String taskName = scan.next();
                Task task1 = user.createTask("taskName");
                task1.start_time = 18.00;
                task1.finish_time = 19.30;
                DecimalFormat df = new DecimalFormat("##.00");
                System.out.println(task1.name + " duration: " + df.format(task1.getDuration()));
                System.out.println("Do yu wish to continue?: ");
            }
            opt = Character.toLowerCase(scan.next().charAt(0));
        } while (opt == 'y');
        // Changing username and password with setter methods
        do {
            System.out.println("Would you like to change your username and password? (y/n)");
            char answer = scan.next().charAt(0);
            if (answer == 'y') {
                System.out.println("Changing username and password...");
                System.out.println("Enter new username: ");
                String username2 = scan.next();
                user.setUsername(username2);
                System.out.println("Enter new password: ");
                String password2 = scan.next();
                user.setPassword(password2);
                // Changing the streak
                user.streak = 2;
                printUserInfo(user);
                System.out.println("Do yu wish to continue?: ");
            }
            opt = Character.toLowerCase(scan.next().charAt(0));
        }while (opt == 'y');

    }
    // Closing the Scanner

    public static void printUserInfo(User user) {
        System.out.println("Username: " + user.getUsername() + "\nFull name: " + user.getFullName()
                + "\nPassword: " + user.getPassword() + "\nEmail: " + user.email + "\nYou have been using the app for " + user.streak + " days.");
    }
}