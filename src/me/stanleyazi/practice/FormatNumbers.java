package me.stanleyazi.practice;

import java.text.NumberFormat;

public class FormatNumbers {
  public static void main(String[] args) {
    NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
    System.out.println("currencyFormat = " + currencyFormat.format(1328.32));

    String result = NumberFormat.getPercentInstance().format(0.399); // methods chaining
    System.out.println("percentFormat = " + result);
  }
}
