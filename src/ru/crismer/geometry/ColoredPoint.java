package ru.crismer.geometry;

public class ColoredPoint extends Point {
    private String color;

    // Создает двухмерную точку с указанным цветом.
    public ColoredPoint(int x, int y, String color) {
        super(x, y);
        if (color == null || color.isBlank()) {
            throw new IllegalArgumentException("Цвет не может быть пустым");
        }
        this.color = color;
    }

    // Возвращает цвет точки.
    public String getColor() {
        return color;
    }

    // Изменяет цвет точки после проверки значения.
    public void setColor(String color) {
        if (color == null || color.isBlank()) {
            throw new IllegalArgumentException("Цвет не может быть пустым");
        }
        this.color = color;
    }

    // Формирует строковое представление точки с цветом.
    @Override
    public String toString() {
        return "Точка " + super.toString() + ", " + color + " цвета";
    }
}
