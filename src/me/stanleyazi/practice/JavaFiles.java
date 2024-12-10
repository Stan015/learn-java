package me.stanleyazi.practice;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;

public class JavaFiles {
  public static void main(String[] args) throws URISyntaxException, IOException {
    Path path = Path.of("/Users/stan015/Desktop/practice-folder/java-practice/hello-java-world/README.md");
    System.out.println(path);

    boolean fileExists = Files.exists(path);
    System.out.println(fileExists);

    FileTime lastModifiedTime = Files.getLastModifiedTime(path);
    System.out.println("lastModifiedTime = " + lastModifiedTime);

    Path utfFile = Files.createTempFile("some", ".txt");
    Files.writeString(utfFile, "this is my string ää öö üü");
    System.out.println("utfFile = " + utfFile);

    Path iso88591File = Files.createTempFile("some", ".txt");
    Files.writeString(iso88591File, "this is my string ää öö üü", StandardCharsets.ISO_8859_1);
    System.out.println("iso88591File = " + iso88591File);
  }
}