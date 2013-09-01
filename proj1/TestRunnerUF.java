
public class TestRunnerUF {

    public static void main(final String[] args) {
        final int N = StdIn.readInt();
        final UF uf = new UF(N);
        while (!StdIn.isEmpty()) {
            final int p = StdIn.readInt();
            final int q = StdIn.readInt();
            if (!uf.connected(p, q)) {
                uf.union(p, q);
                StdOut.println(p + " " + q);
            }
        }
    }
}
