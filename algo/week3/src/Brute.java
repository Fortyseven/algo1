import java.util.Arrays;

import edu.princeton.cs.introcs.In;

public class Brute
{
    static int     mCount;
    static Point[] points;

    public static void main( String[] args )
    {
        StdDraw.setXscale( 0, 32768 );
        StdDraw.setYscale( 0, 32768 );
        StdDraw.show( 0 );
        StdDraw.setPenRadius( 0.001 );

        //In in = new In( "tests/rs1423.txt" );
        //In in = new In( "tests/input20.txt" );
        In in = new In( "tests/input6.txt" );

        mCount = in.readInt();

        points = new Point[ mCount ];

        for ( int i = 0; i < mCount; i++ ) {
            points[ i ] = new Point( in.readInt(), in.readInt() );
        }

        Arrays.sort( points );

        // plot the points
        StdDraw.setPenRadius( 0.003 );
        StdDraw.setPenColor( StdDraw.BLUE );
        for ( int i = 0; i < mCount; i++ ) {
            points[ i ].draw();
        }

        // connect the collinears
        StdDraw.setPenColor( StdDraw.RED );
        StdDraw.setPenRadius( 0.002 );

        for ( int x = 0; x < points.length; x++ ) {
            for ( int y = x + 1; y < points.length; y++ ) {
                for ( int z = y + 1; z < points.length; z++ ) {
                    for ( int q = z + 1; q < points.length; q++ ) {

                        Double a = points[ x ].slopeTo( points[ y ] );
                        Double b = points[ x ].slopeTo( points[ z ] );
                        Double c = points[ x ].slopeTo( points[ q ] );

                        if ( ( a.equals( b ) ) && ( a.equals( c ) ) ) {
                            points[ x ].drawTo( points[ q ] );

                            StdOut.println( points[ x ] + " -> " +
                                            points[ y ] + " -> " +
                                            points[ z ] + " -> " +
                                            points[ q ] );
                        }

                    }
                }

            }
        }
        StdDraw.show( 0 );
    }
}
