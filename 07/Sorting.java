import java.util.Arrays;

public class Sorting {
    /* part 1 */
    public static int smallest(int[] array) {
        int smallest = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] < smallest)
                smallest = array[i];
        }
        return smallest;
    }

    /* part 2 */
    public static int indexOfSmallest(int[] array) {
        int smallest = smallest(array);

        for (int i = 0; i < array.length; i++) {
            if (array[i] == smallest)
                return i;
        }
        return 0;
    }
    
    /* part 3 */
    public static int indexOfSmallestFrom(int[] table, int startIndex) {
        int smallest = table[startIndex];
        int index = 0;

        for (int i = startIndex; i < table.length; i++) {
            if (table[i] <= smallest) {
                index = i;
                smallest = table[i];
            }
        }
        return index;
    }

    /* part 4 */
    public static void swap(int[] array, int index1, int index2) {
        int a = array[index1];
        int b = array[index2];

        int c = b;
        b = a;
        a = c;

        array[index1] = a;
        array[index2] = b;
    }

    /* part 5 */
    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array));
            int smallest = indexOfSmallestFrom(array, i);
            swap(array, i, smallest);
        }
    }

    public static void main(String[] args) {
        int[] numbers = {8, 3, 7, 9, 1, 2, 4};
        sort(numbers);
    }
}
