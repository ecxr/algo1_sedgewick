import java.util.Iterator;
import java.lang.NullPointerException;
import java.util.NoSuchElementException;


/**
 * Created by sky on 9/13/13.
 */

public class RandomizedQueue<Item> implements Iterable<Item>
{
    private Item[] q;
    private int N;

    // construct an empty randomized queue
    public RandomizedQueue()
    {
        q = (Item[]) new Object[1];
        N = 0;
    }

    // is the queue empty?
    public boolean isEmpty()
    {
        return N == 0;
    }

    // return the number of items on the queue
    public int size()
    {
        return N;
    }

    // add the item
    public void enqueue(Item item)
    {
        if (item == null) throw new NullPointerException();

        if (N == q.length)
            resize(2 * q.length);

        q[N++] = item;
    }

    // delete and return a random item
    public Item dequeue()
    {
        if (N == 0) throw new NoSuchElementException();

        // Swap last element with random element and return it.
        int pos   = StdRandom.uniform(N);
        Item item = q[pos];
        q[pos]    = q[--N];
        q[N]      = null;

        // Resize array if more 1/4th full or less
        if (N > 0 && N == q.length/4)
            resize(q.length/2);

        return item;
    }

    // return (but do not delete) a random item
    public Item sample()
    {
        if (N == 0) throw new NoSuchElementException();

        int pos = StdRandom.uniform(N);
        return q[pos];
    }

    private void resize(int capacity)
    {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            copy[i] = q[i];
        }
        q = copy;
    }
    // return an independent iterator over items in random order
    public Iterator<Item> iterator()
    {
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item>
    {
        private int idx = N;
        private Item[] items;

        public RandomizedQueueIterator()
        {
            items = (Item[]) new Object[N];
            System.arraycopy(q, 0, items, 0, N);
            StdRandom.shuffle(items, 0, N-1);
        }

        public boolean hasNext()
        {
            return idx > 0;
        }

        public void remove()
        {
            throw new UnsupportedOperationException();
        }

        public Item next()
        {
            if (idx == 0)
                throw new java.util.NoSuchElementException();
            return items[--idx];
        }
    }

    public static void main(String[] args)
    {

    }
}