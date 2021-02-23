import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Data {

    /*
     * Reads the data from a given csv file
     */
    public static List<List<Double>> dataFrom(String fileName) {
        List<List<Double>> output = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;

            while((line = reader.readLine()) != null) {
                String[] rawValues = line.split(",");
                for(int i = 0; i < rawValues.length; i++) {
                    if(i >= output.size()) output.add(new ArrayList<>());
                    output.get(i).add(Double.parseDouble(rawValues[i]));
                }
            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return output;
    }

    public static List<List<Double>> fileChooser(){
        Component parent = new Component() {
        };
        final JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                ".csv files", "csv");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(parent);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("You chose to open this file: " +
                    chooser.getSelectedFile().getName());
        }

        return Data.dataFrom(chooser.getSelectedFile().getName());

    }

    public static List<List<Double>> datasetHandler() {
        List<List<Double>> data = new ArrayList<>();
        String s = JOptionPane.showInputDialog(null, "How many rows are there in your dataset?");
        int amountOfRows = Integer.parseInt(s);
        for (int x = 0; x <= amountOfRows - 1; x++) {
            data.add(new ArrayList<>());
            String tuple = JOptionPane.showInputDialog(null, "Great. Please enter your data in the form Value,Value with no whitespace.");
            String[] vals = tuple.split(",");
            for (String val : vals) {
                data.get(x).add(Double.parseDouble(val));
            }

        }
        return data;
    }

    public static List<List<Double>> fileOrInput() {
        String userInput = JOptionPane.showInputDialog(null, "Would you like a choose a .csv file or input your own data?\n\n1. Choose a file\n2. Input data");
        int choice = Integer.parseInt(userInput);
        if (choice == 1){
            return Data.fileChooser();
        }
        else if (choice == 2) {
            return Data.datasetHandler();
        }
        return null;
    }
}