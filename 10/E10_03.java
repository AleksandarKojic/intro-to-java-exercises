/*
  Design a class named MyInteger. The class contains:

  - An int data field named value that stores the int value represented by
    this object.
  - A constructor that creates a MyInteger object for the specified int value.
  - A getter method that returns the int value.
  - The methods isEven(), isOdd(), and isPrime() that return true if the value
    in this object is even, odd, or prime, respectively.
  - The static methods isEven(MyInteger), isOdd(MyInteger), and
    isPrime(MyInteger) that return true if the specified value is even, odd,
    or prime, respectively.
  - The methods equals(int) and equals(MyInteger) that return true if the value
    in this object is equal to the specified value.
  - A static method parseInt(char[]) that converts an array of numeric
    characters to an int value.
  - A static method parseInt(String) that converts a string into an int value.

  Write a client program that tests all methods in the class.
*/

public class E10_03 {
  public static void main(String[] args) {
    MyInteger n = new MyInteger(5);
    System.out.println("getValue(): " + n.getValue());
    System.out.println("isEven(): " + n.isEven());
    System.out.println("isOdd(): " + n.isOdd());
    System.out.println("isPrime(): " + n.isPrime());
    System.out.println("equals(10): " + n.equals(10));
    System.out.println("equals(MyInteger(5)): " + n.equals(new MyInteger(5)));
    System.out.println("isEven() static: " + MyInteger.isEven(n));
    System.out.println("isOdd() static: " + MyInteger.isOdd(n));
    System.out.println("isPrime() static: " + MyInteger.isPrime(n));
    System.out.println("parseInt(char[]{1, 2, 3}) static: " +
      MyInteger.parseInt(new char[]{'1', '2', '3'}));
    System.out.println("parseInt(String 123) static: " +
      MyInteger.parseInt(new String("123")));
  }

  private static class MyInteger {
    private int value;

    MyInteger() {
      this(0);
    }

    MyInteger(int value) {
      this.value = value;
    }

    // getters
    int getValue() {
      return value;
    }

    // instance methods
    boolean isEven() {
      return getValue() % 2 == 0;
    }

    boolean isOdd() {
      return !isEven();
    }

    boolean isPrime() {
      int n = getValue();
      if (isEven() || n == 0 || n == 1) { return false; }
      if (n == 2) { return true; }
      for (int i = 3; i <= Math.sqrt(n); i += 2) {
        if (n % i == 0) { return false; }
      }
      return true;
    }

    boolean equals(int n) {
      return getValue() == n;
    }

    boolean equals(MyInteger n) {
      return getValue() == n.getValue();
    }

    // static methods
    static boolean isEven(MyInteger n) {
      return n.isEven();
    }

    static boolean isOdd(MyInteger n) {
      return n.isOdd();
    }

    static boolean isPrime(MyInteger n) {
      return n.isPrime();
    }

    static int parseInt(char[] c) {
      return parseInt(new String(c));
    }

    static int parseInt(String s) {
      return Integer.parseInt(s);
    }
  }
}
