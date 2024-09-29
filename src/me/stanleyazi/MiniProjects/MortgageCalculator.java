package me.stanleyazi.MiniProjects;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {
  public static void main(String[] args) {
    final byte MONTHS_IN_YEAR = 12;
    final byte PERCENTAGE = 100;

    Scanner scanner = new Scanner(System.in);

    int principal = 0;

    while (true) {
      System.out.print("Principal: ");
      principal = scanner.nextInt();
      if (principal >= 1000 && principal <= 9999)
        break;
      System.out.println("Enter a value between 1000 and 9999");
    }

    float annualInterestRate = 1;
    float monthlyInterestRate = 1;

    while (true) {
      System.out.print("Annual Interest Rate: ");
      annualInterestRate = scanner.nextFloat();
      if (annualInterestRate >= 1 && annualInterestRate <= 3) {
        monthlyInterestRate = annualInterestRate / PERCENTAGE / MONTHS_IN_YEAR;
        break;
      }
      System.out.println("Enter a valid annual interest rate between 1 and 3");
    }

    byte years = 0;
    int numberOfPayments = 0;

    while (true) {
      System.out.print("Enter the number of years: ");
      years = scanner.nextByte();
      numberOfPayments = years * MONTHS_IN_YEAR;
      if (years > 0)
        break;
      System.out.println("Enter a valid number of years");
    }

    double mortgage = principal * (((double) monthlyInterestRate * Math.pow((1 + monthlyInterestRate), numberOfPayments))
      / (Math.pow((1 + monthlyInterestRate), numberOfPayments) - 1));

    String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
    System.out.println("Mortgage: " + mortgageFormatted);
  }
}
