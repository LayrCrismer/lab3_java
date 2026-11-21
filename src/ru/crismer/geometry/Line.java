package src.ru.crismer.geometry;

public class Line implements Cloneable {
    private Point start;
    private Point end;

    public Line(Point start, Point end) {
        if (start == null || end == null) {
            throw new IllegalArgumentException("Точки не могут быть null");
        }
        this.start = start.clone();
        this.end = end.clone();
    }

    public Point getStart() {
        return start.clone();
    }

    public void setStart(Point start) {
        if (start == null) throw new IllegalArgumentException("Точка не может быть null");
        this.start = start.clone();
    }

    public Point getEnd() {
        return end.clone();
    }

    public void setEnd(Point end) {
        if (end == null) throw new IllegalArgumentException("Точка не может быть null");
        this.end = end.clone();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Line line = (Line) obj;
        return start.equals(line.start) && end.equals(line.end);
    }

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

    @Override
    public String toString() {
        return "Линия от " + start + " до " + end;
    }
}