package tooling;

public class filters {
    public static double[][] highPass(double[][] signal) {
        double[][] filtered = new double[signal.length][signal[0].length];

        for (int i = 0; i < signal.length; i++) {
            for (int j = 0; j < signal[0].length; j++) {
                if (signal[i][j] > .8) {
                    filtered[i][j] = 1;
                } else {
                    filtered[i][j] = 0;
                }
            }
        }
        return filtered;
    }

    public static double[][] noiseReduction(double[][] filtered) {
        double[][] reduced = new double[filtered.length][filtered[0].length];

        for (int i = 0; i < filtered.length; i++) {
            for (int j = 0; j < filtered[0].length; j++) {
                if (filtered[i][j] > .5) {
                    boolean neighborThreshold = false;

                    if (i + 1 < filtered.length && filtered[i + 1][j] > .5 && j + 1 < filtered[0].length && filtered[i][j + 1] > .5 && j - 1 >= 0 && filtered[i][j - 1] > .5 && i - 1 >= 0 && filtered[i - 1][j] > .5) {
                        neighborThreshold = true;
                    }


                    if (neighborThreshold) {
                        reduced[i][j] = 1;

                        reduced[i + 1][j] = 1;

                        reduced[i][j + 1] = 1;

                        reduced[i - 1][j] = 1;

                        reduced[i][j - 1] = 1;
                        }

                }
            }
        }
        return reduced;
    }

    public static double[][] filterObjects(double[][] filtered) {
        for (int i = 0; i < filtered.length; i++) {
            for (int j = 0; j < filtered[0].length; j++) {

            }
        }
    }
}
