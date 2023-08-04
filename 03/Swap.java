import java.util.Scanner;

public class Swap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];

        numbers[0] = 1;
        numbers[1] = 3;
        numbers[2] = 5;
        numbers[3] = 7;
        numbers[4] = 9;

        for (int i = 0; i < 5; i++)
            System.out.println(numbers[i]);

        System.out.println("Give two indices to swap:");
        int indice_one = Integer.valueOf(scanner.nextLine());
        int indice_two = Integer.valueOf(scanner.nextLine());

        int temp = numbers[indice_one];
        numbers[indice_one] = numbers[indice_two];
        numbers[indice_two] = temp;

        System.out.println("");

        for (int i = 0; i < 5; i++)
            System.out.println(numbers[i]);
    }
}
