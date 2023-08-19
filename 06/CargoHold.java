import java.util.ArrayList;

/* part 1 */
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

    public String toString() {
        return this.name + " (" + this.weight + " kg)";
    }
}

/* part 2 */
class Suitcase {
    private ArrayList<Item> items;
    private int maxWeight;
    private int weight;

    public Suitcase(int maxWeight) {
        this.items = new ArrayList<>();
        this.maxWeight = maxWeight;
        this.weight = 0;
    }

    public void addItem(Item item) {
        /* if this item's weight is greater or if this item + suitcase is greater */
        if ((item.getWeight() > this.maxWeight) || ((item.getWeight() + this.weight) > this.maxWeight))
            return;

        this.items.add(item);
        this.weight += item.getWeight();
    }

    public String toString() {
        /* part 3 */
        if (this.items.size() == 0)
            return "no items (0 kg)";

        /* if size is 1 then "1 item" otherwise "n items" */
        return this.items.size() + (this.items.size() == 1 ? " item" : " items") + " (" + this.weight + " kg)";
    }

    /* part 4 */
    public void printItems() {
        for (int i = 0; i < this.items.size(); i++)
            System.out.println(this.items.get(i).getName() + " (" + this.items.get(i).getWeight() + " kg)");
    }

    public int totalWeight() {
        return this.weight;
    }

    /* part 5 */
    public Item heaviestItem() {
        if (this.items.isEmpty())
            return null;

        Item heaviest = this.items.get(0);

        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i).getWeight() > heaviest.getWeight())
                heaviest = this.items.get(i);
        }

        return heaviest;
    }
}

/* part 6 */
class Hold {
    private ArrayList<Suitcase> suitcases;
    private int maxWeight;
    private int weight;

    public Hold(int maxWeight) {
        this.suitcases = new ArrayList<>();
        this.maxWeight = maxWeight;
        this.weight = 0;
    }

    public void addSuitcase(Suitcase suitcase) {
        /* if this suitcase's weight is greater or if this suitcase + hold is greater */
        if ((suitcase.totalWeight() > this.maxWeight) || ((suitcase.totalWeight() + this.weight) > this.maxWeight))
            return;

        this.suitcases.add(suitcase);
        this.weight += suitcase.totalWeight();
    }

    public String toString() {
        return this.suitcases.size() + " suitcases (" + this.weight + " kg)" ;
    }

    /* part 7 */
    public void printItems() {
        for (int i = 0; i < this.suitcases.size(); i++)
            this.suitcases.get(i).printItems();
    }
}

public class CargoHold {
    public static void main(String[] args) {
        Item book = new Item("Lord of the rings", 2);
        Item phone = new Item("Nokia 3210", 1);
        Item brick = new Item("Brick", 4);

        Suitcase adasCase = new Suitcase(10);
        adasCase.addItem(book);
        adasCase.addItem(phone);

        Suitcase pekkasCase = new Suitcase(10);
        pekkasCase.addItem(brick);

        Hold hold = new Hold(1000);
        hold.addSuitcase(adasCase);
        hold.addSuitcase(pekkasCase);

        System.out.println("The suitcases in the hold contain the following items:");
        hold.printItems();
    }
}
