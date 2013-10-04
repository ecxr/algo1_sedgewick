/**
 * Created by sky on 9/11/13.
 */

import java.util.Iterator;

public class FixedCapacityStack<Item> implements Iterable<Item>
{
    private Item[] s;
    private int N = 0;

    private class ReverseArrayIterator implements Iterator<Item>
    {
        private int i = N;

        public boolean hasNext() {
            return i > 0;
        }

        public void remove() {
            // not supported
        }

        public Item next() {
            return s[--i];
        }
    }

    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    public FixedCapacityStack(int capacity) {
        // (*#$&(* Java doesnt allow generic array creation
        //s = new Item[capacity];
        // use cast instead
        s = (Item[]) new Object[capacity];
    }

    public void push(Item item) {
        s[N++] = item;
    }

    public Item pop() {
        Item item = s[--N];
        s[N] = null;
        return item;

    }

    public boolean isEmpty() {
        return N == 0;
    }

    //public int size() { return 0; }

    public static void main(String[] args) {
        FixedCapacityStack<String> stack = new FixedCapacityStack<String>(10);
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
