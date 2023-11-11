import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Smiley extends Application {
    @Override
    public void start(Stage window) {

        Canvas paintingCanvas = new Canvas(600, 600);
        GraphicsContext painter = paintingCanvas.getGraphicsContext2D();

        BorderPane paintingLayout = new BorderPane();
        paintingLayout.setCenter(paintingCanvas);

        painter.fillRect(100, 50, 50, 50);
        painter.fillRect(450, 50, 50, 50);
        painter.fillRect(50, 350, 50, 50);
        painter.fillRect(500, 350, 50, 50);
        painter.fillRect(100, 400, 400, 50);

        Scene view = new Scene(paintingLayout);

        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(Smiley.class);
    }
}
