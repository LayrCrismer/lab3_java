package ru.crismer.main;

import ru.crismer.geometry.AbstractCoordinatePoint;
import ru.crismer.geometry.ColoredPoint;
import ru.crismer.geometry.ColoredTimedPoint;
import ru.crismer.geometry.Line;
import ru.crismer.geometry.Point;
import ru.crismer.geometry.Point1D;
import ru.crismer.geometry.Point3D;
import ru.crismer.geometry.PolygonalChain;
import ru.crismer.geometry.Square;
import ru.crismer.geometry.TimedPoint3D;
import ru.crismer.math.Fraction;
import ru.crismer.structures.ImmutableIntList;
import ru.crismer.utils.MathUtils;

import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    // Запускает меню и передает управление выбранному демонстрационному разделу.
    public static void main(String[] args) {
        System.out.println("Лабораторная работа №3");

        while (true) {
            printMenu();
            int choice = readInt("Выберите пункт: ", 0, 8);

            if (choice == 0) {
                System.out.println("Выход из программы.");
                return;
            }

            try {
                switch (choice) {
                    case 1 -> taskOne();
                    case 2 -> taskTwo();
                    case 3 -> taskThree();
                    case 4 -> taskFour();
                    case 5 -> taskFive();
                    case 6 -> taskSix();
                    case 7 -> taskSeven(args);
                    case 8 -> taskEight();
                }
            } catch (RuntimeException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }

    // Выводит на экран пункты меню всех восьми заданий.
    private static void printMenu() {
        System.out.println("\n1. Инкапсуляция: линия и квадрат");
        System.out.println("2. Неизменяемый список");
        System.out.println("3. Наследование: трехмерная точка");
        System.out.println("4. Абстрактная иерархия точек");
        System.out.println("5. Полиморфизм и сложение чисел");
        System.out.println("6. Сравнение линий");
        System.out.println("7. Пакеты и возведение в степень");
        System.out.println("8. Клонирование линии");
        System.out.println("0. Выход");
    }

    // Демонстрирует инкапсуляцию линии и вычисление ломаной квадрата.
    private static void taskOne() {
        int startX = readInt("Введите x начала линии: ");
        int startY = readInt("Введите y начала линии: ");
        int endX = readInt("Введите x конца линии: ");
        int endY = readInt("Введите y конца линии: ");

        Point start = new Point(startX, startY);
        Point end = new Point(endX, endY);
        Line line = new Line(start, end);
        start.setX(startX + 10);

        System.out.println("Линия после изменения внешних точек: " + line);
        line.setStart(new Point(startX + 1, startY + 1));
        System.out.println("Линия после изменения начала: " + line);

        Square square = new Square(5, 3, 23);
        System.out.println(square);
        PolygonalChain chain = square.getPolygonalChain();
        System.out.println("Длина ломаной: " + chain.getLength());
        chain.setPoint(chainPointCount(chain) - 1, new Point(15, 25));
        System.out.println("Ломаная после сдвига: " + chain);
        System.out.println("Новая длина ломаной: " + chain.getLength());
    }

    // Возвращает количество точек ломаной для обращения к последней точке.
    private static int chainPointCount(PolygonalChain chain) {
        return chain.getPoints().length;
    }

    // Демонстрирует создание и неизменяемое обновление списка значений.
    private static void taskTwo() {
        int count = readInt("Сколько чисел в списке: ", 1, 100);
        int[] values = new int[count];
        for (int i = 0; i < count; i++) {
            values[i] = readInt("Число " + (i + 1) + ": ");
        }

        ImmutableIntList original = new ImmutableIntList(values);
        ImmutableIntList copy = new ImmutableIntList(original);
        int index = readInt("Индекс для замены: ", 0, count - 1);
        int value = readInt("Новое значение: ");
        ImmutableIntList changed = original.set(index, value);

        System.out.println("Исходный список: " + original);
        System.out.println("Копия списка: " + copy);
        System.out.println("Новый список: " + changed);
        System.out.println("Исходный список остался неизменным: " + original);
        System.out.println("Размер списка: " + original.size());
        System.out.println("Список пустой: " + original.isEmpty());
        System.out.println("Массив значений получен.");
    }

    // Демонстрирует наследование и клонирование трехмерной точки.
    private static void taskThree() {
        int x = readInt("Введите x: ");
        int y = readInt("Введите y: ");
        int z = readInt("Введите z: ");

        Point3D point = new Point3D(x, y, z);
        Point3D copy = point.clone();
        copy.setZ(readInt("Введите новое z для копии: "));

        System.out.println("Исходная точка: " + point);
        System.out.println("Клон точки: " + copy);
        System.out.println("Точки равны: " + point.equals(copy));
    }

    // Показывает одномерные, цветные и временные варианты точек.
    private static void taskFour() {
        AbstractCoordinatePoint one = new Point1D(
                readInt("Введите координату x одномерной точки: "));
        int x = readInt("Введите x двухмерной точки: ");
        int y = readInt("Введите y двухмерной точки: ");
        String color = readText("Введите цвет точки: ");
        Object colored = new ColoredPoint(x, y, color);

        int z = readInt("Введите z трехмерной точки: ");
        String time = readText("Введите время появления точки: ");
        Object timed = new TimedPoint3D(x, y, z, time);

        String coloredTime = readText("Введите время появления желтой точки: ");
        Object combined = new ColoredTimedPoint(7, 7, coloredTime, "желтый");

        System.out.println(one);
        System.out.println(colored);
        System.out.println(timed);
        System.out.println(combined);
    }

    // Вычисляет суммы дробей и вещественных чисел.
    private static void taskFive() {
        int n1 = readInt("Числитель дроби 1: ");
        int d1 = readInt("Знаменатель дроби 1 (не равен 0): ");
        Fraction fraction1 = new Fraction(n1, d1);
        double number = readDouble("Введите вещественное число: ");
        double result = MathUtils.sum(number, fraction1);

        double sum1 = MathUtils.sum(2, new Fraction(3, 5), 2.3);
        double sum2 = MathUtils.sum(3.6, new Fraction(49, 12), 3, new Fraction(3, 2));
        double sum3 = MathUtils.sum(new Fraction(1, 3), 1);

        System.out.println("Сумма введенного числа и дроби " + fraction1 + ": " + result);
        System.out.println("2 + 3/5 + 2.3 = " + sum1);
        System.out.println("3.6 + 49/12 + 3 + 3/2 = " + sum2);
        System.out.println("1/3 + 1 = " + sum3);
    }

    // Сравнивает линии по одинаковым координатам начала и конца.
    private static void taskSix() {
        int x1 = readInt("Введите x начала первой линии: ");
        int y1 = readInt("Введите y начала первой линии: ");
        int x2 = readInt("Введите x конца первой линии: ");
        int y2 = readInt("Введите y конца первой линии: ");

        Line first = new Line(new Point(x1, y1), new Point(x2, y2));
        Line same = new Line(new Point(x1, y1), new Point(x2, y2));
        Line clone = first.clone();

        System.out.println("Первая линия: " + first);
        System.out.println("Линия с такими же точками: " + same);
        System.out.println("Клон первой линии: " + clone);
        System.out.println("Линии с одинаковыми точками равны: " + first.equals(same));
        System.out.println("Линия и ее клон равны: " + first.equals(clone));
    }

    // Получает основание и степень, затем демонстрирует возведение в степень.
    private static void taskSeven(String[] args) {
        String base;
        String exponent;

        if (args.length >= 2) {
            base = args[0];
            exponent = args[1];
        } else {
            base = readText("Введите основание X: ");
            exponent = readText("Введите показатель Y: ");
        }

        System.out.println(base + "^" + exponent + " = " + raiseToPower(base, exponent));
    }

    // Преобразует строки в числа и возводит основание в указанную степень.
    public static double raiseToPower(String base, String exponent) {
        int x = parseInt(base);
        int y = parseInt(exponent);
        return pow(x, y);
    }

    // Демонстрирует создание клона линии и независимое изменение копии.
    private static void taskEight() {
        int x1 = readInt("Введите x начала линии: ");
        int y1 = readInt("Введите y начала линии: ");
        int x2 = readInt("Введите x конца линии: ");
        int y2 = readInt("Введите y конца линии: ");

        Line original = new Line(new Point(x1, y1), new Point(x2, y2));
        Line clone = original.clone();
        clone.setStart(new Point(x1 + 5, y1 + 5));

        System.out.println("Оригинал: " + original);
        System.out.println("Клон после изменения начала: " + clone);
        System.out.println("Клон независим от оригинала: " + !original.equals(clone));
    }

    // Повторно запрашивает ввод непустой строки с клавиатуры.
    private static String readText(String prompt) {
        while (true) {
            System.out.print(prompt);
            String text = scanner.nextLine().trim();
            if (!text.isEmpty()) {
                return text;
            }
            System.out.println("Строка не должна быть пустой.");
        }
    }

    // Повторно запрашивает ввод и проверяет целое число.
    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String text = scanner.nextLine().trim();
            try {
                return parseInt(text);
            } catch (NumberFormatException e) {
                System.out.println("Введите целое число.");
            }
        }
    }

    // Проверяет, что введенное целое число находится в заданном диапазоне.
    private static int readInt(String prompt, int min, int max) {
        while (true) {
            int value = readInt(prompt);
            if (value >= min && value <= max) {
                return value;
            }
            System.out.println("Число должно быть от " + min + " до " + max + ".");
        }
    }

    // Повторно запрашивает ввод и проверяет конечное вещественное число.
    private static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String text = scanner.nextLine().trim().replace(',', '.');
            try {
                double value = Double.parseDouble(text);
                if (Double.isFinite(value)) {
                    return value;
                }
            } catch (NumberFormatException ignored) {
            }
            System.out.println("Введите корректное вещественное число.");
        }
    }
}
