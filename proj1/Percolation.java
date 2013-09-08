/*----------------------------------------------------------------
 *  Author:        Sky King
 *  Written:       8/30/2013
 *  Last updated:  8/30/2013
 *
 *  Compilation:   javac Percolation.java
 *  Execution:     java Percolation
 *
 *  Estimates the value of the percolation threshold via Monte Carlo simulation.
 *
 *  % java Percolation
 *  >>> TBD
 *
 *----------------------------------------------------------------*/

public class Percolation {

    private static final int VIRTUAL_TOP = 0;
    private static final int VIRTUAL_BOTTOM = 1;
    private int N;
    private boolean[] openSites;
    private WeightedQuickUnionUF uf;    // has virt top and bottom
    private WeightedQuickUnionUF ufVT;  // only virt bottom - avoid backlash.

    /* create N-by-N grid, with all sites blocked */
    public Percolation(int N) {
        this.N = N;
        openSites = new boolean[(N+1)*(N+1)];
        uf = new WeightedQuickUnionUF((N+1)*(N+1));
        ufVT = new WeightedQuickUnionUF((N+1)*(N+1));
    }

    /* open site (row i, column j) if it is not already */
    public void open(int i, int j) {
        checkBounds(i, j);
        int idx = xyTo1D(i, j);
        openSites[idx] = true;

        // calculate 1D indexes
        int leftIdx = xyTo1D(i, j-1);
        int rightIdx = xyTo1D(i, j+1);
        int upIdx = xyTo1D(i-1, j);
        int downIdx = xyTo1D(i+1, j);

        // union open site above, unless top row
        if (i != 1 && isOpen(i-1, j)) {
            uf.union(idx, upIdx);
            ufVT.union(idx, upIdx);
        }

        // union open site below, unless bottom row
        if (i != N && isOpen(i+1, j)) {
            uf.union(idx, downIdx);
            ufVT.union(idx, downIdx);
        }

        // union site to left, unless first col
        if (j != 1 && isOpen(i, j-1)) {
            uf.union(idx, leftIdx);
            ufVT.union(idx, leftIdx);
        }

        // union site to right, unless last col
        if (j != N && isOpen(i, j+1)) {
            uf.union(idx,  rightIdx);
            ufVT.union(idx,  rightIdx);
        }

        // top row, connect to virtual top
        if (i == 1) {
            uf.union(VIRTUAL_TOP, idx);
            ufVT.union(VIRTUAL_TOP, idx);
        }

        // bottom row, connect to virtual bottom
        if (i == N) {
            uf.union(VIRTUAL_BOTTOM, idx);
            // ufVT has no virtual bottom top avoid backlash
        }
    }

    /* is site (row i, column j) open? */
    public boolean isOpen(int i, int j) {
        boolean open = false;
        checkBounds(i, j);
        int idx = xyTo1D(i, j);
        open = openSites[idx];
        return open;
    }

    /* is site (row i, column j) full? */
    public boolean isFull(int i, int j) {
        boolean full = false;
        checkBounds(i, j);
        int idx = xyTo1D(i, j);
        // we use ufVT here because bottom elts not actually connected
        // to the top will not be erroneously marked full, causing
        // the "backlash problem"
        full = openSites[idx] && ufVT.connected(idx, VIRTUAL_TOP);
        return full;
    }

    /* does the system percolate? */
    public boolean percolates() {
        boolean isConnected = false;
        isConnected = uf.connected(VIRTUAL_TOP, VIRTUAL_BOTTOM);
        return isConnected;
    }

    /* check whether give row, column is within bounds */
    private void checkBounds(int i, int j) {
        if (i <= 0 || i > N)
            throw new IndexOutOfBoundsException("row index i out of bounds");
        if (j <= 0 || j > N)
            throw new IndexOutOfBoundsException("column index j out of bounds");
    }

    private int xyTo1D(int x, int y) {
        return (x * N) + y;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
