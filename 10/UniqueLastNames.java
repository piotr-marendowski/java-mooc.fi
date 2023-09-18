import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

class Person {
    private String firstName;
    private String lastName;
    private int birthYear;

    public Person(String firstName, String lastName, int birthYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getBirthYear() {
        return birthYear;
    }
}

public class UniqueLastNames {
    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Input first name: ");
            String firstName = scanner.nextLine();
            System.out.print("Input last name: ");
            String lastName = scanner.nextLine();
            System.out.print("Input the year of birth: ");
            int year = Integer.valueOf(scanner.nextLine());

            persons.add(new Person(firstName, lastName, year));

            System.out.println("Continue personal information input? 'quit' ends:");
            if (scanner.nextLine().equals("quit"))
                break;
        }

        System.out.println("");
        System.out.println("Unique last names in alphabetical order:");
        persons.stream()
            .map(person -> person.getLastName())
            .distinct()
            .sorted()
            .forEach(name -> System.out.println(name));

        scanner.close();
    }
}
