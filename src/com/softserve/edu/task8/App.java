package com.softserve.edu.task8;

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
