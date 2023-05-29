//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Changemaker Tester
// Course:   CS 300 Spring 2023
//
// Author:   Kiet Do
// Email:    kqdo@wisc.edu
// Lecturer: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    Tam Vo
// Partner Email:   tvo6@wisc.edu
// Partner Lecturer's Name: Hobbes LeGault
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   _X_ Write-up states that pair programming is allowed for this assignment.
//   _X_ We have both read and understand the course Pair Programming Policy.
//   _X_ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         NONE
// Online Sources:  NONE
//
///////////////////////////////////////////////////////////////////////////////

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Implements six tester methods, with two test methods dedicated to each of the three methods
 * implemented in the Changemaker class.
 */
public class ChangemakerTester {

  /**
   * The test methods testCountBase() and testCountRecursive() are dedicated to testing the
   * count() method
   *
   * 1. count() returns 0 when value is negative
   * 2. count() returns 0 when value is positive but there is no way to make change. You can create
   * such a scenario by choosing the sum total of all the coins in the register to be smaller than
   * value.
   * 3. count() returns 1 when value = 0
   *
   * @return true if and only if all test cases are passed
   */
  public static boolean testCountBase() {
    // count() returns 0 when value is negative
    {
      int[] testDenominations = {1, 4, 10, 25};
      int[] testCoinRemaining = {3, 0, 0, 1};
      int testVal = -1;

      int expected = 0;
      int actual = Changemaker.count(testDenominations, testCoinRemaining, testVal);
      if (expected != actual) return false;
    }

    // sum total of all the coins in the register to be smaller than value
    {
      int[] testDenominations = {1, 4, 10, 25};
      int[] testCoinRemaining = {3, 0, 0, 1};
      int testVal = 100;

      int expected = 0;
      int actual = Changemaker.count(testDenominations, testCoinRemaining, testVal);
      if (expected != actual) return false;
    }

    // count() returns 1 when value = 0
    {
      int[] testDenominations = {1, 4, 10, 25};
      int[] testCoinRemaining = {3, 0, 0, 1};
      int testVal = 0;

      int expected = 1;
      int actual = Changemaker.count(testDenominations, testCoinRemaining, testVal);
      if (expected != actual) return false;
    }
    return true;
  }

  /**
   * The test methods testCountBase() and testCountRecursive() are dedicated to testing the
   * count() method
   *
   * @return true if and only if all test cases are passed
   */
  public static boolean testCountRecursive() {
    //  at least three different coins can be used to make change
    {
      int[] testDenominations = {2, 6, 11, 26};
      int[] testCoinRemaining = {1, 1, 1, 1};
      int testVal = 39;

      int expected = 6;
      int actual = Changemaker.count(testDenominations, testCoinRemaining, testVal);
      if (expected != actual) return false;
    }

    // at least two different optimal ways to make change
    {
      int[] testDenominations = {2, 4, 1, 3};
      int[] testCoinRemaining = {1, 1, 1, 1};
      int testVal = 5;

      int expected = 4;
      int actual = Changemaker.count(testDenominations, testCoinRemaining, testVal);
      if (expected != actual) return false;
    }

    // greedily choosing the largest coin first does not produce a result
    // with the minimum number of coins used
    {
      int[] testDenominations = {1, 3, 5, 6};
      int[] testCoinRemaining = {2, 1, 1, 1};
      int testVal = 8;

      int expected = 5;
      int actual = Changemaker.count(testDenominations, testCoinRemaining, testVal);
      if (expected != actual) return false;
    }
    return true;
  }

  /**
   * The test methods testMinCoinsBase() and testMinCoinsRecursive() are dedicated to testing
   * the minCoins() method
   *
   * @return true if and only if all test cases are passed
   */
  public static boolean testMinCoinsBase() {
    // returns -1 when value is negative
    {
      int[] testDenominations = {1, 5, 10, 25};
      int[] testCoinRemaining = {2, 1, 0, 1};
      int testVal = -5;

      int expected = -1;
      int actual = Changemaker.minCoins(testDenominations, testCoinRemaining, testVal);
      if (expected != actual) return false;
    }

    // returns -1 when value is positive but there is no way to make change
    {
      int[] testDenominations = {1, 5, 10, 25};
      int[] testCoinRemaining = {2, 1, 0, 1};
      int testVal = 9;

      int expected = -1;
      int actual = Changemaker.minCoins(testDenominations, testCoinRemaining, testVal);
      if (expected != actual) return false;
    }

    // returns 0 when value = 0
    {
      int[] testDenominations = {1, 5, 10, 25};
      int[] testCoinRemaining = {2, 1, 0, 1};
      int testVal = 0;

      int expected = 0;
      int actual = Changemaker.minCoins(testDenominations, testCoinRemaining, testVal);
      if (expected != actual) return false;
    }
    return true;
  }

  /**
   * The test methods testMinCoinsBase() and testMinCoinsRecursive() are dedicated to testing
   * the minCoins() method
   *
   * @return true if and only if all test cases are passed
   */
  public static boolean testMinCoinsRecursive() {
    //  at least three different coins can be used to make change
    {
      int[] testDenominations = {1, 5, 10, 25};
      int[] testCoinRemaining = {3, 2, 1, 2};
      int testVal = 40;

      int expected = 3;
      int actual = Changemaker.minCoins(testDenominations, testCoinRemaining, testVal);
      if (expected != actual) return false;
    }

    // at least two different optimal ways to make change
    {
      int[] testDenominations = {2, 6, 10, 14};
      int[] testCoinRemaining = {3, 2, 1, 2};
      int testVal = 16;

      int expected = 2;
      int actual = Changemaker.minCoins(testDenominations, testCoinRemaining, testVal);
      if (expected != actual) return false;
    }

    // greedily choosing the largest coin first does not produce a result
    // with the minimum number of coins used
    {
      int[] testDenominations = {1, 6, 10, 14};
      int[] testCoinRemaining = {3, 2, 1, 2};
      int testVal = 16;

      int expected = 2;
      int actual = Changemaker.minCoins(testDenominations, testCoinRemaining, testVal);
      if (expected != actual) return false;

    }
    return true;
  }

  /**
   * test methods testMakeChangeBase() and testMakeChangeRecursive() are dedicated to
   * testing the makeChange method
   *
   * @return true if and only if all test cases are passed
   */
  public static boolean testMakeChangeBase() {
    // returns null when value is negative
    {
      int[] testDenominations = {1, 6, 10, 14};
      int[] testCoinRemaining = {3, 2, 1, 2};
      int testVal = -16;

      int[] expected = null;
      int actual[] = Changemaker.makeChange(testDenominations, testCoinRemaining, testVal);
      if (actual != expected) return false;
    }

    // returns null when value is positive but can't make change
    {
      int[] testDenominations = {1, 6, 10, 14};
      int[] testCoinRemaining = {1, 1, 1, 2};
      int testVal = 13;

      int[] expected = null;
      int actual[] = Changemaker.makeChange(testDenominations, testCoinRemaining, testVal);
      if (actual != expected) return false;
    }

    // returns an array of 0 when value = 0
    {
      int[] testDenominations = {1, 6, 10, 14};
      int[] testCoinRemaining = {3, 2, 1, 2};
      int testVal = 0;

      int[] expected = {0, 0, 0, 0};
      int actual[] = Changemaker.makeChange(testDenominations, testCoinRemaining, testVal);
      if (!Arrays.equals(expected,actual)) return false;

    }
    return true;
  }

  /**
   * test methods testMakeChangeBase() and testMakeChangeRecursive() are dedicated to
   * testing the makeChange method
   *
   * @return true if and only if all test cases are passed
   */
  public static boolean testMakeChangeRecursive() {
    //  at least three different coins can be used to make change
    {
      int[] testDenominations = {1, 5, 10, 25};
      int[] testCoinRemaining = {3, 2, 1, 2};
      int testVal = 40;

      int[] expected = {0, 1, 1, 1};
      int[] actual = Changemaker.makeChange(testDenominations, testCoinRemaining, testVal);
      if (!Arrays.equals(expected,actual)) return false;
    }

    // at least two different optimal ways to make change
    {
      int[] testDenominations = {2, 6, 10, 14};
      int[] testCoinRemaining = {3, 2, 1, 2};
      int testVal = 16;

      int[] expected1 = {1, 0, 0, 1};
      int[] expected2 = {0, 1, 1, 0};
      int[] actual = Changemaker.makeChange(testDenominations, testCoinRemaining, testVal);
      if (!Arrays.equals(expected1,actual) && !Arrays.equals(expected2,actual)) return false;
    }

    // greedily choosing the largest coin first does not produce a result
    // with the minimum number of coins used
    {
      int[] testDenominations = {1, 6, 10, 14};
      int[] testCoinRemaining = {3, 2, 1, 2};
      int testVal = 16;

      int[] expected = {0, 1, 1, 0};
      int[] actual = Changemaker.makeChange(testDenominations, testCoinRemaining, testVal);
      if (!Arrays.equals(expected,actual)) return false;
    }
    return true;
  }

  /**
   * Runs each of the tester methods and displays their result
   * @param args
   */
  public static void main(String[] args) {
    System.out.println("count base: "+testCountBase());
    System.out.println("count recursive: "+testCountRecursive());
    System.out.println("min base: "+testMinCoinsBase());
    System.out.println("min recursive: "+testMinCoinsRecursive());
    System.out.println("change base: "+testMakeChangeBase());
    System.out.println("change recursive: "+testMakeChangeRecursive());
  }
}
