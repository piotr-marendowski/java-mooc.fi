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

    public String toString() {
        String allElements = "";
        int i = 0;

        if (elements.isEmpty()) {
            return "The collection alphabet is empty.";
        }

        for (; i < elements.size(); i++)
            allElements += "\n" + elements.get(i);

        return "The collection " + this.name + " has " + i + (i == 1 ? " element:" : " elements:") + allElements;
    }
}

public class PrintingACollection {
    public static void main(String[] args) {
        SimpleCollection s = new SimpleCollection("alphabet");
        System.out.println(s);

        System.out.println();

        s.add("a");
        System.out.println(s);

        System.out.println();

        s.add("b");
        System.out.println(s);

        System.out.println();

        s.add("c");
        System.out.println(s);
    }
}
