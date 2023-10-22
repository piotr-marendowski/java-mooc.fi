package application;

import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class UI {
    public static Parent getView() {
        BorderPane layout = new BorderPane();
        GridPane gridPane = new GridPane();
        HBox hbox = new HBox();

        Label turnText = new Label("Turn: ");
        Label turn = new Label("X");
        hbox.getChildren().add(turnText);
        hbox.getChildren().add(turn);

        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        for (int i = 0; i < 9; i++) {
            /* create and add buttons to grid */
            Button button = new Button("  ");
            gridPane.add(button, i % 3, i / 3);
            /* logic */
            button.setOnAction(e -> {
                if (button.getText().equals("  ")) {
                    button.setText(turn.getText());

                    if (turn.getText().equals("X"))
                        turn.setText("O");
                    else if (turn.getText().equals("O"))
                        turn.setText("X");
                }
            });
        }

        String[][] board = new String[3][3];
        int index = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = gridPane.getChildren().get(index).toString();
                index++;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                turnText.setText("Wins: ");
            }
        }
        // Check columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
                turnText.setText("Wins: ");
            }
        }
        // Check diagonals
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            turnText.setText("Wins: ");
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            turnText.setText("Wins: ");
        }

        layout.setTop(hbox);
        layout.setCenter(gridPane);

        return layout;
    }
}
