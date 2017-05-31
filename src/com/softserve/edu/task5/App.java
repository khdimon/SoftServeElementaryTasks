package com.softserve.edu.task5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Converts integer number into words.
 * Number is given in argument of command line.
 */
public class App {
    public static final String ZERO = "Ноль.";
    public static final String MINUS = "минус";

    /**
     * Checks number and format of arguments.
     * Returns number from args[0] - string with digits.
     *
     * @param args given arguments
     * @return number given in args[0]
     */
    private String getNumber(String[] args) {
        if (args.length != 1) {
            throw new IllegalArgumentException("Wrong number of arguments!");
        }

        String number = args[0].replace("_", "");
        String pattern = String.format("-?\\d{1,%d}",
                PartOfNumber.MAX_INDEX * PartOfNumber.DIGITS_IN_PART);
        if (!number.matches(pattern)) {
            throw new IllegalArgumentException("Wrong format of arguments!");
        }

        return number;
    }

    /**
     * Prints instructions to use program.
     */
    private void printInstruction() {
        System.out.println("Enter 1 arguments: integer number "
                + "that we want to convert into words.\n"
                + "Quantity of digits must be not more than "
                + PartOfNumber.MAX_INDEX * PartOfNumber.DIGITS_IN_PART + ".");
        System.out.println("Examples: 123, -4567, 1_000_000.");
    }

    /**
     * Returns list with parts from given number.
     *
     * @param number given number
     * @return list of numbers
     */
    private List<PartOfNumber> getPartsOfNumber(String number) {
        List<PartOfNumber> parts = new ArrayList<>();

        int digits = PartOfNumber.DIGITS_IN_PART;
        int end = number.length();
        int begin;
        int index = 0;
        while (end > 0) {
            begin = end - digits > 0 ? end - digits : 0;
            int value = Integer.parseInt(number.substring(begin, end));
            parts.add(new PartOfNumber(index, value));
            end = begin;
            index++;
        }

        Collections.reverse(parts);
        return parts;
    }

    /**
     * Returns number from arguments in words.
     *
     * @param args given arguments
     * @return number in words
     */
    public String getNumberInWords(String[] args) {
        String number = getNumber(args);

        if (number.matches("-?0+")) {
            return ZERO;
        }

        String result = "";
        if (number.startsWith("-")) {
            number = number.substring(1, number.length());
            result = MINUS;
        }

        List<PartOfNumber> parts = getPartsOfNumber(number);
        for (PartOfNumber part : parts) {
            result = result + " " + part.getRepresentation();
        }

        result = result.replaceAll("\\s+", " ").trim();
        result = result.substring(0, 1).toUpperCase()
                + result.substring(1) + ".";
        return result;
    }

    /**
     * Runs the program. In command line it is necessary
     * to enter 1 argument: integer number
     * that we want to convert into words.
     *
     * @param args arguments of command line
     */
    public static void main(String[] args) {
        App app = new App();
        String numberInWords = "";
        try {
            numberInWords = app.getNumberInWords(args);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            app.printInstruction();
            return;
        }
        System.out.println(numberInWords);
    }
}
