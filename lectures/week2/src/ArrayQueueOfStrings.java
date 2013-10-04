/**
 * Created by sky on 9/11/13.
 */
public class ArrayQueueOfStrings
{
    private String q[];
    private int head, tail;
    private int capacity;

    public ArrayQueueOfStrings() {
        q = new String[1];
        capacity = 1;
        head = tail = 0;
    }

    // add resizing array.  once past capacity, reset head tail to 0
    public void enqueue(String item) {
        // add item at q[tail]
        // update head, tail modulo capacity
    }

    public String dequeue() {
        // remove item from q[head]
        // update head, tail modulo capacity
        return "";
    }

    public boolean isEmpty() {
        return true;
    }

    //int size()
}
