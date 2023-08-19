import java.util.ArrayList;
import java.util.Objects;

class Person {
    private String name;
    private int height;

    public Person(String name, int height) {
        this.name = name;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return this.name + " (" + this.height + " cm)";
    }

    // Created with the insert code functionality of NetBeans
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (this.height != other.height) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
}

/* part 1 */
class Room {
    private ArrayList<Person> room;

    public Room() {
        this.room = new ArrayList<>();
    }

    public void add(Person person) {
        this.room.add(person);
    }

    public boolean isEmpty() {
        return this.room.isEmpty();
    }

    public ArrayList<Person> getPersons() {
        return this.room;
    }

    /* part 2 */
    public Person shortest() {
        if (this.room.isEmpty())
            return null;

        Person shortest = this.room.get(0);

        for (int i = 0; i < this.room.size(); i++) {
            if (shortest.getHeight() > this.room.get(i).getHeight())
                shortest = this.room.get(i);
        }

        return shortest;
    }

    /* part 3 */
    public Person take() {
        if (this.room.isEmpty())
            return null;

        Person shortest = shortest();

        this.room.remove(shortest);

        return shortest;
    }
}

public class HeightOrder {
    public static void main(String[] args) {
        Room room = new Room();
        room.add(new Person("Lea", 183));
        room.add(new Person("Kenya", 182));
        room.add(new Person("Auli", 186));
        room.add(new Person("Nina", 172));
        room.add(new Person("Terhi", 185));

        System.out.println("");
        for (Person person : room.getPersons()) {
            System.out.println(person);
        }

        System.out.println();
        System.out.println("Shortest: " + room.take());
        System.out.println("");
        for (Person person : room.getPersons()) {
            System.out.println(person);
        }
    }
}
