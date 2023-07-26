import java.util.Scanner;

public class FromWhereToWhere {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i;

        System.out.println("Where to?");
        int whereto = Integer.valueOf(scanner.nextLine());
        System.out.println("Where from?");
        int wherefrom = Integer.valueOf(scanner.nextLine());

        for (i = wherefrom; i <= whereto; i++) {
            System.out.println(i);
        }
    }
}
