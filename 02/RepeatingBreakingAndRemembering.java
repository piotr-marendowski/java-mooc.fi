import java.util.Scanner;

public class RepeatingBreakingAndRemembering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i, number, numofnum = 0, sum = 0, even = 0, odd = 0;

        System.out.println("Give numbers:");
        for (i = 0; i < 4; i++) {
            number = Integer.valueOf(scanner.nextLine());

            if (number < 0) continue;

            if ((number % 2) == 0) even++;
            else odd++;

            sum += number;
            numofnum++;
        }

        System.out.println("Thx! Bye!");
        System.out.println("Sum: " + sum);
        System.out.println("Numbers: " + numofnum);
        System.out.println("Average: " + ((double) sum / numofnum));
        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
    }
}
