package algo.week1;

import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.StdStats;

public class PercolationStats
{
    private double _samps[];
    private int    _size, _iterations;

    // perform T independent computational experiments on an N-by-N grid
    public PercolationStats(int N, int T)
    {
        if ((N < 1) || (T < 1)) {
            throw new IllegalArgumentException();
        }

        _size = N;
        _iterations = T;

        _samps = new double[_iterations];

        for (int i = 0; i < _iterations; i++) {
            _samps[i] = doExp();
        }
    }

    private double doExp()
    {
        Percolation perc = new Percolation(_size);
        int open = 0;

        int x, y;

        while (!perc.percolates()) {
            x = StdRandom.uniform(1, _size + 1);
            y = StdRandom.uniform(1, _size + 1);
            if (!perc.isOpen(y, x)) {
                perc.open(y, x);
                open++;
            }
        }

        return (open / (double) (_size * _size));
    }

    // sample mean of percolation threshold
    public double mean()
    {
        return StdStats.mean(_samps);
//        double x = 0;
//
//        for (int i = 0; i < _iterations; i++) {
//            x += _samps[i];
//        }
//
//        return x / _iterations;
    }

    // sample standard deviation of percolation threshold
    public double stddev()
    {
        if (_iterations == 1) {
            return Double.NaN;
        }

        return StdStats.stddev(_samps);

//        // find variance
//        double mean = this.mean();
//        double var = 0;
//
//        for (int i = 0; i < _iterations; i++) {
//            double diff = _samps[i] - mean;
//            var += (diff * diff);
//        }
//
//        return Math.sqrt(var / _iterations);
    }

    // returns lower bound of the 95% confidence interval
    public double confidenceLo()
    {
        return mean() - (1.96 * stddev() / Math.sqrt(_iterations));
    }

    // returns upper bound of the 95% confidence interval
    public double confidenceHi()
    {
        return mean() + (1.96 * stddev() / Math.sqrt(_iterations));
    }

    public static void main(String[] args)
    {
        if (args.length != 2) {
            StdOut.println("Args != 2 (first parm = grid size, second = number of computation experiments");

            return;
        }

        PercolationStats pstats = new PercolationStats(Integer.valueOf(args[0]), Integer.valueOf(args[1]));

        StdOut.printf("mean                    = %f\n", pstats.mean());
        StdOut.printf("stddev                  = %f\n", pstats.stddev());
        StdOut.printf("95%% confidence interval = %f, %f\n", pstats.confidenceLo(), pstats.confidenceHi());
    }
}