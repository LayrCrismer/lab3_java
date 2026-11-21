package src.ru.crismer.main;

import src.ru.crismer.geometry.*;
import src.ru.crismer.math.Fraction;
import src.ru.crismer.structures.ImmutableIntList;
import src.ru.crismer.utils.MathUtils;

import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== ВАРИАНТ 1: ЛАБОРАТОРНАЯ РАБОТА №3 ===");

        boolean running = true;
        while (running) {
            System.out.println("\nВыберите задачу для проверки:");
            System.out.println("1. Задание 1.12 (Квадрат и Ломаная)");
            System.out.println("2. Задание 2.1 (Неизменяемый массив)");
            System.out.println("3. Задание 3.5 / 4.5 (Точки 3D и клонирование)");
            System.out.println("4. Задание 5.1 (Сложение чисел и дробей)");
            System.out.println("5. Задание 7.3 (Возведение в степень из args)");
            System.out.println("0. Выход");
            System.out.print("Ваш выбор: ");

            String input = scanner.nextLine();
            int choice = -1;
            try {
                choice = parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка ввода! Введите число от 0 до 5.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("\n--- Задание 1.12: Квадрат ---");
                    Square square = new Square(new Point(5, 3), 23);
                    System.out.println("1. Создан: " + square);
                    PolygonalChain chain = square.getPolygonalChain();
                    System.out.println("2. Получена ломаная: " + chain);
                    System.out.println("3. Общая длина ломаной: " + chain.getLength());
                    Point[] pts = chain.getPoints();
                    pts[pts.length - 1].setX(15);
                    pts[pts.length - 1].setY(25);
                    System.out.println("4-5. Сдвинута последняя точка. Новая длина: " + chain.getLength());
                    break;

                case 2:
                    System.out.println("\n--- Задание 2.1: Неизменяемый массив ---");
                    ImmutableIntList list = new ImmutableIntList(10, 20, 30);
                    System.out.println("Список: " + list);
                    System.out.println("Элемент по индексу 1: " + list.get(1));
                    ImmutableIntList list2 = list.set(1, 99);
                    System.out.println("После замены в копии: " + list2);
                    System.out.println("Оригинал остался прежним: " + list);
                    break;

                case 3:
                    System.out.println("\n--- Задание 3.5 & 8.5: Точки и Клонирование ---");
                    Point3D p1 = new Point3D(1, 2, 3);
                    Point3D p2 = p1.clone();
                    System.out.println("Оригинал 3D: " + p1 + ", Клон: " + p2);
                    System.out.println("Равны ли через equals? " + p1.equals(p2));
                    
                    Line line1 = new Line(new Point(0, 0), new Point(4, 4));
                    Line line2 = line1.clone();
                    System.out.println("Линия 1: " + line1);
                    System.out.println("Клон линии: " + line2);
                    System.out.println("Линии равны? " + line1.equals(line2));
                    break;

                case 4:
                    System.out.println("\n--- Задание 5.1: Сложение ---");
                    double s1 = MathUtils.sum(2, new Fraction(3, 5), 2.3);
                    double s2 = MathUtils.sum(3.6, new Fraction(49, 12), 3, new Fraction(3, 2));
                    double s3 = MathUtils.sum(new Fraction(1, 3), 1);
                    System.out.println("Сумма 1 (2 + 3/5 + 2.3) = " + s1);
                    System.out.println("Сумма 2 (3.6 + 49/12 + 3 + 3/2) = " + s2);
                    System.out.println("Сумма 3 (1/3 + 1) = " + s3);
                    break;

                case 5:
                    System.out.println("\n--- Задание 7.3: Возведение в степень ---");
                    if (args.length >= 2) {
                        try {
                            double base = parseInt(args[0]);
                            double exp = parseInt(args[1]);
                            System.out.println("Результат из аргументов командной строки (" + args[0] + "^" + args[1] + "): " + pow(base, exp));
                        } catch (NumberFormatException e) {
                            System.out.println("Аргументы командной строки не являются целыми числами.");
                        }
                    } else {
                        System.out.println("Аргументы командной строки не переданы. Демонстрация по умолчанию (2^3): " + pow(2, 3));
                    }
                    break;

                case 0:
                    running = false;
                    System.out.println("Выход из программы.");
                    break;

                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
        scanner.close();
    }
}