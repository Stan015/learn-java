package me.stanleyazi.AdvancedJava;

public class Thread2 implements Runnable {
  SynchronizedMathUtils mu;

  public Thread2(SynchronizedMathUtils mu) {
    this.mu = mu;
  }

  @Override
  public void run() {
    try {
      System.out.println("Thread2 is running...");
      mu.getMultiples(3);
    } catch (Exception e) {
      System.out.println("An Exception has occurred: " + e.getMessage());
    }
  }
}
