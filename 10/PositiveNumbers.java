import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PositiveNumbers {
    public static void main(String[] args) {
        List<Integer> values = new ArrayList<>();
        values.add(3);
        values.add(2);
        values.add(-17);
        values.add(-6);
        values.add(8);

        System.out.println(positive(values));
    }
    public static List<Integer> positive(List<Integer> numbers) {
        ArrayList<Integer> list = numbers.stream()
            .filter(number -> number >= 0) 
            .collect(Collectors.toCollection(ArrayList::new));

        return list;
    }
}
