package com.softserve.edu.task7;

/**
 * The program prints a series of natural numbers
 * separated by a comma,
 * the square of which is less than the specified number n.
 * The program is launched via the main class call
 * with parameters.
 *
 * @author Dima Kholod
 */
public class App {

    /**
     * Starts the program.
     *
     * @param args parameters of the command line
     */
    public static void main(String[] args) {

        ConsoleHelper consoleHelper = new ConsoleHelper();
        consoleHelper.printSolution(args);
    }
}
