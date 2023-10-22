import javafx.application.Application;
import javafx.application.Application.Parameters;
import javafx.stage.Stage;
import java.util.Scanner;

public class UsersTitle extends Application {
    @Override
    public void start(Stage window) {
        Parameters params = getParameters();
        String title = params.getNamed().get("title");

        window.setTitle(title);
        window.show();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a title: ");
        String title = scanner.nextLine();
        
        Application.launch(UsersTitle.class, "--title=" + title);
    }
}
