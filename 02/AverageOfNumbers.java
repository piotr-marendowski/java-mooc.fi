import java.util.Scanner;

public class AverageOfNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        int numbers = 0;

        while (true) {
            System.out.println("Give a number (end with 0):");
            int number = Integer.valueOf(scanner.nextLine());
            
            if (number == 0) {
                break;
            }

            numbers++;
            sum += number;
        }

        System.out.println("Average of the numbers: " + (double)(sum / numbers));
    }
}
