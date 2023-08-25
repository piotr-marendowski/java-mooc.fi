import java.util.Scanner;

/* part 2 */
class UserInterface {
    private Scanner scanner;
    private Container c1;
    private Container c2;

    public UserInterface(Container c1, Container c2, Scanner scanner) {
        this.scanner = scanner;
        this.c1 = c1;
        this.c2 = c2;
    }

    public void start() {
        while (true) {
            System.out.println("First: " + this.c1.contains() + "/100");
            System.out.println("Second: " + this.c2.contains() + "/100");

            String input = scanner.nextLine();
            String[] parts = input.split(" ");

            String command = parts[0];
            int amount = Integer.valueOf(parts[1]);

            if (command.equals("quit")) {
                break;
            } else if (command.equals("add")) {
                this.c1.add(amount);
            } else if (command.equals("move")) {
                this.c1.remove(amount);
                this.c2.add(amount);
            } else if (command.equals("remove")) {
                this.c2.remove(amount);
            }
        }
    }
}

/* part 1 */
class Container {
    private int amount;

    public Container() {
        this.amount = 0;
    }

    public int contains() {
        return this.amount;
    }

    public void add(int amount) {
        if ((this.amount + amount) >= 100)
            this.amount = 100;
        else
            this.amount += amount;
    }

    public void remove(int amount) {
        if ((this.amount - amount) <= 0) {
            this.amount = 0;
        } else
            this.amount -= amount;
    }

    public String toString() {
        return this.amount + "/100";
    }
}

public class LiquidContainers2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Container c1 = new Container();
        Container c2 = new Container();

        UserInterface ui = new UserInterface(c1, c2, scanner);
        ui.start();
    }
}
