import java.util.Scanner;
import java.util.ArrayList;

public class SecondPlusThird {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        int num;

        while (true) {
            num = Integer.valueOf(scanner.nextLine());

            if (num == 0) break;

            numbers.add(num);
        }

        System.out.println((numbers.get(1) + numbers.get(2)));
    }
}
