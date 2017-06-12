package com.softserve.edu.task5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents number. Creates representation of number in words.
 */
public class NumberInWords {
    /**
     * Representation for number 0.
     */
    public static final String ZERO = "Ноль.";

    /**
     * Representation for sign "-".
     */
    public static final String MINUS = "минус";

    /**
     * This number as string of digits.
     */
    private String number;

    /**
     * Representation of this number in words.
     */
    private String representation;

    /**
     * Creates new NumberInWords for given number.
     *
     * @param number given number that is string of digits
     */
    public NumberInWords(String number) {
        if (!number.matches(String.format("-?\\d{1,%d}",
                ArgumentsHelper.MAX_DIGITS_NUMBER))) {
            throw new IllegalArgumentException();
        }

        this.number = number;
    }

    /**
     * If representation of this number in words is absent
     * creates it from representations of parts of number.
     * Returns this representation.
     *
     * @return representation of this number in words
     */
    public String getRepresentation() {
        if (representation != null) {
            return representation;
        }

        if (number.matches("-?0+")) {
            representation = ZERO;
            return representation;
        }

        String result = "";
        if (number.startsWith("-")) {
            number = number.substring(1, number.length());
            result = MINUS;
        }

        List<PartOfNumber> parts = getPartsOfNumber();
        for (PartOfNumber part : parts) {
            result = result + " " + part.getRepresentation();
        }

        result = result.replaceAll("\\s+", " ").trim();
        result = result.substring(0, 1).toUpperCase()
                + result.substring(1) + ".";
        representation = result;

        return representation;
    }

    /**
     * Splits this number on parts and returns
     * list of PartOfNumber.
     *
     * @return list of PartOfNumber
     */
    private List<PartOfNumber> getPartsOfNumber() {
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
}
