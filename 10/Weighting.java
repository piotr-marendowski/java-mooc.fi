import java.util.ArrayList;

class Item {
    private String name;
    private int weight;

    public Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return this.name;
    }

    public int getWeight() {
        return this.weight;
    }

    @Override
    public String toString() {
        return this.name + ": (" + this.weight + " kg)";
    }
}

class Suitcase {
    private int maximumWeight;
    private ArrayList<Item> Items;

    public Suitcase(int maximumWeight) {
        this.Items = new ArrayList<>();
        this.maximumWeight = maximumWeight;
    }

    public void addItem(Item Item) {
        if (this.totalWeight() + Item.getWeight() > this.maximumWeight) {
            return;
        }

        this.Items.add(Item);
    }

    public int totalWeight() {
        int sum = 0;

        sum = Items.stream()
                .mapToInt(item -> item.getWeight())
                .reduce(0, (a, b) -> a + b);

        return sum;
    }

    public void printItems() {
        Items.stream().forEach(item -> System.out.println(item));
    }

    public Item heaviestItem() {
        if (this.Items.isEmpty())
            return null;

        return this.Items.stream()
                .max((t1, t2) -> t1.getWeight() - t2.getWeight())
                .get();
    }

    @Override
    public String toString() {
        if (this.Items.isEmpty()) {
            return "no items (0 kg)";
        }

        if (this.Items.size() == 1) {
            return "1 item (" + this.totalWeight() + " kg)";
        }

        return this.Items.size() + " items (" + this.totalWeight() + " kg)";
    }
}

class Hold {
    private ArrayList<Suitcase> suitcases;
    private int maximumWeight;

    public Hold(int maximumWeight) {
        this.maximumWeight = maximumWeight;
        this.suitcases = new ArrayList<>();
    }

    public void addSuitcase(Suitcase Suitcase) {
        if (this.totalWeight() + Suitcase.totalWeight() > maximumWeight) {
            return;
        }

        this.suitcases.add(Suitcase);
    }

    public int totalWeight() {
        int sum = suitcases.stream()
                .mapToInt(suitcase -> suitcase.totalWeight())
                .reduce(0, (a, b) -> a + b);

        return sum;
    }

    public void printItems() {
        suitcases.stream().forEach(suitcase -> System.out.println(suitcase));
    }

    @Override
    public String toString() {
        if (this.suitcases.isEmpty()) {
            return "no suitcases (0 kg)";
        }

        if (this.suitcases.size() == 1) {
            return "1 suitcase (" + this.totalWeight() + " kg)";
        }

        return this.suitcases.size() + " suitcases (" + this.totalWeight() +
                " kg)";
    }
}

public class Weighting {
    public static void main(String[] args) {
        Suitcase s1 = new Suitcase(10);
        Suitcase s2 = new Suitcase(10);
        Hold hold = new Hold(30);

        s1.addItem(new Item("Toothpaste", 1));
        s1.addItem(new Item("Clothes", 7));
        s2.addItem(new Item("Clothes", 5));
        s2.addItem(new Item("Glasses", 1));
        s2.addItem(new Item("Souvenirs", 2));

        hold.addSuitcase(s1);
        hold.addSuitcase(s2);

        System.out.println("Suitcase 1: " + s1);
        System.out.println("Suitcase 1: " + s2);
        System.out.println("Suitcase 1 - heaviest:\n" + s2.heaviestItem());

        System.out.println("Hold: " + hold);
    }
}
