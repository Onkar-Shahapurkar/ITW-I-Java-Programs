import java.util.Scanner;

class UserAuthenticationException extends Exception {
    public UserAuthenticationException(String message) {
        super(message);
    }
}

class UserRegistrationException extends Exception {
    public UserRegistrationException(String message) {
        super(message);
    }
}

class UserService {
    private static final String validUsername = "user123";
    private static final String validPassword = "pass123";

    public static void login(String username, String password) throws UserAuthenticationException {
        if (validUsername.equals(username) && validPassword.equals(password)) {
            System.out.println("Login successful!");
        } else {
            throw new UserAuthenticationException("Invalid username or password");
        }
    }

    public static void register(String username, String password) throws UserRegistrationException {
        if (validUsername.equals(username)) {
            throw new UserRegistrationException("Username already exists");
        } else {
            System.out.println("Registration successful!");
        }
    }
}

class Assi_13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Login/Signup page.");

        while (true) {
            System.out.println("1. SignUp");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String signupUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String signupPassword = scanner.nextLine();

                    try {
                        UserService.register(signupUsername, signupPassword);
                    } catch (UserRegistrationException e) {
                        System.err.println("Registration failed: " + e.getMessage());
                    }
                    break;
                    
                 case 2:
                    System.out.print("Enter username: ");
                    String loginUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String loginPassword = scanner.nextLine();

                    try {
                        UserService.login(loginUsername, loginPassword);
                    } catch (UserAuthenticationException e) {
                        System.err.println("Login failed: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("Exiting the application. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.err.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
