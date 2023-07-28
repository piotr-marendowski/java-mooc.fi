import java.util.Scanner;
import java.util.ArrayList;

public class ListSize {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();
        String name;

        while (true) {
            name = scanner.nextLine();

            if (name.isEmpty()) break;

            names.add(name);
        }

        System.out.println("In total: " + names.size());
    }
}
