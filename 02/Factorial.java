import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i, factorial = 1;

        System.out.println("Give a number:");
        int number = Integer.valueOf(scanner.nextLine());

        /* one-liner :3 */
        for (i = 1; i <= number; factorial *= i, i++) ;

        System.out.println("Factorial: " + factorial);
    }
}
