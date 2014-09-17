package algo.week2;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item>
{

    private class QueueIterator implements Iterator<Item>
    {
        private Node current = _first;

        public boolean hasNext()
        {
            return current != null;
        }

        public void remove()
        {
            throw new UnsupportedOperationException();
        }

        public Item next()
        {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    private class Node
    {
        Node next, prev;
        Item item;
    }

    private Node _first;
    private int  _count;


    /******************************************************************/
    // construct an empty randomized queue
    public RandomizedQueue()
    {
        _count = 0;
        _first = null;
    }

    /******************************************************************/
    // is the queue empty?
    public boolean isEmpty()
    {
        return _count == 0;
    }

    /******************************************************************/
    // return the number of items on the queue
    public int size()
    {
        return _count;
    }

    /******************************************************************/
    // add the item
    public void enqueue( Item item )
    {
        Node n = new Node();
        n.item = item;
        n.next = _first;
        n.prev = null;
        if ( _first != null ) {
            _first.prev = n;
        }
        _first = n;
        _count++;

    }

    /******************************************************************/
    // delete and return a random item
    public Item dequeue()
    {
        Node n = getItemNode( StdRandom.uniform( 0, _count ) );
        //Node n = getItemNode( 0 );


        if ( n.next != null ) {
            n.next.prev = n.prev;
        }
        if ( n.prev != null ) {
            n.prev.next = n.next;
        }

        if ( _first == n ) {
            _first = n.next;
        }

        _count--;

        if ( _count == 0 ) {
            _first = null;
        }

        return n.item;
    }

    /******************************************************************/
    // return (but do not delete) a random item
    public Item sample()
    {
        return getItemNode( StdRandom.uniform( 0, _count ) ).item;
    }

    /******************************************************************/
    private Node getItemNode( int pos )
    {
        Node n = _first;
        int i = 0;
        while ( n != null ) {
            if ( i == pos ) {
                return n;
            }
            i++;
            n = n.next;
        }
        throw new NoSuchElementException();
    }

    /******************************************************************/
    // return an independent iterator over items in random order
    public Iterator<Item> iterator()
    {
        return new QueueIterator();
    }

//    @Override
//    public String toString()
//    {
//        String out = "---------------------\n";
//        Node n = _first;
//        while ( n != null ) {
//            out += "[ME: " + n.hashCode()
//                   + "\tPREV: " + ( n.prev == null ? "null" : n.prev.hashCode() )
//                   + "\tNEXT: " + ( n.next == null ? "null" : n.next.hashCode() )
//                   + "\tVAL: " + n.item + "]\n";
//            n = n.next;
//        }
//        return out;
//    }

    /******************************************************************/
    /******************************************************************/
    /******************************************************************/

    public static void main( String[] args )
    {
        RandomizedQueue<String> rand = new RandomizedQueue<String>();

        rand.enqueue( "ZER0" );
        rand.enqueue( "1NE" );
        rand.enqueue( "2WO" );
        rand.enqueue( "THR3E" );
        rand.enqueue( "4OUR" );
        rand.enqueue( "5IVE" );
        rand.enqueue( "S6X" );
        rand.enqueue( "SE7EN" );
        rand.enqueue( "EI8HT" );
        rand.enqueue( "9INE" );

        while ( !rand.isEmpty() ) {
            StdOut.println( rand.dequeue() );
        }
    }
}