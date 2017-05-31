package com.softserve.edu.task5;

import org.junit.Test;

import static org.junit.Assert.*;

public class PartOfNumberTest {
    @Test
    public void constructorPartOfNumber_CorrectIndexAndValue_RepresentationReturns()
            throws Exception {
        //Arrange
        int index = 1;
        int value = 109;
        PartOfNumber partOfNumber = new PartOfNumber(index, value);
        String expectedRepresentation = "сто девять тысяч";

        //Act
        String actualRepresentation = partOfNumber.getRepresentation();

        //Assert
        assertEquals(expectedRepresentation, actualRepresentation);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorPartOfNumber_IncorrectIndexOrValue_ExceptionThrown()
            throws Exception {
        //Arrange
        int index = 10;
        int value = 1000;
        PartOfNumber partOfNumber = new PartOfNumber(index, value);

        //Act
        String actualRepresentation = partOfNumber.getRepresentation();

        //Assert
    }
}