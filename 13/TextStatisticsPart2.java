import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.util.Arrays;

public class TextStatisticsPart2 extends Application {
    @Override
    public void start(Stage window) {
        BorderPane layout = new BorderPane();
        HBox stats = new HBox();
        stats.setSpacing(10);

        TextArea textArea = new TextArea("");

        Label letters = new Label("Letters: 0");
        Label wordsLabel = new Label("Words: 0");
        Label longestWord = new Label("The longest word is:");

        stats.getChildren().addAll(letters, wordsLabel, longestWord);
        layout.setCenter(textArea);

        layout.setBottom(stats);
        Scene view = new Scene(layout);

        window.setScene(view);
        window.show();

        textArea.textProperty().addListener((change, oldValue, newValue) -> {
            int characters = newValue.length();
            String[] parts = newValue.split(" ");
            int words = parts.length;

            String longest = Arrays.stream(parts)
                .sorted((s1, s2) -> s2.length() - s1.length())
                .findFirst()
                .get();

            letters.setText("Letters: " + characters);
            wordsLabel.setText("Words: " + words);
            longestWord.setText("The longest word is: " + longest);
        });
    }

    public static void main(String[] args) {
        launch(TextStatisticsPart2.class);
    }
}
