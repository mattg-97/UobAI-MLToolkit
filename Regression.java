import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Regression {
    public static void uniVariateLinearRegression(){
        List<List<Double>> data;
        data = Data.fileOrInput();

        double alpha = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the desired learning rate."));
        double epochs = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the desired amount of epochs."));

        double w1 = 0;
        double w0 = 0;
        double cost = 0;
        JOptionPane.showMessageDialog(null, "Calculating...");
        for (int i = 0; i < epochs; i++) {
            cost = 0;
            for (int j = 0; j < data.get(0).size(); j++) {

                double x_j = data.get(0).get(j);
                double y_j = data.get(1).get(j);

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
        Data.datasetHandler();
    }
    public static void nonLinearRegression(){
        Data.datasetHandler();
    }
}

