package me.stanleyazi.AdvancedJava;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharacterStream {
  public static void main(String[] args) throws IOException {
    FileReader readerStream = null;
    FileWriter writerStream = null;

    try {
      readerStream = new FileReader("/Users/stan015/Desktop/practice-folder/java-practice/hello-java-world/srcTest.md");
      writerStream = new FileWriter("/Users/stan015/Desktop/practice-folder/java-practice/hello-java-world/destination.md");

      // Read source file and write content to destination file character by character
      int content;
      while ((content = readerStream.read()) != -1) {
        writerStream.append((char) content);
      }
    } catch (IOException e) {
      System.out.println("Error reading file" + e.getMessage());
    } finally {
      if (readerStream != null) {
        readerStream.close();
      }
      if (writerStream != null) {
        writerStream.close();
      }
    }
  }
}
