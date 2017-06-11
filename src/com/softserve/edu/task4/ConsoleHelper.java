package com.softserve.edu.task4;

/**
 * Prints instructions to the console.
 */
public class ConsoleHelper {
    private static final String INSTRUCTIONS =
            "Enter: \"<Path to the file> <target string>\""
                    + " to count occurrences\n"
                    + "or \"<Path to the file> <target string>"
                    + " <string for replacement>\" to replacement";

    /**
     * Prints instructions to the console.
     */
    public void printInstructions() {
        System.out.println(INSTRUCTIONS);
    }
}
