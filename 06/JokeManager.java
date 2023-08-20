import java.util.ArrayList;
import java.util.Scanner;

/* part 2 */
class UserInterface {
    private Scanner scanner;
    private JokeManager jokes;

    public UserInterface(JokeManager jokes, Scanner scanner) {
        this.scanner = scanner;
        this.jokes = jokes;
    }

    public void start() {
        while (true) {
            System.out.println("Commands:");
            System.out.println("1 - add a joke");
            System.out.println("2 - draw a joke");
            System.out.println("3 - list jokes");
            System.out.println("X - stop");
            String cmd = scanner.nextLine();

            if (cmd.equals("X")) {
                break;
            } else if (cmd.equals("1")) {
                System.out.println("Write the joke to be added:");
                String joke = scanner.nextLine();

                this.jokes.addJoke(joke);
                continue;
            } else if (cmd.equals("2")) {
                System.out.println("Drawing a joke:");
                this.jokes.drawJoke();
                continue;
            } else if (cmd.equals("3")) {
                System.out.println("Printing the jokes.");
                this.jokes.printJokes();
                continue;
            } else
                System.out.println("Unknown command");
        }
    }
}

/* part 1 */
public class JokeManager {
    private ArrayList<String> jokes;

    public JokeManager() {
        this.jokes = new ArrayList<>();
    }

    public void addJoke(String joke) {
        this.jokes.add(joke);
    }

    public String drawJoke() {
        if (jokes.isEmpty())
            return "Jokes are in short supply.";

        int randomIndex = (int) (Math.random() * jokes.size());
        return jokes.get(randomIndex);
    }

    public void printJokes() {
        for (String joke : jokes)
            System.out.println(joke);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        JokeManager jokes = new JokeManager();

        UserInterface ui = new UserInterface(jokes, scanner);
        ui.start();
    }
}
