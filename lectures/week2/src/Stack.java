/**
 * Created by sky on 9/11/13.
 */

import java.util.Iterator;
import java.util.ListIterator;

public class Stack<Item> implements Iterable<Item>
{
    private Node first = null;

    private class Node {
        Item item;
        Node next;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>
    {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            // not supported
            // Throw UnsupportedOperationException
        }

        public Item next() {
            // if current == null throw NoSuchElementException
            Item item = current.item;
            current   = current.next;
            return item;
        }
    }

    public void Stack() {}

    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        return item;
    }

    public boolean isEmpty() {
        return first == null;
    }

    //public int size() { return 0; }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("-")) {
                StdOut.print(stack.pop());
                StdOut.print(" ");
            }
            else
                stack.push(s);
        }
        StdOut.println();
    }
}

