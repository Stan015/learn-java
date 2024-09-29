package me.stanleyazi.practice;

public class ArithmeticExpression {
  public static void main(String[] args) {
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
}
