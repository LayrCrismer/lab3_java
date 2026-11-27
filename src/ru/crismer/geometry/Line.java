package ru.crismer.geometry;

import java.util.Objects;

public class Line implements Cloneable {
    private Point start;
    private Point end;

    // Создает линию, копируя точки начала и конца.
    public Line(Point start, Point end) {
        if (start == null || end == null) {
            throw new IllegalArgumentException("Точки не могут быть null");
        }
        this.start = start.clone();
        this.end = end.clone();
    }

    // Возвращает копию точки начала линии.
    public Point getStart() {
        return start.clone();
    }

    // Меняет точку начала на независимую копию.
    public void setStart(Point start) {
        if (start == null) throw new IllegalArgumentException("Точка не может быть null");
        this.start = start.clone();
    }

    // Возвращает копию точки конца линии.
    public Point getEnd() {
        return end.clone();
    }

    // Меняет точку конца на независимую копию.
    public void setEnd(Point end) {
        if (end == null) throw new IllegalArgumentException("Точка не может быть null");
        this.end = end.clone();
    }

    // Сравнивает линии по координатам начала и конца.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Line line = (Line) obj;
        return start.equals(line.start) && end.equals(line.end);
    }

    // Вычисляет хеш-код линии.
    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }

    // Создает клонированную линию с копиями точек.
    @Override
    public Line clone() {
        try {
            Line cloned = (Line) super.clone();
            cloned.start = this.start.clone();
            cloned.end = this.end.clone();
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    // Формирует строковое представление линии.
    @Override
    public String toString() {
        return "Линия от " + start + " до " + end;
    }
}