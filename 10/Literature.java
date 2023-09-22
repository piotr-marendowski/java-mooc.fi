import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;

class UserInterface {
    private Scanner scanner;
    private ArrayList<Book> books;

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
        this.books = new ArrayList<>();
    }

    public ArrayList<Book> start() {
        while (true) {
            System.out.print("Input the name of the book, empty stops: ");
            String name = scanner.nextLine();

            if (name.equals(""))
                break;

            System.out.print("Input the age recommendation: ");
            int age = Integer.valueOf(scanner.nextLine());

            books.add(new Book(name, age));
        }
        
        /* part 2 and 3 */
        Comparator<Book> comparator = Comparator
            .comparing(Book::getAgeRec)
            .thenComparing(Book::getName);

        Collections.sort(books, comparator);

        return this.books;
    }
}

class Book {
    private String name;
    private int ageRec;

    public Book(String name, int ageRec) {
        this.name = name;
        this.ageRec = ageRec;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAgeRec() {
        return ageRec;
    }

    public void setAgeRec(int ageRec) {
        this.ageRec = ageRec;
    }
 
    @Override
    public String toString(){
        return this.name + " (recommended for " + this.ageRec + " year-olds or older)";
    }
}

public class Literature {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UserInterface ui = new UserInterface(scanner);
        ArrayList<Book> books = ui.start();

        System.out.println("Books:");
        for (Book i: books)
            System.out.println(i);
    }
}
