package ru.crismer.geometry;

import java.util.Objects;

public class Square extends Figure {
    private Point topLeft;
    private int side;

    // Создает квадрат по точке верхнего левого угла и стороне.
    public Square(Point topLeft, int side) {
        super("Квадрат");
        if (side <= 0) throw new IllegalArgumentException("Сторона должна быть положительной");
        if (topLeft == null) throw new IllegalArgumentException("Точка не может быть null");
        this.topLeft = topLeft.clone();
        this.side = side;
    }

    // Создает квадрат по координатам угла и длине стороны.
    public Square(int x, int y, int side) {
        super("Квадрат");
        if (side <= 0) throw new IllegalArgumentException("Сторона должна быть положительной");
        this.topLeft = new Point(x, y);
        this.side = side;
    }

    // Возвращает копию точки верхнего левого угла.
    public Point getTopLeft() {
        return topLeft.clone();
    }

    // Меняет точку верхнего левого угла квадрата.
    public void setTopLeft(Point topLeft) {
        if (topLeft == null) throw new IllegalArgumentException("Точка не может быть null");
        this.topLeft = topLeft.clone();
    }

    // Возвращает длину стороны квадрата.
    public int getSide() {
        return side;
    }

    // Изменяет длину стороны квадрата.
    public void setSide(int side) {
        if (side <= 0) throw new IllegalArgumentException("Сторона должна быть положительной");
        this.side = side;
    }

    // Вычисляет точки углов и возвращает ломаную квадрата.
    public PolygonalChain getPolygonalChain() {
        Point p1 = topLeft.clone();
        Point p2 = new Point(topLeft.getX() + side, topLeft.getY());
        Point p3 = new Point(topLeft.getX() + side, topLeft.getY() - side);
        Point p4 = new Point(topLeft.getX(), topLeft.getY() - side);
        return new PolygonalChain(new Point[]{p1, p2, p3, p4});
    }

    // Вычисляет площадь квадрата.
    @Override
    public double getArea() {
        return (double) side * side;
    }

    // Возвращает описание квадрата с площадью.
    public String getDescription() {
        return description();
    }

    // Вычисляет хеш-код квадрата.
    @Override
    public int hashCode() {
        return Objects.hash(topLeft, side);
    }

    // Сравнивает квадраты по углу и длине стороны.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Square square = (Square) obj;
        return side == square.side && topLeft.equals(square.topLeft);
    }

    // Формирует строковое представление квадрата.
    @Override
    public String toString() {
        return "Квадрат в точке " + topLeft + " со стороной " + side;
    }
}