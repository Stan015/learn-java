package me.stanleyazi.AdvancedJava;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStream {
  public static void main(String[] args) throws IOException {
    FileInputStream inStream = null;
    FileOutputStream outStream = null;

    try {
      inStream = new FileInputStream("/Users/stan015/Desktop/practice-folder/java-practice/hello-java-world/srcTest.md");
      outStream = new FileOutputStream("/Users/stan015/Desktop/practice-folder/java-practice/hello-java-world/destination.md");

      // reads a byte at a time, if it reaches the end of the file, it returns -1
      int content;
      while ((content = inStream.read()) != -1) {
        outStream.write((byte) content);
      }
    } catch (FileNotFoundException e) {
      System.out.println("Error: " + e.getMessage());
    } finally {
      if (inStream != null) {
        inStream.close(); // make sure to close
      }
      if (outStream != null) {
        outStream.close(); // make sure to close
      }
    }
  }
}
