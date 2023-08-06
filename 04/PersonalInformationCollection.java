import java.util.ArrayList;
import java.util.Scanner;

public class PersonalInformationCollection {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<PersonalInformation> info = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.print("First name: ");
            String firstname = scanner.nextLine();

            if (firstname.isEmpty()) break;

            System.out.print("Last name: ");
            String lastname = scanner.nextLine();
            System.out.print("Identification number: ");
            String id = scanner.nextLine();

            info.add(new PersonalInformation(firstname, lastname, id));
        }

        for (PersonalInformation i: info)
            System.out.println(i.getFirstName() + " " + i.getLastName());
    }
}
