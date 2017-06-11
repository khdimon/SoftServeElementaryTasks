package com.softserve.edu.task4;

/**
 * Counts occurrences of the specified string in given string.
 */
public class StringHelper {
    /**
     * Counts number of target string occurrences
     * in the source string.
     *
     * @param source source string
     * @param target target string
     * @return number of occurrences
     */
    public int countOccurrences(String source, String target) {
        int number = 0;
        int index = 0;
        int targetLength = target.length();

        if (targetLength == 0) {
            return 0;
        }

        while (true) {
            index = source.indexOf(target, index);
            if (index >= 0) {
                number++;
                index += targetLength;
            } else {
                break;
            }
        }

        return number;
    }
}
