package src.ru.crismer.geometry;


public class PolygonalChain {
    private Point[] points;

    public PolygonalChain(Point[] points) {
        if (points == null || points.length == 0) {
            throw new IllegalArgumentException("Массив точек пуст");
        }
        this.points = new Point[points.length];
        for (int i = 0; i < points.length; i++) {
            this.points[i] = points[i].clone();
        }
    }

    public Point[] getPoints() {
        Point[] copy = new Point[points.length];
        for (int i = 0; i < points.length; i++) {
            copy[i] = points[i].clone();
        }
        return copy;
    }

    public double getLength() {
        double length = 0;
        for (int i = 0; i < points.length - 1; i++) {
            int dx = points[i + 1].getX() - points[i].getX();
            int dy = points[i + 1].getY() - points[i].getY();
            length += Math.sqrt(dx * dx + dy * dy);
        }
        return length;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PolygonalChain that = (PolygonalChain) obj;
        if (points.length != that.points.length) return false;
        for (int i = 0; i < points.length; i++) {
            if (!points[i].equals(that.points[i])) return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Ломаная [");
        for (int i = 0; i < points.length; i++) {
            sb.append(points[i]);
            if (i < points.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}