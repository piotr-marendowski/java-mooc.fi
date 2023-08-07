import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class NumbersFromAFile {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int numbers = 0;

        System.out.print("File? ");
        String filename = reader.nextLine();
        System.out.print("Lower bound? ");
        int lower = Integer.valueOf(reader.nextLine());
        System.out.print("Upper bound? ");
        int upper = Integer.valueOf(reader.nextLine());

        ArrayList<Integer> list = new ArrayList<>();
        
        try (Scanner scanner = new Scanner(Paths.get(filename))) {

            while (scanner.hasNextLine()) {
                int num = Integer.valueOf(scanner.nextLine());
                list.add(num);

                if (num >= lower && num <= upper) numbers++;
            }
        } catch (Exception e) {
            System.out.println("Reading the file " + filename + " failed");
            return;
        }

        System.out.print("Numbers: " + numbers);
    }
}
