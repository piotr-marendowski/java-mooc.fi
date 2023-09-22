import java.util.ArrayList;
import java.util.Collections;

class Human implements Comparable<Human> {
    private int wage;
    private String name;

    public Human(String name, int wage) {
        this.name = name;
        this.wage = wage;
    }

    public String getName() {
        return name;
    }

    public int getWage() {
        return wage;
    }

    @Override
    public String toString() {
        return name + " " + wage;
    }

    @Override
    public int compareTo(Human obj) {
        return obj.getWage() - this.wage;
    }
}

public class WageOrder {
    public static void main(String[] args) {
        ArrayList<Human> humans = new ArrayList<>();
        humans.add(new Human("Matti", 150000));
        humans.add(new Human("Merja", 500));
        humans.add(new Human("Pertti", 80));

        System.out.println(humans);

        /*
         * Uncomment the comment below when you have completed the compareTo-method.
         */
        Collections.sort(humans);
        System.out.println(humans);       
    }
}
