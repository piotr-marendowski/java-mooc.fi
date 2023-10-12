package dictionary;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.PrintWriter;

public class SaveableDictionary {
    Map<String, String> dictionary;
    private String filename;

    public SaveableDictionary() { this.dictionary = new HashMap<>(); }

    public void add(String words, String translation) {
        if (dictionary.containsKey(words))
            return;

        // translations work in both ways
        this.dictionary.put(words, translation);
        this.dictionary.put(translation, words);
    }

    public String translate(String word) {
        if (this.dictionary.containsKey(word))
            return this.dictionary.get(word);

        return null;
    }

    // part 2
    public void delete(String word) {
        String translation = this.translate(word);

        // delete both translations
        this.dictionary.remove(word);
        this.dictionary.remove(translation);
    }

    // part 3
    public SaveableDictionary(String file) {
        this();
        this.filename = file;
    }

    public boolean load() {
        try {
            File file = new File(this.filename);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] words = line.split(":");

                // write both translations
                this.dictionary.put(words[0], words[1]);
                this.dictionary.put(words[1], words[0]);
            }
        } catch (Exception e) {
            System.out.println("Error reading file");
            return false;
        }

        return true;
    }

    // part 4
    public boolean save() {
        // delete double translations:
        // don't use this.remove() because it deletes both translations
        HashMap<String, String> copy = new HashMap<>(this.dictionary);
        for (String key: copy.keySet()) {
            String translation = this.translate(key);
            this.dictionary.remove(translation);
        }

        System.out.println(this.dictionary);

        // overwrite file
        try {
            PrintWriter writer = new PrintWriter(this.filename);
            String translation;

            for (String key: this.dictionary.keySet()) {
                translation = this.translate(key);

                writer.print(key);
                writer.print(":");
                writer.println(translation);
            }

            writer.close();
        } catch (Exception e) {
            System.out.println("Error writing file");
        }

        return true;
    }
}
