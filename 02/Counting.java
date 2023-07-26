import java.util.Scanner;

public class Counting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int i;
        int number = Integer.valueOf(scanner.nextLine());

        for (i = 0; i < number; i++) {
            System.out.println(i);
        }
    }
}
