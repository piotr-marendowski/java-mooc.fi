import java.util.HashMap;
import java.util.Scanner;

/* part 1 */
class TextUI {
    private Scanner scanner;
    private SimpleDictionary dict;

    public TextUI(Scanner scanner, SimpleDictionary dict) {
        this.scanner = scanner;
        this.dict = dict;
    }

    public void start() {
        while (true) {
            System.out.print("Enter a command: ");
            String cmd = scanner.nextLine();

            if (cmd.equals("end")) {
                System.out.println("Bye bye!");
                break;
            /* part 2 */
            } else if (cmd.equals("add")) {
                System.out.print("Word: ");
                String word = scanner.nextLine();

                System.out.print("Translation: ");
                String translation = scanner.nextLine();

                dict.add(word, translation);
                continue;
            /* part 3 */
            } else if (cmd.equals("search")) {
                System.out.print("To be translated: ");
                String word = scanner.nextLine();

                /* part 4 */
                if (dict.translate(word) == null) {
                    System.out.println("Word " + word + " was not found");
                    continue;
                }

                System.out.println("Translation: " + dict.translate(word));
                continue;
            } else
                System.out.println("Unknown command");
        }
    }
}

public class SimpleDictionary {
    private HashMap<String, String> translations;

    public SimpleDictionary() {
        this.translations = new HashMap<>();
    }

    public String translate(String word) {
        return this.translations.get(word);
    }

    public void add(String word, String translation) {
        this.translations.put(word, translation);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleDictionary dictionary = new SimpleDictionary();

        TextUI textUI = new TextUI(scanner, dictionary);
        textUI.start();
        System.out.println(dictionary.translate("pike")); // prints the string "hauki"
    }
}
