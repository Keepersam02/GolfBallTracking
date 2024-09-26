package tooling;

public class Information {
    public static void printImage(double[][] image) {
        for (double[] doubles : image) {
            System.out.print("\n");
            for (int j = 0; j < image[0].length; j++) {
                System.out.printf("%.2f ", doubles[j]);
            }
        }
        System.out.println();
    }
}
