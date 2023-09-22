import java.util.List;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Paths;

class literacyData implements Comparable<literacyData> {
    private String country;
    private int year;
    private String gender;
    private double percent;

    public literacyData(String country, int year, String gender, double percent) {
        this.country = country;
        this.year = year;
        this.gender = gender;
        this.percent = percent;
    }

    public String getCountry() {
        return this.country;
    }

    public int getYear() {
        return this.year;
    }

    public String getGender() {
        return this.gender;
    }

    public double getPercent() {
        return this.percent;
    }

    @Override
    public int compareTo(literacyData compared) {
        double percent = (this.percent - compared.getPercent());

        return percent > 0 ? 1 : -1;
    }

    @Override
    public String toString() {
        return this.country + " (" + this.year + "), " + this.gender + ", " + this.percent;
    }
}

public class LiteracyComparison {
    public static void main(String[] args) {
        int count = 0;

        for (literacyData i: read("literacy.csv")) {
            System.out.println(i);

            count++;
            if (count >= 5)
                break;
        }
    }

    public static List<literacyData> read(String filename) {
        List<literacyData> lines = new ArrayList<>();

        try {
            Files.lines(Paths.get(filename))
                .map(row -> row.split(","))
                .filter(parts -> parts.length >= 6)
                .sorted((part1, part2) -> part1[5].compareTo(part2[5]))
                .map(parts -> new literacyData(parts[3].trim(),
                            Integer.valueOf(parts[4]),
                            parts[2].trim().replace(" (%)", ""),
                            Double.parseDouble(parts[5])))
                .forEach(data -> lines.add(data));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return lines;
    }
}
