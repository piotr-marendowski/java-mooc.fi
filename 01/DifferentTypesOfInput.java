import java.util.Scanner;

public class DifferentTypesOfInput {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Give a string:");
        String text = scanner.nextLine();
        System.out.println("Give an integer:");
        int integer = Integer.valueOf(scanner.nextLine());
        System.out.println("Give a double:");
        double floating = Double.valueOf(scanner.nextLine());
        System.out.println("Give a boolean:");
        boolean trueorfalse = Boolean.valueOf(scanner.nextLine());

        System.out.println("You gave string " + text);
        System.out.println("You gave integer " + integer);
        System.out.println("You gave double " + floating);
        System.out.println("You gave boolean " + trueorfalse);
    }
}
