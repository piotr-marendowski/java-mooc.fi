import java.util.Scanner;

public class NameOfTheOldest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int age, oldest = 0, i = 0;
        String name = "";

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("")) {
                break;
            }

            String[] parts = input.split(",");
            age = Integer.valueOf(parts[1]);
            if (age > oldest) {
                name = parts[0];
                oldest = Integer.valueOf(parts[1]);
            }

            i++;
        }

        System.out.println("Name of the oldest: " + name);
    }
}
