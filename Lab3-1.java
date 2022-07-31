package lee_lab3;

import java.util.Scanner;

public class Lab3 {
    public static void main(String[] args) {

    // Declare variables
    final int MIN_RANGE = 100;          // Lowest end of range
    final int MAX_RANGE = 200;          // Highest end of range
    int num;                            // Player's guess
    String input;                       // To hold user input (y or n)
    char ready;                         // First character of yes or no

    // Create object for player
    GuessGame game = new GuessGame(MAX_RANGE, MIN_RANGE);

    //Create scanner object
    Scanner keyboard = new Scanner(System.in);

    // Welcome message
    welcome();

    do
    {
        // Generate a random number within a given range (chosen by me)
        game.newTarget();

        do
        {
            // Ask user to guess a number
            System.out.print("Guess a number between " + game.getRangeMinimum() + " and " + game.getRangeMaximum() + ": ");
            num = keyboard.nextInt();

            // User is given unlimited number of guesses and on each guess, is told whether their guess is too high,
            // too low, or correct.
        }
        // The guess function returns either a true (correct guess) or false (incorrect guess) and will stop asking
        // user to guess a number if they are correct (boolean returns true).
        while (game.guess(num));


        // Display number of guesses it took user to get correct target number
        game.displayStatistics();

        //Ask user if they would like to play again. Repeat if yes. Otherwise, end game.
        System.out.print("\nReady to play again? (no to quit) ");
        input = keyboard.next();
        ready = input.charAt(0);
    }
    while (ready == 'Y' || ready == 'y');

    // Goodbye message
    goodbye();
}

    /**
     *  Welcome method displays a welcome message
     */
    public static void welcome()
    {
        System.out.println("\nThs is a guessing game where you will guess a number\n" +
                           "and I tell you if it is too low or too high.\n");
    }

    /**
     * Goodbye method displays a goodbye message
     */
    public static void goodbye()
    {
        System.out.println("\nThanks for playing!");
    }
}


