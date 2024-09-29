package me.stanleyazi.practice;

import java.util.Scanner;

public class ReadInputsFromUser {
  public static void main(String[] args) {
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
