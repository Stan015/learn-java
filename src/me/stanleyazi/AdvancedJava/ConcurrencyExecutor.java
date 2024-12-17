package me.stanleyazi.AdvancedJava;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrencyExecutor {
  public static void main(String[] args) {
    executorInvoke();
    executorServiceInvoke();
  }

  private static void executorInvoke() {
    Executor executor = new Caller();
    executor.execute(() -> {
      System.out.println("Executor example");
    });
  }

  private static void executorServiceInvoke() {
    try {
      ExecutorService executorService = Executors.newFixedThreadPool(10);
      executorService.submit(() -> {
        System.out.println("Executor service example");
      });
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
}
