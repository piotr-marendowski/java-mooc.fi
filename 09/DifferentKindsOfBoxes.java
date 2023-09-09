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
    private int boxWeight;
    private ArrayList<Item> items;

    public BoxWithMaxWeight(int capacity) {
        this.capacity = capacity;
        this.boxWeight = 0;
        this.items = new ArrayList<>();
    }

    @Override
    public void add(Item item) {
        if ((item.getWeight() + this.boxWeight) <= this.capacity) {
            this.items.add(item);
            this.boxWeight += item.getWeight();
        }
    }

    @Override
    public boolean isInBox(Item item) {
        for (Item i: items) {
			if (i.equals(item))
				return true;
		}

		return false;
    }
}

/* part 3 */
class OneItemBox extends Box {
    private boolean hasItem;
    private Item item;

    public OneItemBox() {
        this.hasItem = false;
        this.item = (Item) item;
    }

    @Override
    public void add(Item item) {
        if (!this.hasItem) {
            this.item = item;
            this.hasItem = true;
        }
    }

    @Override
    public boolean isInBox(Item item) {
        return this.item.getName().equals(item.getName());
    }
}

class MisplacingBox extends Box {
    private ArrayList<Item> items;

    public MisplacingBox() {
        this.items = new ArrayList<>();
    }

    @Override
    public void add(Item item) {
        this.items.add(item);
    }

    @Override
    public boolean isInBox(Item item) {
		return false;
    }
}

public class DifferentKindsOfBoxes {
    public static void main(String[] args) {
        MisplacingBox box = new MisplacingBox();
        box.add(new Item("Saludo", 5));
        box.add(new Item("Pirkka", 5));

        System.out.println(box.isInBox(new Item("Saludo")));
        System.out.println(box.isInBox(new Item("Pirkka")));
    }
}
