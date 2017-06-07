package com.softserve.edu.task4;

import java.io.*;

/**
 * Нужно написать программу, которая будет иметь два режима:
 * 1. Считать количество вхождений строки в текстовом файле.
 * 2. Делать замену строки на другую в указанном файле
 * Программа должна принимать аргументы на вход при запуске:
 * 1. (путь к файлу) (строка для подсчёта)
 * 2. (путь к файлу) (строка для поиска) (строка для замены)
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
            if (index >= 0) {
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
    public void writeFile(final Writer writer, final String content)
            throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        bufferedWriter.write(content);
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    /**
     * Starts the program.
     *
     * @param args parameters of the command line
     */
    public static void main(String[] args) {
        try {
            if (args.length != 2 && args.length != 3) {
                System.out.println("Enter:"
                        + " \"<Path to the file> <target string>\""
                        + " to count occurrences\n"
                        + "or \"<Path to the file> <target string>"
                        + " <string for replacement>\" to replacement");
                return;
            }

            App app = new App();
            String content = app.readFile(args[0]);

            if (args.length == 2) {
                System.out.printf("Count of occurrences of string \"%s\": ",
                        args[1]);
                System.out.println(app.countOccurrences(content, args[1]));
            } else {
                if (!content.contains(args[1])) {
                    System.out.printf("The string \"%s\""
                            + " is absent in the file.%n", args[1]);
                } else {
                    content = content.replace(args[1], args[2]);

                    Writer writer = new FileWriter(args[0]);
                    app.writeFile(writer, content);
                    System.out.printf("All occurrences of string \"%s\" "
                                    + "have been replaced on \"%s\".%n",
                            args[1], args[2]);
                }
            }
        } catch (IOException e) {
            System.out.println("Some problems with input or output"
                    + " have occurred.");
        }
    }
}
