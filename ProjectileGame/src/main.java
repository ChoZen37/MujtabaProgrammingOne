import java.util.Scanner;
import java.util.Random;

// Name: Mujtaba Ghulam
// Date: 2026/03/13
// Description: This program is a game that simulates two players firing artillery at each other[cite: 11].
// It calculates where the shot lands based on projectile motion math[cite: 12].

public class main {

    // I am setting up the scanner here so the whole class can use it easily
    static Scanner keyboardInput = new Scanner(System.in);

    public static void main(String[] args) {
        // The program should start by requesting the names for each player[cite: 29].
        System.out.println("Enter name for player one:");
        String firstPlayerName = keyboardInput.nextLine();

        System.out.println("Enter name for player two:");
        String secondPlayerName = keyboardInput.nextLine();

        // Initialize each player's score to 0[cite: 31].
        int firstPlayerScore = 0;
        int secondPlayerScore = 0;

        // Use a while loop to allow the user to indicate whether they would like to play another game[cite: 48].
        boolean keepPlayingGames = true;

        while (keepPlayingGames) {
            // Start a new game and get the player number of the winner[cite: 47].
            int winningPlayerNumber = runGame(firstPlayerName, secondPlayerName);

            // Update the scores based on who won the game
            if (winningPlayerNumber == 1) {
                firstPlayerScore = firstPlayerScore + 1;
                System.out.println(firstPlayerName + " wins this round!");
            } else {
                if (winningPlayerNumber == 2) {
                    secondPlayerScore = secondPlayerScore + 1;
                    System.out.println(secondPlayerName + " wins this round!");
                }
            }

            // Print the current scores for both players
            System.out.println("Current Scores:");
            System.out.println(firstPlayerName + ": " + firstPlayerScore);
            System.out.println(secondPlayerName + ": " + secondPlayerScore);

            // Ask if they want to play again
            System.out.println("Do you want to play another game? Type yes or no:");
            String playAgainAnswer = keyboardInput.next();

            // The program only ends when the user says no to this prompt[cite: 49].
            if (playAgainAnswer.equalsIgnoreCase("no")) {
                keepPlayingGames = false;
            }
        }

        System.out.println("Thanks for playing!");
    }

    // Prompt the user for their power or velocity value[cite: 33].
    public static double getPower() {
        double velocityPower = 0;
        boolean isPowerValid = false;

        // Loop until the user enters a valid power, without using breaks
        while (!isPowerValid) {
            System.out.println("Enter your firing power (between 1 and 1000):");
            velocityPower = keyboardInput.nextDouble();

            // This can be any number between 1 and 1000[cite: 34].
            if (velocityPower >= 1 && velocityPower <= 1000) {
                isPowerValid = true;
            } else {
                System.out.println("That power is not valid. Please try again.");
            }
        }
        return velocityPower;
    }

    // Prompt the user for their initial projectile angle[cite: 35].
    public static double getAngle() {
        double firingAngle = 0;
        boolean isAngleValid = false;

        // Loop until the user enters a valid angle, without using breaks
        while (!isAngleValid) {
            System.out.println("Enter your firing angle (between 0 and 180):");
            firingAngle = keyboardInput.nextDouble();

            // This should be between 0 and 180[cite: 36].
            if (firingAngle >= 0 && firingAngle <= 180) {
                isAngleValid = true;
            } else {
                System.out.println("That angle is not valid. Please try again.");
            }
        }
        return firingAngle;
    }

    // This will call both getPower and getAngle, and use those values to determine where the shot lands[cite: 41].
    public static double getShot(double startingPositionCoordinate) {
        // Get the power and angle from the user
        double initialVelocity = getPower();
        double initialAngleDegrees = getAngle();

        // Convert the angle to radians because Java Math functions need radians
        double angleInRadians = Math.toRadians(initialAngleDegrees);

        // Gravity constant is 9.81[cite: 27]. I made it positive here to keep the time calculation simple.
        double gravityForce = 9.81;

        // Calculate the time it takes for the shot to land
        // Use the formula to find a value for time after firing when the shot has landed[cite: 43].
        double timeAfterFiring = (initialVelocity * Math.sin(angleInRadians)) / (0.5 * gravityForce);

        // Now use the time to find the x coordinate where the shot has landed[cite: 44].
        double landingCoordinateX = (initialVelocity * Math.cos(angleInRadians)) * timeAfterFiring + startingPositionCoordinate;

        return landingCoordinateX;
    }

    // This will initialize the player positions and start the turns[cite: 45].
    public static int runGame(String nameOfPlayerOne, String nameOfPlayerTwo) {
        Random randomGenerator = new Random();

        // Both players will begin at a random position an x coordinate between 0 and 120[cite: 32].
        double playerOnePosition = randomGenerator.nextDouble() * 120;
        double playerTwoPosition = randomGenerator.nextDouble() * 120;

        System.out.println(nameOfPlayerOne + " starts at position " + playerOnePosition);
        System.out.println(nameOfPlayerTwo + " starts at position " + playerTwoPosition);

        boolean isGameFinished = false;
        int winningPlayerNumber = 0;
        boolean isPlayerOneTurn = true;

        // Loop turns until someone wins, completely avoiding breaks
        while (!isGameFinished) {
            if (isPlayerOneTurn) {
                System.out.println(nameOfPlayerOne + "'s turn! Target is at " + playerTwoPosition);

                // Get the shot landing spot
                double landingLocation = getShot(playerOnePosition);

                // Report the x coordinate where that player's shot landed[cite: 46].
                System.out.println("The shot landed at position " + landingLocation);

                // Check if the shot is within less than 1 of the target's location[cite: 47].
                double distanceToTarget = Math.abs(landingLocation - playerTwoPosition);

                if (distanceToTarget < 1.0) {
                    winningPlayerNumber = 1;
                    isGameFinished = true;
                } else {
                    // Switch to player two
                    isPlayerOneTurn = false;
                }
            } else {
                System.out.println(nameOfPlayerTwo + "'s turn! Target is at " + playerOnePosition);

                // Get the shot landing spot
                double landingLocation = getShot(playerTwoPosition);

                // Report the x coordinate where that player's shot landed[cite: 46].
                System.out.println("The shot landed at position " + landingLocation);

                // Check if the shot is within less than 1 of the target's location[cite: 47].
                double distanceToTarget = Math.abs(landingLocation - playerOnePosition);

                if (distanceToTarget < 1.0) {
                    winningPlayerNumber = 2;
                    isGameFinished = true;
                } else {
                    // Switch back to player one
                    isPlayerOneTurn = true;
                }
            }
        }

        // Return the player number of the winner[cite: 47].
        return winningPlayerNumber;
    }
}