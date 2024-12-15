package me.stanleyazi.AdvancedJava;

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