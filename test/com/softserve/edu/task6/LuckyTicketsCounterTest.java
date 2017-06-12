package com.softserve.edu.task6;

import org.junit.Test;

import static org.junit.Assert.*;

public class LuckyTicketsCounterTest {
    private LuckyTicketsCounter counter = new LuckyTicketsCounter();

    @Test
    public void getDigitsFromNumber_NumberGiven_ArrayReturned()
            throws Exception {
        //Arrange
        int number = 74660;
        int[] expectedResult = {0, 7, 4, 6, 6, 0};

        //Act
        int[] actualResult = counter.getDigitsFromNumber(number);

        //Assert
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void isMoskowLuckyTicket_IsLucky_TrueReturned()
            throws Exception {
        //Arrange
        int number = 174660;

        //Act
        boolean actualResult = counter.isMoskowLuckyTicket(number);

        //Assert
        assertTrue(actualResult);
    }

    @Test
    public void isMoskowLuckyTicket_IsNotLucky_FalseReturned()
            throws Exception {
        //Arrange
        int number = 174662;

        //Act
        boolean actualResult = counter.isMoskowLuckyTicket(number);

        //Assert
        assertFalse(actualResult);
    }

    @Test
    public void isPiterLuckyTicket_IsLucky_TrueReturned()
            throws Exception {
        //Arrange
        int number = 167640;

        //Act
        boolean actualResult = counter.isPiterLuckyTicket(number);

        //Assert
        assertTrue(actualResult);
    }

    @Test
    public void isPiterLuckyTicket_IsNotLucky_FalseReturned()
            throws Exception {
        //Arrange
        int number = 167642;

        //Act
        boolean actualResult = counter.isPiterLuckyTicket(number);

        //Assert
        assertFalse(actualResult);
    }

    @Test
    public void countMoskowLuckyTicketsTest() throws Exception {
        //Arrange
        int expectedResult = 55252;

        //Act
        int actualResult = counter.countMoskowLuckyTickets();

        //Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void countPiterLuckyTicketsTest() throws Exception {
        //Arrange
        int expectedResult = 55252;

        //Act
        int actualResult = counter.countPiterLuckyTickets();

        //Assert
        assertEquals(expectedResult, actualResult);
    }
}