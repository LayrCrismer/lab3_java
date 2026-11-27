package ru.crismer.math;

import java.util.Objects;

public final class Fraction extends Number implements Cloneable, Comparable<Fraction> {
    private final int numerator;
    private final int denominator;

    // Создает сокращенную дробь с ненулевым знаменателем.
    public Fraction(int numerator, int denominator) {
        if (denominator == 0) throw new IllegalArgumentException("Знаменатель не может быть равен нулю");
        int a = Math.abs(numerator);
        int b = Math.abs(denominator);
        int divisor = gcd(a, b);
        int sign = (numerator < 0) == (denominator < 0) ? 1 : -1;
        int normalizedNumerator = sign * (a / divisor);
        int normalizedDenominator = b / divisor;
        this.numerator = normalizedNumerator;
        this.denominator = normalizedDenominator;
    }

    // Находит наибольший общий делитель чисел.
    private static int gcd(int a, int b) {
        while (b != 0) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }
        return a == 0 ? 1 : a;
    }

    // Возвращает числитель дроби.
    public int getNumerator() {
        return numerator;
    }

    // Возвращает знаменатель дроби.
    public int getDenominator() {
        return denominator;
    }

    // Возвращает дробную часть в виде целого типа.
    @Override
    public int intValue() {
        return (int) doubleValue();
    }

    // Возвращает дробную часть в виде типа long.
    @Override
    public long longValue() {
        return (long) doubleValue();
    }

    // Возвращает дробную часть в виде типа float.
    @Override
    public float floatValue() {
        return (float) doubleValue();
    }

    // Возвращает вещественное значение дроби.
    @Override
    public double doubleValue() {
        return (double) numerator / denominator;
    }

    // Сравнивает дроби с учетом числителя и знаменателя.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Fraction fraction = (Fraction) obj;
        return numerator == fraction.numerator && denominator == fraction.denominator;
    }

    // Вычисляет хеш-код дроби.
    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }

    // Создает копию объекта дроби.
    @Override
    public Fraction clone() {
        try {
            return (Fraction) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    // Сравнивает две дроби по их числовому значению.
    @Override
    public int compareTo(Fraction o) {
        long cross1 = (long) this.numerator * o.denominator;
        long cross2 = (long) o.numerator * this.denominator;
        return Long.compare(cross1, cross2);
    }

    // Формирует строковое представление дроби.
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}