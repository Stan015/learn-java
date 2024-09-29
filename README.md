# Java Practice

Here I document what I learn from online resources to better understand java.

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
java me.stanleyazi.Main

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

## Primitive types

1. Byte (1 byte, range -128 to 127)
2. short (2 byte, range -32k to 32k)
3. int (4 byte, range -2b to 2b)
4. long (8 byte, range - to )
5. float 4 bytes
6. double 8 bytes
7. char 2 bytes
8. boolean 1 bit

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

```java
int[] numbers = new int[5];
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