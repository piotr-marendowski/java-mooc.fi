import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ButtonAndLabel extends Application {
    @Override
    public void start(Stage window) {
        window.setTitle("Button and Label");

        Button button = new Button("This is a button");
        Label label = new Label("Text element");

        FlowPane componentGroup = new FlowPane();
        componentGroup.getChildren().add(label);
        componentGroup.getChildren().add(button);

        Scene view = new Scene(componentGroup);

        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(ButtonAndLabel.class);
    }
}
