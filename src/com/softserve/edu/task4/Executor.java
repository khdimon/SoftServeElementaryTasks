package com.softserve.edu.task4;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Counts number of occurrences of the string
 * or replaces one string to another in the given file
 * in depend of given arguments number.
 */
public class Executor {
    private FileHelper fileHelper;
    private StringHelper stringHelper;
    private ConsoleHelper consoleHelper;

    /**
     * Creates new instance of the Executor with given FileHelper, StringHelper
     * and ConsoleHelper.
     *
     * @param fileHelper given FileHelper
     * @param stringHelper given StringHelper
     * @param consoleHelper given ConsoleHelper
     */
    public Executor(FileHelper fileHelper, StringHelper stringHelper,
                    ConsoleHelper consoleHelper) {
        this.fileHelper = fileHelper;
        this.stringHelper = stringHelper;
        this.consoleHelper = consoleHelper;
    }

    /**
     * Counts number of occurrences of the string
     * or replaces one string to another in the given file
     * in depend of given arguments number.
     * The result is printed to the console.
     *
     * @param args given arguments
     */
    public void execute(String[] args) {
        try {
            switch (args.length) {
                case 2:
                    int count = countStringOccurrencesInFile(args[0], args[1]);
                    System.out.printf("Count of occurrences "
                            + "of string \"%s\": %d.", args[1], count);
                    break;

                case 3:
                    if (replaceStringInFile(args[0], args[1], args[2])) {
                        System.out.printf("All occurrences of string \"%s\" "
                                        + "have been replaced on \"%s\".%n",
                                args[1], args[2]);
                    } else {
                        System.out.printf("The string \"%s\""
                                + " is absent in the file.%n", args[1]);
                    }
                    break;

                default:
                    System.out.println("Incorrect number of args.");
                    consoleHelper.printInstructions();
                    break;
            }

        } catch (FileNotFoundException e) {
            System.out.println("Wrong path to the file.");
            consoleHelper.printInstructions();

        } catch (IOException e) {
            System.out.println("Some problems with input or output"
                    + " have occurred.");
        }
    }

    /**
     * Counts number of occurrences of the target string in the file
     * that defined by its path.
     *
     * @param path   path to the file
     * @param target target string
     * @return count of occurrences
     * @throws IOException If a file doesn't exist
     *                     or other I/O error occurs
     */
    public int countStringOccurrencesInFile(String path, String target)
            throws IOException {
        String content = fileHelper.readFileToString(path);
        return stringHelper.countOccurrences(content, target);
    }

    /**
     * Replaces one string to another in the file
     * that defined by its path.
     * Returns true if one or more replacement
     * was executed or false otherwise.
     *
     * @param path        path to the file
     * @param target      string to be replace
     * @param replacement new string for replacement
     * @return true if one or more replacement
     * was executed or false otherwise
     * @throws IOException If a file doesn't exist
     *                     or other I/O error occurs
     */
    public boolean replaceStringInFile(String path, String target,
                                       String replacement) throws IOException {
        if (target.length() == 0) {
            return false;
        }

        String content = fileHelper.readFileToString(path);

        if (!content.contains(target)) {
            return false;
        }

        String newContent = content.replace(target, replacement);
        fileHelper.writeStringToFile(path, newContent);

        return true;
    }
}
