package com.softserve.edu.task4;

import java.io.*;

/**
 * Created by Dmitrij on 24.05.17.
 */
public class App {
    public String readFile(String path) throws IOException {
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

    public int countOccurrences(String source, String target) {
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

    public void writeFile(String path, String content) throws IOException {
        File file = new File(path);
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(content);
        writer.flush();
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.out.println("Enter: \"<Path to the file> <target string>\" to count occurrences"
                    + "\nor \"<Path to the file> <target string> <string for replacement>\" to replacement");
            return;
        }

        App app = new App();
        String content = app.readFile(args[0]);

        if (args.length == 2) {
            System.out.print("Number of occurrences: ");
            System.out.println(app.countOccurrences(content, args[1]));
        } else {
            if (!content.contains(args[1])) {
                System.out.println("This string is absent in the file.");
            } else {
                content = content.replace(args[1], args[2]);
                app.writeFile(args[0], content);
                System.out.println("All occurrences of this string has been replaced.");
            }
        }
    }
}
