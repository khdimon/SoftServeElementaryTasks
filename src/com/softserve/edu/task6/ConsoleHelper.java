package com.softserve.edu.task6;

import java.io.*;

/**
 * Arranges dialog with user by console.
 * Prints a number of lucky tickets.
 */
public class ConsoleHelper {

    /**
     * Gets a path to the file with key from user.
     *
     * @return path to the file
     * @throws IOException If an I/O error occurs
     */
    private String getPathFromUser() throws IOException {
        System.out.println("Enter path to the file with key.");
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        return reader.readLine();
    }

    /**
     * Asks from user path to the file.
     * Reads key from the file.
     * Prints number of lucky tickets for algorithm
     * that corresponds given key.
     */
    public void printLuckyTicketsNumber() {

        String key = "";

        try {
            String path = getPathFromUser();
            FileHelper fileHelper = new FileHelper();
            key = fileHelper.readStringFromFile(path);

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return;

        } catch (IOException e) {
            System.out.println("An input/output error has occurred");
            return;
        }

        LuckyTicketsCounter counter = new LuckyTicketsCounter();

        switch (key) {
            case "Moskow":
                System.out.println("Moskow lucky tickets number is "
                        + counter.countMoskowLuckyTickets());
                break;

            case "Piter":
                System.out.println("Piter lucky tickets number is "
                        + counter.countPiterLuckyTickets());
                break;

            default:
                System.out.println("Incorrect key.");
        }
    }
}
