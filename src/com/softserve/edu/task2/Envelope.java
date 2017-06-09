package com.softserve.edu.task2;

/**
 * Represents envelope.
 *
 * @author Dima Kholod
 */
public class Envelope {
    private String name;
    private double width;
    private double length;

    /**
     * Creates envelope with given side lengths.
     *
     * @param side1 length of first side
     * @param side2 length of second side
     */
    public Envelope(String name, double side1, double side2) {
        if (side1 <= 0 || side2 <= 0) {
            throw new IllegalArgumentException(
                    "Lengths of sides must be positive.");
        }

        this.name = name;

        if (side1 > side2) {
            this.length = side1;
            this.width = side2;
        } else {
            this.length = side2;
            this.width = side1;
        }
    }

    /**
     * Checks can this envelope be put into other envelope.
     *
     * @param other other envelope
     * @return result of checking
     */
    public boolean canPutInto(Envelope other) {
        return (this.length < other.length) && (this.width < other.width);
    }

    /**
     * Returns the name of this envelope.
     *
     * @return the name of this envelope
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the width of this envelope.
     *
     * @return the width of this envelope
     */
    public double getWidth() {
        return width;
    }

    /**
     * Returns the length of this envelope.
     *
     * @return the length of this envelope
     */
    public double getLength() {
        return length;
    }

    /**
     * Returns the string representation of this envelope.
     *
     * @return the string representation of this envelope
     */
    @Override
    public String toString() {
        return name + " (" + width + " X " + length + ")";
    }
}
