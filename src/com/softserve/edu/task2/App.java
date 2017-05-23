package com.softserve.edu.task2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Dmitrij on 23.05.17.
 */
public class App {
    public static Envelope createEnvelope(String number) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter length of side 1 of the " + number + " envelope");
        double side1 = Double.parseDouble(reader.readLine());
        System.out.println("Enter length of side 2 of the " + number + " envelope");
        double side2 = Double.parseDouble(reader.readLine());

        return new Envelope(side1, side2);
    }

    public static void main(String[] args) {
        while (true) {
            try {
                Envelope first = createEnvelope("first");
                Envelope second = createEnvelope("second");
                if (first.canPutInto(second))
                    System.out.println("The first envelope can be put into the second envelope.");
                else if (second.canPutInto(first))
                    System.out.println("The second envelope can be put into the first envelope.");
                else
                    System.out.println("We can't put any of these envelope into another.");

                System.out.println("Do you want to continue? (yes/no)");
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String answer = reader.readLine();
                if (!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("y"))
                    break;
            } catch (Exception e) {
                System.out.println("Incorrect input.");
            }
        }
    }
}
