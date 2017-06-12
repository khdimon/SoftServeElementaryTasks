package com.softserve.edu.task6;

import java.io.*;

/**
 * The ticket number is six-digit number.
 * There are two algorithms for define lucky tickets:
 * <p>1. Moskow. Sum of first 3 digits is equal
 * to sum of last 3 digits.
 * <p>2. Piter. Sum of digits in odd positions is equal
 * to sum of digits in even positions.
 * <p>
 * Need to write console application
 * that can count number of lucky tickets.
 * For selecting count algorithm text file is read.
 * Path to the text file is given in console
 * after start of the program.
 * The indicates of the algorithm:
 * <p>1 - word "Moskow"
 * <p>2 - word "Piter"
 * <p>
 * Program must print number of lucky tickets
 * for given algorithm.
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
        consoleHelper.printLuckyTicketsNumber();
    }
}
