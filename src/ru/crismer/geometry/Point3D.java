package src.ru.crismer.geometry;

public class Point3D extends Point {
    private int z;

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Point3D point3D = (Point3D) obj;
        return z == point3D.z;
    }

    @Override
    public Point3D clone() {
        return (Point3D) super.clone();
    }

    @Override
    public String toString() {
        return "{" + getX() + ";" + getY() + ";" + z + "}";
    }
}