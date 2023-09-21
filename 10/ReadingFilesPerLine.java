import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadingFilesPerLine {
    public static void main(String[] args) {
        System.out.println(read("presidents.txt"));
    }

    public static List<String> read(String file) {
        List<String> lines = new ArrayList<>();

        try {
            Files.lines(Paths.get(file))
                .forEach(person -> lines.add(person));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return lines;
    }
}
