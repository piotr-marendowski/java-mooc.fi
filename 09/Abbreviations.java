import java.util.HashMap;

public class Abbreviations {
    private HashMap<String, String> abbs;

    public Abbreviations() {
        this.abbs = new HashMap<>();
    }

    public void addAbbreviation(String abbreviation, String explanation) {
        this.abbs.put(abbreviation, explanation);
    }

    public boolean hasAbbreviation(String abbreviation) {
        return this.abbs.containsKey(abbreviation);
    }

    public String findExplanationFor(String abbreviation) {
        return this.abbs.get(abbreviation);
    }

    public static void main(String[] args) {
        Abbreviations abbreviations = new Abbreviations();
        abbreviations.addAbbreviation("e.g.", "for example");
        abbreviations.addAbbreviation("etc.", "and so on");
        abbreviations.addAbbreviation("i.e.", "more precisely");

        String text = "e.g. i.e. etc. lol";

        for (String part : text.split(" ")) {
            if (abbreviations.hasAbbreviation(part)) {
                part = abbreviations.findExplanationFor(part);
            }

            System.out.print(part);
            System.out.print(" ");
        }

        System.out.println();
    }
}
