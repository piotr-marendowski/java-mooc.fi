import java.util.Scanner;

public class Division {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numerator = Integer.valueOf(scanner.nextLine());
        int denominator = Integer.valueOf(scanner.nextLine());

        division(numerator, denominator);
    }
    
    public static void division(int numerator, int denominator) {
        System.out.println((double)numerator / denominator);
    }
}
