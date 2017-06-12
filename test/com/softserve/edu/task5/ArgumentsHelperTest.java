package com.softserve.edu.task5;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArgumentsHelperTest {

    @Test
    public void isNumberOfArgumentsCorrect_CorrectNumber_TrueReturned()
            throws Exception {
        //Arrange
        String[] args = {"123"};
        ArgumentsHelper argumentsHelper = new ArgumentsHelper(args);

        //Act
        boolean actualResult = argumentsHelper.isNumberOfArgumentsCorrect();

        //Assert
        assertTrue(actualResult);
    }

    @Test
    public void isNumberOfArgumentsCorrect_IncorrectNumber_FalseReturned()
            throws Exception {
        //Arrange
        String[] args = {"123", "456"};
        ArgumentsHelper argumentsHelper = new ArgumentsHelper(args);

        //Act
        boolean actualResult = argumentsHelper.isNumberOfArgumentsCorrect();

        //Assert
        assertFalse(actualResult);
    }

    @Test
    public void isFormatOfArgumentsCorrect_CorrectFormat_TrueReturned()
            throws Exception {
        //Arrange
        String[] args = {"-123_456_789"};
        ArgumentsHelper argumentsHelper = new ArgumentsHelper(args);

        //Act
        boolean actualResult = argumentsHelper.isFormatOfArgumentsCorrect();

        //Assert
        assertTrue(actualResult);
    }

    @Test
    public void isFormatOfArgumentsCorrect_IncorrectFormat_FalseReturned()
            throws Exception {
        //Arrange
        String[] args = {"-123_456_789.5"};
        ArgumentsHelper argumentsHelper = new ArgumentsHelper(args);

        //Act
        boolean actualResult = argumentsHelper.isFormatOfArgumentsCorrect();

        //Assert
        assertFalse(actualResult);
    }

    @Test
    public void getNumber_CorrectArguments_NumberReturned()
            throws Exception {
        //Arrange
        String[] args = {"-123_456_789"};
        ArgumentsHelper argumentsHelper = new ArgumentsHelper(args);
        String expectedResult = "-123456789";

        //Act
        String actualResult = argumentsHelper.getNumber();

        //Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getNumber_IncorrectArguments_EmptyStringReturned()
            throws Exception {
        //Arrange
        String[] args = {"-123_456_789.5"};
        ArgumentsHelper argumentsHelper = new ArgumentsHelper(args);
        String expectedResult = "";

        //Act
        String actualResult = argumentsHelper.getNumber();

        //Assert
        assertEquals(expectedResult, actualResult);
    }
}