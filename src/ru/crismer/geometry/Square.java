package src.ru.crismer.geometry;

public class Square extends Figure {
    private Point topLeft;
    private int side;

    public Square(Point topLeft, int side) {
        if (side <= 0) throw new IllegalArgumentException("Сторона должна быть положительной");
        if (topLeft == null) throw new IllegalArgumentException("Точка не может быть null");
        this.topLeft = topLeft.clone();
        this.side = side;
    }

    public Square(int x, int y, int side) {
        if (side <= 0) throw new IllegalArgumentException("Сторона должна быть положительной");
        this.topLeft = new Point(x, y);
        this.side = side;
    }

    public Point getTopLeft() {
        return topLeft.clone();
    }

    public void setTopLeft(Point topLeft) {
        if (topLeft == null) throw new IllegalArgumentException("Точка не может быть null");
        this.topLeft = topLeft.clone();
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        if (side <= 0) throw new IllegalArgumentException("Сторона должна быть положительной");
        this.side = side;
    }

    public PolygonalChain getPolygonalChain() {
        Point p1 = topLeft;
        Point p2 = new Point(topLeft.getX() + side, topLeft.getY());
        Point p3 = new Point(topLeft.getX() + side, topLeft.getY() - side);
        Point p4 = new Point(topLeft.getX(), topLeft.getY() - side);
        return new PolygonalChain(new Point[]{p1, p2, p3, p4});
    }

    @Override
    public double getArea() {
        return (double) side * side;
    }

    @Override
    public String toString() {
        return "Квадрат в точке " + topLeft + " со стороной " + side;
    }
}