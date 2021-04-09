import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

import weka.core.*;
import weka.core.converters.CSVLoader;

public class NaiveBayes {
    public static void mu(){

    }
    public static void sigma(){

    }
    public static void gaussianDistribution(){

    }
    public static void alpha(){

    }
    public void function() throws Exception {
        CSVLoader loader = new CSVLoader();
        loader.setSource(new File(Data.fileChooser()));
        Instances data = loader.getDataSet();
        data.setClassIndex(data.numAttributes() - 1);

        weka.classifiers.bayes.NaiveBayes naive = new weka.classifiers.bayes.NaiveBayes();
        naive.buildClassifier(data);


        ArrayList<Attribute> attributes = new ArrayList<Attribute>();
        attributes.add(new Attribute("Height"));
        attributes.add(new Attribute("Wear Glasses", (List<String>)null));
        attributes.add(new Attribute("Favourite Music Genre", (List<String>)null));


        Instance test = new DenseInstance(3);
        Instances dataset = new Instances("TestInstances", attributes, 0);
        test.setDataset(dataset);
        test.setValue(0, 152);
        test.setValue(1, "Yes");
        test.setValue(2, "Pop");


        double[] array = naive.distributionForInstance(test);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        System.out.println(test);
        System.out.println(data);
        System.out.println(naive.toString());

    }

}
