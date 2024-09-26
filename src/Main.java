import tooling.*;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        ArrayList<double[][]> images;
        double[][] traceImage;

        images = ImageHandling.processImageDirectory("/Users/rh-ws1/Desktop/02-GolfShotTest");

        traceImage = ImageTooling.createTrace(images);

        try {
            ImageHandling.saveImage2dArray(traceImage, "/Users/rh-ws1/Desktop/02-GolfShotTest/trace.png");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}