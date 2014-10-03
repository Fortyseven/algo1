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
//        In in = new In( "tests/input20.txt" );
        In in = new In( "tests/input40.txt" );

        mCount = in.readInt();

        points = new Point[ mCount ];

        for ( int i = 0; i < mCount; i++ ) {
            points[ i ] = new Point( in.readInt(), in.readInt() );
        }

        // plot the points
        StdDraw.setPenRadius( 0.002 );
        StdDraw.setPenColor( StdDraw.BLUE );
        for ( int i = 0; i < mCount; i++ ) {
            points[ i ].draw();
        }

        StdDraw.setPenColor( StdDraw.RED );

        for ( int x = 0; x < points.length; x++ ) {
            for ( int y = x + 1; y < points.length; y++ ) {
                for ( int z = y + 1; z < points.length; z++ ) {
                    for ( int q = z + 1; q < points.length; q++ ) {

                        Double a = points[ x ].slopeTo( points[ y ] );
                        Double b = points[ x ].slopeTo( points[ z ] );
                        Double c = points[ x ].slopeTo( points[ q ] );

                        if ( ( a.equals( b ) ) && ( a.equals( c ) ) ) {
                            points[ x ].drawTo( points[ y ] );
                            points[ y ].drawTo( points[ z ] );
                            points[ z ].drawTo( points[ q ] );
                        }
                    }
                }

            }
        }
        StdDraw.show( 0 );
    }
}
