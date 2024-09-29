package me.stanleyazi.practice;

import java.util.Scanner;

public class ConditionalStatements {
  public static void main(String[] args) {

    // if statement
    int temperature = 32;
    if (temperature > 30) {
      System.out.println("It's a hot day");
      System.out.println("Drink water");
    }
    else if (temperature > 20)
      System.out.println("It's a beautiful day");
    else
      System.out.println("It's not a hot day");

    int income = 128_388;
    boolean hasHighIncome = income > 99_999;
    System.out.println(hasHighIncome);

    // ternary operator
    String className = income > 99_999 ? "First class" : "Economy class";
    System.out.println(className);

    // switch statement
    String role = "admin";
    switch (role) {
      case "admin":
        System.out.println("Admin");
        break;
      case "user":
        System.out.println("User");
        break;
      default:
        System.out.println("Not a valid role");
    }

    // exercise
    // if number is divisible by 5, print "Fizz". If number is divisible by 3, print "Buzz".
    // if number is divisible by both 3 and 5, print "FizzBuzz"

    Scanner scanner = new Scanner(System.in);
    System.out.print("Number: ");
    int number = scanner.nextInt();

    String result = number % 5 == 0  && number % 3 == 0 ? "FizzBuzz"
      : number % 5 == 0 ? "Fizz"
      : number % 3 == 0 ? "Buzz"
      : "" + number;

    System.out.println(result);

    // For loop
    for (int i = 0; i < 5; i++)
      System.out.println("Hello Java Loop World");

    // While loop
    int i = 0;
    while (i < 3) {
      System.out.println("Hello Java Loop World");
      i++;
    }

//    Scanner scanner2 = new Scanner(System.in);
//    String input = "";
//    while (!input.equals("exit")) {
//      System.out.print("Input: ");
//      input = scanner2.next().toLowerCase();
//      System.out.println(input);
//    }

    // Do...while loop
    Scanner scanner3 = new Scanner(System.in);
    String input3 = "";

    do {
      System.out.print("Input: ");
      input3 = scanner3.next().toLowerCase();
      System.out.println(input3);
    } while (!input3.equals("exit"));

    // ForEach loop
    String[] fruits = {"Apple", "Banana", "Orange", "Pear", "Grape"};
    for (String fruit : fruits)
      System.out.println(fruit);
  }
}
