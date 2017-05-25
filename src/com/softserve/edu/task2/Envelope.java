package com.softserve.edu.task2;

/**
 * Represents envelope.
 *
 * @author Dima Kholod
 */
public class Envelope {
    private double width;
    private double length;

    /**
     * Creates envelope with give width and length.
     *
     * @param side1 length of first side
     * @param side2 length of second side
     */
    public Envelope(double side1, double side2) {
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
        return this.length < other.length && this.width < other.width;
    }
}
