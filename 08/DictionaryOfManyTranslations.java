import java.util.HashMap;
import java.util.ArrayList;

public class DictionaryOfManyTranslations {
    private HashMap<String, ArrayList<String>> dictionary;

    public DictionaryOfManyTranslations() {
        this.dictionary = new HashMap<>();
    }

    public void add(String word, String translation) {
        this.dictionary.putIfAbsent(word, new ArrayList<>());

        ArrayList<String> translations = this.dictionary.get(word);

        translations.add(translation);
    }

    public ArrayList<String> translate(String word) {
        for (String i: this.dictionary.keySet()) {
            if (i.contains(word))
                return this.dictionary.get(word);
        }

        return new ArrayList<>();
    }

    public void remove(String word) {
        for (String i: this.dictionary.keySet()) {
            if (i.contains(word))
                this.dictionary.remove(word);
        }
    }

    public static void main(String[] args) {
        DictionaryOfManyTranslations dictionary = new DictionaryOfManyTranslations();
        dictionary.add("lie", "maata");
        dictionary.add("lie", "valehdella");

        dictionary.add("bow", "jousi");
        dictionary.add("bow", "kumartaa");

        System.out.println(dictionary.translate("lie"));
        dictionary.remove("bow");
        System.out.println(dictionary.translate("bow"));
    }
}
