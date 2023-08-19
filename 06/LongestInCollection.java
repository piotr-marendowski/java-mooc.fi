import java.util.ArrayList;

class SimpleCollection {
    private String name;
    private ArrayList<String> elements;

    public SimpleCollection(String name) {
        this.name = name;
        this.elements = new ArrayList<>();
    }

    public void add(String element) {
        this.elements.add(element);
    }

    public ArrayList<String> getElements() {
        return this.elements;
    }

    public String longest() {
        if (this.elements.isEmpty())
            return null;

        String longest = this.elements.get(0);

        for (int i = 0; i < elements.size(); i++) {
            if (longest.length() < elements.get(i).length())
                longest = this.elements.get(i);
        }

        return longest;
    }
}

public class LongestInCollection {
    public static void main(String[] args) {
        SimpleCollection j = new SimpleCollection("characters");
        System.out.println("Longest: " + j.longest());

        j.add("magneto");
        j.add("mystique");
        j.add("phoenix");

        System.out.println("Longest: " + j.longest());
    }
}
