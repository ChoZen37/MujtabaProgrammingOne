/*
Name: Mujtaba Ghulam
Date: 2026/03/13
Description: This program simulates a game where two players shoot projectiles at each other
It calculates the landing spot using math formulas for projectile motion
*/

import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;

public class ProjectileGame {

    // Scanner is set up here so the whole class can use it easily
    static Scanner keyboardInput = new Scanner(System.in);

    public static void main(String[] args) {
        // declaring all the variables at the top of the method
        String firstPlayerName = "";
        String secondPlayerName = "";
        int firstPlayerScore = 0;
        int secondPlayerScore = 0;
        boolean keepPlayingGames = true;
        int winningPlayerNumber = 0;
        String playAgainAnswer = "";

        // Get the names of both players to start the program
        System.out.println("Enter name for player one:");
        firstPlayerName = keyboardInput.nextLine();

        System.out.println("Enter name for player two:");
        secondPlayerName = keyboardInput.nextLine();

        // This boolean controls the main game loop
        while (keepPlayingGames) {
            // Call runGame to play a round and find out who won
            winningPlayerNumber = runGame(firstPlayerName, secondPlayerName);

            // Add a point to whoever won the round
            if (winningPlayerNumber == 1) {
                firstPlayerScore = firstPlayerScore + 1;
                System.out.println(firstPlayerName + " wins this round!");
            } else {
                if (winningPlayerNumber == 2) {
                    secondPlayerScore = secondPlayerScore + 1;
                    System.out.println(secondPlayerName + " wins this round!");
                }
            }

            // Show the current score to the players so they know who is winning
            System.out.println("Current Scores:");
            System.out.println(firstPlayerName + ": " + firstPlayerScore);
            System.out.println(secondPlayerName + ": " + secondPlayerScore);

            // Check if the players want to play another game
            System.out.println("Do you want to play another game? Type yes or no:");
            playAgainAnswer = keyboardInput.next();

            // If they say no change the boolean to false to stop the loop
            if (playAgainAnswer.equalsIgnoreCase("no")) {
                keepPlayingGames = false;
            }
        }

        System.out.println("Thanks for playing!");
    }

    // Method to get the power value from the user safely
    public static double getPower() {
        // initializing variables at the top
        double velocityPower = 0.0;
        boolean isPowerValid = false;

        // Loop until valid input is given avoiding break statements
        while (!isPowerValid) {
            System.out.println("Enter your firing power (between 1 and 1000):");

            try {
                // Try to read a number from the user
                velocityPower = keyboardInput.nextDouble();

                // Check if the number is in the correct range
                if (velocityPower >= 1 && velocityPower <= 1000) {
                    isPowerValid = true;
                } else {
                    System.out.println("That power is not valid. Please try again.");
                }
            } catch (InputMismatchException error) {
                // This catches the error if the user types letters or symbols instead of a number
                System.out.println("Invalid input. Please enter a number.");
                // Clear the bad input from the scanner so it does not loop forever
                keyboardInput.next();
            }
        }
        return velocityPower;
    }

    // Method to get the angle value from the user safely
    public static double getAngle() {
        // initialize at the top
        double firingAngle = 0.0;
        boolean isAngleValid = false;

        // Loop until valid input is given avoiding break statements
        while (!isAngleValid) {
            System.out.println("Enter your firing angle (between 0 and 180):");

            try {
                // Try to read a number from the user
                firingAngle = keyboardInput.nextDouble();

                // Check if the number is in the correct range
                if (firingAngle >= 0 && firingAngle <= 180) {
                    isAngleValid = true;
                } else {
                    System.out.println("That angle is not valid. Please try again.");
                }
            } catch (InputMismatchException error) {
                // This catches the error if the user types letters or symbols
                System.out.println("Invalid input. Please enter a number.");
                // Clear the bad input from the scanner
                keyboardInput.next();
            }
        }
        return firingAngle;
    }

    // Calculates the landing coordinate using the physics formulas
    public static double getShot(double startingPositionCoordinate) {
        // initialize all variables at the top of the method
        double initialVelocity = 0.0;
        double initialAngleDegrees = 0.0;
        double angleInRadians = 0.0;
        double gravityForce = 9.81;
        double timeAfterFiring = 0.0;
        double landingCoordinateX = 0.0;

        // Get user input for power and angle
        initialVelocity = getPower();
        initialAngleDegrees = getAngle();

        // Java uses radians for math so we convert the degrees here
        angleInRadians = Math.toRadians(initialAngleDegrees);

        // Calculate how long the shot stays in the air
        timeAfterFiring = (initialVelocity * Math.sin(angleInRadians)) / (0.5 * gravityForce);

        // Calculate the final landing spot by adding the travel distance to the starting point
        landingCoordinateX = (initialVelocity * Math.cos(angleInRadians)) * timeAfterFiring + startingPositionCoordinate;

        // Give a bit more info about the calcualtion process in the output
        System.out.println("Calculating trajectory...");
        System.out.println("Power: " + initialVelocity + " | Angle: " + initialAngleDegrees + " degrees");
        System.out.println("Flight time: " + timeAfterFiring + " seconds");

        return landingCoordinateX;
    }

    // Sets up the game and runs the turns until someone wins
    public static int runGame(String nameOfPlayerOne, String nameOfPlayerTwo) {
        // all variables declared at the top
        Random randomGenerator = new Random();
        double playerOnePosition = 0.0;
        double playerTwoPosition = 0.0;
        boolean isGameFinished = false;
        int winningPlayerNumber = 0;
        boolean isPlayerOneTurn = true;
        double landingLocation = 0.0;
        double distanceToTarget = 0.0;

        // Give both players a random starting position from 0 to 120
        playerOnePosition = randomGenerator.nextDouble() * 120;
        playerTwoPosition = randomGenerator.nextDouble() * 120;

        System.out.println(nameOfPlayerOne + " starts at position " + playerOnePosition);
        System.out.println(nameOfPlayerTwo + " starts at position " + playerTwoPosition);

        // Loop the turns avoiding break statements
        while (!isGameFinished) {
            if (isPlayerOneTurn) {
                System.out.println(nameOfPlayerOne + "'s turn! Target is at " + playerTwoPosition);

                // Call getShot to see where the player's projectile lands
                landingLocation = getShot(playerOnePosition);
                System.out.println("The shot landed at position " + landingLocation);

                // Check if the landing spot is within 1 unit of the target
                distanceToTarget = Math.abs(landingLocation - playerTwoPosition);

                if (distanceToTarget < 1.0) {
                    winningPlayerNumber = 1;
                    isGameFinished = true;
                } else {
                    // Pass the turn to player two
                    isPlayerOneTurn = false;
                }
            } else {
                System.out.println(nameOfPlayerTwo + "'s turn! Target is at " + playerOnePosition);

                // Call getShot to see where the player's projectile lands
                landingLocation = getShot(playerTwoPosition);
                System.out.println("The shot landed at position " + landingLocation);

                // Check if the landing spot is within 1 unit of the target
                distanceToTarget = Math.abs(landingLocation - playerOnePosition);

                if (distanceToTarget < 1.0) {
                    winningPlayerNumber = 2;
                    isGameFinished = true;
                } else {
                    // Pass the turn to player one
                    isPlayerOneTurn = true;
                }
            }
        }

        // Return the player number of the person who got a direct hit
        return winningPlayerNumber;
    }
}