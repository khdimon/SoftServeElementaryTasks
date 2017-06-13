package com.softserve.edu.task8;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class FibonacciCalculatorTest {
    @Test
    public void getFibonacciInInterval_CorrectBoundaries_ResultReturned()
            throws Exception {
        //Arrange
        FibonacciCalculator calculator = new FibonacciCalculator();
        Pair<Double, Double> boundaries =
                new ImmutablePair<>(0.5, 10.0);
        Long[] resultArray = {1L, 1L, 2L, 3L, 5L, 8L};
        List<Long> expectedResult = Arrays.asList(resultArray);

        //Act
        List<Long> actualResult = calculator.getFibonacciInInterval(boundaries);

        //Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getFibonacciInInterval_NegativeBoundaries_ExceptionThrown()
            throws Exception {
        //Arrange
        FibonacciCalculator calculator = new FibonacciCalculator();
        Pair<Double, Double> boundaries =
                new ImmutablePair<>(-0.5, 10.0);

        //Act
        List<Long> actualResult = calculator.getFibonacciInInterval(boundaries);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getFibonacciInInterval_LeftBoundaryGreater_ExceptionThrown()
            throws Exception {
        //Arrange
        FibonacciCalculator calculator = new FibonacciCalculator();
        Pair<Double, Double> boundaries =
                new ImmutablePair<>(15.0, 10.0);

        //Act
        List<Long> actualResult = calculator.getFibonacciInInterval(boundaries);
    }
}