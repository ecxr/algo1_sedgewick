/**
 * Created by sky on 9/14/13.
 */
public class Subset
{
    public static void main(String[] args)
    {
        RandomizedQueue<String> q = new RandomizedQueue<String>();

        int k = Integer.parseInt(args[0]);
        String s = null;

        while (!StdIn.isEmpty())
        {
            s = StdIn.readString();
            q.enqueue(s);
        }

        for (int i = 0; i < k; i++)
        {
            s = q.dequeue();
            StdOut.println(s);
        }
    }
}
