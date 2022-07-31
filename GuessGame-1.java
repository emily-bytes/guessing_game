package lee_lab3;

import java.util.Random;

/**
 * This program simulates a guessing game.
 *
 * @author Emily Lee
 * @version 1.0
 */

public class GuessGame {
    private int maximumRange;               // Maximum range for target number
    private int minimumRange;               // Minimum range for target number
    private int guessCount;                 // Number of guesses
    private int newTarget;                  // Target number

    /**
     * Constructor
     * @param minRange The highest range
     * @param maxRange The lowest range
     */
    public GuessGame (int maxRange, int minRange) {
        maximumRange = maxRange;        // Maximum range
        minimumRange = minRange;        // Minimum range
    }

    /**
     * displayStatistics method displays number of guesses it took user to correctly guess target number
     */
    public void displayStatistics() {
        System.out.print("\nYou've guessed " + guessCount + " times.\n");
    }

    /**
     * newTarget method generates a target number according to min and max range provided by me
     */
     public void newTarget() {

         // Initialize guessCount to zero
         guessCount = 0;

         // Create random object
         Random rand = new Random();

         // Choose a new integer which is now the new target
         newTarget = rand.nextInt(maximumRange - minimumRange) + minimumRange;
     }

     /**
      * guess method If guess is incorrect, return false, Otherwise, return true.
      * @param num Guess number
      * @return boolean True or false
      */
    public boolean guess(int num) {

        // Count number of guesses
        guessCount++;

        if (num == newTarget) {
            System.out.print("That's correct!");
            return true;
        }
        else {
            // Call private dsplayHint method to determine whether guess is too high or too low
            displayHint(num);
            return false;
        }
    }

      /**
       * getRangeMinimum method
       * @return minRange The low end of the range for target number
       */
      public int getRangeMinimum() {
          return minimumRange;}

    /**
      * getRangeMaximum method
      * @return maxRange The high end of the range for target number
      */
    public int getRangeMaximum() { return maximumRange; }

    /**
     * displayHint method Used within guess function to display too high or too low
     * @param num Guess
     */
    private void displayHint(int num) {
        if (num > newTarget)
            System.out.println(num + " is too high.");
        else
            System.out.println(num + " is too low.");
    }
}


