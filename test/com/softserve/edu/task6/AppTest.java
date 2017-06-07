package com.softserve.edu.task6;

import org.junit.Test;

import static org.junit.Assert.*;

public class AppTest {
    @Test
    public void countLuckyTickets_MoskowKey_ResultReturned() throws Exception {
        //Arrange
        App app = new App();
        int expectedResult = 55252;

        //Act
        int actualResult = app.countLuckyTickets("Moskow");

        //Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void countLuckyTickets_PiterKey_ResultReturned() throws Exception {
        //Arrange
        App app = new App();
        int expectedResult = 55252;

        //Act
        int actualResult = app.countLuckyTickets("Piter");

        //Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void countLuckyTickets_IncorrectKey_ResultReturned()
            throws Exception {
        //Arrange
        App app = new App();
        int expectedResult = 0;

        //Act
        int actualResult = app.countLuckyTickets("IncorrectKey");

        //Assert
        assertEquals(expectedResult, actualResult);
    }
}