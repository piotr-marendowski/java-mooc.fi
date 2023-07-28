import java.util.Scanner;
import java.util.ArrayList;

public class RememberTheseNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        int num;

        while (true) {
            num = Integer.valueOf(scanner.nextLine());

            if (num == -1) break;

            numbers.add(num);
        }

        for (int i = 0; i < numbers.size(); i++)
            System.out.println(numbers.get(i));
    }
}
