import java.util.Comparator;

/**
 * Created by sky on 9/20/13.
 */
public class Brute
{
    private static void sort(Comparable[] a)
    {
        int N = a.length;
        for (int i = 0; i < N; i++)
        {
            for (int j = i; j > 0; j--)
            {
                if (less(a[j], a[j-1]))
                exch(a, j, j-1);
                else
                break;
            }
        }
    }

    private static boolean less(Comparable v, Comparable    w)
    {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j)
    {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void main(String[] args)
    {
        if (args.length != 1)
        {
            StdOut.println("Usage: java Brute <filename>");
            return;
        }

        In in = new In(args[0]);
        int num = in.readInt();
        Point[] points = new Point[num];

        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);

        int cnt = 0;
        while (!in.isEmpty())
        {
            int x = in.readInt();
            int y = in.readInt();
            Point p = new Point(x, y);
            p.draw();
            points[cnt++] = p;
        }

        // Sort points
        //sort(points);

        for (int i = 0; i < points.length; i++)
        {
            for (int j = i+1; j < points.length; j++)
            {
                //if (i == j) continue;
                double slopeij = points[i].slopeTo(points[j]);

                for (int k = j+1; k < points.length; k++)
                {
                    //if (j == k) continue;
                    double slopeik = points[i].slopeTo(points[k]);
                    if (slopeij != slopeik)
                        continue;  // move to next point

                    for (int l = k+1; l < points.length; l++)
                    {
                        //if (k == l) continue;
                        double slopeil = points[i].slopeTo(points[l]);
                        if ((slopeij == slopeik) && (slopeij == slopeil))
                        {
                            //if ((points[i].compareTo(points[j]) == -1) &&
                            //    (points[j].compareTo(points[k]) == -1) &&
                            //    (points[k].compareTo(points[l]) == -1))
                            //{
                                Point[] p = { points[i], points[j], points[k], points[l] };
                                sort(p);
                                StdOut.println(p[0] + " -> " + p[1] + " -> " + p[2] + " -> " + p[3]);
                                p[0].drawTo(p[3]);
                            //}
                        }
                    }
                }
            }
        }
    }
}
