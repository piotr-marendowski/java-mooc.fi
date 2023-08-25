import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class ReadyMadeSortingAlgorithms {
    public static void sort(int[] array) {
        Arrays.sort(array);
    }

    public static void sort(String[] array) {
        Arrays.sort(array);
    }

    public static void sortIntegers(ArrayList<Integer> integers) {
        Collections.sort(integers);
    }

    public static void sortStrings(ArrayList<String> strings) {
        Collections.sort(strings);
    }

    public static void main(String[] args) {
        int[] numbers = {8, 3, 7, 9, 1, 2, 4};

        System.out.println(Arrays.toString(numbers));
        sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
