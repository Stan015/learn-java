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

Note: the output of concurrency doesn't occur in any order. Threads never run in sequence, they run in parallel. They run in no order.

The Concurrency utilities package provide a powerful, extensible framework of high-performance threading utilities such as thread pools and blocking queues. It provides low-level primitives for advanced concurrent programming.

- `java.util.concurrent`
- `java.util.concurrent.locks`
- `java.util.concurrent.atomic`

### Concurrency Executors
Executors are simple standardized interfaces for defining custom thread-like subsystems, including thread pools, asynchronous I/O, and lightweight task frameworks.
- `ExecutorService` provides a more complete asynchronous task execution framework, managing queues and scheduling tasks, and allowing controlled shutdown.
- `ScheduledExecutorService` subinterface and associated interfaces add support for delayed and periodic task execution.

```java
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
```
```java
public class Caller implements Executor {
  @Override
  public void execute(Runnable command) {
    command.run();
  }
}
```
The above code blocks show how we can use the `Executor` class to launch a new task, and the `ExecutorService` is used to initiate an asynchronous logic which is better handled with the `Future` class below:

### Future class
a Future returns the result of a function, allows determination of whether execution has completed, and provides a means to cancel execution. It is basically used in hand with the `ExecutorService` to handle asynchronous tasks.

```java
public class ConcurrencyFutureDemo {
  public static void main(String[] args) {
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    Future<String> future = executorService.submit(() -> {
      Thread.sleep(3000);
      return "Completed";
    });

    try {
      while (!future.isDone()) {
        System.out.println("Task still in progress...wait");
        Thread.sleep(500);
      }
      System.out.println("Task completed");
      String result = future.get(3000, TimeUnit.MILLISECONDS);
      System.out.println(result);

      executorService.shutdown();
    } catch (InterruptedException | ExecutionException | TimeoutException e) {
      future.cancel(true);
      future.isDone();
      future.isCancelled();
      System.err.println("Task interrupted");
    }
  }
}
```

This way, we can handle in asynchronous logic or function in java using `ExecutorService` class, and the `Future` class which monitors the asynchronous running initiated with the `ExecutorService` class. 

## Synchronization in Java

When we execute threads, they do not run in sequence. This is not a problem in the thread example above, 
but it becomes a problem when for instance two threads are trying to access an object at the same time. This is where java in providing _Synchronization_ which is built around an internal entity known as _intrinsic lock or monitor lock_.

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

## Autoboxing and Unboxing

_Autoboxing_ is the automatic conversion that the Java compiler makes between the primitive types and their corresponding object wrapper classes. Converting `int` to `integer` is an example.
If the conversion goes in reverse, then it is called _Unboxing_.

```java
public static void main(String[] args) {
  int i = 48;
  
  // Autobox
  Integer iObj = Integer.valueOf(i);
  System.out.println(iObj);
  
  // auto-unbox
  int i1 = iObj.intValue();
  System.out.println(i1);
}
```

## Input/Output (I/O) Streams

The basic idea is that the program takes input from some external source (e.g, command line, file, etc). It involves getting values from an input sources and sends to output destination in a process called _stream_.

- Input stream reads data from a source
- Output stream writes data to a destination

Types of Streams:
- Byte Streams - if you don't know the kind of data you will be streaming, or if the data you will be streaming will be in bytes like reading image files, use Byte Stream. The below code reads the file byte by byte and writes to the destinations file.
```java
public class ByteStream {
  public static void main(String[] args) throws IOException {
    FileInputStream inStream = null;
    FileOutputStream outStream = null;

    try {
      inStream = new FileInputStream("/source.md");
      outStream = new FileOutputStream("/destination.md");

      // reads a byte at a time, if it reaches the end of the file, it returns -1
      int content;
      while ((content = inStream.read()) != -1) {
        outStream.write((byte) content);
      }
    } catch (FileNotFoundException e) {
      System.out.println("Error: " + e.getMessage());
    } finally {
      if (inStream != null) {
        inStream.close(); // make sure to close
      }
      if (outStream != null) {
        outStream.close(); // make sure to close
      }
    }
  }
}
```
- Character Streams - used to stream character by character using the `FileReader` and `FileWriter` APIs instead.
```java
public class CharacterStream {
  public static void main(String[] args) throws IOException {
    FileReader readerStream = null;
    FileWriter writerStream = null;

    try {
      readerStream = new FileReader("input.txt");
      writerStream = new FileWriter("output.txt");

      // Read source file and write content to destination file character by character
      int content;
      while ((content = readerStream.read()) != -1) {
        writerStream.append((char) content);
      }
    } catch (IOException e) {
      System.out.println("Error reading file" + e.getMessage());
    } finally {
      if (readerStream != null) {
        readerStream.close();
      }
      if (writerStream != null) {
        writerStream.close();
      }
    }
  }
}
```

## JDBC (Java Database Connectivity)
The JDBC API is a very helper class in java that helps with connecting to different databases with technically the `DriverManager` and `Connection` syntax.
This bridges the gap of having to worry about how every database allows for its connection. 

So you simply have to:
- choose your database (MySQL, PostgreSQL, Oracle, etc) 
- download the db installer
- set it up and get the connection url
- download the JDBC driver for that database. This will download a `.jar` file which you can add to your java program's Classpath.
- write your java program to connect to the db and perform your CRUD to the db as in the example below:
```java
public class PostgresqlJDBC {
  public static void main(String[] args) throws SQLException {
    // Creating the connection
    String url = "jdbc:postgresql://localhost:5432/testdb";
    Connection conn = null;

    // data to send to db; which would in most cases come from user input or elsewhere
    int id = 2;
    String name = "John Smith";
    String email = "john.smith@gmail.com";
    int age = 26;

    // write the sql statement to update db
    String sql = "insert into students(id, name, age, email)" + "values(" + id + ",'" + name + "'," + age + ",'" + email + "')";

    try {
      conn = DriverManager.getConnection(url, "stan015", "testpassword");

      Statement stmt = conn.createStatement();
      int count = stmt.executeUpdate(sql);
      if (count == 1) {
        System.out.println("Inserted successfully: " + sql);
      } else {
        System.out.println("Insertion failed");
      }
    } catch (SQLException e) {
      System.err.println(e.getMessage());
    } finally {
      if (conn != null) {
        conn.close();
      }
    }
  }
}
```
- Always make sure to `close()` the connection after connecting to db!

## Generics in Java
Generic enables types (classes and interfaces) to be parameters when defining classes, interfaces and methods. Java is a strongly typed language. Generics aids to reuse the same code with different inputs with strong type checks.

Generics is useful for:
- elimination of casts
```java
//casting
List list = new ArrayList();
list.add("hello");
String s = (String) list.get(0);//cast

//no casting
List<String> list = new ArrayList<String>();
list.add("hello");
String s = list.get(0); //no cast
```
- Stronger type checks at compile time
- Enabling programmers to implement generic algorithms

Example of Generics:
```java
public class Generics<T> {
  T object;

  Generics(T object) {
    this.object = object;
  }

  public T getObject() {
    return this.object;
  }

  public static void main(String[] args) {
    Generics<Integer> obj3 = new Generics<Integer>(29);
    System.out.println(obj3.getObject());
  }
}
```

```java
class DualGenerics<T, U, V> {
  T object;
  U object2;
  V object3;

  DualGenerics(T object, U object2, V object3) {
    this.object = object;
    this.object2 = object2;
    this.object3 = object3;
  }

  public void display() {
    System.out.println(object + " " + object2 + " " + object3);
  }

  public static void main(String[] args) {
    DualGenerics<Integer, String, Character> obj = new DualGenerics<Integer, String, Character>(29, "Test", '&');
    obj.display();
  }
}
```
From the examples above, you would notice that the generic class holds a placeholder for the types of the obj which should be provided
when calling the class.

## String Handling in Java
The `String` class/API has a very versatile methods that are super helpful. Example of the methods include:
- charAt(int index)
- codePoints()
- concat(String str)
- compareToIgnoreCase(String str)
- contentEqual()
- length()
- format()
- etc

`String` class is super helpful and worth checking out to know all the methods you can use to play around a string.
_strings are immutable in nature_.

```java
String result = String.format("The name of the student is %s, and the age is %d", "Kelvin", 32);
System.out.println(result); // output: The name of the student is Kelvin, and the age is 32
```

## Java.lang package

This package provides classes that are fundamental to the design of a java program. You don't need to import this package at the top of your application as it is already an essential package provided to us when we create a java program.

It has interfaces and classes which are worth checking out to see what `java.lang` package is offering.

## Java.util package
This package contains collections framework, some internationalization support classes, a service loader, properties, random number generation, string parsing and scanning classes, base64 encoding and decoding, a bit array, and lots more utility classes.

You would need to explicitly import this package to get it work.

## Networking in Java
Java Networking is a concept of connecting two or more computing devices together so that we can share resources.

The `java.net` package supports two protocols;

- TCP: Transmission Control Protocol provides reliable communication between the sender and receiver. TCP is used along with the Internet Protocol referred as IP.
- UDP: User Datagram Protocol provides a connection-less protocol service by allowing packet of data to be transferred along two or more nodes

There are lots of helper classes, interfaces, exceptions, enums this package provides which is worth checking out.

```java
public class NetworkingDemo {
  public static void main(String[] args) throws UnknownHostException {
    String url = "www.stanleyazi.me";

    InetAddress address = InetAddress.getByName(url);
    System.out.println("Address: " + Arrays.toString(address.getAddress()));

    // getHostAddress() method
    System.out.println("Host address: " + address.getHostAddress());

    // getHostName() method
    System.out.println("Host name: " + address.getHostName());

    // isAnyLocalAddress() method
    System.out.println("isAnyLocalAddress: " + address.isAnyLocalAddress());

    // isLinkLocalAddress() method
    System.out.println("isLinkLocalAddress: " + address.isLinkLocalAddress());

    // isLoopbackAddress() method
    System.out.println("isLoopbackAddress: " + address.isLoopbackAddress());

    // isSiteLocalAddress() method
    System.out.println("isSiteLocalAddress: " + address.isSiteLocalAddress());
  }
}
```

## Image handling in Java
Java does provide support for image handling using two classes:

- `java.awt.Image` class and
- `java.awt.image.BufferedImage` class which extends the Image class

You can easily read provided image file and also write that exact image to a destination file in java as seen in the below example: 
```java
  private static BufferedImage readFromFile(int width, int height, BufferedImage image) {
    try {
      File sampleImageFile = new File("/sampleImage.jpg");

      image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

      // Reading input file
      image = ImageIO.read(sampleImageFile);

      System.out.println("Reading complete." + image);
    } catch (IOException e) {
      System.err.println("Error" + e.getMessage());;
    }
    return image;
  }
  
  private static void writeToFile(BufferedImage image) {
    try {
      File output = new File("/sampleImageOut.jpg");

      ImageIO.write(image, "jpg", output );

      System.out.println("Writing complete.");
    } catch (IOException e) {
      System.err.println("Error" + e.getMessage());
    }
  }
}
```

## Regular Expressions in Java (Regex)

The basic idea behind Regex is a way to describe a set of strings based on common characteristics shared by each string in the set.

Java provides the `java.util.regex` package which helps to implement regular expressions.

The `java.util.regex` package primarily consists of three classes: 
- `Pattern`: A Pattern object is a compiled representation of a regular expression.
- `Matcher`: A Matcher object is the engine that interprets the pattern and performs match operations against an input string.
- `PatternSyntaxException`: A PatternSyntaxException object is an unchecked exception that indicates a syntax error in a regular expression pattern.

```java
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
```

## NIO in java
`NIO` stands for _New Input/Out_, which is an API that defines `Buffers` (containers for data), and other structures such as `Charsets`, `Channels` and `Selectors` channels. 

The `NIO` package is a new improved version of the old `IO` package which allows reading or writing of files without blocking...this aid multithreading and non-blocking in threads more efficiently.

Both `NIO` package and `IO` package can be used together.

```java
public class NIODemo {
  public static void main(String[] args) throws IOException {
    // read a file
    FileInputStream fis = new FileInputStream("srcTest.md");
    FileChannel readChannel = fis.getChannel();
    ByteBuffer readBuffer = ByteBuffer.allocate(1024);
    int result = readChannel.read(readBuffer);
    System.out.println("File read successfully: " + result);

    // write to a file
    FileOutputStream fout = new FileOutputStream("nioDest.md");
    FileChannel writeChannel = fout.getChannel();
    ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
    String message = "Hello World tesing NIO write stream";
    writeBuffer.put(message.getBytes());
    writeBuffer.flip();
    writeChannel.write(writeBuffer);
    System.out.println(message);
  }
}
```

# References

- [Advanced Java](https://www.youtube.com/watch?v=Ae-r8hsbPUo)