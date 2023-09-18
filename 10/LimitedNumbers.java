import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class LimitedNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        List<Integer> numbers = new ArrayList<>();

        System.out.println("Input numbers, type 'end' to stop.");
        while (true) {
            int number = Integer.valueOf(scanner.nextLine());
            if (number < 0)
                break;

            numbers.add(number);
        }

        numbers.stream()
            .filter(number -> number >= 1 && number <= 5)
            .forEach(str -> System.out.println(str));

        scanner.close();
    }
}
