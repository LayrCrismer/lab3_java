package ru.crismer.geometry;

import java.util.Objects;

public class Point3D extends Point {
    private int z;

    // Создает трехмерную точку и передает x и y в базовый класс.
    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    // Возвращает координату z точки.
    public int getZ() {
        return z;
    }

    // Изменяет координату z точки.
    public void setZ(int z) {
        this.z = z;
    }

    // Сравнивает трехмерные точки по всем координатам.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        Point3D point3D = (Point3D) obj;
        return z == point3D.z;
    }

    // Вычисляет хеш-код трехмерной точки.
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), z);
    }

    // Создает независимую копию трехмерной точки.
    @Override
    public Point3D clone() {
        return (Point3D) super.clone();
    }

    // Формирует строковое представление трехмерной точки.
    @Override
    public String toString() {
        return "{" + getX() + ";" + getY() + ";" + z + "}";
    }
}