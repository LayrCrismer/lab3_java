package ru.crismer.geometry;

public abstract class Figure implements Measurable {
    private final String name;

    // Создает фигуру с проверенным названием.
    protected Figure(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Название фигуры не может быть пустым");
        }
        this.name = name;
    }

    // Возвращает название фигуры.
    public final String getName() {
        return name;
    }

    // Формирует базовое описание фигуры с площадью.
    protected String description() {
        return name + ", площадь=" + getArea();
    }

    // Определяет метод вычисления площади конкретной фигуры.
    @Override
    public abstract double getArea();

    // Формирует строковое представление фигуры.
    @Override
    public String toString() {
        return description();
    }
}