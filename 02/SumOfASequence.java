import java.util.Scanner;

public class SumOfASequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i, sum;

        System.out.println("Last number?");
        int number = Integer.valueOf(scanner.nextLine());

        for (i = 1, sum = 0; i <= number; i++) {
            sum += i;
        }

        System.out.println("The sum is " + sum);
    }
}
