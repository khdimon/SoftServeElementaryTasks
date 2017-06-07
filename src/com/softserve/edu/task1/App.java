package com.softserve.edu.task1;

/**
 * To print chess board with given height and width.
 * <p>
 * *  *  *  *  *  *
 * _*  *  *  *  *
 * *  *  *  *  *  *
 * _*  *  *  *  *
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
        ArgumentsHelper helper = new ArgumentsHelper();

        if (!helper.isArgumentsNumberCorrect(args)) {
            return;
        }

        int[] intArgs = helper.convertArgumentsToInt(args);
        if (intArgs != null) {
            ChessBoard board = new ChessBoard(intArgs[0], intArgs[1]);
            board.print();
        }
    }
}
