/**
 * Created by sky on 10/4/13.
 */
public class Node<Key extends Comparable<Key>, Value>
{
    private Key key;
    private Value val;
    private Node left, right;

    public Node(Key key, Value val)
    {
        this.key = key;
        this.val = val;
    }
}
