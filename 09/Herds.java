import java.util.ArrayList;
import java.util.List;

interface Movable {
    void move(int dx, int dy);
}

/* part 1 */
class Organism implements Movable {
    private int x, y;

    public Organism(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "x: " + this.x + "; y: " + this.y;
    }

    @Override
    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }
}

/* part 2 */
class Herd implements Movable {
    private List<Movable> herd;

    public Herd() {
        this.herd = new ArrayList<>();
    }

    @Override
    public String toString() {
        String output = "";

        for (Movable i: this.herd)
            output += (i.toString() + "\n");

        return output;
    }

    public void addToHerd(Movable movable) {
        this.herd.add(movable);
    }

    @Override
    public void move(int dx, int dy) {
        for (Movable i: this.herd) {
            i.move(dx, dy);
        }
    }
}

public class Herds {
    public static void main(String[] args) {
        Herd herd = new Herd();
        herd.addToHerd(new Organism(57, 66));
        herd.addToHerd(new Organism(73, 56));
        herd.addToHerd(new Organism(46, 52));
        herd.addToHerd(new Organism(19, 107));
        System.out.println(herd);
    }
}
