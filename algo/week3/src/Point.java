public class Point implements Comparable<Point>
{

    // compare points by slope to this point

//    public int getX()
//    {
//        return x;
//    }
//
//
//    public int getY()
//    {
//        return y;
//    }

    private final int x;
    private final int y;

    // construct the point (x, y)
    public Point( int x, int y )
    {
        this.x = x;
        this.y = y;
//        public final Comparator<Point> SLOPE_ORDER = new Comparator<Point>()
//        {
//            @Override
//            public int compare( Point o1, Point o2 )
//            {
//                return 0;
//            }
//        };
//
    }


    // draw this point
    public void draw()
    {
        StdDraw.point( x, y );
    }

    // draw the line segment from this point to that point
    public void drawTo( Point that )
    {
        StdDraw.line( x, y, that.x, that.y );
    }

    // string representation
    public String toString()
    {
        return "(" + x + ", " + y + ")";
    }

    // is this point lexicographically smaller than that point?
    public int compareTo( Point that )
    {
        return 0;
    }

    // the slope between this point and that point
    public double slopeTo( Point that )
    {
        double dy = (double) ( that.y - this.y );
        double dx = (double) ( that.x - this.x );

        if ( dx == 0 ) {
            return Double.NEGATIVE_INFINITY;
        }
        if ( dy == 0 ) {
            return Double.POSITIVE_INFINITY;
        }

        return ( dy / dx );
    }
}

