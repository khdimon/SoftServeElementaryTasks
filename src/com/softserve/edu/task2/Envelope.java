package com.softserve.edu.task2;

/**
 * Created by Dmitrij on 23.05.17.
 */
public class Envelope {
    private double width;
    private double length;

    public Envelope(double side1, double side2) {
        if (side1 > side2) {
            this.length = side1;
            this.width = side2;
        } else {
            this.length = side2;
            this.width = side1;
        }
    }

    public boolean canPutInto(Envelope other) {
        return this.length < other.length && this.width < other.width;
    }
}
