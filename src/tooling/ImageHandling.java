package tooling;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ImageHandling {

    public static double[][] loadImage2dArray(String filePath) throws IOException {
        BufferedImage image = loadImage(filePath);
        image = toGreyScale(image);
        return imageTo2dArray(image);
    }

    public static void saveImage2dArray(double[][] image, String filePath) throws IOException {
        BufferedImage image2d = arrayToImage(image);
        saveImage(image2d, filePath);
    }

    public static BufferedImage loadImage(String filePath) throws IOException {
        File file = new File(filePath);
        return ImageIO.read(file);
    }

    public static BufferedImage toGreyScale(BufferedImage image) {
        BufferedImage greyScale = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        java.awt.Graphics g = greyScale.getGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
        return greyScale;
    }

    public static double[][] imageTo2dArray(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        double[][] image2d = new double[height][width];

        Raster raster = image.getRaster();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int greyLevel = raster.getSample(x, y, 0);
                image2d[y][x] = (double) greyLevel / 255;
            }
        }
        return image2d;
    }

    public static BufferedImage arrayToImage(double[][] pixelArray) {
        int height = pixelArray.length;
        int width = pixelArray[0].length;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int greyLevel = (int) (pixelArray[y][x] * 255);
                greyLevel = greyLevel < 0 ? 0 : Math.min(greyLevel, 255);
                int gray = (greyLevel << 16) | (greyLevel << 8) + greyLevel;
                image.setRGB(x, y, gray);
            }
        }
        return image;
    }

    public static void saveImage(BufferedImage image, String filePath) throws IOException {
        File file = new File(filePath);
        ImageIO.write(image, "png", file);
    }

    public static ArrayList<double[][]> processImageDirectory(String directoryPath) {
        File directory = new File(directoryPath);

        File[] files = directory.listFiles((d, name) -> name.endsWith(".png") || name.endsWith(".jpg"));

        ArrayList<double[][]> images = new ArrayList<>();

        if (files != null) {
            for (File file : files) {
                try {
                    BufferedImage image = ImageIO.read(file);
                    if(image != null) {
                        image = toGreyScale(image);
                        double[][] image2d = imageTo2dArray(image);
                        images.add(image2d);
                    } else {
                        System.err.println("Could not read image" + file.getName());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.err.println("Directory is empty or doesnt exist.");
        }
        return images;
    }
}
