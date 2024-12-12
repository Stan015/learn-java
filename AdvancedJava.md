# Advanced Java

Here I would be documenting my notes on advanced java, covering key topics.

## Enumeration in Java (Enums)

An `enum` is a language construct that is used to define type-safe enumerations which can be used when a fixed set of named values is desired.

```java
// define enum
public enum Day {
  SUNDAY, MONDAY, TUESDAY, WEDNESDAY, 
  THURSDAY, FRIDAY, SATURDAY
}
```

You can also pass values to the enums and create a `get` method to retrieve a value:

```java
// Define color enum and pass values to it with a getValue getter.
enum Color {
  RED("red"), BLACK("black"), WHITE("white");

  private String value;

  Color(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
```

```java
// use the Color enum
public class Main {
  public static void main(String[] args) {
    Color c1 = Color.RED;

    System.out.println("Red enum name: " + c1);
    System.out.println("Red enum value: " + c1.getValue());
  }
}
```

## Annotations

Annotations is a form of metadata which provides data about a program that is not part of the program it's self.
You can use annotations to provide:
- information for the compiler
- Compile-time and deployment-time processing
- Runtime processing

Annotation in Java starts with the "@" and then the annotation  name. for example: 
- `@Override`: Override the initial implementation of a code
- `@Author()`: Gives details about an author
- `@SuppressWarnings()`: suppresses warning (not recommended for use unless there is need to do so)

You can build your own custom annotation

```java
@Retention(RetentionPolicy.RUNTIME) // where the annotation works,could be METHOD, etc
@Target(ElementType.TYPE) // type of element, specify the target element
public @interface MyCustomAnnotation {
  // logic for the annotation
}
```

## Serialization in Java
For complex application, say enterprise, there would be need to send or receive serialized objects. To 'Serialize' an object means to convert its state to a byte stream so that the byte stream can be reverted back into a copy of the object.
"Deserialization" is the process of converting the serialized form of an object back to a copy of the object.

Steps to serialization:
- use the `implements` keyword to define that a class is serializable:

```java
import java.io.Serializable;

class MyClass implements Serializable {
  // give is a serialVersionUID
  private static final long serialVersionUID = 1L;
  
  // your code
}
```
- To serialize the MyClass object, get the location you are sending the serialized form to, use `.writeObject(MyClassInstance)`.
- To deserialize the MyClass object from where the serialized form is sent, use `.readObject()`. 

```java
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

// Just a demo code...improve to get it work
public class UsingSerialization {
  // Serialize
  FileOutputStream fileOut = new FileOutputStream(filename);
  ObjectOutputStream objOut = new ObjectOutputStream(fileOut);

  // write to it (serialize)
  objOut.writeObject(MyClassInstance);
  objOut.close();
  fileOut.close();

  //Deserialize
  FileInputStream fileIn = new FileInputStream(filename);
  ObjectInputStream objIn = new ObjectInputStream(fileIn);
  // read serialized file
  objIn.readObject();
  objIn.close();
  fileIn.close();
}
```

There are cases where you may not want a variable to be serialized in a serializable class/object. In this case, prefix the `transient` variable. 
```java
transient int x;
```

## Concurrency and Threads in Java

Concurrency is the ability to run multiple programs/tasks at once. <br>
To apply concurrency, we use Processes and Threads. These are the two basic units of execution in concurrency programming. 
In Java programming, concurrency mostly deals with Threads.

To define a thread, create your thread class and extend to the built-in `Thread` class to inherit the methods you want to override and specify your own logics.

```java
public class Thread1 extends Thread {
  @Override
  public void run() {
    try {
      System.out.println("Thread1 is running");
    } catch (Exception e) {
      // throw exceptions
      System.out.println("Thread1 is interrupted" + e.getMessage());
    }
  }
}
```

Subsequent Threads `implements` the built-in `Runnable` class.

```java
public class Thread2 implements Runnable {
  @Override
  public void run() {
    try {
      System.out.println("Thread2 is running...");
    } catch (Exception e) {
      System.out.println("An Exception has occured: " + e.getMessage());
    }
  }
}
```

And finally you can call the threads to run concurrently as in this example:

```java
// Concurrency and Threads
int n = 10;
for (int i = 0; i < n; i++) {
  Thread1 thread1 = new Thread1();
  thread1.start();

  Thread thread2 = new Thread(new Thread2());
  thread2.start();
}
```

Note: the output of concurrently doesn't occur in any order. Threads never run in sequence, they run in parallel. They run in no order.

## Synchronization in Java

When we execute threads, they do not run in sequence. This is not a problem in the thread example above, but it becomes a problem when for instance two threads are trying to access a value in an object at the same time. This is where java in providing _Synchronization_ which is built around an internal entity known as _intrinsic lock or monitor lock_.

```java
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
```

In the above code block, we _synchronized_ a class which is being accessed by two threads. With the `synchronized (this) {}` block, we are specifically indicating which part of the class should be accessed once at a time. You can synchronize the while method when you prefix the `synchronized` in the front of the method.

Threads accessing the SynchronizedMathUtils class:
```java
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
```

```java
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
```

Usage: 
```java
public class Main {
  public static void main(String[] args) throws Exception {
    // Concurrency Threads Synchronization
      SynchronizedMathUtils obj = new SynchronizedMathUtils();

      Thread1 thread1 = new Thread1(obj);
      Thread thread2 = new Thread(new Thread2(obj));
      thread1.start();
      thread2.start();
  }
}
```

Note: Threads should be used with caution. It can cause performance issue in large applications when you are trying to run expensive logics at the same time. This is why care should be taken in consideration when creating threads.


# References

- [Advanced Java](https://www.youtube.com/watch?v=Ae-r8hsbPUo)