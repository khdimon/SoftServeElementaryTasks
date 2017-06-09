package com.softserve.edu.task2;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class EnvelopeInspectorTest {
    private Pair<Envelope, Envelope> testPair;
    private String expectedResult;

    public EnvelopeInspectorTest(Pair<Envelope, Envelope> testPair,
                                 String expectedResult) {
        this.testPair = testPair;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Envelope first;
        Envelope second;
        Pair<Envelope, Envelope> testPair;
        String expectedResult;
        List<Object[]> dataList = new ArrayList<>();

        first = new Envelope("first", 3.5, 4.5);
        second = new Envelope("second", 4.5, 5);
        testPair = new ImmutablePair<>(first, second);
        expectedResult = "The first (3.5 X 4.5) envelope can be put into "
                + "the second (4.5 X 5.0) envelope.";
        dataList.add(new Object[] {testPair, expectedResult});

        first = new Envelope("first", 3.5, 4.5);
        second = new Envelope("second", 4, 3);
        testPair = new ImmutablePair<>(first, second);
        expectedResult = "The second (3.0 X 4.0) envelope can be put into "
                + "the first (3.5 X 4.5) envelope.";
        dataList.add(new Object[] {testPair, expectedResult});

        first = new Envelope("first", 5, 5);
        second = new Envelope("second", 6, 4);
        testPair = new ImmutablePair<>(first, second);
        expectedResult = "We can't put any of these envelope into another.";
        dataList.add(new Object[] {testPair, expectedResult});

        return dataList;
    }

    @Test
    public void getResultOfInspectionTest() throws Exception {
        //Arrange
        EnvelopeInspector inspector = new EnvelopeInspector(testPair);

        //Act
        String actualResult = inspector.getResultOfInspection();

        //Assert
        assertEquals(expectedResult, actualResult);
    }

}