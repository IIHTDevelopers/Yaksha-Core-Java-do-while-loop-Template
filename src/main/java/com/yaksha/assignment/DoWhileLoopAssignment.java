package com.yaksha.assignment;

import java.util.Scanner;

public class DoWhileLoopAssignment {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Task 1: Repeat user input until valid response
        int userInput;
        do {
            System.out.print("Enter a positive integer: ");
            userInput = scanner.nextInt();
            if (userInput <= 0) {
                System.out.println("Please enter a positive integer.");
            }
        } while (userInput <= 0);
        System.out.println("Thank you! You entered: " + userInput);

        // Task 2: Reverse a given string
        System.out.print("Enter a string to reverse: ");
        String inputString = scanner.next();
        String reversedString = "";
        int length = inputString.length();
        int i = length - 1;
        do {
            reversedString += inputString.charAt(i);
            i--;
        } while (i >= 0);
        System.out.println("Reversed string: " + reversedString);

        // Task 3: Validate password
        String password;
        boolean validPassword;
        do {
            System.out.print("Enter a password: ");
            password = scanner.next();
            validPassword = isValidPassword(password);
            if (!validPassword) {
                System.out.println("Password must be at least 8 characters long, contain at least one digit, and one special character.");
            }
        } while (!validPassword);
        System.out.println("Password accepted.");

        // Task 4: Number guessing game
        int numberToGuess = (int) (Math.random() * 100) + 1;
        int guess;
        do {
            System.out.print("Guess the number (1-100): ");
            guess = scanner.nextInt();
            if (guess > numberToGuess) {
                System.out.println("Too high, try again!");
            } else if (guess < numberToGuess) {
                System.out.println("Too low, try again!");
            }
        } while (guess != numberToGuess);
        System.out.println("Correct! You guessed the number.");

        // Task 5: Print multiplication table of a number
        System.out.print("Enter a number for multiplication table: ");
        int number = scanner.nextInt();
        int multiplier = 1;
        do {
            System.out.println(number + " x " + multiplier + " = " + (number * multiplier));
            multiplier++;
        } while (multiplier <= 10);
    }

    // Helper method to check password validity
    private static boolean isValidPassword(String password) {
        return password.length() >= 8 && password.matches(".*\\d.*") && password.matches(".*[!@#$%^&*()].*");
    }
}
