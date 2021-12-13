
public class Main {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    public static String lineSegmentToString(LineSegment l) {
        return "Line Segment between " + l.ptA + " and " + l.ptB + " with slope " + slope(l) + " and length "
                + length(l);
    }

    public static String pointToString(Point p) {
        return "(" + p.x + ", " + p.y + ")";
    }

    public static void test1() {
        System.out.println(new Point(1.2, 3.4));
    }

    public static void test2() {
        System.out.println(lineSegmentToString(new LineSegment(new Point(0, 1), new Point(11, 12))));
    }

    public static double slope(LineSegment l) {
        return l.ptA.x != l.ptB.x ? (l.ptA.y - l.ptB.y) / (l.ptA.x - l.ptB.x) : 0;
    }

    public static double length(LineSegment l) {
        return Math.sqrt(Math.pow(l.ptA.y - l.ptB.y, 2) + Math.pow(l.ptA.x - l.ptB.x, 2));
    }

    public static double area(Rectangle r) {
        return length(r.lineSegAB) * length(r.lineSegBC);
    }

    public static String rectangleToString(Rectangle r) {
        return "Rectangle with vertices " + r.ptA + " " + r.ptB + " " + r.ptC + " " + r.ptD + " and area " + area(r);
    }

    public static void shift(Rectangle r, double h, double k) {
        r.ptA.x += h * 2;
        r.ptA.y += k * 2;
        r.ptB.x += h * 2;
        r.ptB.y += k * 2;
        r.ptC.x += h * 2;
        r.ptC.y += k * 2;
        r.ptD.x += h * 2;
        r.ptD.y += k * 2;
    }

    public static void test3() {
        Rectangle r = new Rectangle(new Point(0, 0), new Point(0, 2), new Point(6, 2), new Point(6, 0));
        shift(r, 1, 1.5);
        System.out.println(rectangleToString(r));
    }
}

class Point {
    public double x, y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return Main.pointToString(this);
    }
}

class LineSegment {
    public Point ptA, ptB;

    LineSegment(Point x, Point y) {
        this.ptA = x;
        this.ptB = y;
    }
}

class Rectangle {
    public Point ptA, ptB, ptC, ptD;
    public LineSegment lineSegAB, lineSegBC, lineSegCD, lineSegAD;

    Rectangle(Point a, Point b, Point c, Point d) {
        this.ptA = a;
        this.ptB = b;
        this.ptC = c;
        this.ptD = d;
        this.lineSegAB = new LineSegment(a, b);
        this.lineSegBC = new LineSegment(b, c);
        this.lineSegCD = new LineSegment(c, d);
        this.lineSegAD = new LineSegment(a, d);
    }
}