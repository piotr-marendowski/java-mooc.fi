import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.control.Label;
import javafx.scene.control.Button;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;

import java.util.Arrays;

public class MultipleViews extends Application {
    @Override
    public void start(Stage window) {
        BorderPane first = new BorderPane();
        first.setTop(new Label("First view!"));
        Button firstButton = new Button("To second view!");
        first.setCenter(firstButton);

        VBox second = new VBox();
        Button secondButton = new Button("To third view!");
        second.getChildren().add(secondButton);
        second.getChildren().add(new Label("Second view!"));

        GridPane third = new GridPane();
        Button thirdButton = new Button("To first view!");
        third.add(new Label("Third view!"), 0, 0);
        third.add(thirdButton, 1, 1);

        Scene firstScene = new Scene(first);
        Scene secondScene = new Scene(second);
        Scene thirdScene = new Scene(third);

        window.setScene(firstScene);
        window.show();

        firstButton.setOnAction(e -> {
            window.setScene(secondScene);
        });
        secondButton.setOnAction(e -> {
            window.setScene(thirdScene);
        });
        thirdButton.setOnAction(e -> {
            window.setScene(firstScene);
        });
    }

    public static void main(String[] args) {
        launch(MultipleViews.class);
    }
}
