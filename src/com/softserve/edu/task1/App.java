package com.softserve.edu.task1;

/**
 * To print chess board with given height and width.
 * <p>
 * *  *  *  *  *  *
 *  *  *  *  *  *
 * *  *  *  *  *  *
 *  *  *  *  *  *
 * <p>
 * 2 parameters are given in command line.
 *
 * @author Dima Kholod
 */
public class App {

    /**
     * Starts the program.
     *
     * @param args parameters of the command line
     */
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("You must input two parameters: "
                    + "height and width.");
            return;
        }

        int h;
        int w;
        try {
            h = Integer.parseInt(args[0]);
            w = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("Incorrect parameters.");
            return;
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print((i + j) % 2 == 0 ? "*  " : "   ");
            }
            System.out.println();
        }
    }
}
