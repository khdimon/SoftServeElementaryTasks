package com.softserve.edu.task5;

import org.junit.Test;

import static org.junit.Assert.*;

public class AppTest {
    @Test
    public void getNumberInWords_CorrectParameters_NumberInWordsReturned()
            throws Exception {
        //Arrange
        App app = new App();
        String[] args = {"-123_456_789"};
        String expectedNumber = "Минус сто двадцать три миллиона "
                + "четыреста пятьдесят шесть тысяч "
                + "семьсот восемьдесят девять.";

        //Act
        String actualNumber = app.getNumberInWords(args);

        //Assert
        assertEquals(expectedNumber, actualNumber);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getNumberInWords_IncorrectParameters_NumberInWordsReturned()
            throws Exception {
        //Arrange
        App app = new App();
        String[] args = {"-a23_456_789"};

        //Act
        String actualNumber = app.getNumberInWords(args);

        //Assert
    }

}