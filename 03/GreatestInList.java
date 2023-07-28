import java.util.Scanner;
import java.util.ArrayList;

public class GreatestInList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        int num, greatest = 0;

        while (true) {
            num = Integer.valueOf(scanner.nextLine());

            if (num > greatest) greatest = num;

            if (num == -1) break;

            numbers.add(num);
        }

        System.out.println("The greatest number: " + greatest);
    }
}
