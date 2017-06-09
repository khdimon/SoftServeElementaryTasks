package com.softserve.edu.task2;

/**
 * <p>
 * There are two envelops with sides (a, b) and (c, d).
 * It is necessary to determine whether we can put one envelope
 * into another.
 * <p>
 * Program must to work with numbers with float point.
 * Program asks an user for envelope sizes one at a time.
 * Program  asks the user after any computation
 * whether he wants to continue.
 * If the user answers "y" or "yes" (ignoring case),
 * program continues the work from start,
 * otherwise program completes.
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
        ConsoleHelper helper = new ConsoleHelper();
        helper.getEnvelopsAndCheck();
    }
}
