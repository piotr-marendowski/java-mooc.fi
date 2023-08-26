import java.util.ArrayList;
import java.util.Scanner;

class Bird {
    private String name;
    private String nameLatin;
    private int observations;

    public Bird(String name, String nameLatin) {
        this.name = name;
        this.nameLatin = nameLatin;
        this.observations = 0;
    }

    public String getName() {
        return this.name;
    }

    public void addObeservation() {
        this.observations++;
    }

    @Override
    public String toString() {
        return name + " (" + nameLatin + ")" + ": " + observations + " observations";
    }
}

class BirdDatabase {
    private ArrayList<Bird> birds;

    public BirdDatabase() {
        this.birds = new ArrayList<>();
    }

    public int getSize() {
        return this.birds.size();
    }

    public void add(Scanner scanner) {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Name in Latin: ");
        String nameLatin = scanner.nextLine();

        this.birds.add(new Bird(name, nameLatin));
    }

    public int searchForIndex(String name) {
        for (int i = 0; i < this.birds.size(); i++) {
            if (this.birds.get(i).getName().equals(name))
                return i;
        }

        return -1;
    }

    public void observation(Scanner scanner) {
        System.out.print("Bird? ");
        String name = scanner.nextLine();

        int index = searchForIndex(name);

        if (index < 0) {
            System.out.println("Not a bird!");
            return;
        }

        this.birds.get(index).addObeservation();
    }

    public void print(int num, Scanner scanner) {
        if (num == this.birds.size()) {
            for (int i = 0; i < this.birds.size(); i++)
                System.out.println(this.birds.get(i));

        } else if (num == 1) {
            System.out.print("Bird? ");
            String name = scanner.nextLine();
            int index = searchForIndex(name);

            System.out.println(this.birds.get(index));
        } else {
            for (int i = 0; i < num; i++)
                System.out.println(this.birds.get(i));
        }
    }

}

class UserInterface {
    private Scanner scanner;
    private BirdDatabase database;

    public UserInterface(BirdDatabase database, Scanner scanner) {
        this.scanner = scanner;
        this.database = database;
    }

    public void start() {
        while (true) {
            System.out.print("? ");
            String cmd = scanner.nextLine();

            if (cmd.equals("Quit")) {
                break;
            } else if (cmd.equals("Add")) {
                database.add(scanner);
            } else if (cmd.equals("Observation")) {
                database.observation(scanner);
            } else if (cmd.equals("All")) {
                database.print(database.getSize(), scanner);
            } else if (cmd.equals("One")) {
                database.print(1, scanner);
            }
        }
    }

}

public class BigYear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BirdDatabase birds = new BirdDatabase();

        UserInterface ui = new UserInterface(birds, scanner);
        ui.start();
    }
}

/* Hierarchy:
 * Bird = base bird with observations and names
 * BirdDatabase = ArrayList with Bird objects and methods for this ArrayList 
 * UI = hijacks BirdDatabase and uses it, and scanner provides scanner to BirdDatabase's
 * methods that use it */
