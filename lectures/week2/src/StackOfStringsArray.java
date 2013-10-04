/**
 * Created by sky on 9/10/13.
 */
public class StackOfStringsArray
{
    //private Node first = null;

    private String[] s;
    private int N = 0;

    public StackOfStringsArray(int capacity) {
        s = new String[capacity];
    }

    public void push(String item) {
        s[N++] = item;
    }

    public String pop() {
        String item = s[--N];
        s[N] = null;
        return item;

    }

    public boolean isEmpty() {
        return N == 0;
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
