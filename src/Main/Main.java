package Main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import mathprocessors.Fibonacci;

import java.util.ArrayList;

public class Main extends Application {




    public static void main(String[] args) {
        launch(args);

    }


    @Override
    /**This is the start class for the primary javaFX thread that is used to call the recursive and non recursive methods and then
     * add their outputs to a chart for the javaFX api to display
     *
     */
    public void start(Stage stage) throws Exception {
        //this following section retrieves all the numbers needed for program launch


        //creating all variables needed for the fibonacci calculations and time storage
        int xCount = 25;


        //creating a data processor object
        Fibonacci fibpro = new Fibonacci();


        //creating and filling arraylists with the times
        ArrayList<Long> recursionTimes = fibpro.fibRecursiveTimer(xCount);
        ArrayList<Long> nonRecursionTimes = fibpro.fibnonRecursive(xCount);












        //anything following this comment is used for the charts and the javafx side

        stage.setTitle("Time charts");

        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Number in sequence");


        //creating the chart object
        final LineChart<Number, Number> timechart = new LineChart<Number, Number>(xAxis, yAxis);

        //naming the time chart
        timechart.setTitle("Time monitoring Recursive");

        //creating the chart data for the recursive times
        XYChart.Series recursive = new XYChart.Series();
        recursive.setName("Recursive times");

        //creating the chart data for the nonrecursive data
        XYChart.Series nonRecursive = new XYChart.Series();
        nonRecursive.setName("linear times");

        //for loop to fill the full series with dataa
        for (int yCount= 0; yCount < xCount; yCount++){
            recursive.getData().add(new XYChart.Data(yCount, recursionTimes.get(yCount)));
            nonRecursive.getData().add(new XYChart.Data(yCount, nonRecursionTimes.get(yCount)));

        }

        Scene scene = new Scene(timechart,800,600);
        timechart.getData().add(recursive);
        timechart.getData().add(nonRecursive);

        stage.setScene(scene);
        stage.show();



    }
}
