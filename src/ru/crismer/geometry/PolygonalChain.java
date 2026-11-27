package ru.crismer.geometry;

import java.util.Arrays;

public class PolygonalChain {
    private Point[] points;

    // Создает ломаную, копируя переданный массив точек.
    public PolygonalChain(Point[] points) {
        if (points == null || points.length == 0) {
            throw new IllegalArgumentException("Массив точек пуст");
        }
        this.points = new Point[points.length];
        for (int i = 0; i < points.length; i++) {
            this.points[i] = points[i].clone();
        }
    }

    // Возвращает копию массива точек ломаной.
    public Point[] getPoints() {
        Point[] copy = new Point[points.length];
        for (int i = 0; i < points.length; i++) {
            copy[i] = points[i].clone();
        }
        return copy;
    }

    // Возвращает копию точки ломаной по индексу.
    public Point getPoint(int index) {
        if (index < 0 || index >= points.length) {
            throw new IndexOutOfBoundsException("Индекс точки вне диапазона");
        }
        return points[index].clone();
    }

    // Заменяет точку ломаной независимой копией.
    public void setPoint(int index, Point point) {
        if (index < 0 || index >= points.length) {
            throw new IndexOutOfBoundsException("Индекс точки вне диапазона");
        }
        if (point == null) {
            throw new IllegalArgumentException("Точка не может быть null");
        }
        points[index] = point.clone();
    }

    // Вычисляет суммарную длину всех звеньев ломаной.
    public double getLength() {
        double length = 0;
        for (int i = 0; i < points.length - 1; i++) {
            int dx = points[i + 1].getX() - points[i].getX();
            int dy = points[i + 1].getY() - points[i].getY();
            length += Math.sqrt(dx * dx + dy * dy);
        }
        return length;
    }

    // Сравнивает ломаные по количеству и координатам точек.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PolygonalChain that = (PolygonalChain) obj;
        if (points.length != that.points.length) return false;
        for (int i = 0; i < points.length; i++) {
            if (!points[i].equals(that.points[i])) return false;
        }
        return true;
    }

    // Вычисляет хеш-код ломаной.
    @Override
    public int hashCode() {
        return Arrays.hashCode(points);
    }

    // Формирует строковое представление ломаной.
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Ломаная [");
        for (int i = 0; i < points.length; i++) {
            sb.append(points[i]);
            if (i < points.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}