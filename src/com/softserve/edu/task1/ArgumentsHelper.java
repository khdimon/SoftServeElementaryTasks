package com.softserve.edu.task1;

/**
 * Contains methods for work with args of command line.
 */
public class ArgumentsHelper {
    public static final String INSTRUCTION =
            "You must input two integer parameters: height and width";

    /**
     * Checks is number of args correct.
     *
     * @return result of checking
     */
    public boolean isArgumentsNumberCorrect(String[] args) {
        if (args.length == 2) {
            return true;
        } else {
            System.out.println("Incorrect number of args");
            System.out.println(INSTRUCTION);
            return false;
        }
    }

    /**
     * Converts args into int array and returns it.
     * If NumberFormatException occurs returns null.
     *
     * @return result array or null
     */
    public int[] convertArgumentsToInt(String[] args) {
        int[] result = new int[args.length];
        try {
            for (int i = 0; i < args.length; i++) {
                result[i] = Integer.parseInt(args[i]);
            }
        } catch (NumberFormatException e) {
            System.out.println("Incorrect format of args");
            System.out.println(INSTRUCTION);
            return null;
        }
        return result;
    }
}
