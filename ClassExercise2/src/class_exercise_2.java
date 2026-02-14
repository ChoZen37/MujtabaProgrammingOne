/*
Mujtaba Ghulam
2026-02-06
Description: guessing game program!
 */

import java.util.Scanner;
import java.util.Random;

public class class_exercise_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Random number generator
        Random randomNumber = new Random();

        // Controls replaying the game
        char playAgain = 'y';

        // Outer loop for replay feature
        while (playAgain == 'y') {

            // Generate random number between 1 and 100
            int number = randomNumber.nextInt(100) + 1;

            // Attempt tracking
            int attempts = 0;
            int maxAttempts = 10;

            // Flag to check if number was guessed
            boolean guessedCorrectly = false;

            System.out.println("Guess a number between 1 and 100.");

            // Game loop
            while (attempts < maxAttempts && !guessedCorrectly) {

                System.out.print("Enter your guess: ");

                // Check if input is NOT a number
                if (!input.hasNextInt()) {
                    System.out.println("Error: Please enter a numeric value.");
                    input.next(); // Clear invalid input
                    continue; // Do not count as an attempt
                }

                int guess = input.nextInt();

                // Check if number is outside valid range
                if (guess < 1 || guess > 100) {
                    System.out.println("Error: Number must be between 1 and 100.");
                    continue; // Do not count as an attempt
                }

                // Valid guess, count attempt
                attempts++;

                // Compare guess to random number
                if (guess < number) {
                    System.out.println("Too low.");
                } else if (guess > number) {
                    System.out.println("Too high.");
                } else {
                    System.out.println("Correct! You guessed the number.");
                    guessedCorrectly = true;
                }
            }

            // Game over message
            System.out.println("The correct number was: " + number);
            System.out.println("Attempts used: " + attempts);

            // Ask user if they want to play again
            System.out.print("Play again? (y or n): ");
            playAgain = input.next().toLowerCase().charAt(0);
        }

        // Close scanner
        input.close();
    }
}
