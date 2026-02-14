/*
 * Mujtaba Ghulam
 * 2026-02-13
 * COSC 1200 Intro to Programming
 * Description: A program that uses arrays and iterations to calculate are of a pizza
 */

import java.util.Scanner;

public class PizzaCutting {

    public static void main(String[] args) {

        // Constants
        final double MIN_DIAMETER = 6.0;
        final double MAX_DIAMETER = 24.0;

        // Arrays
        double[] diameterThresholds = {8.0, 12.0, 14.0, 16.0, 20.0, 24.1};
        int[] slicesPerSize = {4,   6,    8,    10,   12,   16};

        Scanner input = new Scanner(System.in);

        // Variables
        double diameter = 0.0;
        boolean validInput = false;

        // Error handling/user validation
        while (!validInput) {

            System.out.print("Please enter the diameter of your pizza: ");

            // Check if input is a number
            if (input.hasNextDouble()) {
                diameter = input.nextDouble();

                // Check if number is in valid range
                if (diameter >= MIN_DIAMETER && diameter <= MAX_DIAMETER) {
                    validInput = true; // This stops the while loop!
                } else {
                    // Range Error
                    System.out.println("Error:");
                    System.out.println("Pizza must have a diameter in the range of 6\" to 24\" inclusive!");
                    System.out.println("Please try again.\n");
                }
            } else {
                // Type Error (User typed words instead of numbers)
                String badInput = input.next(); // Consume the bad text so we don't loop infinitely
                System.out.println("Error:");
                System.out.println("\"" + badInput + "\" is not a valid number.");
                System.out.println("Please try again.\n");
            }
        }

        // Calculations
        int numberOfSlices = 0;
        boolean found = false;

        // Loop through the array to find the correct number of slices
        for (int i = 0; i < diameterThresholds.length && !found; i++) {
            if (diameter < diameterThresholds[i]) {
                numberOfSlices = slicesPerSize[i];
                found = true;
            }
        }

        // Calculate Areas
        double radius = diameter / 2.0;
        double totalArea = Math.PI * Math.pow(radius, 2);
        double sliceArea = totalArea / numberOfSlices;

        // Output Results
        System.out.println();
        System.out.printf("A %.0f\" pizza will yield %d slices.\n", diameter, numberOfSlices);
        System.out.printf("Each slice will have an area of %.2f square inches.\n", sliceArea);

        // Close scanner
        input.close();
    }
}