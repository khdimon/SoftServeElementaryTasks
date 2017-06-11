package com.softserve.edu.task4;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringHelperTest {

    private StringHelper stringHelper = new StringHelper();

    @Test
    public void countOccurrences_StringPresent_NumberReturned()
            throws Exception {
        //Arrange
        String source = "AAA aaa BBB AAA AAAA";
        String target = "AAA";
        int expectedResult = 3;

        //Act
        int actualResult = stringHelper.countOccurrences(source, target);

        //Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void countOccurrences_StringAbsent_ZeroReturned()
            throws Exception {
        //Arrange
        String source = "AAA aaa BBB AAA AAAA";
        String target = "CCC";
        int expectedResult = 0;

        //Act
        int actualResult = stringHelper.countOccurrences(source, target);

        //Assert
        assertEquals(expectedResult, actualResult);
    }
}