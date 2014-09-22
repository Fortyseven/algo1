import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Fortyseven on 9/21/14.
 */
public class RandomizedQueueTest
{
    RandomizedQueue<String> mRandQueue;

    @Before
    public void setUp() throws Exception
    {
        StdOut.println( "----------------------------------" );
        mRandQueue = new RandomizedQueue<String>();
    }

    @After
    public void tearDown() throws Exception
    {
//        StdOut.println( "\n\t" + mRandQueue );
    }

    @Test
    public void Test1() throws Exception
    {
        StdOut.println( "TEST 1 - Calls to enqueue() (and dequeue() just to verify)" );
        Test1_Do( 5 );
        Test1_Do( 50 );
        Test1_Do( 500 );
        Test1_Do( 1000 );
    }

    private void Test1_Do( int n ) throws Exception
    {
        StdOut.println( "N = " + n );
        for ( int i = 0; i < 1000; i++ ) {
            String foo = String.valueOf( StdRandom.uniform() );
            mRandQueue.enqueue( foo );
            org.junit.Assert.assertEquals( foo, mRandQueue.dequeue() );
        }
    }

    @Test
    public void Test2() throws Exception
    {
        StdOut.println( "TEST 2 - Calls to enqueue() and dequeue()" );
        Test2_DoA( 5 );
        Test2_DoA( 50 );
        Test2_DoA( 500 );
        Test2_DoA( 1000 );
        StdOut.println();
        Test2_DoB( 5 );
        Test2_DoB( 50 );
        Test2_DoB( 500 );
        Test2_DoB( 1000 );
    }

    private void Test2_DoA( int n ) throws Exception
    {
        StdOut.println( "N = " + n );

        for ( int i = 0; i < n; i++ ) {

            double prb = StdRandom.uniform();

            if ( prb < 0.10 ) {
                mRandQueue.enqueue( String.valueOf( StdRandom.uniform() ) );
            }
            else {
                if ( !mRandQueue.isEmpty() ) {
                    mRandQueue.dequeue();
                }
            }
        }
    }

    private void Test2_DoB( int n ) throws Exception
    {
        StdOut.println( "N = " + n );

        for ( int i = 0; i < n; i++ ) {

            double prb = StdRandom.uniform();

            if ( prb < 0.10 ) {
                if ( !mRandQueue.isEmpty() ) {
                    mRandQueue.dequeue();
                }
            }
            else {
                mRandQueue.enqueue( String.valueOf( StdRandom.uniform() ) );
            }
        }
    }


    @Test
    public void Test8() throws Exception
    {
        StdOut.println( "TEST 8 - Check that iterator() returns correct items after sequence of enqueue() and dequeue() operations" );

        for ( int i = 0; i < 10000; i++ ) {
            mRandQueue.enqueue( String.valueOf( StdRandom.uniform() ) );
            mRandQueue.enqueue( String.valueOf( StdRandom.uniform() ) );
            mRandQueue.dequeue();
            mRandQueue.enqueue( String.valueOf( StdRandom.uniform() ) );
            mRandQueue.dequeue();
            mRandQueue.enqueue( String.valueOf( StdRandom.uniform() ) );
            mRandQueue.dequeue();
        }

        int count = 0;

        for ( String str : mRandQueue ) {
            count++;
        }

        org.junit.Assert.assertEquals( count, 10000 );

    }

    @Test
    public void testHuge() throws Exception
    {
        StdOut.println( "TEST Q - Huge" );

        for ( int i = 0; i < 500000; i++ ) {
            mRandQueue.enqueue( "pisscakes" );
        }

        for ( int i = 0; i < 500000; i++ ) {
            mRandQueue.dequeue();
        }

        org.junit.Assert.assertEquals( 0, mRandQueue.size() );
    }
}
