public class PrintNeatly {
    public static void main(String[] args) {
        int[] array = {5, 1, 3, 4, 2};

        printArrayInStars(array);
    }
    public static void printArrayInStars(int[] array) {
        int i = 0, j = 0;

        for (; i < array.length; i++) {
            for (j = array[i]; j > 0; j--) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
