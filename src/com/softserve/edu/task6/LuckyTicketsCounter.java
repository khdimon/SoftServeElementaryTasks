package com.softserve.edu.task6;

/**
 * Counts number of lucky tickets for different algorithms.
 */
public class LuckyTicketsCounter {

    /**
     * Returns array of 6 digits for given number.
     *
     * @param number given number
     * @return array of digits
     */
    public int[] getDigitsFromNumber(int number) {
        int[] digits = {0, 0, 0, 0, 0, 0};
        //begins from the end of array
        int i = 5;

        while (number > 0) {
            digits[i] = number % 10;
            number = number / 10;
            i--;
        }

        return digits;
    }

    /**
     * Checks whether given ticket number is lucky
     * by Moskow algorithm.
     *
     * @param number given number of ticket
     * @return result of checking
     */
    public boolean isMoskowLuckyTicket(int number) {
        int[] digits = getDigitsFromNumber(number);

        return (digits[0] + digits[1] + digits[2])
                == (digits[3] + digits[4] + digits[5]);
    }

    /**
     * Checks whether given ticket number is lucky
     * by Piter algorithm.
     *
     * @param number given number of ticket
     * @return result of checking
     */
    public boolean isPiterLuckyTicket(int number) {
        int[] digits = getDigitsFromNumber(number);

        return (digits[0] + digits[2] + digits[4])
                == (digits[1] + digits[3] + digits[5]);
    }

    /**
     * Counts number of all lucky tickets
     * by Moskow algorithm.
     *
     * @return number of lucky tickets
     */
    public int countMoskowLuckyTickets() {
        int count = 0;
        for (int i = 0; i < 1000000; i++) {
            if (isMoskowLuckyTicket(i)) {
                count++;
            }
        }

        return count;
    }

    /**
     * Counts number of all lucky tickets
     * by Piter algorithm.
     *
     * @return number of lucky tickets
     */
    public int countPiterLuckyTickets() {
        int count = 0;
        for (int i = 0; i < 1000000; i++) {
            if (isPiterLuckyTicket(i)) {
                count++;
            }
        }

        return count;
    }
}
