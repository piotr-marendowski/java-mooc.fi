import java.util.ArrayList;
import java.util.List;

public class Pipe<T> {
    private List<T> values;

    public Pipe() { this.values = new ArrayList<T>(); }

    public void putIntoPipe(T value) { this.values.add(value); }

    public T takeFromPipe() {
        if (this.values.isEmpty())
            return null;

        T value = this.values.get(0);
        this.values.remove(0);
        return value;
    }

    public boolean isInPipe() {
        if (this.values.isEmpty())
            return false;
        else
            return true;
    }

    public static void main(String[] args) {
        Pipe<Integer> numberPipe = new Pipe<>();
        numberPipe.putIntoPipe(1);
        numberPipe.putIntoPipe(2);
        numberPipe.putIntoPipe(3);

        int sum = 0;
        while (numberPipe.isInPipe()) {
            sum = sum + numberPipe.takeFromPipe();
        }
        System.out.println(sum);
        System.out.println(numberPipe.takeFromPipe());
    }
}
