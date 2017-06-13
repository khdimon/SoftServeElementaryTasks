package com.softserve.edu.task8;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

/**
 * Gets boundaries of given interval. Prints instructions for user.
 */
public class ArgumentsHelper {

    private static final String INSTRUCTIONS = "Enter 2 arguments: "
            + "2 not negative numbers - "
            + "left boundary and right boundary\n"
            + "to take all Fibonacci numbers in interval.";

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
     * Gets boundaries of interval from arguments of this ArgumentsHelper.
     * If number or format of arguments are incorrect throws
     * IllegalArgumentException.
     *
     * @return pair of boundaries - left and right
     */
    public Pair<Double, Double> getBoundaries() {
        if (args.length != 2) {
            throw new IllegalArgumentException("Wrong number of arguments!");
        }

        double left;
        double right;

        try {
            left = Double.parseDouble(args[0]);
            right = Double.parseDouble(args[1]);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Wrong format of arguments!");
        }

        return new ImmutablePair<>(left, right);
    }

    public void printInstructions() {
        System.out.println(INSTRUCTIONS);
    }
}
