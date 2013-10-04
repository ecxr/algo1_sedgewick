/**
 * Created by sky on 9/27/13.
 *
 * MaxPQ binary heap implementation
 *
 * Insert:  Log N
 * Del Max: Log N
 * Max:     N
 *
 * TODO: Use immutable keys.  Client should not be able to change keys
 * TODO: Use resizing array and use no-arg constructor
 *
 * Min oriented PQ repalces less with greater, implement greater
 *
 * Other operations needed: Remove arbitrary item, change priority of item
 * Can be implemented with sink and swim
 **/

public class MyMaxPQ<Key extends Comparable<Key>>
{
    private Key[] pq;
    private int N;

    public MyMaxPQ(int capacity)
    {
        pq = (Key[]) new Comparable[capacity+1];
    }

    public boolean isEmpty()
    {
        return N == 0;
    }

    // insert at the end, swim it up.
    // Cost: at most 1 + lg N compares
    public void insert(Key x)
    {
        pq[++N] = x;
        swim(N);
    }

    // Exchange root with last node, then sink it down.
    // Cost: At most 2 lg N compares
    public Key delMax()
    {
        // TODO: Throw exception if deleting from empty PQ
        Key max = pq[1];
        exch(1, N--);
        sink(1);
        pq[N+1] = null;     // prevent loitering
        return max;
    }

    // heap helper functions
    private void swim(int k)
    {
        // parent of node is at k/2
        while (k > 1 && less(k/2, k))
        {
            exch(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k)
    {
        while (2*k <= N)
        {
            int j = 2*k;
            // children of node at k are 2k and 2k + 1
            if (j < N && less(j, j+1))
                j++;    // swap k and j+1
            if (!less(k, j))
                break;  // k not smaller than j or j+1, stop
            exch(k, j);
            k = j;
        }
    }

    //array helper functions
    private boolean less(int i, int j)
    {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j)
    {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

}
