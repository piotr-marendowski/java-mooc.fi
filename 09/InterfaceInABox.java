import java.util.ArrayList;

interface Packable {
    double weight();
}

class Book implements Packable {
    private double weight;
    private String author;
    private String name;

    public Book(String author, String name, double weight) {
        this.author = author;
        this.name = name;
        this.weight = weight;
    }
    
    public double weight() {
        return this.weight;
    }

    @Override
    public String toString() {
        return this.author + ": " + this.name;
    }
}

class CD implements Packable {
    private double weight;
    private int year;
    private String artist;
    private String name;

    public CD(String artist, String name, int year) {
        this.artist = artist;
        this.name = name;
        this.weight = 0.1;
        this.year = year;
    }

    public double weight() {
        return this.weight;
    }

    @Override
    public String toString() {
        return this.artist + ": " + this.name + " (" + this.year + ")" ;
    }
}

/* part 2 */
class Box implements Packable {
    private ArrayList<Packable> items;
    private double capacity;

    public Box(double capacity) {
        this.items = new ArrayList<>();
        this.capacity = capacity;
    }

    /* part 3 */
    public void add(Packable item) {
        double weight = 0.0;
        for (Packable i: items)
            weight += i.weight();

        if ((weight + item.weight()) > this.capacity)
            return;

        this.items.add(item);
    }

    public double weight() {
        double weight = 0;
        
        for (Packable i: this.items)
            weight += i.weight();

        return weight;
    }

    @Override
    public String toString() {
        return "Box: " + this.items.size() + " items, total weight " + this.weight() + " kg";
    }
}

class InterfaceInABox {
    public static void main(String[] args) {
        Box box = new Box(10);

        box.add(new Book("Fyodor Dostoevsky", "Crime and Punishment", 2)) ;
        box.add(new Book("Robert Martin", "Clean Code", 1));
        box.add(new Book("Kent Beck", "Test Driven Development", 0.7));

        box.add(new CD("Pink Floyd", "Dark Side of the Moon", 1973));
        box.add(new CD("Wigwam", "Nuclear Nightclub", 1975));
        box.add(new CD("Rendezvous Park", "Closer to Being Here", 2012));

        System.out.println(box);

        Box boxInBox = new Box(10);

        boxInBox.add(new Book("author", "book", 2));
        boxInBox.add(new CD("artist", "song", 2023));
        boxInBox.add(new Box(5));

        // boxInBox.add(boxInBox);

        System.out.println(boxInBox);
    }
}
