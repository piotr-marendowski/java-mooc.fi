import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private int id;
    private String name;

    public Book(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "(id: " + id + "; name: " + name + ")";
    }
}

public class Searching {

    /* part 1 */
    public static int linearSearch(ArrayList<Book> books, int searchedId) {
        int index = 0;
        int foundIndex = -1;

        for (Book i : books) {
            if (i.getId() == searchedId)
                foundIndex = index;

            index++;
        }

        return foundIndex;
    }

    /* part 2 */
    public static int binarySearch(ArrayList<Book> books, int searchedId) {
        int first = 0;
        int last = books.size() - 1;

        int foundIndex = -1;

        while (first <= last) {

            int middle = (first + last) / 2;

            if (books.get(middle).getId() == searchedId) {

                foundIndex = middle;
                break;
            } else if (books.get(middle).getId() < searchedId) {
                first = middle + 1;
            } else if (books.get(middle).getId() > searchedId) {
                last = middle - 1;
            }
        }

        return foundIndex;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();

        System.out.println("How many books to create?");
        int numberOfBooks = Integer.valueOf(scanner.nextLine());

        for (int i = 0; i < numberOfBooks; i++) {
            books.add(new Book(i, "name for the book " + i));
        }

        System.out.println("Id of the book to search for?");
        int idToSearchFor = Integer.valueOf(scanner.nextLine());


        System.out.println("");
        System.out.println("Searching with linear search:");

        int linearSearchId = linearSearch(books, idToSearchFor);

        if (linearSearchId < 0) {
            System.out.println("Book not found");
        } else {
            System.out.println("Found it! " + books.get(linearSearchId));
        }


        System.out.println("");
        System.out.println("");
        System.out.println("Seaching with binary search:");
        int binarySearchId = binarySearch(books, idToSearchFor);

        if (binarySearchId < 0) {
            System.out.println("Book not found");
        } else {
            System.out.println("Found it! " + books.get(binarySearchId));
        }
    }
}
