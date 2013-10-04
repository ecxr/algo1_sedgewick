/**
 * Created by sky on 9/12/13.
 */
public class Selection
{
    public static void sort(Comparable[] a)
    {
        int N = a.length;
        for (int i = 0; i < N; i++)
        {
            int min = i;
            for (int j = i+1; j < N; j++)
                if (less(a[j], a[min]))
                    min = j;
            exch(a, i, min);
        }
    }

    private static boolean less(Comparable v, Comparable w)
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
        //String[] a = new String[1024];
        //a = StdIn.readAllStrings();
        Integer[] a = new Integer[] { 30, 54, 17, 92, 61, 27, 34, 11, 80, 65 };

        sort(a);
    }
}
