import java.util.ArrayList;
import java.util.Scanner;

/* part 2 */
class UserInterface {
    private Scanner scanner;
    private TodoList list;

    public UserInterface(TodoList list, Scanner scanner) {
        this.scanner = scanner;
        this.list = list;
    }

    public void start() {
        while (true) {
            System.out.print("Enter a command: ");
            String cmd = scanner.nextLine();

            if (cmd.equals("stop")) {
                break;
            } else if (cmd.equals("add")) {
                System.out.print("To add: ");
                String task = scanner.nextLine();

                list.add(task);
                continue;
            } else if (cmd.equals("list")) {
                list.print();
                continue;
            } else if (cmd.equals("remove")) {
                System.out.print("Which one is removed? ");
                int toRemove = Integer.valueOf(scanner.nextLine());

                list.remove(toRemove);
                continue;
            } else
                System.out.println("Unknown command");
        }
    }
}

/* part 1 */
public class TodoList {
    private ArrayList<String> list;

    public TodoList() {
        this.list = new ArrayList<String>();
    }

    public void add(String task) {
        this.list.add(task);
    }

    public void print() {
        for (String i : list)
            System.out.println((this.list.indexOf(i) + 1) + ": " + i);
    }

    public void remove(int number) {
        this.list.remove(number - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TodoList list = new TodoList();

        UserInterface ui = new UserInterface(list, scanner);
        ui.start();
    }
}
