package ru.crismer.geometry;

public class Point1D extends AbstractCoordinatePoint {
    private int x;

    // Создает одномерную точку с координатой x.
    public Point1D(int x) {
        super("одномерная точка");
        this.x = x;
    }

    // Возвращает координату x точки.
    public int getX() {
        return x;
    }

    // Изменяет координату x точки.
    public void setX(int x) {
        this.x = x;
    }

    // Формирует описание одномерной точки.
    @Override
    public String getDescription() {
        return "Точка с координатой " + x;
    }

    // Возвращает строковое представление точки.
    @Override
    public String toString() {
        return getDescription();
    }
}
