package com.softserve.edu.task8;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class AppTest {
    @Test
    public void getBoundaries_CorrectArguments_BoundariesReturned()
            throws Exception {
        //Arrange
        App app = new App();
        String[] args = {"2.5", "10"};
        double[] expectedBoundaries = {2.5, 10};
        double delta = 0.0001;

        //Act
        double[] actualBoundaries = app.getBoundaries(args);

        //Assert
        assertArrayEquals(expectedBoundaries, actualBoundaries, delta);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getBoundaries_WrongArgumentsNumber_ExceptionThrown()
            throws Exception {
        //Arrange
        App app = new App();
        String[] args = {"1"};

        //Act
        app.getBoundaries(args);

        //Assert
    }

    @Test(expected = NumberFormatException.class)
    public void getBoundaries_WrongFormatArguments_ExceptionThrown()
            throws Exception {
        //Arrange
        App app = new App();
        String[] args = {"aaa", "bbb"};

        //Act
        app.getBoundaries(args);

        //Assert
    }

    @Test(expected = IllegalArgumentException.class)
    public void getBoundaries_NegativeArguments_ExceptionThrown()
            throws Exception {
        //Arrange
        App app = new App();
        String[] args = {"-1", "-2.5"};

        //Act
        app.getBoundaries(args);

        //Assert
    }

    @Test(expected = IllegalArgumentException.class)
    public void getBoundaries_FirstArgumentLargerSecond_ExceptionThrown()
            throws Exception {
        //Arrange
        App app = new App();
        String[] args = {"10", "2.5"};

        //Act
        app.getBoundaries(args);

        //Assert
    }

    @Test
    public void getFirstIndex_NotNegativeLeftBoundary_IndexReturned()
            throws Exception {
        //Arrange
        App app = new App();
        double leftBoundary = 11.5;
        int expectedIndex = 7;

        //Act
        long actualIndex = app.getFirstIndex(leftBoundary);

        //Assert
        assertEquals(expectedIndex, actualIndex);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getFirstIndex_NegativeLeftBoundary_ExceptionThrown()
            throws Exception {
        //Arrange
        App app = new App();
        double leftBoundary = -10;

        //Act
        long actualIndex = app.getFirstIndex(leftBoundary);

        //Assert
    }

    @Test
    public void getFibonacciByIndex_PositiveIndex_FibonacciReturned()
            throws Exception {
        //Arrange
        App app = new App();
        int index = 10;
        long expectedFibonacci = 55;

        //Act
        long actualFibonacci = app.getFibonacciByIndex(index);

        //Assert
        assertEquals(expectedFibonacci, actualFibonacci);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getFibonacciByIndex_NegativeIndex_ExceptionThrown()
            throws Exception {
        //Arrange
        App app = new App();
        int index = -5;

        //Act
        app.getFibonacciByIndex(index);

        //Assert
    }

    @Test
    public void getFibonacciInInterval_CorrectInterval_ResultListReturned()
            throws Exception {
        //Arrange
        App app = new App();
        double[] boundaries = {0.5, 10.0};
        Long[] expectedResult = {1L, 1L, 2L, 3L, 5L, 8L};
        List<Long> expectedList = Arrays.asList(expectedResult);

        //Act
        List<Long> actualList = app.getFibonacciInInterval(boundaries);

        //Assert
        assertEquals(expectedList, actualList);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getFibonacciInInterval_IncorrectInterval_ExceptionThrown()
            throws Exception {
        //Arrange
        App app = new App();
        double[] boundaries = {-0.5, 10.0};

        //Act
        List<Long> actualList = app.getFibonacciInInterval(boundaries);

        //Assert
    }
}