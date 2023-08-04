import java.util.Scanner;

public class LastWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String s1 = scanner.nextLine();

            if (s1.isEmpty()) break;

            String[] pieces = s1.split(" ");

            System.out.println(pieces[pieces.length - 1]);
        }
    }
}
