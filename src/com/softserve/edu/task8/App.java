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
     * Checks arguments and
     * returns array of double numbers -
     * left and right boundaries.
     *
     * @param args given arguments
     * @return array of double numbers - left and right boundaries
     */
    public double[] getBoundaries(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("Wrong number of arguments!");
        }

        double[] boundaries = new double[2];

        try {
            boundaries[0] = Double.parseDouble(args[0]);
            boundaries[1] = Double.parseDouble(args[1]);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Wrong format of arguments!");
        }

        if (boundaries[0] < 0 || boundaries[1] < 0) {
            throw new IllegalArgumentException("Boundaries can't be negative.");
        }

        if (boundaries[0] > boundaries[1]) {
            throw new IllegalArgumentException("Left boundary"
                    + " can't be larger than right boundary.");
        }

        return boundaries;
    }

    /**
     * Prints instructions to use program.
     */
    public void printInstruction() {
        System.out.println("Enter 2 arguments: 2 not negative numbers - "
                + "left boundary and right boundary\n"
                + "to take all Fibonacci numbers in interval.");
    }

    /**
     * Prints numbers separated by comma from given list.
     *
     * @param numbers given list of numbers
     */
    public void printNumbers(List<Long> numbers) {
        if (numbers.size() == 0) {
            System.out.println("No Fibonacci numbers in this interval");
        }

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
    public List<Long> getFibonacciInInterval(double[] boundaries) {
        if (boundaries.length != 2 || boundaries[0] < 0 || boundaries[1] < 0
                || (boundaries[0] > boundaries[1])) {
            throw new IllegalArgumentException();
        }

        List<Long> numbers = new ArrayList<>();
        double leftBoundary = boundaries[0];
        double rightBoundary = boundaries[1];
        int index = getFirstIndex(leftBoundary);
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
    public int getFirstIndex(double leftBoundary) {
        if (leftBoundary < 0) {
            throw new IllegalArgumentException();
        }

        if (leftBoundary == 0) {
            return 0;
        }

        if (leftBoundary < 1) {
            return 1;
        }

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
    public long getFibonacciByIndex(int index) {
        if (index < 0) {
            throw new IllegalArgumentException();
        }

        long current = 0;
        long next = 1;
        long temp;
        for (int i = 0; i < index; i++) {
            temp = next;
            next = current + next;
            current = temp;
        }

        return current;
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
        ConsoleHelper consoleHelper = new ConsoleHelper();
        consoleHelper.printFibonacciNumbers(args);
    }
}
