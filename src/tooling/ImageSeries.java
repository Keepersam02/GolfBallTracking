package tooling;

import java.util.ArrayList;

public class ImageSeries {
    private int seriesLength = 0;
    private ArrayList<double[][]> series = new ArrayList<>();

    public ImageSeries() {
        this.seriesLength = 0;
        this.series = null;
    }

    public ImageSeries(ArrayList<double[][]> series) {
        this.seriesLength = series.size();
        this.series = series;
    }


}
