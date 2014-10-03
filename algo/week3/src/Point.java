public class Point implements Comparable<Point>
{

    // compare points by slope to this point

    private final int x;
    private final int y;

    /**************************************/
    // construct the point (x, y)
    public Point( int x, int y )
    {
        this.x = x;
        this.y = y;
    }

    /**************************************/
    // draw this point
    public void draw()
    {
        StdDraw.point( x, y );
    }

    /**************************************/
    // draw the line segment from this point to that point
    public void drawTo( Point that )
    {
        StdDraw.line( this.x, this.y, that.x, that.y );
    }

    /**************************************/
    // is this point lexicographically smaller than that point?
    public int compareTo( Point that )
    {
        if ( this.y > that.y ) {
            return 1;
        }

        if ( this.y < that.y ) {
            return -1;
        }

        if ( this.x > that.x ) {
            return 1;
        }

        if ( this.x < that.x ) {
            return -1;
        }

        return 0;
    }

    /**************************************/
    // the slope between this point and that point
    public double slopeTo( Point that )
    {
        if ( this == that ) {
            return Double.POSITIVE_INFINITY;
        }

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

    /**************************************/
    public String toString()
    {
        return "(" + x + ", " + y + ")";
    }
}

