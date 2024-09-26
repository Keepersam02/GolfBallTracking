package tooling;

import java.util.ArrayList;

public class ImageTooling {

    public static double[][] createAverage(double[][] input1, double[][] input2) {
        double[][] average = new double[input1.length][input1[0].length];

        for (int i = 0; i < input1.length; i++) {
            for (int j = 0; j < input1[0].length; j++) {
                if (input1[i][j] > .5 || input2[i][j] > .5) {
                    average[i][j] = 1;
                }
            }
        }
        return average;
    }

    public static double[][] createTrace(ArrayList<double[][]> images) {
        double[][] trace = new double[images.getFirst().length][images.getFirst()[0].length];

        for (double[][] image : images) {
            trace = createAverage(trace, image);
        }
        return trace;
    }
}
