package com.softserve.edu.task8;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArgumentsHelperTest {
    @Test
    public void getBoundaries_CorrectArguments_ResultReturned()
            throws Exception {
        //Arrange
        String args[] = {"1", "10.5"};
        ArgumentsHelper argumentsHelper = new ArgumentsHelper(args);
        Pair<Double, Double> expectedResult =
                new ImmutablePair<>(1.0, 10.5);

        //Act
        Pair<Double, Double> actualResult = argumentsHelper.getBoundaries();

        //Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test (expected = IllegalArgumentException.class)
    public void getBoundaries_WrongArgumentsNumber_ExceptionThrown()
            throws Exception {
        //Arrange
        String args[] = {"1"};
        ArgumentsHelper argumentsHelper = new ArgumentsHelper(args);

        //Act
        argumentsHelper.getBoundaries();
    }

    @Test (expected = IllegalArgumentException.class)
    public void getBoundaries_WrongArgumentsFormat_ExceptionThrown()
            throws Exception {
        //Arrange
        String args[] = {"1", "aaa"};
        ArgumentsHelper argumentsHelper = new ArgumentsHelper(args);

        //Act
        argumentsHelper.getBoundaries();
    }
}