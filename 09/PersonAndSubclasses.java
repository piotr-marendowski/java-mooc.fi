import java.util.ArrayList;

class Person {
    private String name;
    private String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return this.name + "\n  " + this.address;
    }
}

/* part 2 */
class Student extends Person {
    private int credits;

    public Student(String name, String address) {
        super(name, address);
        this.credits = 0;
    }

    public void study() {
        this.credits++;
    }

    public int credits() {
        return credits;
    }

    /* part 3 */
    @Override
    public String toString() {
        return super.toString() + "\n  Study credits " + this.credits;
    }
}

/* part 4 */
class Teacher extends Person {
    private int salary;

    public Teacher(String name, String address, int salary) {
        super(name, address);
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString() + "\n  Salary " + this.salary + " euro/month ";
    }
}

public class PersonAndSubclasses {
    /* part 5 */
    public static void printPersons(ArrayList<Person> persons) {
        for (Person i: persons)
            System.out.println(i);
    }

    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<Person>();
        persons.add(new Teacher("Ada Lovelace", "24 Maddox St. London W1S 2QN", 1200));
        persons.add(new Student("Ollie", "6381 Hollywood Blvd. Los Angeles 90028"));

        printPersons(persons);
    }
}
