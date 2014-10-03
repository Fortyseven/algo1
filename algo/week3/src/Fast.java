import java.util.Arrays;

import edu.princeton.cs.introcs.In;

public class Fast
{
    static int     mCount;
    static Point[] points;

    static Double[] mSlopes;

    public static void main( String[] args )
    {
        StdDraw.setXscale( 0, 32768 );
        StdDraw.setYscale( 0, 32768 );
        StdDraw.show( 0 );
        StdDraw.setPenRadius( 0.001 );


        edu.princeton.cs.introcs.In in = new In( "tests/input40.txt" );

        mCount = in.readInt();

        points = new Point[ mCount ];

        mSlopes = new Double[ mCount * mCount * mCount * mCount ];

        StdOut.printf( Arrays.toString( mSlopes ) );

        Arrays.sort( mSlopes );

        StdOut.printf( Arrays.toString( mSlopes ) );

    }
}

