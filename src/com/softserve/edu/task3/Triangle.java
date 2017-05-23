package com.softserve.edu.task3;

/**
 * Created by Dmitrij on 23.05.17.
 */
public class Triangle {
    private String name;
    private double a;
    private double b;
    private double c;

    public Triangle(String name, double a, double b, double c) {
        this.name = name;
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("Incorrect length of sides:" +
                    " any two sides must be larger than the third side");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getArea() {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public String toString() {
        return String.format("[Triangle %s]: %.2f sq. cm", name, getArea());
    }

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
