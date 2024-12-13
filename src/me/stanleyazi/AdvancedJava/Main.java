package me.stanleyazi.AdvancedJava;

import java.lang.reflect.Method;

public class Main {
  @MyCustomAnnotation(value = 10)
  public void sayHello() {
    System.out.println("Hello my custom annotation");
  }

  public static void main(String[] args) throws Exception {
    // enums
    Color c1 = Color.RED;

    System.out.println("Red enum name: " + c1.name());
    System.out.println("Red enum value: " + c1.getValue());

//    for (Color c : Color.values()) {
//      System.out.println("Color: " + c.name());
//      System.out.println("Color: " + c.getValue());
//    }

    // annotations
    Main main = new Main();
    Method methodVal = main.getClass().getMethod("sayHello");

    MyCustomAnnotation myCustomAnnotation = methodVal.getAnnotation(MyCustomAnnotation.class);
//    System.out.println("Value is: " + myCustomAnnotation.value());

    // Concurrency and Threads
//    int n = 10;
//    for (int i = 0; i < n; i++) {
      SynchronizedMathUtils obj = new SynchronizedMathUtils();

      Thread1 thread1 = new Thread1(obj);
      Thread thread2 = new Thread(new Thread2(obj));
//      thread1.start();
//      thread2.start();
//    }

    // Autoboxing and Unboxing
    int i = 48;

    // Autobox
    Integer iObj = Integer.valueOf(i);
    System.out.println(iObj);

    // auto-unbox
    int i1 = iObj.intValue();
    System.out.println(i1);
  }
}
