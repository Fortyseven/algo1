//package algo.week2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item>
{
    private class DequeIterator implements Iterator<Item>
    {
        private Node current = _first;
        private Node next    = _first.next;

        public boolean hasNext()
        {
            return current != _nil;
        }

        public void remove()
        {
            throw new UnsupportedOperationException();
        }

        public Item next()
        {
            if ( current == _nil ) {
                throw new NoSuchElementException();
            }

            Item item = current.item;

            current = next;
            next = current.next;

            return item;
        }
    }

    private class Node
    {
        Node next, prev;
        Item item;
    }

    private Node _first, _last;
    private final Node _nil;
    private int _count = 0;


    // construct an empty deque
    public Deque()
    {

        _nil = new Node();
        _nil.next = _nil;
        _nil.prev = _nil;

        _first = _nil;
        _last = _nil;

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
        n.prev = _nil;

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
        n.next = _nil;
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
        if ( isEmpty() ) {
            throw new java.util.NoSuchElementException();
        }

        _count--;

        Node n = _first;
        Item i = n.item;
        n.item = null;

        _first = n.next;
        _first.prev = _nil;

        if ( isEmpty() ) {
            _first = _nil;
            _last = _nil;
        }

        return i;
    }

    // delete and return the item at the end
    public Item removeLast()
    {
        if ( isEmpty() ) {
            throw new java.util.NoSuchElementException();
        }

        _count--;

        Node n = _last;
        Item i = n.item;
        n.item = null;

        _last = n.prev;
        _last.next = _nil;
        //_last.next = _nil;

        if ( isEmpty() ) {
            _first = _nil;
            _last = _nil;
        }

        return i;
    }

    // return an iterator over items in order from front to end
    public Iterator<Item> iterator()
    {
        return new DequeIterator();
    }

//    @Override
//    public String toString()
//    {
//        String out = "Deque{" +
//                     "\n _first = " + ( _first == null ? "null" : _first.item ) +
//                     "\n _last = " + ( _last == null ? "null" : _last.item ) +
//                     "\n _count = " + _count +
//                     "\n}";
//
//        Node n = _first;
//        while ( n != null ) {
//            out += "<THIS: " + n.hashCode() + "\t\t - PREV: " + ( ( n.prev == null ) ? "null" : n.prev.hashCode() ) + "\t  NEXT: " + ( ( n.next == null ) ? "null" : n.next
//                                                                                                                                                                             .hashCode() ) + "\t - ITEM: " + n.item + ">\n";
//            n = n.next;
//        }
//
//        return out + "\n\n";
//    }

    ///////////////////////////////////////////////////
    // unit testing
    public static void main( String[] args )
    {
    }
}