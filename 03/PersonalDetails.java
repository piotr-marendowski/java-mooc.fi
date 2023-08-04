import java.util.Scanner;

public class PersonalDetails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0, longest = 0, i = 0, age;
        String name = "";

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("")) {
                break;
            }

            String[] parts = input.split(",");
            age = Integer.valueOf(parts[1]);

            if (parts[0].length() > longest) {
                name = parts[0];
                longest = parts[0].length();
            }

            sum += age;
            i++;
        }

        System.out.println("Longest name: " + name);
        System.out.println("Average of the birth years: " + (1.0 * sum / i));
    }
}
