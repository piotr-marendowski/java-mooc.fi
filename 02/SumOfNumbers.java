import java.util.Scanner;

public class SumOfNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;

        while (true) {
            System.out.println("Give a number (end with 0):");
            int number = Integer.valueOf(scanner.nextLine());
            
            if (number == 0) {
                break;
            }

            sum += number;
        }

        System.out.println("Sum of numbers: " + sum);
    }
}
