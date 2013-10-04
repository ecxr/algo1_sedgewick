/**
 * Created by sky on 9/10/13.
 */
public class StackOfStringsResizingArray {

    private String[] s;
    private int N = 0;

    public StackOfStringsResizingArray() {
        s = new String[1];
    }

    public void push(String item) {
        if (N == s.length)
            resize(2 * s.length);

        s[N++] = item;
    }

    public String pop() {
        String item = s[--N];
        s[N] = null;
        if (N > 0 && N == s.length/4)
            resize(s.length/2);
        return item;

    }

    public boolean isEmpty() {
        return N == 0;
    }

    //public int size() { return 0; }

    private void resize(int capacity) {
        String[] copy = new String[capacity];
        for (int i = 0; i < N; i++) {
            copy[i] = s[i];
        }
        s = copy;
    }

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
