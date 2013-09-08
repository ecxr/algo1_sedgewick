
public class TestRunnerUF {

    public static void main(final String[] args) {
        //final int N = StdIn.readInt();
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(10);

        /*
        while (!StdIn.isEmpty()) {
            final int p = StdIn.readInt();
            final int q = StdIn.readInt();
            if (!uf.connected(p, q)) {
                uf.union(p, q);
                StdOut.println(p + " " + q);
            }
        }
        */

        // 3-9 2-7 2-5 5-0 2-9 4-7
        /*
        uf.union(3, 9);
        uf.union(2, 7);
        uf.union(2, 5);
        uf.union(5, 0);
        uf.union(2, 9);
        uf.union(4, 7);
        */

        // 4-0 8-9 2-5 7-3 7-6 0-8 3-5 3-1 0-3
        uf.union(4, 0);
        uf.union(8, 9);
        uf.union(2, 5);
        uf.union(7, 3);
        uf.union(7, 6);
        uf.union(0, 8);
        uf.union(3, 5);
        uf.union(3, 1);
        uf.union(0, 3);

        uf.find(3);


    }
}
