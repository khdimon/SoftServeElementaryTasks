package com.softserve.edu.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Есть два конверта со сторонами (a,b) и (c,d) определить,
 * можно ли один конверт вложить в другой.
 * Программа должна обрабатывать ввод чисел с плавающей точкой.
 * Программа спрашивает у пользователя размеры конвертов
 * по одному параметру за раз.
 * После каждого подсчёта программа спрашивает у пользователя
 * хочет ли он продолжить.
 * Если пользователь ответит “y” или “yes” (без учёта регистра),
 * программа продолжает работу сначала,
 * в противном случае – завершает выполнение.
 *
 * @author Dima Kholod
 */
public class App {
    /**
     * Requests data from user and create new envelope.
     *
     * @param number number of envelope
     * @return creating envelope
     * @throws IOException If an I/O error occurs
     */
    public Envelope createEnvelope(String number) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter length of side 1 of the "
                + number + " envelope");
        double side1 = Double.parseDouble(reader.readLine());

        System.out.println("Enter length of side 2 of the "
                + number + " envelope");
        double side2 = Double.parseDouble(reader.readLine());

        return new Envelope(side1, side2);
    }

    /**
     * Starts the program.
     *
     * @param args parameters of the command line
     */
    public static void main(String[] args) {
        App app = new App();
        while (true) {
            try {
                Envelope first = app.createEnvelope("first");
                Envelope second = app.createEnvelope("second");
                if (first.canPutInto(second))
                    System.out.println("The first envelope "
                            + "can be put into the second envelope.");
                else if (second.canPutInto(first))
                    System.out.println("The second envelope "
                            + "can be put into the first envelope.");
                else {
                    System.out.println("We can't put any of these envelope"
                            + " into another.");
                }

                System.out.println("Do you want to continue? (yes/no)");
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(System.in));
                String answer = reader.readLine();
                if (!answer.equalsIgnoreCase("yes")
                        && !answer.equalsIgnoreCase("y")) {
                    break;
                }
            } catch (IOException e) {
                System.out.println("Some problems with input or output "
                        + "have occurred.");
            } catch (NumberFormatException e) {
                System.out.println("Incorrect input.");
            }
        }
    }
}
