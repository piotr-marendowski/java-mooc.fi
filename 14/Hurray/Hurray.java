import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import java.applet.AudioClip;
import javafx.stage.Stage;

public class Hurray extends Application {
    @Override
    public void start(Stage window) {
        BorderPane layout = new BorderPane();

        // nothing works for me :/

        layout.setCenter(hurray);

        Scene view = new Scene(layout);
        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(Hurray.class);
    }
}
