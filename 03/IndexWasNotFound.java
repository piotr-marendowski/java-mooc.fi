import java.util.Scanner;

public class IndexWasNotFound {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];

        numbers[0] = 1;
        numbers[1] = 3;
        numbers[2] = 5;
        numbers[3] = 7;
        numbers[4] = 9;

        System.out.println("Search for?");
        int num = Integer.valueOf(scanner.nextLine());

        int i = 0;
        while (i < numbers.length) {
            if (numbers[i] == num) {
                System.out.println(num + " is at index " + i);
                return;
            }

            i++;
        }

        System.out.println(num + " was not found.");
    }
}
