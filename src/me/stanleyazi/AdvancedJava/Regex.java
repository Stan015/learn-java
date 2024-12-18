package me.stanleyazi.AdvancedJava;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
  public static  void main(String[] args) {
    String regex = "[a-zA-Z0-9_-]+";
    Pattern pattern = Pattern.compile(regex);

    Matcher matcher = pattern.matcher("ThisTest123");
    boolean found = matcher.find();
    if (found) {
      System.out.println("Match found: " + matcher.group());
    } else {
      System.out.println("Match not found: " + matcher.group());
    }
  }
}
