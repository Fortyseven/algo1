package algo.week2;

import java.util.Iterator;

import edu.princeton.cs.introcs.StdOut;

public class Deque<Item> implements Iterable<Item>
{
    private class DequeIterator implements Iterator<Item>
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

    private Node _first, _last;
    private int _count = 0;

    // construct an empty deque
    public Deque()
    {
        _first = null;
        _last = null;
        _count = 0;
    }

    // is the deque empty?
    public boolean isEmpty()
    {
        return _count == 0;
    }

    // return the number of items on the deque
    public int size()
    {
        return _count;
    }

    // insert the item at the front
    public void addFirst( Item item )
    {
        if ( item == null ) {
            throw new NullPointerException();
        }

        Node n = new Node();
        n.item = item;
        n.next = _first;
        n.prev = null;

        _first.prev = n;

        _first = n;

        if ( _count == 0 ) {
            _last = n;
        }

        _count++;
    }

    // insert the item at the end
    public void addLast( Item item )
    {
        if ( item == null ) {
            throw new NullPointerException();
        }

        Node n = new Node();
        n.item = item;
        n.next = null;
        n.prev = _last;

        if ( _count == 0 ) {
            _first = n;
        }
        else {
            _last.next = n;
        }

        _last = n;

        _count++;
    }

    // delete and return the item at the front
    public Item removeFirst()
    {
        if ( _first == null ) {
            throw new java.util.NoSuchElementException();
        }
        _count--;
        Node n = _first;
        _first = _first.next;

        if ( _count == 0 ) {
            _last = null;
        }
        return n.item;
    }

    // delete and return the item at the end
    public Item removeLast()
    {
        if ( _last == null ) {
            throw new java.util.NoSuchElementException();
        }
        _count--;
        Node n = _last;
        _last = _last.prev;
        if ( _last != null ) {
            _last.next = null;
        }

        if ( _count == 0 ) {
            _first = null;
        }
        return n.item;
    }

    // return an iterator over items in order from front to end
    public Iterator<Item> iterator()
    {
        return new DequeIterator();
    }

    @Override
    public String toString()
    {
        String out = "Deque{" +
                     "\n _first = " + ( _first == null ? "null" : _first.item ) +
                     "\n _last = " + ( _last == null ? "null" : _last.item ) +
                     "\n _count = " + _count +
                     "\n}";

        Node n = _first;
        while ( n != null ) {
            out += "<THIS: " + n.hashCode() + "\t\t - PREV: " + ( ( n.prev == null ) ? "null" : n.prev.hashCode() ) + "\t  NEXT: " + ( ( n.next == null ) ? "null" : n.next
                                                                                                                                                                             .hashCode() ) + "\t - ITEM: " + n.item + ">\n";
            n = n.next;
        }

        return out + "\n\n";
    }

    ///////////////////////////////////////////////////
    // unit testing
    public static void main( String[] args )
    {
        Deque<String> deck = new Deque<String>();
        StdOut.println( deck.toString() );

        deck.addLast( "Zero" );
        deck.addLast( "One" );
        deck.addLast( "Two" );
        deck.addFirst( "Alpha" );
        deck.addFirst( "Beta" );
        deck.addLast( "Three" );
//
//        deck.addLast("A");
//        deck.addLast("B");
//        deck.addLast("C");

//        StdOut.println(deck.toString());
//
        StdOut.println( deck.removeLast() );
        StdOut.println( deck.removeLast() );
        StdOut.println( deck.removeLast() );
        StdOut.println( deck.removeLast() );
        StdOut.println( deck.removeLast() );
        StdOut.println( deck.removeLast() );
        StdOut.println( "\n" );
//        StdOut.println(deck.removeLast());
//        StdOut.println(deck.removeLast());
//        StdOut.println(deck.removeLast());


        StdOut.println( deck.toString() );
        StdOut.println( deck.isEmpty() );
        StdOut.println( deck.size() );
    }
}