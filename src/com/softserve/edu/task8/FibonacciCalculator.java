package com.softserve.edu.task8;

import java.util.ArrayList;
import java.util.List;

public class FibonacciCalculator {

    public List<Long> getFibonacciInInterval(double left, double right) {
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
