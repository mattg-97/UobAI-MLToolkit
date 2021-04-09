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
    public static double sigmoid(double x) {
        return (1 / (1 + Math.pow(Math.E, (-1 * x))));
    }

    public void uniVariateLinearRegression() {
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

    public static void multiVariateLinearRegression() {

        List<List<Double>> data = Data.fileOrInput();
        final int epochs = 1000;  // Number of iterations we want to run through the algorithm

        // We want to predict h(x) = w2 * x * x + w1 * x + w0
        double w2 = 0;
        double w1 = 0;
        double w0 = 0;

        // Learning rate
        double alpha = 0.1;

        // Main Gradient Descent Function for Linear Regression
        for (int i = 0; i < epochs; i++) {

            double cost = 0;

            for (int j = 0; j < data.get(0).size(); j++) {

                double x1_j = data.get(0).get(j);

                double x2_j = data.get(1).get(j);

                double y_j = data.get(2).get(j);

                double prediction = sigmoid((w2 * x2_j) + (w1 * x1_j) + w0);

                // cost += (y_j - h(x))^2
                cost += -1 * (y_j * Math.log(prediction) + (1 - y_j) * (Math.log(1 - prediction)));

                // Update the parameters for our equation.
                w2 += alpha * (y_j - prediction) * x2_j;
                w1 += alpha * (y_j - prediction) * x1_j;
                w0 += alpha * (y_j - prediction);
            }
            System.out.println("Current Cost: " + cost);

            final double w_2 = w2;
            final double w_1 = w1;
            final double w_0 = w0;
        }
        System.out.println("Final Equation: h(x) = (" + w2 + " * x2 ) + (" + w1 + " * x1) + " + w0);
    }

    public static void nonLinearRegression() {
        Data.datasetHandler();
    }
}

