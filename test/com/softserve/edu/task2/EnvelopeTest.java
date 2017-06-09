package com.softserve.edu.task2;

import org.junit.Test;

import static org.junit.Assert.*;

public class EnvelopeTest {
    @Test
    public void canPutInto_ThisEnvelopeCouldBePutIntoAnother_TrueReturned()
            throws Exception {
        //Arrange
        Envelope thisEnvelope = new Envelope("a", 5.0, 5.0);
        Envelope anotherEnvelope = new Envelope("b", 5.5, 6.0);

        //Act
        boolean actualResult = thisEnvelope.canPutInto(anotherEnvelope);

        //Assert
        assertTrue(actualResult);
    }

    @Test
    public void canPutInto_ThisEnvelopeCouldNotBePutIntoAnother_TrueReturned()
            throws Exception {
        //Arrange
        Envelope thisEnvelope = new Envelope("a", 5.0, 5.0);
        Envelope anotherEnvelope = new Envelope("b", 4.0, 6.0);

        //Act
        boolean actualResult = thisEnvelope.canPutInto(anotherEnvelope);

        //Assert
        assertFalse(actualResult);
    }
}