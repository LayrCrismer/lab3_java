package ru.crismer.geometry;

public class TimedPoint3D extends Point3D {
    private String time;

    // Создает трехмерную точку с временем появления.
    public TimedPoint3D(int x, int y, int z, String time) {
        super(x, y, z);
        if (time == null || time.isBlank()) {
            throw new IllegalArgumentException("Время не может быть пустым");
        }
        this.time = time;
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

    // Формирует строковое представление точки и времени.
    @Override
    public String toString() {
        return "Точка " + super.toString() + " в " + time;
    }
}
