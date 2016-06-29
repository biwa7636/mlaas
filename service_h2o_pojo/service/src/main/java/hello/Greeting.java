package hello;
import java.io.*;
import hex.genmodel.easy.RowData;
import hex.genmodel.easy.EasyPredictModelWrapper;
import hex.genmodel.easy.exception.PredictException;
import hex.genmodel.easy.prediction.*;
import hello.KMeans_model_R_1467231909822_2;

public class Greeting {

    private double sepal_length = 1.0;
    private double sepal_width = 1.0;
    private double petal_length = 1.0;
    private double petal_width = 1.0;

    public Greeting(double sepal_length, double sepal_width,
                    double petal_length, double petal_width) {
        this.sepal_length = sepal_length;
        this.sepal_width = sepal_width;
        this.petal_length = petal_length;
        this.petal_width = petal_width;
    }

    public String predict() throws ClassNotFoundException, IllegalAccessException, InstantiationException, PredictException {

        hex.genmodel.GenModel rawModel;
        rawModel = new KMeans_model_R_1467231909822_2();
        EasyPredictModelWrapper model = new EasyPredictModelWrapper(rawModel);
        RowData row = new RowData();
        row.put("sepal_length", this.sepal_length);
        row.put("sepal_width", this.sepal_width);
        row.put("petal_length", this.petal_length);
        row.put("petal_width", this.petal_width);
        ClusteringModelPrediction p = model.predictClustering(row);
        System.out.println("Label (aka prediction) is flight departure delayed: " + p.toString());
//        double prediction = this.sepal_length + this.sepal_width + this.petal_length + this.petal_width;
//        return prediction;

        return Integer.toString(p.cluster);
    }

}