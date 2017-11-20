public class Point {
    private double x, y;

    public Point() {
        this.x = 0.0;
        this.y = 0.0;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point add(double x, double y) {
        return new Point(this.x + x, this.y + y);
    }

    /**
    Get x-value of point
    @return x-value
    */
    public double x() {
        return this.x;
    }

    /**
    Get x-value of point
    @return y-value
    */
    public double y() {
        return this.y;
    }

    /**
    Returns a squared geometric distance between two points
    */
    public double distSquared(Point p) {
        return (Math.pow(this.x - p.x(), 2) + Math.pow(this.y - p.y(), 2));
    }

    /**
    Returns a simplified geometric distance between two points
    */
    public double dist(Point p) {
        return Math.sqrt(distSquared(p));
    }
}
