package com.softserve.edu.task2;

import org.apache.commons.lang3.tuple.*;

/**
 * Utility class that checks two envelope on possibility
 * to put one into another.
 */
public class EnvelopeInspector {

    private Envelope first;
    private Envelope second;

    /**
     * Creates EnvelopeInspector with given pair of envelope.
     *
     * @param pair given pair of envelope
     */
    public EnvelopeInspector(Pair<Envelope, Envelope> pair) {
        this.first = pair.getLeft();
        this.second = pair.getRight();
    }

    /**
     * Checks possibility of two envelops from this EnvelopeInspector
     * to put one into another and returns result in string.
     *
     * @return result of checking
     */
    public String getResultOfInspection() {
        String result;

        if (first.canPutInto(second)) {
            result = String.format("The %s envelope can be put into "
                    + "the %s envelope.", first, second);

        } else if (second.canPutInto(first)) {
            result = String.format("The %s envelope can be put into "
                    + "the %s envelope.", second, first);

        } else {
            result = "We can't put any of these envelope into another.";
        }

        return result;
    }
}
