/**
 * Created by sky on 9/19/13.
 */
public class Quick
{
    private static int partition(Comparable[] a, int lo, int hi)
    {
        int i = lo, j = hi+1;
        while (true)
        {
            // find item on left to swap
            while (less(a[++i], a[lo]))
                if (i == hi) break;

            // find item on right to swap
            while (less(a[lo], a[--j]))
                if (j == lo) break;

            // check if pointers cross
            if (i >= j) break;
            // swap
            exch(a, i, j);
        }

        // swap with partitioning item
        exch(a, lo, j);
        // return item of index now known to be in place
        return j;
    }

    public static void sort(Comparable[] a)
    {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi)
    {
        /* USE INSERTION SORT FOR SMALL SUBARRAYS... ~10 items
        // OR, wait until end to do insertion sort and leave small subarrays unsorted
        if (hi <= lo + CUTOFF - 1)
        {
            Insertion.sort(a, lo, hi);
            return
        }
        */

        if (hi <= lo) return;

        // best of choice pivot item is the median
        // estimate true median by taking median of sample.
        /*
        int m = medianOf3(a, lo, lo + (hi - lo)/2, hi);
        swap(a, lo, m);
        */

        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a,j+1, hi);
    }

    private static void threewaysort(Comparable[] a, int lo, int hi)
    {
        if (hi <= lo) return;
        int lt = lo, gt = hi;
        Comparable v = a[lo];
        int i = lo;
        while (i <= gt)
        {
            int cmp = a[i].compareTo(v);
            if      (cmp < 0) exch(a, lt++, i++);
            else if (cmp > 0) exch(a, i, gt--);
            else              i++;
        }

        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

    public static Comparable select(Comparable[] a, int k)
    {
        StdRandom.shuffle(a);
        int lo = 0, hi = a.length -1;
        while (hi > lo)
        {
            int j = partition(a, lo, hi);
            if      (j < k) lo = j + 1;
            else if (j > k) hi = j - 1;
            else            return a[k];
        }
        return a[k];
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
}
