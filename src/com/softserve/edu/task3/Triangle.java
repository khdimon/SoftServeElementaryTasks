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

    /**
     * Creates triangle with given name and length of sides.
     *
     * @param name name of triangle
     * @param a length of side a
     * @param b length of side b
     * @param c length of side c
     */
    public Triangle(String name, double a, double b, double c) {
        this.name = name;
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("Incorrect length of sides:"
                    + " any two sides must be larger than the third side");
        }
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
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
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

    /**
     * Compares this triangle with another object.
     *
     * @param o another object
     * @return the result of comparing
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        if (Double.compare(triangle.a, a) != 0) return false;
        if (Double.compare(triangle.b, b) != 0) return false;
        if (Double.compare(triangle.c, c) != 0) return false;
        return name != null ? name.equals(triangle.name) : triangle.name == null;
    }

    /**
     * Returns hashcode of this triangle.
     *
     * @return hashcode of this triangle
     */
    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        temp = Double.doubleToLongBits(a);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(b);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(c);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
