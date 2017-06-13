package com.softserve.edu.task8;

import org.apache.commons.lang3.tuple.Pair;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Prints Fibonacci numbers.
 */
public class ConsoleHelper {

    /**
     * Prints Fibonacci numbers in interval given in arguments.
     *
     * @param args given arguments
     */
    public void printFibonacciNumbers(String[] args) {
        ArgumentsHelper argumentsHelper = new ArgumentsHelper(args);

        try {
            Pair<Double, Double> boundaries = argumentsHelper.getBoundaries();

            FibonacciCalculator calculator = new FibonacciCalculator();
            List<Long> fibonacciList = calculator.getFibonacciInInterval(
                    boundaries);

            if (fibonacciList.isEmpty()) {
                System.out.println("No Fibonacci numbers in this interval");
                return;
            }

            System.out.println("Fibonacci numbers in given interval:");
            System.out.println(fibonacciList.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(", ")));

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            argumentsHelper.printInstructions();
        }
    }
}
