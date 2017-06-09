package com.softserve.edu.task1;

import org.junit.Test;
import org.apache.commons.lang3.tuple.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ArgumentsHelperTest_CorrectArgs {
    private final String[] testData;
    private final Optional<Pair<Integer, Integer>> expected;

    public ArgumentsHelperTest_CorrectArgs(
            String[] testData, Optional<Pair<Integer, Integer>> expected) {
        this.testData = testData;
        this.expected = expected;
    }

    @Test
    public void getValuesTest()
            throws Exception {
        //Arrange
        ArgumentsHelper helper = new ArgumentsHelper(testData);

        //Act
        Optional<Pair<Integer, Integer>> actual = helper.getValues();

        //Assert
        assertEquals(expected, actual);
    }

    @Parameterized.Parameters
    public static List<Object[]> getValuesData() {
        String[] testData1 = {"1", "2"};
        String[] testData2 = {"3", "4"};
        String[] testData3 = {"6", "8"};
        String[] testData4 = {"10", "5"};

        Optional<Pair<Integer, Integer>> expected1 =
                Optional.of(new ImmutablePair<>(1, 2));
        Optional<Pair<Integer, Integer>> expected2 =
                Optional.of(new ImmutablePair<>(3, 4));
        Optional<Pair<Integer, Integer>> expected3 =
                Optional.of(new ImmutablePair<>(6, 8));
        Optional<Pair<Integer, Integer>> expected4 =
                Optional.of(new ImmutablePair<>(10, 5));

        return Arrays.asList(new Object[][]{
                {testData1, expected1},
                {testData2, expected2},
                {testData3, expected3},
                {testData4, expected4}
        });
    }
}