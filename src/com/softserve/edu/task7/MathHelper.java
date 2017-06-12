package com.softserve.edu.task7;

/**
 * Provides Mathematical calculations.
 */
public class MathHelper {

    /**
     * For a given number, calculates an Natural number
     * that is the maximum number whose square
     * is less than the specified number.
     * If there is no such numbers -1 returned.
     *
     * @param number given number
     * @return calculated number or -1
     */
    public int getMaxNumber(int number) {
        if (number <= 1) {
            return -1;
        }

        double sqrt = Math.sqrt(number);
        int maxNumber = (int) sqrt;
        if (maxNumber < sqrt) {
            return maxNumber;
        } else {
            return maxNumber - 1;
        }
    }
}
