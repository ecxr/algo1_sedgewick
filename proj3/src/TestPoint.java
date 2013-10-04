/**
 * Created by sky on 9/20/13.
 */
public class TestPoint
{
    private static boolean testCompareTo()
    {
        Point p1 = new Point(-1, -1);
        Point p2 = new Point(1, 1);
        Point p3 = new Point(-1, 1);

        assert(p1.compareTo(p2) == -1);
        assert(p2.compareTo(p1) == 1);
        assert(p1.compareTo(p3) == -1);
        assert(p3.compareTo(p1) == 1);
        assert(p1.compareTo(p1) == 0);

        return true;
    }

    private static boolean testSlopeTo()
    {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(0, 0);
        Point p3 = new Point(-1, 1);
        Point p4 = new Point(1, 0);

        assert(p1.slopeTo(p2) == 1);
        assert(p2.slopeTo(p1) == 1);
        assert(p2.slopeTo(p3) == -1);
        assert(p3.slopeTo(p2) == -1);
        assert(p1.slopeTo(p4) == Double.POSITIVE_INFINITY);
        assert(p4.slopeTo(p1) == Double.POSITIVE_INFINITY);
        assert(p1.slopeTo(p3) == 0.0);
        assert(p3.slopeTo(p1) == 0.0);
        assert(p1.slopeTo(p1) == Double.NEGATIVE_INFINITY);

        return true;
    }
    public static void main(String[] args)
    {
        testCompareTo();
        testSlopeTo();
    }
}
