package ru.crismer.geometry;

import java.util.Objects;

public class Point implements Cloneable {
    private int x;
    private int y;

    // Создает точку с заданными координатами.
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Возвращает координату x точки.
    public int getX() {
        return x;
    }

    // Изменяет координату x точки.
    public void setX(int x) {
        this.x = x;
    }

    // Возвращает координату y точки.
    public int getY() {
        return y;
    }

    // Изменяет координату y точки.
    public void setY(int y) {
        this.y = y;
    }

    // Сравнивает точки по координатам x и y.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point point = (Point) obj;
        return x == point.x && y == point.y;
    }

    // Вычисляет хеш-код на основе координат точки.
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    // Создает независимую копию точки.
    @Override
    public Point clone() {
        try {
            return (Point) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    // Формирует строковое представление точки.
    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }
}