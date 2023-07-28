import java.util.Scanner;
import java.util.ArrayList;

public class IndexOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        int num;

        while (true) {
            num = Integer.valueOf(scanner.nextLine());

            if (num == -1) break;

            numbers.add(num);
        }

        System.out.println("Search for?");
        num = Integer.valueOf(scanner.nextLine());

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == num) System.out.println(num + " is at index " + i);
        }
    }
}
