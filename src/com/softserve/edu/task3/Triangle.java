package com.softserve.edu.task3;

/**
 * Represents triangle.
 *
 * @author Dima Kholod
 */
public class Triangle {
    private String name;
    private double a;
    private double b;
    private double c;
    private double area;

    /**
     * Creates triangle with given name and length of sides.
     * Area is calculated by Geron's formula.
     *
     * @param name name of triangle
     * @param a    length of side a
     * @param b    length of side b
     * @param c    length of side c
     */
    public Triangle(String name, double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Incorrect length of sides:"
                    + " sides must be positive.\n");
        }
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("Incorrect length of sides:"
                    + " any two sides must be larger than the third side.\n");
        }

        this.name = name;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Returns area of this triangle.
     *
     * @return area of this triangle
     */
    public double getArea() {
        if (area == 0) {
            double p = (a + b + c) / 2;
            area = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }

        return area;
    }

    /**
     * Returns description of this triangle in a string.
     *
     * @return description of this triangle
     */
    @Override
    public String toString() {
        return String.format("[Triangle %s]: %.2f sq. cm", name, getArea());
    }
}
