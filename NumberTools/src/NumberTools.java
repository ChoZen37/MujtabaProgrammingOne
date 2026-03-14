/*
Name: Mujtaba Ghulam
Date: 2026/02/27
Course: COSC 1200 Intro to Programming
Description: this class has number testing functions for class exercise 3.
*/
public class NumberTools {

    // this function checks if the value is an even number
    public static boolean isEven(int value) {
        if (value % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    // this function checks if the value is positive
    public static boolean isPositive(int value) {
        if (value > 0) {
            return true;
        } else {
            return false;
        }
    }

    // this function checks if the value is a power of two
    public static boolean isPowerOfTwo(int value) {
        if (value <= 0) {
            return false;
        }
        int currentPower = 1;
        boolean foundPower = false;

        // loops to find if it matches a power of two
        while (currentPower <= value) {
            if (currentPower == value) {
                foundPower = true;
            }
            currentPower = currentPower * 2;
        }
        return foundPower;
    }

    // this function checks if the value is a prime number
    public static boolean isPrime(int value) {
        if (value < 2) {
            return false;
        }
        boolean isItPrime = true;
        int divisorTest = 2;

        // loops to see if any number divides it evenly
        while (divisorTest < value) {
            if (value % divisorTest == 0) {
                isItPrime = false;
            }
            divisorTest = divisorTest + 1;
        }
        return isItPrime;
    }

    // this function checks if the value is a square number
    public static boolean isSquare(int value) {
        if (value < 0) {
            return false;
        }
        boolean foundSquare = false;
        int rootTest = 0;

        // loops to find if a number multiplied by itself equals the value
        while (rootTest * rootTest <= value) {
            if (rootTest * rootTest == value) {
                foundSquare = true;
            }
            rootTest = rootTest + 1;
        }
        return foundSquare;
    }

    // this function checks if the value is a fibonacci number
    public static boolean isFibonacci(int value) {
        if (value < 0) {
            return false;
        }
        int previousNumber = 0;
        int currentNumber = 1;
        boolean isItFibonacci = false;

        // checks the first two numbers
        if (value == 0) {
            isItFibonacci = true;
        }
        if (value == 1) {
            isItFibonacci = true;
        }

        // loops to calculate the sequence
        while (currentNumber <= value) {
            int nextNumber = previousNumber + currentNumber;
            previousNumber = currentNumber;
            currentNumber = nextNumber;

            if (currentNumber == value) {
                isItFibonacci = true;
            }
        }
        return isItFibonacci;
    }
}