import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /* all in plain text! talk about security! */
        String usernames[] = {"alex", "emma"};
        String passwords[] = {"sunshine", "haskell"};
        boolean login = false;

        System.out.print("Enter username: ");
        String usr = scanner.nextLine();
        System.out.print("Enter password: ");
        String passwd = scanner.nextLine();

        for (int i = 0; i < usernames.length; i++ ) {
            if (usr.equals(usernames[i]) && passwd.equals(passwords[i]))
                login = true;
        }

        if (login == true) {
            System.out.print("You have successfully logged in!");
        } else {
            System.out.print("Incorrect username or password!");
        }
    }
}
