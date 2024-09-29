package me.stanleyazi.practice;

public class MathClass {
  public static void main(String[] args) {
    double x = Math.random() * 100;
    System.out.println(x);

    int y = (int) Math.round(x);
    System.out.println(y);
  }
}
