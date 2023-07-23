import java.util.Scanner;

public class NumberOfNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbers = 0;

        while (true) {
            System.out.println("Give a number (end with 0):");
            int number = Integer.valueOf(scanner.nextLine());
            
            if (number == 0) {
                break;
            }

            // increment works!
            numbers++;
        }

        System.out.println("Number of numbers: " + numbers);
    }
}
