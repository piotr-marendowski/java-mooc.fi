import java.util.ArrayList;
import java.util.Scanner;

public class Books {
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Title: ");
            String inputTitle = scanner.nextLine();
            if (inputTitle.isEmpty()) {
                break;
            }

            System.out.print("Publication year: ");
            int inputPubYear = Integer.valueOf(scanner.nextLine());

            System.out.print("Pages: ");
            int inputPages = Integer.valueOf(scanner.nextLine());

            books.add(new Book(inputTitle, inputPages, inputPubYear));
        }

        System.out.print("What information will be printed? ");
        String whatToPrint = scanner.nextLine();

        if (whatToPrint.toLowerCase().equals("everything")) {
            for (Book element : books) {
                System.out.println(element);
            }
        }
        if (whatToPrint.toLowerCase().equals("name")) {
            for (Book element : books) {
                System.out.println(element.getTitle());
            }
            
        } else {
           return;
        }

    }
}
