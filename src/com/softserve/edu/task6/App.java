package com.softserve.edu.task6;

import java.io.*;

/**
 * Solves task6.
 *
 * @author Dima Kholod
 */
public class App {
    /**
     * Counts lucky tickets by Moskow algorithm.
     *
     * @return quantity of lucky tickets
     */
    public int countLuckyTicketsMoskow() {
        int result = 0;
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                if (getDigitsSum(i) == getDigitsSum(j)) {
                    result++;
                }
            }
        }

        return result;
    }

    /**
     * Returns sum of this number digits.
     *
     * @param number given number
     * @return sum of digits
     */
    private int getDigitsSum(int number) {
        int result = 0;
        while (number > 0) {
            result += number % 10;
            number = number / 10;
        }
        return result;
    }

    /**
     * Returns sum of this number odd or even digits.
     *
     * @param number    given number
     * @param evenOrOdd even (evenOrOdd = 0) or odd (evenOrOdd = 1) digits must be summed
     * @return sum of odd or even digits
     */
    private int getDigitsSum(int number, final int evenOrOdd) {
        if (evenOrOdd != 0 && evenOrOdd != 1) {
            return 0;
        }

        int result = 0;
        while (number > 0) {
            int digit = number % 10;
            if (digit % 2 == evenOrOdd) {
                result += digit;
            }
            number = number / 10;
        }
        return result;
    }

    /**
     * Counts lucky tickets by Piter algorithm.
     *
     * @return quantity of lucky tickets
     */
    public int countLuckyTicketsPiter() {
        int result = 0;
        for (int i = 0; i < 1000000; i++) {
            if (getDigitsSum(i, 0) == getDigitsSum(i, 1)) {
                result++;
            }
        }

        return result;
    }

    /**
     * Starts the program.
     *
     * @param args parameters of the command line
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Enter path to the file with key.");
            return;
        }

        App app = new App();
        String key = "";
        File file = new File(args[0]);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            key = reader.readLine();
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("An input/output error has occurred");
        }
        if (key.equals("Moskow")) {
            System.out.println("Quantity of lucky tickets by Moskow algorithm is "
                    + app.countLuckyTicketsMoskow());
        } else if (key.equals("Piter")) {
            System.out.println("Quantity of lucky tickets by Piter algorithm is "
                    + app.countLuckyTicketsPiter());
        } else {
            System.out.println("Incorrect key.");
        }
    }
}
