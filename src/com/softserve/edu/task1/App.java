package com.softserve.edu.task1;

import org.apache.commons.lang3.tuple.Pair;

import java.util.Optional;

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
        ArgumentsHelper helper = new ArgumentsHelper(args);

        Optional<Pair<Integer, Integer>> values = helper.getValues();

        if (!values.isPresent()) {
            return;
        }

        ChessBoard board = new ChessBoard(values.get().getLeft(),
                values.get().getRight());
        board.print();
    }
}
