package com.softserve.edu.task5;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class NumberInWordsTest {
    @Test
    public void getRepresentation_CorrectNumber_RepresentationReturned()
            throws Exception {
        //Arrange
        String number = "-123456789";
        NumberInWords numberInWords = new NumberInWords(number);
        String expectedResult = "Минус сто двадцать три миллиона "
                + "четыреста пятьдесят шесть тысяч "
                + "семьсот восемьдесят девять.";

        //Act
        String actualResult = numberInWords.getRepresentation();

        //Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getRepresentation_IncorrectNumber_ExceptionThrown()
            throws Exception {
        //Arrange
        String number = "-123456789.5";
        NumberInWords numberInWords = new NumberInWords(number);

        //Act
        numberInWords.getRepresentation();
    }
}