import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Regression {
    public static void uniVariateLinearRegression(){
        Double[][] data = datasetHandler();
        double alpha = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the desired learning rate."));
        double epochs = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the desired amount of epochs."));

        double w1 = 0;
        double w0 = 0;
        double cost = 0;
        //JOptionPane.showMessageDialog(null, "Calculating...");
        for (int i = 0; i < epochs; i++) {
            cost = 0;
            for (int j = 0; j < data[0].length; j++) {

                double x_j = data[0][j];
                double y_j = data[1][j];

                double prediction = (w1 * x_j) + w0;

                // cost += (y_j - h(x))^2
                cost += (y_j - prediction) * (y_j - prediction);

                // Update the parameters for our equation.
                w1 += alpha * (y_j - prediction) * x_j;
                w0 += alpha * (y_j - prediction);

            }
            System.out.println(cost + " - " + w0 + " - " + w1);
        }
        JOptionPane.showMessageDialog(null, "Cost: " + cost + "\nLinear Function: y = " + w1 + "x + " + w0);
    }
    public static void multiVariateLinearRegression(){
        datasetHandler();
    }
    public static void nonLinearRegression(){
        datasetHandler();
    }
    public static Double[][] datasetHandler(){
        String s = JOptionPane.showInputDialog(null, "How many rows are there in your dataset?");
        int amountOfRows = Integer.parseInt(s);
        Double[][] data = new Double[2][amountOfRows];
        for (int x = 0; x <= amountOfRows - 1; x++){
            String tuple = JOptionPane.showInputDialog(null, "Great. Please enter your data in the form Value,Value with no whitespace.");
            String[] vals = tuple.split(",");
            data[0][x] = Double.parseDouble(vals[0]);
            data[1][x] = Double.parseDouble(vals[1]);
        }
        return data;

    }
}
