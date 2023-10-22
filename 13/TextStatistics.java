import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextStatistics extends Application {
    @Override
    public void start(Stage window) {
        BorderPane layout = new BorderPane();

        HBox stats = new HBox();
        stats.setSpacing(10);
        stats.getChildren().add(new Label("Letters: 0"));
        stats.getChildren().add(new Label("Words: 0"));
        stats.getChildren().add(new Label("The longest word is:"));

        layout.setCenter(new TextArea(""));
        layout.setBottom(stats);

        Scene view = new Scene(layout);

        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(TextStatistics.class);
    }
}
