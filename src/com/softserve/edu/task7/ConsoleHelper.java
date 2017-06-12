package com.softserve.edu.task7;

public class ConsoleHelper {

    /**
     * Prints integer numbers from 1 to given number.
     *
     * @param number given number
     */
    public void printNumbers(int number) {

        if (number < 1) {
            System.out.println("Nothing to show.");
            return;
        }

        for (int i = 1; i <= number; i++) {
            if (i == number) {
                System.out.println(i);
            } else {
                System.out.print(i + ", ");
            }
        }
    }

    /**
     * Prints numbers that correspond the task.
     * Number n given in arguments.
     *
     * @param args given arguments
     */
    public void printSolution(String[] args) {
        ArgumentsHelper argumentsHelper = new ArgumentsHelper(args);
        int number;
        try {
            number = argumentsHelper.getNumberFromArguments();

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            argumentsHelper.printInstructions();
            return;
        }
        MathHelper mathHelper = new MathHelper();
        int maxNumber = mathHelper.getMaxNumber(number);
        printNumbers(maxNumber);
    }
}
