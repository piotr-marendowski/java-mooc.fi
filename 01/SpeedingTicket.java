import java.util.Scanner;

public class SpeedingTicket {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Give speed:");
        int first = Integer.valueOf(scanner.nextLine());

        if (first > 120) {
            System.out.println("Speeding ticket!");
        }
    }
}
