package me.stanleyazi.practice;

public class Operators {
  public static void main(String[] args) {
    int x = 2;
    int y = 4;
    System.out.println(x == y);
    System.out.println(x <= y);
    System.out.println(x >= y);
    System.out.println(x != y);

    int temperature = 33;
    boolean isWarm = temperature > 20 && temperature < 40;
    System.out.println(isWarm);

    boolean hasHighIncome = true;
    boolean hasGoodCredit = false;
    boolean hasCriminalRecord  = false;
    boolean isEligible = (hasHighIncome || hasGoodCredit) && !hasCriminalRecord;
    System.out.println(isEligible);
  }
}
