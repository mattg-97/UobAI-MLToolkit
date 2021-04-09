import javax.swing.JOptionPane;
public class Toolkit {
    public static void main(String[] args) {
        String userInput = JOptionPane.showInputDialog(null, "Welcome to Group 69's AI/ML Toolkit.\nPlease Select from one of the following options:\n\n" +
                    "1. Regression\n2. Classification\n3. Naive Bayes\n4. Quit");
        int choice = Integer.parseInt(userInput);
        if (choice == 1){
            String regressionChoice = JOptionPane.showInputDialog(null, "You have chosen Regression. Which type of regression would you like to calculate?\n\n1. Univariate Linear Regression\n" +
                    "2. Multivariate Linear Regression\n3. Non-linear Regression\n4. Logistic Regression\n5. Quit");
            int numericalRegressionChoice = Integer.parseInt(regressionChoice);
            if (numericalRegressionChoice == 1){
               Regression.uniVariateLinearRegression();
            } else if (numericalRegressionChoice == 2){
                Regression.multiVariateLinearRegression();
            } else if (numericalRegressionChoice == 3){
                Regression.nonLinearRegression();
            } else if (numericalRegressionChoice == 4){
                //logistic regression goes here
            } else if (numericalRegressionChoice == 5){
                JOptionPane.showMessageDialog(null, "Goodbye");
            }
        } else if (choice == 2){
            JOptionPane.showInputDialog(null, "You have chosen Classification.");
        } else if (choice == 3){
            JOptionPane.showInputDialog(null, "You have chosen Naive Bayes.");
        } else if (choice == 4){
            JOptionPane.showMessageDialog(null, "Goodbye");
        }

    }
}
