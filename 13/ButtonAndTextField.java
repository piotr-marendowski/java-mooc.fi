import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ButtonAndTextField extends Application {
    @Override
    public void start(Stage window) {
        window.setTitle("Button and TextField");

        Button button = new Button("This is a button");
        TextField textField = new TextField("default text");

        FlowPane componentGroup = new FlowPane();
        componentGroup.getChildren().add(button);
        componentGroup.getChildren().add(textField);

        Scene view = new Scene(componentGroup);

        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(ButtonAndTextField.class);
    }
}
