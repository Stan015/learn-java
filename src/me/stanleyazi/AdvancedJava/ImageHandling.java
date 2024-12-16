package me.stanleyazi.AdvancedJava;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageHandling {
  public static void main(String[] args) throws IOException {
    int width = 640;
    int height = 480;

    BufferedImage image = null;

    image = readFromFile(width, height, image);

    writeToFile(image);
  }

  private static BufferedImage readFromFile(int width, int height, BufferedImage image) {
    try {
      File sampleImageFile = new File("/Users/stan015/Desktop/practice-folder/java-practice/hello-java-world/sampleImage.jpg");

      image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

      // Reading input file
      image = ImageIO.read(sampleImageFile);

      System.out.println("Reading complete." + image);
    } catch (IOException e) {
      System.err.println("Error" + e.getMessage());;
    }
    return image;
  }

  private static void writeToFile(BufferedImage image) {
    try {
      File output = new File("/Users/stan015/Desktop/practice-folder/java-practice/hello-java-world/sampleImageOut.jpg");

      ImageIO.write(image, "jpg", output );

      System.out.println("Writing complete.");
    } catch (IOException e) {
      System.err.println("Error" + e.getMessage());
    }
  }
}
