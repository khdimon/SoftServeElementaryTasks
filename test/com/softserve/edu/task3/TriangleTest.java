package com.softserve.edu.task3;

import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleTest {
    @Test
    public void isSidesCorrect_CorrectSides_TrueReturned()
            throws Exception {
        //Arrange
        double a = 4.0;
        double b = 5.0;
        double c = 6.0;

        //Act
        boolean actualResult = Triangle.isSidesCorrect(a, b, c);

        //Assert
        assertTrue(actualResult);
    }

    @Test
    public void isSidesCorrect_IncorrectSides_FalseReturned()
            throws Exception {
        //Arrange
        double a = 4.0;
        double b = 5.0;
        double c = 10.0;

        //Act
        boolean actualResult = Triangle.isSidesCorrect(a, b, c);

        //Assert
        assertFalse(actualResult);
    }

    @Test
    public void getArea_CreatedTriangle_AreaReturned() throws Exception {
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