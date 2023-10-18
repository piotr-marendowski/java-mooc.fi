import java.util.Random;
import java.util.Scanner;

public class Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("How many random numbers should be printed?");
        int length = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < length; i++) {
            int num = rand.nextInt(10);
            System.out.println(num);
        }
    }
}
