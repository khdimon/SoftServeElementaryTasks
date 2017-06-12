package com.softserve.edu.task5;

/**
 * Prints number in words for given number in arguments.
 * If number or format of arguments is incorrect prints message
 * about mistake and instructions for users.
 */
public class NumberHelper {

    /**
     * Prints number in words for given arguments.
     * If number or format of arguments is incorrect prints message
     * about mistake and instructions for users.
     *
     * @param args given arguments
     */
    public void printNumberInWordsFromArgs(String[] args) {
        ArgumentsHelper argumentsHelper = new ArgumentsHelper(args);
        if (!argumentsHelper.isNumberOfArgumentsCorrect()) {
            System.out.println("Wrong number of arguments!");
            argumentsHelper.printInstruction();
            return;
        }

        if (!argumentsHelper.isFormatOfArgumentsCorrect()) {
            System.out.println("Wrong format of arguments!");
            argumentsHelper.printInstruction();
            return;
        }

        String number = argumentsHelper.getNumber();
        NumberInWords numberInWords = new NumberInWords(number);
        String result = numberInWords.getRepresentation();
        System.out.println(result);
    }
}
