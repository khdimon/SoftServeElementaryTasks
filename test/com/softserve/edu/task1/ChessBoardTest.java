package com.softserve.edu.task1;

import org.junit.Test;

import static org.junit.Assert.*;

public class ChessBoardTest {

    @Test
    public void CreateChessBoard_CorrectParams_ChessBoardCreated() {
        //Arrange
        int height = 4;
        int width = 5;

        //Act
        ChessBoard chessBoard = new ChessBoard(height, width);
    }

    @Test(expected = IllegalArgumentException.class)
    public void CreateChessBoard_IncorrectParams_ExceptionThrown() {
        //Arrange
        int height = 4;
        int width = -5;

        //Act
        ChessBoard chessBoard = new ChessBoard(height, width);
    }

}