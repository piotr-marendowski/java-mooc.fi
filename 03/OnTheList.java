import java.util.Scanner;
import java.util.ArrayList;

public class OnTheList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        String input;

        while (true) {
            input = scanner.nextLine();

            if (input.isEmpty()) break;

            list.add(input);
        }

        System.out.println("Search for?");
        input = scanner.nextLine();
        
        if (list.contains(input)) {
            System.out.println(input + " was found!");
        } else {
            System.out.println(input + " was not found!");
        }
    }
}
