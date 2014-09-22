import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item>
{
    private static final int INITIAL_SIZE = 1;

    /******************/
    private class RandomQIterator implements Iterator<Item>
    {
        int[] rand_bag;
        int   counter;

        private RandomQIterator()
        {
            rand_bag = createShuffleBag();
            counter = 0;
        }

        public boolean hasNext()
        {
            return counter < rand_bag.length;
        }

        public void remove()
        {
            throw new UnsupportedOperationException();
        }

        public Item next()
        {
            if ( counter >= rand_bag.length ) {
                throw new NoSuchElementException();
            }

            return mStack[ rand_bag[ counter++ ] ];
        }

        private int[] createShuffleBag()
        {
            int[] rand_order = new int[ size() ];

            for ( int i = 0; i < size(); i++ ) {
                rand_order[ i ] = i;
            }

            StdRandom.shuffle( rand_order );

//            for ( int i = 0; i < size(); i++ ) {
//                StdRandom.
//                int pos_b = StdRandom.uniform( 0, size() );
//                // swap
//                int tmp = rand_order[ pos_b ];
//                rand_order[ pos_b ] = rand_order[ i ];
//                rand_order[ i ] = tmp;
//            }

            return rand_order;
        }

    }

    /*****************/

    private Item[] mStack;

    private int mStackPtr;

    /**********************************************************************/
    // construct an empty deque
    public RandomizedQueue()
    {
        mStack = (Item[]) new Object[ INITIAL_SIZE ];
    }

    /**********************************************************************/
    // is the deque empty?
    public boolean isEmpty()
    {
        return mStackPtr < 1;
    }

    /**********************************************************************/
    // return the number of items on the deque
    public int size()
    {
        return mStackPtr;
    }

    /**********************************************************************/
    // return an iterator over items in order from front to end
    public Iterator<Item> iterator()
    {
        return new RandomQIterator();
    }

    /**********************************************************************/
    public void enqueue( Item item )    // add the item
    {
        if ( item == null ) {
            throw new NullPointerException();
        }

        if ( mStackPtr == mStack.length ) {
            resizeStack( mStack.length * 2 );
        }

        mStack[ mStackPtr ] = item;

        mStackPtr++;

    }

    /**********************************************************************/
    private void resizeStack( int new_length )
    {
//        StdOut.println( "\n\nResizing to " + new_length );
        Item[] new_stack = (Item[]) new Object[ new_length ];

        for ( int i = 0; i < mStackPtr; i++ ) {
            new_stack[ i ] = mStack[ i ];
        }

        mStack = new_stack;
    }

    /**********************************************************************/
    public Item dequeue()   // delete and return a random item
    {
        if ( isEmpty() ) {
            throw new NoSuchElementException();
        }

        int pos = StdRandom.uniform( 0, mStackPtr );

        // swap random value to the end

        mStackPtr--;

        Item tmp = mStack[ mStackPtr ];

        mStack[ mStackPtr ] = mStack[ pos ];
        mStack[ pos ] = tmp;

        Item it = mStack[ mStackPtr ];
        mStack[ mStackPtr ] = null;


//        int pos = StdRandom.uniform( 0, mStackPtr );
//        Item item = mStack[ pos ];
//
//
//        while ( pos < mStackPtr - 1 ) {
//            mStack[ pos ] = mStack[ pos + 1 ];
//            pos++;
//        }
//
//
//        mStack[ pos ] = null;
//

        if ( mStackPtr > 3 ) {
            if ( mStackPtr == mStack.length / 4 ) {
                resizeStack( mStack.length / 2 );
            }
        }

        return it;

    }

    /**********************************************************************/
    public Item sample()    // return (but do not delete) a random item
    {
        if ( isEmpty() ) {
            throw new NoSuchElementException();
        }
        return mStack[ StdRandom.uniform( 0, mStackPtr ) ];
    }

    /**********************************************************************/
//    @Override
//    public String toString()
//    {
//        return "RandomizedQueue{" +
//               "mStackPtr=" + mStackPtr +
//               ", mStack.length=" + mStack.length +
//               ", mStack=" + Arrays.toString( mStack ) +
//               '}';
//    }


    /******************************************************************/
    /******************************************************************/
    /******************************************************************/

    public static void main( String[] args )
    {
    }

}