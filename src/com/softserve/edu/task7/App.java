package com.softserve.edu.task7;

/**
 * Solve task7.
 *
 * @author Dima Kholod
 */
public class App {
    /**
     * Prints numbers that are less than given number.
     *
     * @param number number that we print numbers less than
     */
    public void printNumbers(final int number) {
        if (number < 2) {
            System.out.println("Nothing to show.");
        }
        for (int i = 1; i < number; i++) {
            if (i == number - 1) {
                System.out.print(i);
            } else {
                System.out.print(i + ", ");
            }
        }
        System.out.println();
    }

    /**
     * Starts the program.
     *
     * @param args parameters of the command line
     */
    @SuppressWarnings("CheckStyle")
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Enter the parameter - number.");
            return;
        }
        App app = new App();
        try {
            double d = Double.parseDouble(args[0]);
            if (d < 0) {
                System.out.println("Number can't be negative.");
                return;
            }
            double sqrt = Math.sqrt(d);
            int n = (int) sqrt;
            if (n == sqrt) {
                app.printNumbers(n);
            } else {
                app.printNumbers(n + 1);
            }
        } catch (NumberFormatException e) {
            System.out.println("Wrong format of number.");
        }
    }
}
