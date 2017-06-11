package com.softserve.edu.task4;

import java.io.*;

/**
 * It's necessary to write a program that will have two modes:
 * 1. Count the number of string occurrences in text file.
 * 2. Replace string on another one in specified file.
 * The program must receive input arguments at start:
 * 1. (path to the file) (string for the counting)
 * 2. (path to the file) (string for finding) (string to replace)
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
        FileHelper fileHelper = new FileHelper();
        StringHelper stringHelper = new StringHelper();
        ConsoleHelper consoleHelper = new ConsoleHelper();
        Executor executor = new Executor(fileHelper, stringHelper,
                consoleHelper);
        executor.execute(args);
    }
}
