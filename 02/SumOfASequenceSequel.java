import java.util.Scanner;

public class SumOfASequenceSequel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i, sum;

        System.out.println("First number?");
        int firstnumber = Integer.valueOf(scanner.nextLine());
        System.out.println("Last number?");
        int lastnumber = Integer.valueOf(scanner.nextLine());

        for (i = firstnumber, sum = 0; i <= lastnumber; i++) {
            sum += i;
        }

        System.out.println("The sum is " + sum);
    }
}
