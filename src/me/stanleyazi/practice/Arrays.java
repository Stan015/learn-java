package me.stanleyazi.practice;

public class Arrays  {
  public static void main(String[] args) {
    //Arrays
    int[] numbers = new int[5];
    numbers[0] = 4;
    numbers[1] = 6;
    numbers[2] = 3;
    System.out.println(numbers);
    System.out.println(java.util.Arrays.toString(numbers));

    int[] newNumbers = {3, 53, 2, 5, 0};
    System.out.println(java.util.Arrays.toString(newNumbers));
    System.out.println(newNumbers.length);

    // two-dimensional Array
    int[][] numbers2 = new int[2][3];
    numbers2[0][0] = 1;
    numbers2[0][1] = 2;
    System.out.println(java.util.Arrays.deepToString(numbers2));

    int[][] numbers3 = {{3, 2, 1}, {0, 4, 9}};
    System.out.println(java.util.Arrays.deepToString(numbers3));
  }
}
