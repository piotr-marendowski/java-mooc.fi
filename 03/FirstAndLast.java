import java.util.Scanner;
import java.util.ArrayList;

public class FirstAndLast {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        String input;

        while (true) {
            input = scanner.nextLine();

            if (input.isEmpty()) break;

            list.add(input);
        }

        System.out.println(list.get(0));
        System.out.println(list.get(list.size() - 1));
    }
}
