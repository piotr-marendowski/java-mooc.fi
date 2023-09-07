import java.util.ArrayList;

class Warehouse {
    private double capacity;
    private double balance;

    public Warehouse(double capacity) {
        if (capacity > 0.0)
            this.capacity = capacity;
        else
            this.capacity = 0.0;

        this.balance = 0.0;
    }

    public double getBalance() {
        return this.balance;
    }

    public double getCapacity() {
        return this.capacity;
    }

    public double howMuchSpaceLeft() {
        return this.capacity - this.balance;
    }

    public void addToWarehouse(double amount) {
        if (amount < 0)
            return;

        if (amount <= howMuchSpaceLeft())
            this.balance = this.balance + amount;
        else
            this.balance = this.capacity;
    }

    public double takeFromWarehouse(double amount) {
        if (amount < 0)
            return 0.0;

        if (amount > this.balance) {
            double allThatWeCan = this.balance;
            this.balance = 0.0;
            return allThatWeCan;
        }

        this.balance = this.balance - amount;
        return amount;
    }

    @Override
    public String toString() {
        return "balance = " + this.balance + ", space left " + howMuchSpaceLeft();
    }
}

/* part 1 */
class ProductWarehouse extends Warehouse {
    private String name;

    public ProductWarehouse(String productName, double capacity) {
        super(capacity);
        this.name = productName;
    }

    public String getName() {
        return name;
    }

    /* part 2 */
    public void setName(String newName) {
        this.name = newName;
    }

    @Override
    public String toString() {
        return this.name + ": " + super.toString();
    }
}

/* part 3 */
class ChangeHistory {
    private ArrayList<Double> history;

    public ChangeHistory() {
        this.history = new ArrayList<>();
    }

    public void add(double status) {
        this.history.add(status);
    }

    public void clear() {
        this.history.clear();
    }

    @Override
    public String toString() {
        return this.history.toString();
    }

    /* part 4 */
    public double maxValue() {
        if (this.history.isEmpty())
            return 0.0;

        double biggest = 0.0;
        for (double i: this.history) {
            if (i > biggest)
                biggest = i;
        }

        return biggest;
    }

    public double minValue() {
        if (this.history.isEmpty())
            return 0.0;

        double lowest = this.history.get(0);
        for (double i: this.history) {
            if (i < lowest)
                lowest = i;
        }

        return lowest;
    }

    public double average() {
        double sum = 0.0;
        for (double i: this.history) {
            sum += i; 
        }

        return (sum / this.history.size());
    }
}

/* part 5 */
class ProductWarehouseWithHistory extends ProductWarehouse {
    private ChangeHistory history;

    public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance) {
        super(productName, capacity);
        super.addToWarehouse(initialBalance);
        this.history = new ChangeHistory();
        this.history.add(initialBalance);
    }

    public String history() {
        return this.history.toString(); 
    }

    /* part 6 */
    @Override
    public void addToWarehouse(double amount) {
        super.addToWarehouse(amount);
        this.history.add(super.getBalance());
    }

    @Override
    public double takeFromWarehouse(double amount) {
        double taken = super.takeFromWarehouse(amount);
        
        this.history.add(super.getBalance());
        return taken;
    }

    /* part 7 */
    public void printAnalysis() {
        System.out.println("Product: " + super.getName());
        System.out.println("History: " + this.history());
        System.out.println("Largest amount of product: " + this.history.maxValue());
        System.out.println("Smallest amount of product: " + this.history.minValue());
        System.out.println("Average: " + this.history.average());
    }
}

public class Warehousing {
    public static void main(String[] args) {
        ProductWarehouseWithHistory juice = new ProductWarehouseWithHistory("Juice", 1000.0, 1000.0);
        juice.takeFromWarehouse(11.3);
        juice.addToWarehouse(1.0);
        //System.out.println(juice.history()); // [1000.0, 988.7, 989.7]

        juice.printAnalysis();
    }
}
