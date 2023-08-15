import java.util.ArrayList;
import java.util.Scanner;

public class Archive {
    static class Item {
        private String name;
        private String id;

        public Item(String name, String id) {
            this.name = name;
            this.id = id;
        }

        public boolean equals(Object compared) {
            if (this == compared) return true;

            if (!(compared instanceof Item)) return false;

            Item comparedItem = (Item) compared;

            if (this.id.equals(comparedItem.id))
                return true;

            return false;
        }

        public String toString() {
            return id + ": " + name;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Item> items = new ArrayList<>();

        while (true) {
            System.out.println("Identifier? (empty will stop)");
            String id = scanner.nextLine();

            if (id.isEmpty()) break;

            System.out.println("Name? (empty will stop)");
            String name = scanner.nextLine();

            if (name.isEmpty()) break;

            Item item = new Item(name, id);

            if (!(items.contains(item))) {
                items.add(item);
            }
        }

        System.out.println("==Items==");
        for (Item item: items) {
            System.out.println(item);
        }
    }
}
