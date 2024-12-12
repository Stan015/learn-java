package me.stanleyazi.AdvancedJava;

public class SynchronizedMathUtils {
  void getMultiples(int n) {
    synchronized (this) {
      for (int i = 0; i < 5; i++) {
        System.out.println(n * i);
        try {
          Thread.sleep(400);
        } catch (Exception e) {
          System.out.println(e.getMessage());
        }
      }
    }
  }
}
