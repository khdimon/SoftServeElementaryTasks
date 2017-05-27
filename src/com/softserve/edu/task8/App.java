package com.softserve.edu.task8;

import java.util.ArrayList;
import java.util.List;

/**
 * Allows to print all Fibonacci numbers
 * in interval that is given by two arguments of command line.
 * Fibonacci Numbers are printed in ascending order
 * and separated by comma.
 *
 * @author Dima Kholod
 */
public class App {
    /**
     * Checks number of arguments (must be 2).
     *
     * @param args given arguments
     * @return the result of checking
     */
    private boolean checkArguments(String[] args) {
        return args.length == 2;
    }

    /**
     * Returns array of double numbers - left and right boundaries.
     *
     * @param args given arguments
     * @return array of double numbers - left and right boundaries
     */
    private double[] getBoundaries(String[] args) {
        double[] boundaries = new double[2];
        try {
            boundaries[0] = Double.parseDouble(args[0]);
            boundaries[1] = Double.parseDouble(args[1]);
            if (boundaries[0] > boundaries[1]) {
                throw new IllegalArgumentException("Left boundary"
                        + " can't be larger than right boundary.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Wrong format of arguments!");
        }
        return boundaries;
    }

    /**
     * Prints instructions to use program.
     */
    private void printInstruction() {
        System.out.println("Enter 2 arguments: 2 numbers - left boundary"
                + " and right boundary to take all Fibonacci numbers"
                + " in interval.");
    }

    /**
     * Prints numbers separated by comma from given list.
     *
     * @param numbers given list of numbers
     */
    private void printNumbers(List<Long> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (i == numbers.size() - 1) {
                System.out.println(numbers.get(i));
            } else {
                System.out.print(numbers.get(i) + ", ");
            }
        }
    }

    /**
     * Returns list with all Fibonacci numbers
     * that are in given interval -
     * from leftBoundary to rightBoundary.
     *
     * @param boundaries array with left and right boundaries
     */
    private List<Long> getFibonacciInInterval(double[] boundaries) {
        List<Long> numbers = new ArrayList<>();
        double leftBoundary = boundaries[0];
        double rightBoundary = boundaries[1];
        int index = calculateFirstIndex(leftBoundary);
        long fibonacci = getFibonacciByIndex(index);
        while (fibonacci <= rightBoundary) {
            numbers.add(fibonacci);
            index++;
            fibonacci = getFibonacciByIndex(index);
        }
        return numbers;
    }

    /**
     * Returns the index of the least Fibonacci number
     * that is lager or equals than given left boundary.
     *
     * @param leftBoundary given left boundary
     * @return the index of the Fibonacci number
     */
    private int calculateFirstIndex(double leftBoundary) {
        //This formula allows to take approximate value of index
        // we are looking for.
        int index = (int) (Math.log(Math.sqrt(5) * leftBoundary)
                / Math.log((1 + Math.sqrt(5)) / 2));
        long fib = getFibonacciByIndex(index);
        if (fib < leftBoundary) {
            do {
                index++;
                fib = getFibonacciByIndex(index);
            } while (fib < leftBoundary);
            return index;
        } else {
            do {
                index--;
                fib = getFibonacciByIndex(index);
            } while (fib >= leftBoundary);
            return index + 1;
        }
    }

    /**
     * Returns Fibonacci number by its index.
     *
     * @param index given index of Fibonacci number
     * @return Fibonacci number for given index
     */
    private long getFibonacciByIndex(int index) {
        if (index < 0) {
            throw new IllegalArgumentException();
        }
        if (index == 0) {
            return 0;
        }
        long current = 1;
        long next = 1;
        long temp;
        for (int i = 2; i < index; i++) {
            temp = next;
            next = current + next;
            current = temp;
        }
        return next;
    }

    /**
     * Runs program. In command line it is necessary
     * to enter 2 arguments:
     * 2 numbers - left boundary and right boundary
     * to take all Fibonacci numbers in interval.
     *
     * @param args arguments of command line
     */
    public static void main(String[] args) {
        App app = new App();
        if (!app.checkArguments(args)) {
            app.printInstruction();
            return;
        }
        try {
            double[] boundaries = app.getBoundaries(args);
            List<Long> numbers = app.getFibonacciInInterval(boundaries);
            app.printNumbers(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            app.printInstruction();
        }
    }
}
