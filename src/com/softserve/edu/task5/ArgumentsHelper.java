package com.softserve.edu.task5;

/**
 * Checks number and format of command line arguments.
 * Returns number given in arguments.
 */
public class ArgumentsHelper {

    /**
     * Maximum possible number of digits in given number.
     */
    public static final int MAX_DIGITS_NUMBER =
            PartOfNumber.DIGITS_IN_PART * (PartOfNumber.MAX_INDEX + 1);

    /**
     * Instructions for users.
     */
    private static final String INSTRUCTIONS = String.format(
            "Enter 1 arguments: integer number "
                    + "that we want to convert into words.%n"
                    + "Quantity of digits must be not more than %d.%n"
                    + "Examples: 123, -4567, 1_000_000.",
            MAX_DIGITS_NUMBER);

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
     * Checks whether number of arguments is correct.
     *
     * @return result of checking
     */
    public boolean isNumberOfArgumentsCorrect() {
        return args.length == 1;
    }

    /**
     * Checks whether format of arguments is correct.
     *
     * @return result of checking
     */
    public boolean isFormatOfArgumentsCorrect() {
        String number = args[0].replace("_", "");
        return (number.matches(
                String.format("-?\\d{1,%d}", MAX_DIGITS_NUMBER)));
    }

    /**
     * Prints instructions for users.
     */
    public void printInstruction() {
        System.out.println(INSTRUCTIONS);
    }

    /**
     * Returns number given in arguments as string of digits.
     * If number or format of arguments is incorrect returns empty string.
     *
     * @return number as string of digits
     */
    public String getNumber() {
        if (isNumberOfArgumentsCorrect() && isFormatOfArgumentsCorrect()) {
            return args[0].replace("_", "");
        }

        return "";
    }
}
