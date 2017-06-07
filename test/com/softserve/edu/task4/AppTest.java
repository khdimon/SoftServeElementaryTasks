package com.softserve.edu.task4;

import org.junit.Test;

import java.io.Writer;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class AppTest {

    @Test
    public void countOccurrences_SourceContainsTarget_ResultReturned()
            throws Exception {
        //Arrange
        App app = new App();
        String source = "AAAaaaAAA   BBBAAA";
        String target = "AAA";
        int expectedResult = 3;

        //Act
        int actualResult = app.countOccurrences(source, target);

        //Assert
        assertEquals(expectedResult, actualResult);
    }

    /*@Test
    public void writeFile_StringWrites_CloseCalled() throws Exception {
        //Arrange
        App app = new App();
        Writer mock = mock(Writer.class);
        String string = "AAA";

        //Act
        app.writeFile(mock, string);

        //Assert
        verify(mock).close();
    }*/
}