import java.nio.file.Paths;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class FinnishParties extends Application {
    @Override
    public void start(Stage stage) {
        NumberAxis xAxis = new NumberAxis(1968, 2008, 4);
        NumberAxis yAxis = new NumberAxis(0, 30, 5);

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Relative support of the parties");

        XYChart.Series kok = new XYChart.Series();
        kok.setName("KOK");
        XYChart.Series sdp = new XYChart.Series();
        sdp.setName("SDP");
        XYChart.Series kesk = new XYChart.Series();
        kesk.setName("KESK");
        XYChart.Series vihr = new XYChart.Series();
        vihr.setName("VIHR");
        XYChart.Series vas = new XYChart.Series();
        vas.setName("VAS");
        XYChart.Series ps = new XYChart.Series();
        ps.setName("PS");
        XYChart.Series rkp = new XYChart.Series();
        rkp.setName("RKP");
        XYChart.Series[] parties = new XYChart.Series[]{kok, sdp, kesk, vihr, vas, ps, rkp};

        try (Scanner scanner = new Scanner(Paths.get("partiesdata.tsv"))) {
            String line = scanner.nextLine(); // skip first line
            int party = 0;
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                String[] parts = line.split("\t");

                for (int i = 1, year = 1968; year <= 2008; i++, year+=4) {
                    if (parts[i].equals("-"))
                        continue;
                    else
                        parties[party].getData().add(new XYChart.Data(year, Double.valueOf(parts[i])));
                }

                party++;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }

        for (int i = 0; i < parties.length; i++)
            lineChart.getData().add(parties[i]);

        Scene view = new Scene(lineChart, 640, 480);
        stage.setScene(view);
        stage.show();
    }

    public static void main(String[] args) {
        launch(FinnishParties.class);
    }
}
