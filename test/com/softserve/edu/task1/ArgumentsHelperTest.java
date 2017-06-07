package com.softserve.edu.task1;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArgumentsHelperTest {
    private ArgumentsHelper helper = new ArgumentsHelper();

    @Test
    public void isArgumentsNumberCorrect_CorrectNumber_TrueReturned()
            throws Exception {
        //Arrange
        String[] args = {"1", "2"};

        //Act
        boolean actualResult = helper.isArgumentsNumberCorrect(args);

        //Assert
        assertTrue(actualResult);
    }

    @Test
    public void isArgumentsNumberCorrect_IncorrectNumber_FalseReturned()
            throws Exception {
        //Arrange
        String[] args = {"1", "2", "3"};

        //Act
        boolean actualResult = helper.isArgumentsNumberCorrect(args);

        //Assert
        assertFalse(actualResult);
    }

    @Test
    public void convertArgumentsToInt_CorrectArguments_ResultReturned()
            throws Exception {
        //Arrange
        String[] args = {"1", "2"};
        int[] expectedResult = {1, 2};

        //Act
        int[] actualResult = helper.convertArgumentsToInt(args);

        //Assert
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void convertArgumentsToInt_IncorrectArguments_NullReturned()
            throws Exception {
        //Arrange
        String[] args = {"a", "b"};

        //Act
        int[] actualResult = helper.convertArgumentsToInt(args);

        //Assert
        assertNull(actualResult);
    }
}