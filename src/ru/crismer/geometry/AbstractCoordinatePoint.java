package ru.crismer.geometry;

public abstract class AbstractCoordinatePoint {
    private final String characteristics;

    // Создает точку с проверенным описанием характеристик.
    protected AbstractCoordinatePoint(String characteristics) {
        if (characteristics == null || characteristics.isBlank()) {
            throw new IllegalArgumentException("Характеристики точки не могут быть пустыми");
        }
        this.characteristics = characteristics;
    }

    // Возвращает общие характеристики точки.
    public String getCharacteristics() {
        return characteristics;
    }

    // Требует определить текстовое описание конкретного вида точки.
    public abstract String getDescription();

    // Формирует строковое представление точки через описание.
    @Override
    public String toString() {
        return getDescription();
    }
}
