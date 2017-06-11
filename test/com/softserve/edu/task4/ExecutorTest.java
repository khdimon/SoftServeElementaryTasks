package com.softserve.edu.task4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ExecutorTest {
    private Executor executor;

    @Before
    public void initExecutor() throws Exception {
        FileHelper mockFileHelper = mock(FileHelper.class);
        when(mockFileHelper.readFileToString(anyString()))
                .thenReturn("sdkjfsjkaaaa d skldklaaaadlddklj\nbbb\n"
                        + "d aaaa\ndkndkj\ndk k jl klj");
        StringHelper stringHelper = new StringHelper();
        ConsoleHelper consoleHelper = new ConsoleHelper();
        executor = new Executor(mockFileHelper, stringHelper,
                consoleHelper);
    }

    @Test
    public void countStringOccurrencesInFile_Stringresent_NumberReturned()
            throws Exception {
        //Arrange
        int expectedResult = 3;

        //Act
        int actualResult = executor.countStringOccurrencesInFile(
                "path to the file", "aaaa");

        //Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void replaceStringInFile_StringPresent_TrueReturned()
            throws Exception {
        //Act
        boolean actualResult =
                executor.replaceStringInFile("path to the file",
                "aaaa", "bbbb");

        //Assert
        assertTrue(actualResult);
    }

    @Test
    public void replaceStringInFile_StringAbsent_FalseReturned()
            throws Exception {
        //Act
        boolean actualResult =
                executor.replaceStringInFile("path to the file",
                        "abcd", "dcba");

        //Assert
        assertFalse(actualResult);
    }
}