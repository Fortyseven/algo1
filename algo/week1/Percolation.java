package algo.week1;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation
{
    private boolean _sites[];
    private int     _size;

    private WeightedQuickUnionUF _qu;

    // create N-by-N grid, with all sites blocked
    public Percolation(int N)
    {
        if (N < 1) {
            throw new IllegalArgumentException();
        }

        _size = N;

        _sites = new boolean[_size * _size];

        // set all sites to closed/blocked
        for (int j = 1; j <= _size; j++) {
            for (int i = 1; i <= _size; i++) {
                _sites[toLinear(i, j)] = true;
            }
        }

        _qu = new WeightedQuickUnionUF(_size * _size);

        // Build 'virtual node'; connect up the top and bottom rows
        for (int x = 1; x < _size; x++) {
            _qu.union(toLinear(x, 1), toLinear(x + 1, 1));
            _qu.union(toLinear(x, _size), toLinear(x + 1, _size));
        }
    }

    // open site (row i, column j) if it is not already
    public void open(int i, int j)
    {
        validate(j, i);

        _sites[toLinear(j, i)] = false;

        //up
        if (i > 1) {
            if (isOpen(i - 1, j)) {
                _qu.union(toLinear(j, i - 1), toLinear(j, i));
            }
        }
        //down
        if (i < _size) {
            if (isOpen(i + 1, j)) {
                _qu.union(toLinear(j, i + 1), toLinear(j, i));
            }
        }

        //left
        if (j > 1) {
            if (isOpen(i, j - 1)) {
                _qu.union(toLinear(j - 1, i), toLinear(j, i));
            }
        }
        //right
        if (j < _size) {
            if (isOpen(i, j + 1)) {
                _qu.union(toLinear(j + 1, i), toLinear(j, i));
            }
        }
    }

    // is site (row i, column j) open?
    public boolean isOpen(int i, int j)
    {
        validate(j, i);
        return !_sites[toLinear(j, i)];
    }

    // is site (row i, column j) full?
    public boolean isFull(int i, int j)
    {
        return isOpen(i, j) && _qu.connected(toLinear(1, 1), toLinear(j, i));
    }

    // does the system percolate?
    public boolean percolates()
    {
        if (_size == 1) {
            return isOpen(1, 1);
        }
        return _qu.connected(0, toLinear(_size, _size));
    }

    private int toLinear(int x, int y)
    {
        validate(x, y);
        return ((y - 1) * _size) + (x - 1);
    }

    private void validate(int x, int y)
    {
        if ((x < 1) || (x > _size) || (y < 1) || (y > _size)) {
            throw new IndexOutOfBoundsException();
        }
    }

    // test client, optional
    public static void main(String[] args)
    {
//        algo.week1.Percolation p = new algo.week1.Percolation(1);
//
//        System.out.println(p.percolates());
//        p.open(1,1);
//        System.out.println(p.percolates());
    }
}