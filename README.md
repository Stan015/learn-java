# Java Practice

Here I document what I learnt from online resources to better understand java.

## The anatomy of java

- The smallest building block of java is Function.
```java
ReturnType nameOfFunction() {
  //...
}
```
- Every java program should have at least one function. The function is called main which is the entry function.
```java
void main() {
  //...
}
```
- The main function should always belong to a class. A class is a container for related functions (methods).
```java
class Main {
  void main() {
    //...
  }
}
```
- The classes and methods should have access modifier like public, private, default, protected, etc. 
```java
public class Main {
  public void main() {
    //...
  }
}
```

## Java code compilation

source code ( *.java) to Java Compiler to Byte Code ( *.class)

```java
//open file in terminal and type the below command to compile

javac Main.java

// ls to list Main.java file and the byte code file, Main.class
ls

// cd to src and run the file to output the compiled result
java [packageName].[FileName]

// example 
java me.stanleyazi.practice.Main

```

## 5 interesting facts about java

- java was developed by James Gosling in 1995 at Sun Micro System which was later acquired by Oracle in 2010
- It was originally called Oak, later renamed to green and finally named Java
- Java Editions: Standard Edition (SE), Enterprise Edition (EE), Micro Edition (ME), Java Card
- latest version (date: 28/9/2024) is JDK 23 edition
- Java is Widely used

## Variables

```java
type nameOrIdentifier = value;

int age = 25;
age = 30; //reassignment

// you can declare multiple variables of the same type in a single line (not recommended)
init age = 25, temperature = 20;

// copy the value of another variable
int myAge = age;
```

## Primitive types - Default value

1. Byte (8 bits = 1 byte, range -128 to 127) => 0
2. short (2 byte, range -32k to 32k) => 0
3. int (4 byte, range -2b to 2b) => 0
4. long (8 byte, range - to ) => 0L
5. float (4 bytes) => 0.0f
6. double (8 bytes) => 0.0d
7. char (2 bytes->16-bit, range 0 to 65k) => \u0000
8. boolean (1 bit) => false

## reference types

1. string
2. array
3. date
4. stacks
5. queues etc

Primitive variables are completely independent on each other because they are stored in different memory location. 
Reference variable are dependent on each other.

```java
// String message = new String("Hello World") - redundant
String message = "Hello World" + "!!";
System.out.println("message = " + message.length());
System.out.println("message = " + message.replace("!!", "👋"));
```

## Arrays

Each item in an array is called an element, and each element is accessed by its numerical index.

```java
int[] numbers = new int[5]; //declared an array of int and allocated a memory for 5 integers.
numbers[0] = 4;
numbers[1] = 6;
numbers[2] = 3;
System.out.println(numbers); // output: [I@34a245ab
System.out.println(Arrays.toString(numbers)); // output: [4, 6, 3, 0, 0]
```
```java
//better array declaration
int[] newNumbers = {3, 53, 2, 5, 0};
System.out.println(Arrays.toString(newNumbers));
System.out.println(newNumbers.length);
```

```java
// two-dimensional Array
int[][] numbers2 = new int[2][3];
numbers2[0][0] = 1;
numbers2[0][1] = 2;
System.out.println(Arrays.deepToString(numbers2));

int[][] numbers3 = {{3, 2, 1}, {0, 4, 9}};
System.out.println(Arrays.deepToString(numbers3));
```

## Copying Arrays

Using the built in System.arraycopy(), you can easily copy an array.
```java
public static void arraycopy(Object src, int srcPos,
                             Object dest, int destPos, int length)
```

```java
class copyArray {
  public static void main() {
    String[] copyFrom = {"me", "you", "learning java"};
    String[] copyTo = new String[1];

    System.arraycopy(copyFrom, 2, copyTo, 0, 1);
    System.out.println(copyTo[0]); // outputs "learning java"
    String[] copyTo2 = java.util.Arrays.copyOfRange(copyFrom, 0, 2);
    System.out.println(java.util.Arrays.toString(copyTo2)); // [me, you]
  }
}
```

## Some array manipulation methods

- binarySearch() - returns the index of the search key
- equal() - checks arrays equality
- toString() - converts to string
- fill() - fills an array at the specified index
- sort() - sort array in ascending order 
- parallelSort() - sort large arrays and faster
- stream() - create a stream that uses an array as its source

## Using the var keyword

You can use the var keyword to declare a variable and allow the compiler to decide the type of the variable. This comes in handy to reduce redundant type specification:

```java
// From
String message = "Hello world!";
Path path = Path.of("debug.log");
InputStream stream = Files.newInputStream(path);
// To
var message = "Hello world!";
var path = Path.of("debug.log");
var stream = Files.newInputStream(path);
```
## Restrictions on using the var keyword

- Only used in local variables declared in methods, constructors and initializer blocks.
- Cannot be used for fields, methods and constructor parameters
- The variable must have an initializer

## Constant

```java
final float PI = 3.142F; // final
```
## Arithmetics Expression

```java
public static void arithmeticExpression() {
  int a = 23 * 3;
  System.out.println("a = " + a);
  
  double result = (double)10 / (double) 3;
  System.out.println(result);
  
  int x = 1;
  x++;
  int y = ++x;
  y += 4;
  System.out.println(x);
  System.out.println(y);
  
  int z = (3 + 4) * 9;
  System.out.println(z);
  
  // implicit casting
  // byte > short > int > long > float > double
  short s = 1;
  int d = s + 2;
  System.out.println(d);
  
  // explicit casting.
  double h = 4.9;
  int k = (int)h + 4;
  System.out.println(k);
  // can only happen between compatible types
  String f = "2";
  int b = Integer.parseInt(f) - 3;
  System.out.println(b);
}
```

## Math Class

```java
public static void mathClass() {
  double x = Math.random();
  System.out.println(x);

  int y = Math.round(1.1F);
  System.out.println(y);
}
```

## format numbers with NumberFormat package

```java
public static void formatNumbers() {
  NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
  System.out.println("currencyFormat = " + currencyFormat.format(1328.32));

  String result = NumberFormat.getPercentInstance().format(0.399); // methods chaining
  System.out.println("percentFormat = " + result);
}
```

## Reading input from the user

```java
public static void readingInputFromUser() {
  Scanner scanner = new Scanner(System.in);
  System.out.print("My age is: ");
  byte age = scanner.nextByte();
  System.out.println("age = " + age);

  Scanner scanner2 = new Scanner(System.in);
  System.out.print("My name is: ");
  String name = scanner2.nextLine().trim(); //.next reads one token, nextLine reads all tokens in a line
  System.out.println("name = " + name);
}
```

## Comparison Operators

We use these operators to compare primitive values

```java
public class Main {
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
  }
}
```

## Type comparison
`instanceof` operator is used to compare the types of objects

```java
class InstanceofDemo {
  public static void main(String[] args) {

    Parent obj1 = new Parent();
    Parent obj2 = new Child();

    System.out.println("obj1 instanceof Parent: "
      + (obj1 instanceof Parent)); // true
    System.out.println("obj1 instanceof Child: "
      + (obj1 instanceof Child)); // false
    System.out.println("obj1 instanceof MyInterface: "
      + (obj1 instanceof MyInterface)); // false
  }
}

class Parent {}
class Child extends Parent implements MyInterface {}
interface MyInterface {}
```

## Logical Operators

```java
public class Main {
  public static void main(String[] args) {
    boolean hasHighIncome = true;
    boolean hasGoodCredit = false;
    boolean hasCriminalRecord  = false;
    boolean isEligible = (hasHighIncome || hasGoodCredit) && !hasCriminalRecord;
    System.out.println(isEligible);
  }
}
```

## Conditional Statements

### The `if statement` and `ternary operator`: 

```java
public class ConditionalStatements {
  public static void main(String[] args) {
    int temperature = 32;
    if (temperature > 30) {
      System.out.println("It's a hot day");
      System.out.println("Drink water");
    }
    else if (temperature > 20)
      System.out.println("It's a beautiful day");
    else
      System.out.println("It's not a hot day");

    int income = 128_388;
    boolean hasHighIncome = income > 99_999;
    System.out.println(hasHighIncome);

    String className = income > 99_999 ? "First class" : "Economy class";
    System.out.println(className);
  }
}
```
### The switch statement
```java
public class ConditionalStatements {
  public static void main(String[] args) {
    // switch statement
    String role = "admin";
    switch (role) {
      case "admin":
        System.out.println("Admin");
        break;
      case "user":
        System.out.println("User");
        break;
      default:
        System.out.println("Not a valid role");
    }
  }
}
```

```java
// exercise
// if number is divisible by 5, print "Fizz". If number is divisible by 3, print "Buzz".
// if number is divisible by both 3 and 5, print "FizzBuzz"
public class FizzBuzz {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Number: ");
    int number = scanner.nextInt();

    String result = number % 5 == 0 && number % 3 == 0 ? "FizzBuzz"
      : number % 5 == 0 ? "Fizz"
      : number % 3 == 0 ? "Buzz"
      : "" + number;

    System.out.println(result);
  }
}
```

### For loop

With the for loop, so long as the condition is true, the code block will run

```java
for (int i = 0; i < 5; i++)
  System.out.println("Hello Java Loop World");
```

### While Loop
Similar to `for` loop, but with different syntax. The code block will run as long as the condition is truthy.

```java
// While loop
int i = 0;
while (i < 3) {
  System.out.println("Hello Java Loop World");
  i++;
}
```
`While` is preferred when we don't know how many times to loop, orderwise use for loop.
```java
Scanner scanner2 = new Scanner(System.in);
String input = "";
while (!input.equals("exit")) {
  System.out.print("Input: ");
  input = scanner2.next().toLowerCase();
  System.out.println(input);
}
```

### Do...while loop
This type of loop executes at least once.

```java
// Do...while loop
Scanner scanner3 = new Scanner(System.in);
String input3 = "";

do {
  System.out.print("Input: ");
  input3 = scanner3.next().toLowerCase();
  
  if (input3.equals("pass"))
    continue;
  
  if (input3.equals("exit"))
    break;
  
  System.out.println(input3);
} while (true);
```

### ForEach loop
This is used to iterate over an array
limitations: can't not loop in reverse. No access to index of array

```java
// ForEach loop
String[] fruits = {"Apple", "Banana", "Orange", "Pear", "Grape"};
for (String fruit : fruits)
  System.out.println(fruit);
```

## The break, continue, and return statements

Just as seen in the above code blocks, the `break` statement is used to prevent further checks in loops, while `continue` resumes the checks in the loop. The `return` is used to stop a function from further executing.

## Exception handling in Java
This is the ability to handle runtime errors.

Types of Java Exceptions
- checked exception (IOException, SQLException, ParseException, and ClassNotFoundException)
- unchecked exception (NullPointerException, ArrayIndexOutOfBoundsException, ArithmeticException, and IllegalArgumentException)
- error (OutOfMemoryError, StackOverflowError, and NoClassDefFoundError)

### Java Exception Keywords

try, catch, finally, throw, throws

```java
try {  
  // Code that may throw an exception  
} catch (Exception e) {  
  // Exception handling code  
} finally {  
  // Cleanup code  
}  
```

## Date in Java

```java
public class DateTime {
  public static void main(String[] args){

    LocalDate today = LocalDate.now();
    System.out.println("Today : " + today);

    LocalTime thisTime = LocalTime.now();
    System.out.println("This time : " + thisTime);

    LocalDateTime currentDateTime = LocalDateTime.now();
    System.out.println("Current Time : " + currentDateTime);

    LocalDate someDay = LocalDate.of(2020, Month.JUNE, 12);
    System.out.println("Someday : " + someDay);

    LocalTime someTime = LocalTime.of(23, 53);
    System.out.println("Sometime : " + someTime);

    LocalDateTime otherDateTime = LocalDateTime.of(2021, Month.MARCH, 4, 10,51,44);
    System.out.println("Other Date Time : " + otherDateTime);

  }
}
```

## Java’s File APIs

Java has two file APIs.

- The original `java.io.File` API, available since Java 1.0 (1996).
- The newer `java.nio.file.Path` API, available since Java 1.7 (2011).

Firstly, you would need to reference a file path:

```java
public static void main(String[] args) throws URISyntaxException {

  // Java11+  : Path.of()

  Path path = Path.of("/Desktop/practice-folder/java-practice/hello-java-world/README.md");
  System.out.println(path);

  path = Path.of("/Desktop/practice-folder/java-practice/hello-java-world/README.md");
  System.out.println(path);

  path = Path.of("Desktop" , "practice-folder", "java-practice", "hello-java-world", "README.md");
  System.out.println(path);

  path = Path.of("Desktop" , "practice-folder", "java-practice", "hello-java-world").resolve("README.md"); // resolve == getChild()
  System.out.println(path);

  path = Path.of(new URI("file:///Desktop/practice-folder/java-practice/hello-java-world/README.md"));
  System.out.println(path);

  // Java < 11 equivalent: Paths.get()
  path = Paths.get("/Desktop/practice-folder/java-practice/hello-java-world/README.md");
  System.out.println(path);

  // etc...
}
```

All the above read the file path correctly, outputting same result.

### Common File Operations

1. Check if file exists
```java
Path path = Path.of("/Desktop/practice-folder/java-practice/hello-java-world/README.md");
System.out.println(path);

boolean fileExists = path.toFile().exists();
System.out.println(fileExists);
//or
boolean fileExists2 = Files.exists(path);
System.out.println(fileExists2);
```

2. Check last date modified
```java
Path path = Path.of("/Desktop/practice-folder/java-practice/hello-java-world/README.md");
FileTime lastModifiedTime = Files.getLastModifiedTime(path);
System.out.println("lastModifiedTime = " + lastModifiedTime);
```
3. How to compare files (Java12+): `File.mismatch(path, Paths.get("/path2"))`
4. Get owner of file: `Files.getOwner(path)`
5. Create Temporary file: `Files.createTempFile(path.getParent(), "somePrefixOrNull", ".jpg");`
6. Create Directory: `Path newDirectory = Files.createDirectories(path.getParent().resolve("some/new/dir"));`
7. Create file: `Files.createFile(newDirectory.resolve("emptyFile.txt"));`


## Data Structure

We can classify Data Structures into two categories:

- Primitive Data Structure
- Non-Primitive Data Structure

The Primitive Data Structure includes: Integer, Float, Character, Boolean.
While the Non-Primitive Data Structure are further divided into Linear Data Structure and Non-Linear Data Structure.
<br>
- Linear Data Structure include: Array, Queue, Stack, Linked-list.  Array is a perfect example of a Static Data Structure, while, Queue, Stack and Linked-List are Dynamic Data Structures.
- Non-linear data structure include: Graph, Tree, Hash Table

### DS Algorithms

An Algorithm is a set of rules or procedure through which a task or problem is solved by the computer following the specified rules.

#### Algorithm characteristics
- Input
- Output
- Not ambiguous
- Language dependent free
- Finiteness
- Effectiveness

#### Factors of an algorithm

- Modularity
- Correctness
- Maintainability
- User-friendly
- Simplicity
- Functionality
- Extensibility
- Robustness

#### Approaches of Algorithm

- Brute Force Algorithm
- Divide and Conquer
- Greedy Algorithm
- Dynamic Programming
- Branch and Bound algorithm
- Randomized algorithm
- Backtracking

#### Major categories of algorithms

- Sort: Algorithm developed for sorting the items in a certain order.
- Search: Algorithm developed for searching the items inside a data structure.
- Delete: Algorithm developed for deleting the existing element from the data structure.
- Insert: Algorithm developed for inserting an item inside a data structure.
- Update: Algorithm developed for updating the existing element inside a data structure.

#### Algorithm complexity

The complexity of an algorithm is calculated on two bases;
1. Time Complexity: This is the time it takes to solve a problem with an algorithm. Time Complexity is denoted by the `Big O Notation`
2. Space Complexity: On the other hand, is the amount of memory required to complete solving a problem with an algorithm. This is also expressed with `Big O Notation`.

#### Types of Algorithms

- Search Algorithm: Linear search and Binary Search
- Sort Algorithm


# References
- [Java's File APIs](https://www.marcobehler.com/guides/java-files)