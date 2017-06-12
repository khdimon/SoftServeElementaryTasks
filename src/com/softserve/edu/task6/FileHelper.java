package com.softserve.edu.task6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Reads string from the given file.
 */
public class FileHelper {

    /**
     * Reads string from the given file define by its path.
     *
     * @param path path to the given file
     * @return string has been read
     * @throws IOException If a file doesn't exist
     *                     or other I/O error occurs
     */
    public String readStringFromFile(String path) throws IOException {
        String result = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            if (reader.ready()) {
                result = reader.readLine();
            }
        }

        return result;
    }
}
