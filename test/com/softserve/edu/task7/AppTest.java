package com.softserve.edu.task7;

import org.junit.Test;

import static org.junit.Assert.*;

public class AppTest {
    @Test
    public void getMaxNumber_PositiveArgument_ResultReturned()
            throws Exception {
        //Arrange
        App app = new App();
        int n = 25;
        int expectedResult = 4;

        //Act
        int actualResult = app.getMaxNumber(n);

        //Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getMaxNumber_NegativeArgument_ExceptionTrown()
            throws Exception {
        //Arrange
        App app = new App();
        int n = -1;

        //Act
        int actualResult = app.getMaxNumber(n);
    }
}