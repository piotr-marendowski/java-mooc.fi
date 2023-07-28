import java.util.Scanner;
import java.util.ArrayList;

public class OnlyTheseNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        int num;

        while (true) {
            num = Integer.valueOf(scanner.nextLine());

            if (num == -1) break;

            numbers.add(num);
        }

        System.out.println("From where?");
        int start = Integer.valueOf(scanner.nextLine());

        System.out.println("To where?");
        int end = Integer.valueOf(scanner.nextLine());

        System.out.println("");
        for (int i = start; i <= end; i++)
            System.out.println(numbers.get(i));
    }
}
