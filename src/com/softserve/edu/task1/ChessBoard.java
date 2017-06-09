package com.softserve.edu.task1;

/**
 * Represents the chess board.
 */
public class ChessBoard {
    private int height;
    private int width;

    /**
     * Creates new instance of ChessBoard with given height and width.
     *
     * @param height given height, must be positive
     * @param width  given width, must be positive
     */
    public ChessBoard(int height, int width) {
        if (height <= 0 || width <= 0) {
            throw new IllegalArgumentException(
                    "Height and width must be positive");
        }

        this.height = height;
        this.width = width;
    }

    /**
     * Prints this chess board.
     */
    public void print() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                String item = (i + j) % 2 == 0 ? "*  " : "   ";
                System.out.print(item);
            }
            System.out.println();
        }
    }
}
