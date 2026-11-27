package ru.crismer.geometry;

public class ColoredTimedPoint extends Point {
    private String color;
    private String time;

    // Создает двухмерную точку с временем и цветом.
    public ColoredTimedPoint(int x, int y, String time, String color) {
        super(x, y);
        setTime(time);
        setColor(color);
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

    // Возвращает время появления точки.
    public String getTime() {
        return time;
    }

    // Изменяет время появления точки после проверки.
    public void setTime(String time) {
        if (time == null || time.isBlank()) {
            throw new IllegalArgumentException("Время не может быть пустым");
        }
        this.time = time;
    }

    // Формирует строковое представление точки, времени и цвета.
    @Override
    public String toString() {
        return "Точка " + super.toString() + " в " + time + ", " + color + " цвета";
    }
}
