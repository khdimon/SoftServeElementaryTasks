package com.softserve.edu.task7;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArgumentsHelperTest {
    @Test
    public void getNumberFromArguments_CorrectArgs_NumberReturned()
            throws Exception {
        //Arrange
        String args[] = {"12"};
        ArgumentsHelper argumentsHelper = new ArgumentsHelper(args);
        int expectedResult = 12;

        //Act
        int actualResult = argumentsHelper.getNumberFromArguments();

        //Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getNumberFromArguments_IncorrectArgsNumber_ExceptionTrown()
            throws Exception {
        //Arrange
        String args[] = {"12", "34"};
        ArgumentsHelper argumentsHelper = new ArgumentsHelper(args);

        //Act
        argumentsHelper.getNumberFromArguments();
    }

    @Test(expected = IllegalArgumentException.class)
    public void getNumberFromArguments_IncorrectArgsFormat_ExceptionTrown()
            throws Exception {
        //Arrange
        String args[] = {"abc"};
        ArgumentsHelper argumentsHelper = new ArgumentsHelper(args);

        //Act
        argumentsHelper.getNumberFromArguments();
    }
}