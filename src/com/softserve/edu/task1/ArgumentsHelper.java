package com.softserve.edu.task1;

import org.apache.commons.lang3.tuple.*;

import java.util.Optional;

/**
 * Contains methods for work with args of command line.
 */
public class ArgumentsHelper {
    private static final String INSTRUCTIONS =
            "You must specify the parameters: "
                    + "two positive integer numbers - height and width";

    private String[] args;

    /**
     * Creates new instance of ArgumentsHelper with given args.
     *
     * @param args given args
     */
    public ArgumentsHelper(String[] args) {
        this.args = args;
    }

    /**
     * Checks whether the number of args is correct.
     *
     * @return result of checking
     */
    private boolean isArgumentsNumberCorrect() {
        if (args.length == 2) {
            return true;
        } else {
            System.out.println("Incorrect number of args");
            printInstructions();
            return false;
        }
    }

    /**
     * Checks whether the format of args is correct.
     *
     * @return result of checking
     */
    private boolean isArgumentsFormatCorrect() {
        boolean isCorrect = true;

        for (String arg : args) {
            if (!arg.matches("\\d+")) {
                isCorrect = false;
                break;
            }
        }

        if (!isCorrect) {
            System.out.println("Incorrect format of args");
            printInstructions();
        }

        return isCorrect;
    }

    /**
     * Checks whether the args are correct.
     *
     * @return result of checking
     */
    private boolean isArgumentsCorrect() {
        return isArgumentsNumberCorrect()
                && isArgumentsFormatCorrect();
    }

    /**
     * Prints instructions
     */
    public void printInstructions() {
        System.out.println(INSTRUCTIONS);
    }

    /**
     * Returns an Optional of pair of values gotten from args.
     * If args is incorrect returns an empty Optional.
     *
     * @return Optional with values or empty Optional
     */
    public Optional<Pair<Integer, Integer>> getValues() {
        Pair<Integer, Integer> resultPair = null;

        if (isArgumentsCorrect()) {
            int left = Integer.parseInt(args[0]);
            int right = Integer.parseInt(args[1]);
            resultPair = new ImmutablePair<>(left, right);
        }

        return Optional.ofNullable(resultPair);
    }
}
