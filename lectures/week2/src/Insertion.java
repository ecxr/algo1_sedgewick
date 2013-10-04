import java.lang.Comparable;
import java.util.Comparator;

/**
 * Created by sky on 9/12/13.
 */
public class Insertion
{
    public static void sort(Object[] a, Comparator comparator)
    {
        int N = a.length;
        for (int i = 0; i < N; i++)
        {
            for (int j = i; j > 0; j--)
            {
                if (less(comparator, [j], a[j-1]))
                    exch(a, j, j-1);
                else
                    break;
            }
        }
    }

    private static boolean less(Comparator c, Object v, Object w)
    {
        return c.compare(v, w) < 0;
    }

    private static void exch(Object[] a, int i, int j)
    {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void main(String args[])
    {
        //Integer[] a = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8 };
        //sort(a);
    }
}
