package com.softserve.edu.task5;

/**
 * Converts integer number into words.
 * Number is given in argument of command line.
 */
public class App {

    /**
     * Runs the program. In command line it is necessary
     * to enter 1 argument: integer number
     * that we want to convert into words.
     *
     * @param args arguments of command line
     */
    public static void main(String[] args) {
        NumberHelper numberHelper = new NumberHelper();
        numberHelper.printNumberInWordsFromArgs(args);
    }
}
