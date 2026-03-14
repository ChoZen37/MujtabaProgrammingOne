/*
Name: Mujtaba Ghulam
Date: 2026/02/27
Course: COSC 1200 Intro to Programming
Description: test program to ask user for numbers and test them using the NumberTools class.
*/
import java.util.Scanner;

public class TestProgram {
    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        boolean keepRunningProgram = true;

        // loops until the user enters something that is not an integer
        while (keepRunningProgram) {
            System.out.print("Please enter an integer to test: ");

            // uses if statement to validate the input
            if (userInputScanner.hasNextInt()) {
                int userValue = userInputScanner.nextInt();

                System.out.print("Is " + userValue + " an even number? ");
                if (NumberTools.isEven(userValue)) {
                    System.out.println("Yes.");
                } else {
                    System.out.println("No.");
                }

                System.out.print("Is " + userValue + " a positive number? ");
                if (NumberTools.isPositive(userValue)) {
                    System.out.println("Yes.");
                } else {
                    System.out.println("No.");
                }

                System.out.print("Is " + userValue + " a Fibonacci number? ");
                if (NumberTools.isFibonacci(userValue)) {
                    System.out.println("Yes.");
                } else {
                    System.out.println("No.");
                }

                System.out.print("Is " + userValue + " a power of two? ");
                if (NumberTools.isPowerOfTwo(userValue)) {
                    System.out.println("Yes.");
                } else {
                    System.out.println("No.");
                }

                System.out.print("Is " + userValue + " a prime number? ");
                if (NumberTools.isPrime(userValue)) {
                    System.out.println("Yes.");
                } else {
                    System.out.println("No.");
                }

                System.out.print("Is " + userValue + " a square number? ");
                if (NumberTools.isSquare(userValue)) {
                    System.out.println("Yes.");
                } else {
                    System.out.println("No.");
                }
            } else {
                keepRunningProgram = false;
            }
        }
        userInputScanner.close();
    }
}