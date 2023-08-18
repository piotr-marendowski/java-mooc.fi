import java.util.ArrayList;

public class Stack {
    private ArrayList<String> stack;

    public Stack() {
        this.stack = new ArrayList<>();
    }

    /* part 1 */
    public boolean isEmpty() {
        if (stack.isEmpty())
            return true;
        else
            return false;
    }

    public void add(String value) {
        this.stack.add(value);
    }

    public ArrayList<String> values() {
        return this.stack;
    }

    /* part 2 */
    public String take() {
        int top = (this.stack.size() - 1);
        String var = this.stack.get(top);

        this.stack.remove(this.stack.get(top));

        return var;
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.add("1");
        s.add("2");
        s.add("3");
        s.add("4");
        s.add("5");

        while (!s.isEmpty()) {
            System.out.println(s.take());
        }
    }
}
