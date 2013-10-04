/**
 * Created by sky on 9/26/13.
 */
public class UnorderedMaxPQ<Key extends Comparable<Key>>
{
    private Key[] pq;
    private int N;

    public UnorderedMaxPQ(int capacity)
    {
        // no generic array creation
        pq = (Key[]) new Comparable[capacity];
    }

    public void insert(Key x)
    {
        pq[N++] = x;
    }

    public Key delMax()
    {
        int max = 0;
        for (int i = 1; i < N; i++)
        {
            if (less(max, i)) max = i;
        }
        exch(max, N-1);
        return pq[--N]; // null out item
    }

    public boolean isEmpty()
    {
        return N == 0;
    }

    public Key max()
    {
        return null;
    }

    public int size()
    {
        return N;
    }

    private boolean less(Comparable v, Comparable w)
    {
        return v.compareTo(w) < 0;
    }

    private void exch(int i, int j)
    {
        Comparable swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

}
