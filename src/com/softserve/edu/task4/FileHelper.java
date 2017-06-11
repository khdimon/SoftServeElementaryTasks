package com.softserve.edu.task4;

import java.io.*;

/**
 * Reads and writes files.
 */
public class FileHelper {
    /**
     * Reads file defined by path to string and returns it.
     *
     * @param path the path to the file
     * @return result string
     * @throws IOException If a file doesn't exist
     *                     or other I/O error occurs
     */
    public String readFileToString(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String result = "";
        char[] buffer = new char[1000];
        int symbols;
        while (reader.ready()) {
            symbols = reader.read(buffer);
            result = result + String.valueOf(buffer, 0, symbols);
        }
        reader.close();

        return result;
    }

    /**
     * Writes given string into the file.
     *
     * @param path    path to the file
     * @param content given string
     * @throws IOException If an I/O error occurs
     */
    public void writeStringToFile(String path, String content)
            throws IOException {
        BufferedWriter bufferedWriter =
                new BufferedWriter(new FileWriter(path));
        bufferedWriter.write(content);
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
