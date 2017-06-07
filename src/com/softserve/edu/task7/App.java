package com.softserve.edu.task7;

/**
 * Программа выводит ряд натуральных чисел через запятую,
 * квадрат которых меньше заданного n.
 * Программа запускается через вызов главного класса с параметрами.
 *
 * @author Dima Kholod
 */
public class App {
    /**
     * Prints numbers that are less or equal than given number.
     *
     * @param number number that we print numbers less than
     */
    public void printNumbers(final int number) {
        if (number < 1) {
            System.out.println("Nothing to show.");
        }

        for (int i = 1; i <= number; i++) {
            if (i == number) {
                System.out.print(i);
            } else {
                System.out.print(i + ", ");
            }
        }
        System.out.println();
    }

    /**
     * For given number n calculates integer number
     * that is max number that we must print.
     *
     * @param n given number
     * @return calculated number
     */
    public int getMaxNumber(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }

        double sqrt = Math.sqrt(n);
        int maxNumber = (int) sqrt;
        if (maxNumber < sqrt) {
            return maxNumber;
        } else {
            return maxNumber - 1;
        }
    }

    /**
     * Starts the program.
     *
     * @param args parameters of the command line
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Enter the parameter - integer number.");
            return;
        }

        App app = new App();

        try {
            int n = Integer.parseInt(args[0]);

            if (n < 0) {
                System.out.println("Number can't be negative.");
                return;
            }

            int maxNumber = app.getMaxNumber(n);
            app.printNumbers(maxNumber);

        } catch (NumberFormatException e) {
            System.out.println("Wrong format of number.");
        }
    }
}
