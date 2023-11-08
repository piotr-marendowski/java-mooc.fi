import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.Map;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


class CyclingStatisticsApp {

    private List<String> rows;

    public CyclingStatisticsApp(String file) {
        try {
            rows = Files.lines(Paths.get(file)).collect(Collectors.toCollection(ArrayList::new));
        } catch (IOException ex) {
            throw new RuntimeException("Failed to read the file " + file + ". Error message: " + ex.getMessage());
        }
    }

    public List<String> locations() {
        List<String> locations = Arrays.stream(rows.get(0).split(";")).collect(Collectors.toList());
        return locations.subList(1, locations.size());
    }

    public Map<String, Integer> monthlyCyclists(String location) {
        List<String> locations = locations();
        if (locations.indexOf(location) < 0) {
            return new HashMap<>();
        }

        Map<String, List<Integer>> monthlyValues = new TreeMap<>();

        int index = locations.indexOf(location) + 1;
        rows.stream().map(string -> string.split(";"))
                .filter(array -> array.length > 10)
                .forEach(array -> {
                    String[] dateArray = array[0].split(" ");
                    if (dateArray.length < 3) {
                        return;
                    }

                    String month = dateArray[3] + " / " + stringToMonthNumber(dateArray[2]);

                    monthlyValues.putIfAbsent(month, new ArrayList<>());

                    int count = 0;
                    if (!array[index].isEmpty()) {
                        count = Integer.parseInt(array[index]);
                    }

                    monthlyValues.get(month).add(count);
                });

        Map<String, Integer> cyclistCounts = new TreeMap<>();
        monthlyValues.keySet().stream().forEach(value -> {
            cyclistCounts.put(value, monthlyValues.get(value).stream().mapToInt(a -> a).sum());
        });

        return cyclistCounts;
    }

    private String stringToMonthNumber(String month) {
        List<String> months = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
        int number = months.indexOf(month) + 1;

        if (number < 10) {
            return "0" + number;
        }

        return "" + number;
    }
}

public class CyclingStatistics extends Application {

    @Override
    public void start(Stage stage) {

        CyclingStatisticsApp statistics = new CyclingStatisticsApp("helsinki-cycling-statistics.csv");

        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        gridPane.add(new Label("Choose the examined location"), 0, 0);

        ObservableList<String> data = FXCollections.observableArrayList();
        data.addAll(statistics.locations());

        ListView<String> list = new ListView<>(data);
        gridPane.add(list, 0, 1);

        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Year / Month");
        yAxis.setLabel("Cyclists");

        
        javafx.scene.chart.BarChart<String, Number> chart = new javafx.scene.chart.BarChart<>(xAxis, yAxis);
        chart.setLegendVisible(false);

        list.setOnMouseClicked((MouseEvent event) -> {
            String chosen = list.getSelectionModel().getSelectedItem();
            Map<String, Integer> values = statistics.monthlyCyclists(chosen);
            chart.getData().clear();
            XYChart.Series chartData = new XYChart.Series();

            values.keySet().stream().forEach(time -> {
                chartData.getData().add(new XYChart.Data(time, values.get(time)));
            });

            chart.getData().add(chartData);
        });

        gridPane.add(chart, 1, 0, 1, 2);

        Scene view = new Scene(gridPane);

        stage.setScene(view);
        stage.show();
    }

    public static void main(String[] args) {
        launch(CyclingStatistics.class);
    }

}
