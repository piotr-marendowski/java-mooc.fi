import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class RecordsFromAFile {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.println("Name of the file:");
        String filename = reader.nextLine();

        ArrayList<String> list = new ArrayList<>();
        
        try (Scanner scanner = new Scanner(Paths.get(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                String[] parts = line.split(",");
                System.out.println(parts[0] + ", age: " + parts[1] + " years");
            }
        } catch (Exception e) {
            System.out.println("Reading the file " + filename + " failed");
            return;
        }
    }
}
