import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import javafx.scene.control.Slider;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class SavingsCalculator extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        BorderPane layout = new BorderPane();

        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis(0, 20000, 2500);

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Savings");
        XYChart.Series data = new XYChart.Series();

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(20, 20, 20, 20));
        vbox.setSpacing(50);


        // monthly savings
        BorderPane monthly = new BorderPane();
        Slider monthlySlider = new Slider(0, 250, 0);
        monthlySlider.setShowTickMarks(true);
        monthlySlider.setShowTickLabels(true);
        monthlySlider.setMajorTickUnit(25);

        monthly.setLeft(new Label("Monthly Savings"));
        monthly.setCenter(monthlySlider);
        Label monthlyLabel = new Label("0");
        monthly.setRight(monthlyLabel);


        // yearly interest rate
        BorderPane yearly = new BorderPane();
        Slider yearlySlider = new Slider(0, 10, 0);
        yearlySlider.setShowTickMarks(true);
        yearlySlider.setShowTickLabels(true);
        yearlySlider.setMajorTickUnit(10);

        yearly.setLeft(new Label("Yearly Interest Rate"));
        yearly.setCenter(yearlySlider);
        Label yearlyLabel = new Label("0");
        yearly.setRight(yearlyLabel);

        vbox.getChildren().addAll(monthly, yearly);

        layout.setTop(vbox);
        layout.setCenter(lineChart);


        // actions
        monthlySlider.valueProperty().addListener((change, oldValue, newValue) -> {
            String val = String.format("%.1f", newValue);
            monthlyLabel.setText(val.toString());

            data.getData().clear();
            data.getData().add(new XYChart.Data(0, 0));
            double savs = 0.0;

            for (int i = 0; i < 30; i++, savs += (monthlySlider.getValue() * 12))
                data.getData().add(new XYChart.Data(i, savs));

            lineChart.getData().add(data);
        });
        yearlySlider.valueProperty().addListener((change, oldValue, newValue) -> {
            String val = String.format("%.1f", newValue);
            yearlyLabel.setText(val.toString());
        });

        Scene view = new Scene(layout);
        stage.setScene(view);
        stage.show();
    }

    public static void main(String[] args) {
        launch(SavingsCalculator.class);
    }
}
