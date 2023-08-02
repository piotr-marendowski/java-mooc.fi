import java.util.Scanner;
import java.util.ArrayList;

public class SumOfAList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        int num, sum = 0;

        while (true) {
            num = Integer.valueOf(scanner.nextLine());

            if (num == -1) break;

            numbers.add(num);
        }

        for (int i: numbers) {
            sum += i;
        }

        System.out.println("Sum: " + sum);
    }
}
