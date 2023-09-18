import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AverageOfSelectedNumbers {
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

        double averagePos = numbers.stream()
            .mapToInt(s -> Integer.valueOf(s))
            .filter(s -> s >= 0)
            .average()
            .getAsDouble();

        double averageNeg = numbers.stream()
            .mapToInt(s -> Integer.valueOf(s))
            .filter(s -> s < 0)
            .average()
            .getAsDouble();

        System.out.println("Print the average of the negative numbers or the positive numbers? (n/p)");
        String ch = scanner.nextLine();

        if (ch.equals("p"))
            System.out.println("Average of the positive numbers: " + averagePos);
        else
            System.out.println("Average of the negative numbers: " + averageNeg);

        scanner.close();
    }
}
