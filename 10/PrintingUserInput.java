import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class PrintingUserInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        List<String> strings = new ArrayList<>();

        System.out.println("Input numbers, type 'end' to stop.");
        while (true) {
            String row = scanner.nextLine();
            if (row.equals(""))
                break;

            strings.add(row);
        }

        strings.stream()
            .forEach(str -> System.out.println(str));

        scanner.close();
    }
}
