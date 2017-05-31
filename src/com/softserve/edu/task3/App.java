package com.softserve.edu.task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Разработать консольную программу, выполняющую вывод треугольников
 * в порядке убывания их площади.
 * После добавления каждого нового треугольника программа спрашивает,
 * хочет ли пользователь добавить ещё один.
 * Если пользователь ответит “y” или “yes” (без учёта регистра),
 * программа попросит ввести данные для ещё одного треугольника,
 * в противном случае – выводит результат в консоль.
 *
 * @author Dima Kholod
 */
public class App {

    /**
     * Requests data from user and creates new triangle.
     *
     * @return creating triangle
     * @throws IOException If an I/O error occurs
     */
    public Triangle createTriangle() throws IOException {
        System.out.println("Enter data (<name>, <length side 1>,"
                + " <length side 2>, <length side 3>");
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        String[] data = string.replaceAll("[ \\t]", "").split(",");
        double a = Double.parseDouble(data[1]);
        double b = Double.parseDouble(data[2]);
        double c = Double.parseDouble(data[3]);

        return new Triangle(data[0].toLowerCase(), a, b, c);
    }

    /**
     * Starts the program.
     *
     * @param args parameters of the command line
     */
    public static void main(String[] args) {
        List<Triangle> triangles = new ArrayList<>();
        App app = new App();
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                Triangle triangle = app.createTriangle();
                triangles.add(triangle);
                System.out.println(
                        "Do you want to add another triangle? (Y/N)");
                String answer = reader.readLine();
                if (!answer.equalsIgnoreCase("y")
                        && !answer.equalsIgnoreCase("yes")) {
                    break;
                }
            } catch (IOException e) {
                System.out.println("Can't read data.");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Not enough data.");
            } catch (NumberFormatException e) {
                System.out.println("Incorrect data.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        Collections.sort(triangles,
                (t1, t2) -> Double.compare(t2.getArea(), t1.getArea()));

        System.out.println("======== Triangles list: =========");
        int i = 1;
        for (Triangle triangle : triangles) {
            System.out.print(i + ". ");
            System.out.println(triangle);
            i++;
        }
    }
}
