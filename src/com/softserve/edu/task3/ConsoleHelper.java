package com.softserve.edu.task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConsoleHelper {

    /**
     * Prints given message to console.
     *
     * @param message given message
     */
    private void printMessage(String message) {
        System.out.print(message);
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

    private Triangle getTriangleFromUser() throws IOException {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        Triangle triangle;

        while (true) {
            printMessage("Enter data (<name>, <length side 1>,"
                    + " <length side 2>, <length side 3>\n");
            try {
                String string = reader.readLine();
                String[] data = string.replaceAll("[ \\t]", "")
                        .split(",");
                double a = Double.parseDouble(data[1]);
                double b = Double.parseDouble(data[2]);
                double c = Double.parseDouble(data[3]);
                triangle = new Triangle(data[0].toLowerCase(), a, b, c);
                break;

            } catch (ArrayIndexOutOfBoundsException e) {
                printMessage("Not enough data.\n");
            } catch (NumberFormatException e) {
                printMessage("Incorrect data.\n");
            } catch (IllegalArgumentException e) {
                printMessage(e.getMessage());
            }
        }

        return triangle;
    }

    public List<Triangle> getTriangles() {
        List<Triangle> triangles = new ArrayList<>();

        while (true) {
            try {
                Triangle triangle = getTriangleFromUser();
                triangles.add(triangle);
                printMessage(
                        "Do you want to add another triangle? (Y/N)\n");
                String answer = readMessage();
                if (!answer.equalsIgnoreCase("y")
                        && !answer.equalsIgnoreCase("yes")) {
                    break;
                }

            } catch (IOException e) {
                printMessage("Some problems with input or output "
                        + "have occurred.\n");
            }
        }

        return triangles;
    }

    public void printSortedTriangles(List<Triangle> triangles) {
        Collections.sort(triangles,
                (t1, t2) -> Double.compare(t2.getArea(), t1.getArea()));

        printMessage("======== Triangles list: =========\n");
        for (int i = 0; i < triangles.size(); i++) {
            printMessage((i + 1) + ". ");
            printMessage(triangles.get(i).toString() + "\n");
        }
    }

}
