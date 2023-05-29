//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Changemaker
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

import java.util.Arrays;

/**
 * Contains three public static methods. These three methods will be focused on solving
 * three different aspects of the change-making problem
 */
public class Changemaker {

  /**
   * determine the number of possible ways to make change for a given value
   *
   * @param denominations: value of each type of coin in your register
   * @param coinsRemaining: quantity of each type of coin in your register
   * @param value: total amount of change to be dispensed to the customer
   * @return total number of possible ways to make change for a given value
   */
  public static int count(int[] denominations, int[] coinsRemaining, int value) {
    int count = 0;
    int total = 0;

    for (int i = 0; i < denominations.length; i++) {
      total += denominations[i] * coinsRemaining[i];
    }

    if ((value < 0) || (total < value)) {
      return 0;

    } else if (value == 0) {
      return 1;

    } else {

      for (int i = 0; i < denominations.length; i++) {
        if ((denominations[i] <= value) && (coinsRemaining[i] > 0)) {
          coinsRemaining[i]--;
          count += count(denominations, coinsRemaining, value - denominations[i]);
          coinsRemaining[i]++;
        }
      }
    }
    return count;
  }

  /**
   * determine the optimal way to make change
   *
   * @param denominations: value of each type of coin in your register
   * @param coinsRemaining: quantity of each type of coin in your register
   * @param value: total amount of change to be dispensed to the customer
   * @return minimum total number of coins needed to make change
   */
  public static int minCoins(int[] denominations, int[] coinsRemaining, int value) {
    int total = 0;
    int pathLength = 0;
    int shortestPath = Integer.MAX_VALUE;

    for (int i = 0; i < denominations.length; i++) {
      total += denominations[i] * coinsRemaining[i];
    }

    if ((value < 0) || (total < value)) {
      return -1;
    } else if (value == 0) {
      return 0;
    }

    if (count(denominations, coinsRemaining, value) == 0) {
      return -1;
    }

    for (int i = denominations.length - 1; i >= 0; i--) {
      if ((denominations[i] <= value) && (coinsRemaining[i] > 0)) {
        coinsRemaining[i]--;
        pathLength = minCoins(denominations, coinsRemaining, value - denominations[i]);
        coinsRemaining[i]++;

        if (pathLength == -1) {
          continue;
        }

        if (pathLength < shortestPath) {
          shortestPath = pathLength + 1;
        }
      }
    }
    return shortestPath;
  }

    /**
     * determines the number of coins of each denominations that were used
     *
     * @param denominations: value of each type of coin in your register
     * @param coinsRemaining: quantity of each type of coin in your register
     * @param value: total amount of change to be dispensed to the customer
     * @return an array representing the exact number of each coin needed to make change optimally
     */
    public static int[] makeChange(int[] denominations, int[] coinsRemaining, int value){
      int[] changeArray = null;
      int lowestTotal = 0;

      if (value == 0) {
        changeArray = new int[coinsRemaining.length];
        for (int i = 0; i < changeArray.length; i++) {
          changeArray[i] = 0;
        }
        return changeArray;
      }
      if (value < 0) {
        return null;
      }

      for (int i = 0; i < denominations.length; i++) {
        int[] sampleArray = null;
        if ((denominations[i] <= value) && (coinsRemaining[i] > 0)){
          coinsRemaining[i]--;
          sampleArray = makeChange(denominations, coinsRemaining, value - denominations[i]);
          coinsRemaining[i]++;
          if (sampleArray == null) {
            continue;
          }

          //else {
            sampleArray[i]++;
            if ((Arrays.stream(sampleArray).sum() < lowestTotal) || (lowestTotal == 0)) {
              lowestTotal = Arrays.stream(sampleArray).sum();
              changeArray = sampleArray;
            //}
          }
        }
      }
      return changeArray;
    }
}
