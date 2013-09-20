import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by sky on 9/13/13.
 */
public class Deque<Item> implements Iterable<Item>
{
    private DLNode head;
    private DLNode tail;
    private int size;

    private class DLNode {
        Item item;
        DLNode next;
        DLNode prev;
    }

    // construct an empty deque
    public Deque()
    {
        head = new DLNode();
        tail = new DLNode();

        head.item = null;
        head.prev = null;
        head.next = tail;

        tail.item = null;
        tail.next = null;
        tail.prev = head;

        size = 0;
    }

    // is the deque empty?
    public boolean isEmpty()
    {
        return size == 0;
    }

    // return the number of items on the deque
    public int size()
    {
        return size;
    }

    // insert the item at the front
    public void addFirst(Item item)
    {
        if (item == null) throw new NullPointerException();

        DLNode oldfirst = head.next;
        DLNode newnode  = new DLNode();
        newnode.item    = item;

        head.next     = newnode;
        newnode.next  = oldfirst;
        newnode.prev  = head;
        oldfirst.prev = newnode;

        size++;
    }

    // insert the item at the end
    public void addLast(Item item)
    {
        if (item == null) throw new NullPointerException();

        DLNode oldlast = tail.prev;
        DLNode newnode = new DLNode();
        newnode.item   = item;

        tail.prev    = newnode;
        newnode.next = tail;
        oldlast.next = newnode;
        newnode.prev = oldlast;

        size++;
    }

    // delete and return the item at the front
    public Item removeFirst()
    {
        if (size == 0) throw new NoSuchElementException();

        DLNode toRemove = head.next;
        Item item = toRemove.item;

        head.next = toRemove.next;
        toRemove.next.prev = head;

        toRemove = null;
        size--;
        return item;
    }

    // delete and return the item at the end
    public Item removeLast()
    {
        if (size == 0) throw new NoSuchElementException();

        DLNode toRemove = tail.prev;
        Item item = toRemove.item;

        tail.prev = toRemove.prev;
        toRemove.prev.next = tail;

        toRemove = null;
        size--;
        return item;
    }

    // return an iterator over items in order from front to end
    public Iterator<Item> iterator()
    {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {
        private DLNode current = head.next;

        public boolean hasNext() {
            return current != tail;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (current == tail) throw new NoSuchElementException();
            Item item = current.item;
            current   = current.next;
            return item;
        }
    }

    public static void main(String[] args)
    {

    }
}
