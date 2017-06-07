package com.softserve.edu.task6;

import java.io.*;

/**
 * Номер билета - шестизначное число.
 * Нужно написать консольное приложение,
 * которое может посчитать количество счастливых билетов.
 * Для выбора алгоритма подсчёта читается текстовый файл.
 * Путь к текстовому файлу задаётся в консоли после запуска программы.
 * Индикаторы алгоритмов:
 * 1 - слово 'Moskow'
 * 2 - слово 'Piter'
 * После задания всех необходимых параметров,
 * программа в консоль должна вывести количество счастливых билетов
 * для указанного способа подсчёта.
 *
 * @author Dima Kholod
 */
public class App {
    /**
     * Counts lucky tickets by the given algorithm.
     *
     * @param key given algorithm
     * @return counts of lucky tickets.
     */
    public int countLuckyTickets(String key) {
        int count = 0;
        for (int i = 0; i < 1000000; i++) {
            int[] digits = {0, 0, 0, 0, 0, 0};
            int number = i;
            int j = 5;
            while (number > 0) {
                digits[j] = number % 10;
                number = number / 10;
                j--;
            }

            if (key.equals("Moskow")
                    && (digits[0] + digits[1] + digits[2])
                    == (digits[3] + digits[4] + digits[5])) {
                count++;
            }

            if (key.equals("Piter")
                    && (digits[0] + digits[2] + digits[4])
                    == (digits[1] + digits[3] + digits[5])) {
                count++;
            }
        }

        return count;
    }

    /**
     * Starts the program.
     *
     * @param args parameters of the command line
     */
    public static void main(String[] args) {

        System.out.println("Enter path to the file with key.");
        BufferedReader pathReader =
                new BufferedReader(new InputStreamReader(System.in));
        String path = "";
        try {
            path = pathReader.readLine();
        } catch (IOException e) {
            System.out.println("An input/output error has occurred");
        }

        App app = new App();
        File file = new File(path);
        String key = "";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            key = reader.readLine();
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("An input/output error has occurred");
        }

        if (key.equals("Moskow") || key.equals("Piter")) {
            System.out.println("Quantity of lucky tickets by algorithm "
                    + key + " is " + app.countLuckyTickets(key));
        } else {
            System.out.println("Incorrect key.");
        }
    }
}
