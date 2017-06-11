package com.softserve.edu.task3;

import java.util.Collections;
import java.util.List;

/**
 * Develop the console program that prints triangles
 * in descending order of their areas.
 * After adding any new triangle, program asks
 * whether the user wants to add another one.
 * If the user enters "y" or "yes" (ignore case)
 * program'll enter data for another one triangle.
 * Otherwise program prints the result to console.
 *
 * @author Dima Kholod
 */
public class App {

    /**
     * Starts the program.
     *
     * @param args parameters of the command line
     */
    public static void main(String[] args) {
        ConsoleHelper helper = new ConsoleHelper();
        List<Triangle> triangles = helper.getTriangles();
        Collections.sort(triangles,
                (t1, t2) -> Double.compare(t2.getArea(), t1.getArea()));
        helper.printTriangles(triangles);
    }
}
