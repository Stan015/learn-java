package me.stanleyazi.AdvancedJava;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIODemo {
  public static void main(String[] args) throws IOException {
    // read a file
    FileInputStream fis = new FileInputStream("/Users/stan015/Desktop/practice-folder/java-practice/hello-java-world/srcTest.md");
    FileChannel readChannel = fis.getChannel();
    ByteBuffer readBuffer = ByteBuffer.allocate(1024);
    int result = readChannel.read(readBuffer);
    System.out.println("File read successfully: " + result);

    // write to a file
    FileOutputStream fout = new FileOutputStream("/Users/stan015/Desktop/practice-folder/java-practice/hello-java-world/nioDest.md");
    FileChannel writeChannel = fout.getChannel();
    ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
    String message = "Hello World tesing NIO write stream";
    writeBuffer.put(message.getBytes());
    writeBuffer.flip();
    writeChannel.write(writeBuffer);
    System.out.println(message);
  }
}
