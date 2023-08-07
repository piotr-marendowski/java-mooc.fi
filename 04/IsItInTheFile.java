import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class IsItInTheFile {
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
            System.out.println("Reading the file " + filename + " failed");
            return;
        }

        System.out.println("Search for:");

        String name = reader.nextLine();

        if (list.contains(name))
            System.out.println("Found!");
        else
            System.out.println("Not found.");
    }
}
