import java.util.ArrayList;
import java.util.Scanner;
import java.nio.file.Paths;

class UserInterface {
    private Scanner scanner;
    private ArrayList<Recipe> recipes;

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
        this.recipes = new ArrayList<>();
    }

    public void listAll() {
        System.out.println("");
        System.out.println("Recipes:");
        for (int i = 0; i < this.recipes.size(); i++)
            System.out.println(this.recipes.get(i));

        System.out.println("");
    }
    
    /* part 2 */
    public void findByName() {
        System.out.print("Searched word: ");
        String word = scanner.nextLine();

        for (int i = 0; i < this.recipes.size(); i++) {
            if (this.recipes.get(i).getName().contains(word))
                System.out.println(this.recipes.get(i));
        }
        System.out.println("");
    }

    /* part 3 */
    public void findByTime() {
        System.out.print("Max cooking time: ");
        int time = Integer.valueOf(scanner.nextLine());

        for (int i = 0; i < this.recipes.size(); i++) {
            if (this.recipes.get(i).getTime() <= time)
                System.out.println(this.recipes.get(i));
        }
        System.out.println("");
    }

    /* part 4 */
    public void findByIngredient() {
        System.out.print("Ingredient: ");
        String ingredient = scanner.nextLine();

        for (int i = 0; i < this.recipes.size(); i++) {
            ArrayList<String> ingredients = this.recipes.get(i).getIngredients();
            for (int j = 0; j < ingredients.size(); j++) {
                if (ingredients.get(j).equals(ingredient))
                    System.out.println(this.recipes.get(i));
            }
        }
        System.out.println("");
    }

    public void start() {
        System.out.print("File to read: ");
        String filename = scanner.nextLine();

        try (Scanner scanner = new Scanner(Paths.get(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String name = line;

                line = scanner.nextLine();
                int time = Integer.valueOf(line);

                ArrayList<String> ingredients = new ArrayList<>();

                while (scanner.hasNextLine()) {
                    line = scanner.nextLine();
                    if (!line.equals(""))
                        ingredients.add(line);
                    else
                        break;
                }
                
                this.recipes.add(new Recipe(name, time, ingredients));
            }
        } catch (Exception e) {
            System.out.println("Reading the file " + filename + " failed");
        }

        System.out.println("Commands:");
        System.out.println("list - lists the recipes");
        System.out.println("stop - stops the program");
        System.out.println("find name - searches recipes by name");
        System.out.println("find cooking time - searches recipes by cooking time");
        System.out.println("find ingredient - searches recipes by ingredient");

        while (true) {
            System.out.print("Enter a command: ");
            String cmd = scanner.nextLine();

            if (cmd.equals("stop")) {
                break;
            } else if (cmd.equals("list")) {
                listAll();
            } else if (cmd.equals("find name")) {
                findByName();
            } else if (cmd.equals("find cooking time")) {
                findByTime();
            } else if (cmd.equals("find ingredient")) {
                findByIngredient();
            }
        }
    }
}

class Recipe {
    private String name;
    private int time;
    private ArrayList<String> ingredients;

    public Recipe(String name, int time, ArrayList<String> ingredients) {
        this.name = name;
        this.time = time;
        this.ingredients = ingredients;
    }

    public String getName() {
        return this.name;
    }

    public int getTime() {
        return this.time;
    }

    public ArrayList<String> getIngredients() {
        return this.ingredients;
    }

    @Override
    public String toString() {
        return this.name + ", cooking time: " + this.time;
    }
}

public class RecipeSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UserInterface ui = new UserInterface(scanner);
        ui.start();
    }
}
