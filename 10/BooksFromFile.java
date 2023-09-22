import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;

class Book {
    private String author;
    private String name;
    private int pages;

    public Book(String author, String name, int pages) {
        this.author = author;
        this.name = name;
        this.pages = pages;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getName() {
        return this.name;
    }

    public int getPages() {
        return this.pages;
    }
}

public class BooksFromFile {
    public static void main(String[] args) {
        System.out.println(readBooks("books.txt"));
    }

    public static List<Book> readBooks(String file) {
        List<Book> lines = new ArrayList<>();

        try {
            Files.lines(Paths.get(file))
                .map(row -> row.split(","))
                .filter(parts -> parts.length >= 4)
                .map(parts -> new Book(parts[3], parts[0], Integer.valueOf(parts[2])))
                .forEach(books -> lines.add(books));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return lines;
    }
}
