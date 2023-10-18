import java.lang.StringBuilder;

public class ArrayAsAString {
    public static String arrayAsString(int[][] array) {
        StringBuilder string = new StringBuilder();

        // go through each member of arrays of rows in this array
        // and in that every row go through each column's values
        for (int[] row : array) {
            for (int column : row)
                string.append(column);

            string.append("\n");
        }

        return string.toString();
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {3, 2, 7, 6},
            {2, 4, 1, 0},
            {3, 2, 1, 0}
        };

        System.out.println(arrayAsString(matrix));
    }
}
