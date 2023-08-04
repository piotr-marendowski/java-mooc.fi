import java.util.Scanner;

public class IsItTrue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = "true";

        System.out.print("Give a string: ");
        String s2 = scanner.nextLine();

        if (s2.equals(s1)) {
            System.out.println("You got it right!");
        } else {
            System.out.println("Try again!");
        }
        
    }
}
