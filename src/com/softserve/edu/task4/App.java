package com.softserve.edu.task4;

import java.io.*;

/**
 * Solves task4.
 *
 * @author Dima Kholod
 */
public class App {
    /**
     * Reads file to string and returns it.
     *
     * @param path the path to the file
     * @return result string
     * @throws IOException If an I/O error occurs
     */
    public String readFile(final String path) throws IOException {
        File file = new File(path);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String string = "";
        char[] buffer = new char[100];
        int symbols;
        while (reader.ready()) {
            symbols = reader.read(buffer);
            string = string + String.valueOf(buffer, 0, symbols);
        }
        reader.close();

        return string;
    }

    /**
     * Counts occurrences of the target string in given string.
     *
     * @param source string that we seek occurrences of target string in
     * @param target string that occurrences we seek
     * @return quantity of occurrences
     */
    public int countOccurrences(final String source, final String target) {
        int number = 0;
        int index = 0;
        while (true) {
            index = source.indexOf(target, index);
            if (index > 0) {
                number++;
                index++;
            } else {
                break;
            }
        }
        return number;
    }

    /**
     * Writes string into the file.
     *
     * @param path    path to the file
     * @param content given string
     * @throws IOException If an I/O error occurs
     */
    public void writeFile(final String path, final String content)
            throws IOException {
        File file = new File(path);
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(content);
        writer.flush();
        writer.close();
    }

    /**
     * Starts the program.
     *
     * @param args parameters of the command line
     */
    public static void main(String[] args) {
        try {
            if (args.length < 2) {
                System.out.println("Enter: \"<Path to the file> <target string>\" to count occurrences"
                        + "\nor \"<Path to the file> <target string> <string for replacement>\" to replacement");
                return;
            }

            App app = new App();
            String content = app.readFile(args[0]);

            if (args.length == 2) {
                System.out.printf("Count of occurrences of string \"%s\": ", args[1]);
                System.out.println(app.countOccurrences(content, args[1]));
            } else {
                if (!content.contains(args[1])) {
                    System.out.printf("The string \"%s\" is absent in the file.%n", args[1]);
                } else {
                    content = content.replace(args[1], args[2]);
                    app.writeFile(args[0], content);
                    System.out.printf("All occurrences of string \"%s\" have been replaced on \"%s\".%n", args[1], args[2]);
                }
            }
        } catch (IOException e) {
            System.out.println("Some problems with input or output have occurred.");
        }
    }
}
