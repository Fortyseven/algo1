import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Fortyseven on 9/21/14.
 */
public class DequeTest
{
    private Deque<String> mDeque;

    @Before
    public void setUp() throws Exception
    {
        StdOut.println( "\n------------------------" );
        mDeque = new Deque<String>();
    }

    @After
    public void tearDown() throws Exception
    {

    }

    @Test
    public void test2() throws Exception
    {
        StdOut.println( "TEST 1 - Validate expectations addFirst/removeFirst, etc." );

        for ( int i = 0; i < 10000; i++ ) {
            String str = String.valueOf( StdRandom.uniform() );
            mDeque.addFirst( "PISS" );
            mDeque.addFirst( str );
            //org.junit.Assert.assertEquals( str, mDeque.removeFirst() );
        }

//        for ( int i = 0; i < 10000; i++ ) {
//            String str = String.valueOf( StdRandom.uniform() );
//            mDeque.addFirst( "PISS" );
//            mDeque.addLast( str );
//            org.junit.Assert.assertEquals( str, mDeque.removeLast() );
//        }

        org.junit.Assert.assertEquals( 20000, mDeque.size() );

    }

    @Test
    public void Test1() throws Exception
    {
        StdOut.println( "TEST 1 - 100 adds, 100 removeFirsts" );

        for ( int i = 0; i < 100; i++ ) {
            mDeque.addFirst( "TRACK 01" );
        }

        for ( int i = 0; i < 100; i++ ) {
            mDeque.removeFirst();
        }

        org.junit.Assert.assertEquals( 0, mDeque.size() );

        for ( int i = 0; i < 100; i++ ) {
            mDeque.addFirst( "TRACK 01" );
        }

        for ( int i = 0; i < 100; i++ ) {
            mDeque.removeLast();
        }

        org.junit.Assert.assertEquals( 0, mDeque.size() );
    }

    @Test
    public void test3() throws Exception
    {
        StdOut.println( "TEST 3 - iterator count" );

        for ( int i = 0; i < 50000; i++ ) {
            mDeque.addFirst( String.valueOf( StdRandom.uniform() ) );
        }

        int count = 0;

        for ( String str : mDeque ) {
            count++;
        }

        org.junit.Assert.assertEquals( 50000, count );


    }
}
