package me.stanleyazi.practice;

import java.awt.*;
import java.util.Date;

public class DataTypes {
  public static void main(String[] args) {
    byte age = 25;
    age = 30;
    System.out.println("age = " + age);

    int viewCount = 573_844_334; //use underscore to separate every 3 digits for large numbers
    System.out.println("viewCount = " + viewCount);

    long viewCountTwo = 3_333_834_343L; // use L to indicate larger Numbers
    System.out.println("viewCountTwo = " + viewCountTwo);

    float price = 10.29F; // use F to indicate float as decimals are always seen as doubles
    System.out.println("price = " + price);

    char letter = 'A';
    System.out.println("letter = " + letter);

    boolean isCorrect = true;
    System.out.println("a = " + isCorrect);

    // Reference type
    Date now = new Date();
    System.out.println("now = " + now);

    //
    byte x = 3;
    byte y = 4;
    // x and y are independent on each other

    Point point1 = new Point(1, 3);
    Point point2 = point1;
    System.out.println("point1 = " + point1);
    System.out.println("point2 = " + point2);

    point1.y = 5;
    System.out.println("point1 = " + point1);
    System.out.println("point2 = " + point2);
    //Point2 is dependent on point1

    // String
    // String message = new String("Hello World") - redundant
    String message = "Hello World" + "!!";
    System.out.println("message = " + message.length());
    System.out.println("message = " + message.replace("!!", "👋"));
  }
}
