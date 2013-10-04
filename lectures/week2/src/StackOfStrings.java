/**
 * Created by sky on 9/10/13.
 */
public class StackOfStrings
{
    private Node first = null;

    private class Node {
        String item;
        Node next;
    }

    public void StackOfStrings() {}

    public void push(String item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }

    public String pop() {
        String item = first.item;
        first = first.next;
        return item;
    }

    public boolean isEmpty() {
        return first == null;
    }

    //public int size() { return 0; }

    public static void main(String[] args) {
        StackOfStrings stack = new StackOfStrings();
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
