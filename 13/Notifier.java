import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Notifier extends Application {
    @Override
    public void start(Stage window) {
        VBox layout = new VBox();
        layout.setSpacing(5);

        TextField textField = new TextField();
        Button button = new Button("Update");
        Label label = new Label();

        button.setOnAction(e -> label.setText(textField.getText()));

        layout.getChildren().addAll(textField, button, label);

        Scene view = new Scene(layout);

        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(Notifier.class);
    }
}
