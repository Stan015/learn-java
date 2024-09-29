package me.stanleyazi;

import java.awt.*;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    System.out.println("Hello Java World!");

    for (int i = 1; i <= 5; i++) {
      System.out.println("i = " + i);
    }

//    dataTypes();
//    arrays();
//    arithmeticExpression();
//    mathClass();
//    formatNumbers();
//    readingInputFromUser();
  };

  public static void dataTypes() {
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

  public static void arrays() {
    //Arrays
    int[] numbers = new int[5];
    numbers[0] = 4;
    numbers[1] = 6;
    numbers[2] = 3;
    System.out.println(numbers);
    System.out.println(Arrays.toString(numbers));

    int[] newNumbers = {3, 53, 2, 5, 0};
    System.out.println(Arrays.toString(newNumbers));
    System.out.println(newNumbers.length);

    // two-dimensional Array
    int[][] numbers2 = new int[2][3];
    numbers2[0][0] = 1;
    numbers2[0][1] = 2;
    System.out.println(Arrays.deepToString(numbers2));

    int[][] numbers3 = {{3, 2, 1}, {0, 4, 9}};
    System.out.println(Arrays.deepToString(numbers3));
  }

  public static void arithmeticExpression() {
    int a = 23 * 3;
    System.out.println("a = " + a);

    double result = (double)10 / (double) 3;
    System.out.println(result);

    int x = 1;
    x++;
    int y = ++x;
    y += 4;
    System.out.println(x);
    System.out.println(y);

    int z = (3 + 4) * 9;
    System.out.println(z);

    // implicit casting
    // byte > short > int > long > float > double
    short s = 1;
    int d = s + 2;
    System.out.println(d);

    // explicit casting.
    double h = 4.9;
    int k = (int)h + 4;
    System.out.println(k);
    // can only happen between compatible types
    String f = "2";
    int b = Integer.parseInt(f) - 3;
    System.out.println(b);
  }

  public static void mathClass() {
    double x = Math.random() * 100;
    System.out.println(x);

    int y = (int) Math.round(x);
    System.out.println(y);
  }

  public static void formatNumbers() {
    NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
    System.out.println("currencyFormat = " + currencyFormat.format(1328.32));

    String result = NumberFormat.getPercentInstance().format(0.399); // methods chaining
    System.out.println("percentFormat = " + result);
  }

  public static void readingInputFromUser() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("My age is: ");
    byte age = scanner.nextByte();
    System.out.println("age = " + age);

    Scanner scanner2 = new Scanner(System.in);
    System.out.print("My name is: ");
    String name = scanner2.nextLine().trim(); //.next reads one token, nextLine reads all tokens in a line
    System.out.println("name = " + name);
  }
}