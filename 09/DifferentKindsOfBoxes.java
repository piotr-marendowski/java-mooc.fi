import java.util.ArrayList;

abstract class Box {
    public abstract void add(Item item);

    public void add(ArrayList<Item> items) {
        for (Item item : items)
            Box.this.add(item);
    }

    public abstract boolean isInBox(Item item);
}

class Item {
    private String name;
    private int weight;

    public Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public Item(String name) {
        this(name, 0);
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    /* part 1 */
    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;

        if (!(object instanceof Item))
            return false;

        Item compared = (Item) object;
        if (this.name.equals(compared.name))
            return true;

        return false;
    }
}

/* part 2 */
class BoxWithMaxWeight extends Box {
    private int capacity;
    private ArrayList<Item> items;

    public BoxWithMaxWeight(int capacity) {
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }

    @Override
    public void add(Item item) {
        if ((item.getWeight() + this.capacity) <= this.capacity) {
            this.items.add(item);
        }
    }

    @Override
    public boolean isInBox(Item item) {
        for (Item i: items) {
			if (i.equals(item)) {
				return true;
			}
		}
		return false;
    }
}

public class DifferentKindsOfBoxes {
    public static void main(String[] args) {
        BoxWithMaxWeight coffeeBox = new BoxWithMaxWeight(10);
        coffeeBox.add(new Item("Saludo", 5));
        coffeeBox.add(new Item("Pirkka", 5));
        coffeeBox.add(new Item("Kopi Luwak", 5));

        System.out.println(coffeeBox.isInBox(new Item("Saludo")));
        System.out.println(coffeeBox.isInBox(new Item("Pirkka")));
        System.out.println(coffeeBox.isInBox(new Item("Kopi Luwak")));
    }
}
