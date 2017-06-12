package com.softserve.edu.task7;

import org.junit.Test;

import static org.junit.Assert.*;

public class MathHelperTest {
    MathHelper mathHelper = new MathHelper();

    @Test
    public void getMaxNumber_PositiveNumber_ResultReturned()
            throws Exception {
        //Arrange
        int number = 122;
        int expectedResult = 11;

        //Act
        int actualResult = mathHelper.getMaxNumber(number);

        //Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getMaxNumber_NegativeNumber_MinusOneReturned()
            throws Exception {
        //Arrange
        int number = -122;
        int expectedResult = -1;

        //Act
        int actualResult = mathHelper.getMaxNumber(number);

        //Assert
        assertEquals(expectedResult, actualResult);
    }
}