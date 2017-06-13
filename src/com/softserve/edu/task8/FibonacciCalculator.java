package com.softserve.edu.task8;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Allows to calculate Fibonacci numbers.
 */
public class FibonacciCalculator {

    /**
     * Calculates and returns list of Fibonacci numbers in given interval.
     * If boundaries are negative or left boundary greater than right throws
     * IllegalArgumentException.
     *
     * @param boundaries left and right boundaries of given interval
     * @return list of Fibonacci numbers
     */
    public List<Long> getFibonacciInInterval(Pair<Double, Double> boundaries) {
        Double left = boundaries.getLeft();
        Double right = boundaries.getRight();

        if (left < 0 || right < 0) {
            throw new IllegalArgumentException("Boundaries can't be negative.");
        }

        if (left > right) {
            throw new IllegalArgumentException("Left boundary"
                    + " can't be larger than right boundary.");
        }

        List<Long> result = new ArrayList<>();

        long current = 0;
        long next = 1;
        long temp;

        while (true) {
            if (current >= left) {
                result.add(current);
            }

            temp = next;
            next = current + next;
            current = temp;

            if (current > right) {
                break;
            }
        }

        return result;
    }
}
