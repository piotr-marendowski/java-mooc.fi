import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/* part 1 */
enum Education {
    PHD, MA, BA, HS;
}

/* part 2 */
class Person {
    private String name;
    private Education education;

    public Person(String name, Education education) {
        this.name = name;
        this.education = education;
    }

    public Education getEducation() {
        return this.education;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.education;
    }
}

/* part 3 */
class Employees {
    private List<Person> employees;

    public Employees() {
        this.employees = new ArrayList<>();
    }

    public void add(Person personToAdd) {
        this.employees.add(personToAdd);
    }

    public void add(List<Person> peopleToAdd) {
        for (Person i: peopleToAdd)
            this.employees.add(i);
    }

    public void print() {
        Iterator<Person> iterator = this.employees.iterator();

        while (iterator.hasNext())
            System.out.println(iterator.next());
    }

    public void print(Education education) {
        Iterator<Person> iterator = this.employees.iterator();

        /* iterator needs to be a variable in order to be printed */
        while (iterator.hasNext()) {
            Person person = iterator.next();

            if (person.getEducation() == education)
                System.out.println(person);
        }
    }

    /* part 4 */
    public void fire(Education education) {
        Iterator<Person> iterator = this.employees.iterator();

        while(iterator.hasNext()) {
            Person person = iterator.next();

            if (person.getEducation() == education)
                iterator.remove();
        }
    }
}

public class EnumAndIterator {   
    public static void main(String[] args) {
        Employees university = new Employees();
        university.add(new Person("Petrus", Education.PHD));
        university.add(new Person("Arto", Education.HS));
        university.add(new Person("Elina", Education.PHD));

        university.print();

        university.fire(Education.HS);

        System.out.println("==");

        university.print();
    }
}
