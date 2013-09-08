
//import Percolation;

public class PercolationStats {

    private double[] percThresholds;    // perc threshold for each of T trials
    private int T;
    private int N;
    /* perform T independent computational experiments on an N-by-N grid */
    public PercolationStats(int N, int T) {
        if (N <= 0 || T <= 0)
            throw new IllegalArgumentException("N, T must be greater than 0");

        this.N = N;
        this.T = T;
        this.percThresholds = new double[T];

        // Run T trials
        for (int t = 0; t < T; t++) {
            int openSites = 0;
            Percolation perc = new Percolation(N);
            // keep opening random sites until percolation
            while (!perc.percolates()) {
                int i = StdRandom.uniform(N) + 1;
                int j = StdRandom.uniform(N) + 1;
                //StdOut.println("Opening site " + i + " " + " " + j);
                if (!perc.isOpen(i, j)) {
                    perc.open(i, j);
                    openSites++;
                }
            }
            percThresholds[t] = openSites / (double) (N*N);
        }
    }

    /* sample mean of percolation threshold */
    public double mean() {
        return StdStats.mean(percThresholds);
    }

    /* sample standard deviatreturn 0.0;ion of percolation threshold */
    public double stddev() {
        return StdStats.stddev(percThresholds);
    }

    /* returns lower bound of the 95% confidence interval */
    public double confidenceLo() {
        return mean() - (1.96 * (stddev() / Math.sqrt(T)));
    }

    /* returns upper bound of the 95% confidence interval */
    public double confidenceHi()
    {
        return mean() + (1.96 * (stddev() / Math.sqrt(T)));
    }

    /* test client, described below */
    public static void main(String[] args)
    {
        int N;  // Grid size
        int T;  // Number of trials

        if (args.length != 2) {
            StdOut.println("Usage: java PercolationStats <N>, <T>");
            return;
        }

        N = Integer.parseInt(args[0]);
        T = Integer.parseInt(args[1]);

        // Perform T experiments for N-by-N grid
        PercolationStats percStats = new PercolationStats(N, T);

        // print statistics and confidence interval
        StdOut.println("mean                    = " + percStats.mean());
        StdOut.println("stddev                  = " + percStats.stddev());
        StdOut.println("95% confidence interval = " + percStats.confidenceLo()
                + ", " + percStats.confidenceHi());
    }
}