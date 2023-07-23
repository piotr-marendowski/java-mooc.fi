import java.util.Scanner;

public class OnlyPositive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Give a number:");
            int number = Integer.valueOf(scanner.nextLine());

            if (number == 0) {
                break;
            } else if (number < 0) {
                System.out.println("Unsuitable number");
            } else {
                System.out.println(number * number);
            }
        }
    }
}
