import java.util.Scanner;

public class FromParameterToOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.valueOf(scanner.nextLine());

        printFromNumberToOne(number);
    }

    public static void printFromNumberToOne(int number) {
        int i;

        for (i = number; i >= 1; i--) System.out.println(i);
    }
}
