import java.util.ArrayList;
import java.util.Scanner;

public class Items {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Item> items = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.print("Name: ");
            String name = scanner.nextLine();

            if (name.isEmpty()) break;

            items.add(new Item(name));
        }

        for (Item item: items)
            System.out.println(item);
    }
}
