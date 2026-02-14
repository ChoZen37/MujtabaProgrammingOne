/*
Name: Mujtaba Ghulam
Date: 2026-01-30
COSC-1200
Description: First Java Assignment
*/

import java.util.Scanner;

public class SimpleInput {
    public static void main(String[] args) {
        String studentName = "Mujtaba Ghulam";
        String bannerId = "100755448";

        System.out.println("Welcome: " + studentName + " " + bannerId);
        System.out.println("\"Do or do not. There is no try.\" - Yoda, Star Wars");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a number (decimal or integer): ");

        if (scanner.hasNextDouble()) {
            double userNumber = scanner.nextDouble();
            System.out.println("You entered the number: " + userNumber);
        } else {
            String badInput = scanner.next();
            System.out.println("That input is not a valid number: " + badInput);
        }

        scanner.close();
    }
}
