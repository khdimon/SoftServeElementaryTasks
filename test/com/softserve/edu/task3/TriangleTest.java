package com.softserve.edu.task3;

import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleTest {
    @Test
    public void constructor_CorrectSides_TriangleCreated()
            throws Exception {
        //Arrange
        double a = 4.0;
        double b = 5.0;
        double c = 6.0;

        //Act
        Triangle actualResult = new Triangle("Triangle", a, b, c);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_IncorrectSidesLength_ExceptionThrown()
            throws Exception {
        //Arrange
        double a = 4.0;
        double b = 5.0;
        double c = 20.0;

        //Act
        Triangle actualResult = new Triangle("Triangle", a, b, c);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_NegativeSideLength_ExceptionThrown()
            throws Exception {
        //Arrange
        double a = -4.0;
        double b = 5.0;
        double c = 20.0;

        //Act
        Triangle actualResult = new Triangle("Triangle", a, b, c);
    }

    @Test
    public void getArea_TriangleCreated_AreaReturned() throws Exception {
        //Arrange
        Triangle triangle =
                new Triangle("Test Triangle", 3.0, 4.0, 5.0);
        double expectedArea = 6.0;

        //Act
        double actualArea = triangle.getArea();

        //Assert
        assertEquals(expectedArea, actualArea, 0.000001);
    }
}