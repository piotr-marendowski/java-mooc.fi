import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AverageOfNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        List<String> numbers = new ArrayList<>();

        System.out.println("Input numbers, type 'end' to stop.");
        while (true) {
            String row = scanner.nextLine();
            if (row.equals("end"))
                break;

            numbers.add(row);
        }

        double average = numbers.stream()
            .mapToInt(s -> Integer.valueOf(s))
            .average()
            .getAsDouble();

        System.out.println("average of the numbers: " + average);
        scanner.close();
    }
}
