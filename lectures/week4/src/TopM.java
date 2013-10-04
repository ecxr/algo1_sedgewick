/**
 *  Created by sky on 9/26/13.
 *
 *  Finds the largest M items in a stream of N items
 **/

public class TopM
{
    public static void main(String[] args)
    {
        // Transactions are Comparables (ordered by $$$)
        MinPQ<Transaction> pq = new MinPQ<Transaction>();

        // read M
        int M = 0;

        while (StdIn.hasNextLine())
        {
            String line = StdIn.readLine();
            Transaction item = new Transaction(line);
            pq.insert(item);
            if (pq.size() > M)
                pq.delMin();    // pq already contains largest M items, delete one.
        }
    }
}
