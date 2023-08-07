import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class StoringRecords {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        ArrayList<Person> people = new ArrayList<>();

        System.out.println("Name of the file:");
        String filename = reader.nextLine();

        people = readRecordsFromFile(filename);

        for (Person i: people)
        System.out.println(i);
    }
    public static ArrayList<Person> readRecordsFromFile(String filename) {
        ArrayList<Person> people = new ArrayList<>();

        try (Scanner scanner = new Scanner(Paths.get(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                String[] parts = line.split(",");
                String name = parts[0];
                int age = Integer.valueOf(parts[1]);

                people.add(new Person(name, age));
            }
        } catch (Exception e) {
            System.out.println("Reading the file " + filename + " failed");
            return people;
        }

        return people;
    }
}
