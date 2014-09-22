public class Subset
{
    public static void main( String[] args )
    {

        String[] input = StdIn.readAllStrings();

        int count = Integer.valueOf( args[ 0 ] );

        if ( count > input.length ) {
            throw new IndexOutOfBoundsException( "Requested count would overflow quantity of input values." );
        }

        RandomizedQueue<String> queue = new RandomizedQueue<String>();

        for ( int i = 0, inputLength = input.length; i < inputLength; i++ ) {
            String s = input[ i ];
            queue.enqueue( s );
        }

        for ( int i = 0; i < count; i++ ) {
            StdOut.println( queue.dequeue() );
        }

    }
}