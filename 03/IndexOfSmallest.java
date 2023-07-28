import java.util.Scanner;
import java.util.ArrayList;

public class IndexOfSmallest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        int num, smallest = 9999;

        while (true) {
            num = Integer.valueOf(scanner.nextLine());

            if (num < smallest) smallest = num;

            if (num == 9999) break;

            numbers.add(num);
        }

        System.out.println("Smallest number: " + smallest);

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == smallest)
                System.out.println("found at index " + i);
        }
    }
}
