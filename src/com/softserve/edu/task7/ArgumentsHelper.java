package com.softserve.edu.task7;

/**
 * Checks number of arguments.
 * Gets the number given in arguments.
 * Prints instructions for user.
 */
public class ArgumentsHelper {

    private static final String INSTRUCTIONS =
            "Enter one argument - positive integer number.";

    private String[] args;

    /**
     * Creates new ArgumentsHelper with given arguments.
     *
     * @param args given arguments
     */
    public ArgumentsHelper(String[] args) {
        this.args = args;
    }

    /**
     * Checks whether the number of arguments is correct.
     *
     * @return the result of checking
     */
    private boolean isArgumentsNumberTrue() {
        return args.length == 1;
    }

    /**
     * Returns the given number from arguments of this ArgumentsHelper.
     * If number or format or arguments are incorrect
     * the IllegalArgumentException is thrown.
     *
     * @return number given in arguments
     */
    public int getNumberFromArguments() {
        int result;

        if (!isArgumentsNumberTrue()) {
            throw new IllegalArgumentException("Wrong number of arguments!");
        }

        try {
            result = Integer.parseInt(args[0]);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Wrong format of arguments!");
        }

        return result;
    }

    /**
     * Prints instructions for user.
     */
    public void printInstructions() {
        System.out.println(INSTRUCTIONS);
    }
}
