package com.softserve.edu.task2;

import org.apache.commons.lang3.tuple.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {

    /**
     * Prints given message to console.
     *
     * @param message given message
     */
    private void printMessage(String message) {
        System.out.println(message);
    }

    /**
     * Reads message from console and returns it.
     *
     * @return message that has been read
     * @throws IOException when IOException occurs
     */
    private String readMessage() throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        return reader.readLine();
    }

    /**
     * Asks an user to enter the length of the given side
     * of the envelope, reads, parses and returns it.
     * If length not to be correct asks the user to repeat.
     *
     * @param side         name of the given side
     * @param envelopeName name of the given envelope
     * @return length that has been read
     * @throws IOException when IOException occurs
     */
    private double getLengthFromUser(String side, String envelopeName)
            throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        String resultString;
        double resultLength;
        while (true) {
            printMessage("Enter the " + side + " length of the "
                    + envelopeName + " envelope:");
            resultString = reader.readLine();

            try {
                resultLength = Double.parseDouble(resultString);
                if (resultLength <= 0) {
                    throw new IllegalArgumentException(
                            "Lengths of sides must be positive.");
                }
                break;

            } catch (NumberFormatException e) {
                printMessage("Incorrect format of the length.");

            } catch (IllegalArgumentException e) {
                printMessage(e.getMessage());
            }
        }

        return resultLength;
    }

    /**
     * Creates and returns new envelop with given names.
     * Length of sides is entered by user.
     *
     * @param name given name of the envelope
     * @return created envelope
     * @throws IOException when IOException occurs
     */
    private Envelope getEnvelopeFromUser(String name) throws IOException {
        double side1;
        double side2;

        side1 = getLengthFromUser("side 1", name);
        side2 = getLengthFromUser("side 2", name);

        return new Envelope(name, side1, side2);
    }

    /**
     * Creates and returns two envelops with given names.
     * Length of sides is entered by user.
     *
     * @param firstName  first envelope name
     * @param secondName second envelope name
     * @return pair of envelops
     * @throws IOException when IOException occurs
     */
    private Pair<Envelope, Envelope> getEnvelopePairFromUser(
            String firstName, String secondName) throws IOException {

        Envelope firstEnvelope = getEnvelopeFromUser(firstName);
        Envelope secondEnvelope = getEnvelopeFromUser(secondName);

        return new ImmutablePair<>(firstEnvelope, secondEnvelope);
    }

    /**
     * Gets pair of envelops from user and checks
     * possibility to put one into another.
     * Then asks user whether he wants to continue.
     * If he wants begins from start.
     */
    public void getEnvelopsAndCheck() {
        String firstName = "first";
        String secondName = "second";
        String result = "";

        while (true) {
            try {
                Pair<Envelope, Envelope> pair =
                        getEnvelopePairFromUser(firstName, secondName);

                EnvelopeInspector inspector = new EnvelopeInspector(pair);
                result = inspector.getResultOfInspection();
                printMessage(result);

                printMessage("Do you want to continue?"
                        + " (Print \"yes\" if you want.)");
                String answer = readMessage();

                if (!answer.equalsIgnoreCase("yes")
                        && !answer.equalsIgnoreCase("y")) {
                    break;
                }

            } catch (IOException e) {
                printMessage("Some problems with input or output "
                        + "have occurred.");
            }
        }
    }
}
