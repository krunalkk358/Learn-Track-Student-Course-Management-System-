package com.airtribe.learntrack.util;

import com.airtribe.learntrack.exception.InvalidInputException;


public class InputValidator {

    public static void validateMenuChoice(int choice, int min, int max)
            throws InvalidInputException {

        if (choice < min || choice > max) {
            throw new InvalidInputException(
                    "Invalid choice. Please select between " + min + " and " + max
            );
        }
    }

    public static void validateNotEmpty(String value, String fieldName)
            throws InvalidInputException {

        if (value == null || value.trim().isEmpty()) {
            throw new InvalidInputException(fieldName + " cannot be empty.");
        }
    }
}
