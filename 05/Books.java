import java.util.ArrayList;
import java.util.Scanner;

public class Books {
    static class Book {
        private String name;
        private int publicationYear;

        public Book(String name, int publicationYear) {
            this.name = name;
            this.publicationYear = publicationYear;
        }

        public String getName() {
            return name;
        }

        public int getPublicationYear() {
            return publicationYear;
        }

        public boolean equals(Object compared) {
            if (this == compared) return true;

            if (!(compared instanceof Book)) return false;

            Book comparedBook = (Book) compared;

            if (this.name.equals(comparedBook.name) &&
                this.publicationYear == comparedBook.publicationYear)
                return true;

            return false;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();

        while (true) {
            System.out.println("Name:");
            String name = scanner.nextLine();

            if (name.isEmpty()) break;

            System.out.println("Publication year:");
            int publicationYear = Integer.valueOf(scanner.nextLine());

            Book book = new Book(name, publicationYear);

            if (books.contains(book))
                System.out.println("The book is already on the list. Let's not add the same book again.");
            else
                books.add(book);
        }
        
        System.out.println("Thank you! Books added: " + books.size());
    }
}
