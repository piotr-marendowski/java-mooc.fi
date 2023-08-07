import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class GuestListFromAFile {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.println("Name of the file:");
        String filename = reader.nextLine();

        ArrayList<String> list = new ArrayList<>();
        
        try (Scanner scanner = new Scanner(Paths.get(filename))) {

            while (scanner.hasNextLine()) {
                String row = scanner.nextLine();
                list.add(row);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Enter names, an empty line quits.");

        while (true) {
            String name = reader.nextLine();
            if (name.isEmpty()) break;

            if (list.contains(name))
                System.out.println("The name is on the list.");
            else
                System.out.println("The name is not on the list.");
        }

        System.out.println("Thank you!");
    }
}
