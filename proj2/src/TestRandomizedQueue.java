import java.util.Random;

/**
 * Created by sky on 9/15/13.
 */
public class TestRandomizedQueue
{
    public static void main(String[] args)
    {
        RandomizedQueue<Integer> q = new RandomizedQueue<Integer>();

        int N = Integer.parseInt(args[0]);

        StdOut.print("Inserting ");
        for (int i = 0; i < N; i++)
        {
            int item = StdRandom.uniform(N);
            StdOut.print(item + " ");
            q.enqueue(item);
        }

        assert(q.size() == N);

        StdOut.println();

        StdOut.print("Testing iterator: ");
        for (Integer i : q)
        {
            StdOut.print(i);
        }

        StdOut.print("Dequeing ");

        for (int i = 0; i < N; i++)
        {
            int item = q.dequeue();
            StdOut.print(item + " ");
        }

        assert(q.size() == 0);

    }
}
