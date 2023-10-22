import application.*;

import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TicTacToe extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        BorderPane layout = new BorderPane();
        layout.setCenter(UI.getView());

        Scene view = new Scene(layout);
        stage.setTitle("Tic-tac-toe");
        stage.setScene(view);
        stage.show();
    }

    public static void main(String[] args) {
        launch(TicTacToe.class);
    }
}
