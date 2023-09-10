import java.util.Set;
import java.util.HashSet;

public class SetAsAMethodParameter {
    public static int returnSize(Set<String> set) {
        return set.size();
    }

    public static void main(String[] args) {
        Set<String> names = new HashSet<>();
        names.add("first");
        names.add("first");
        names.add("second");
        names.add("second");
        names.add("second");

        System.out.println(returnSize(names));
    }
}
