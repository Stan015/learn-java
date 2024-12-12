package me.stanleyazi.AdvancedJava;

public class Thread1 extends Thread {
  SynchronizedMathUtils mu;

  public Thread1(SynchronizedMathUtils mu) {
    this.mu = mu;
  }

  @Override
  public void run() {
    try {
      System.out.println("Thread1 is running...");
      mu.getMultiples(4);
    } catch (Exception e) {
      // throw exceptions
      System.out.println("Thread1 is interrupted" + e.getMessage());
    }
  }
}
