/**
 * Created by sky on 10/4/13.
 */
public class BST<Key extends Comparable<Key>, Value>
{
    private Node root;

    private class Node
    {
        private Key key;
        private Value val;
        private Node left, right;
        private int count;

        public Node(Key key, Value val)
        {
            this.key = key;
            this.val = val;
        }
    }

    // put key-value pair into the table
    // remove key from table if the value is null
    public void put(Key key, Value val)
    {
        root = put(root, key, val);
    }

    // cost: 1 + depth of node compares
    private Node put(Node x, Key key, Value val)
    {
        if (x == null) return new Node(key, val);
        int cmp = key.compareTo(x.key);
        if      (cmp  < 0)
            x.left = put(x.left, key, val);
        else if (cmp  > 0)
            x.right = put(x.right, key, val);
        else if (cmp == 0)
            x.val = val;
        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }

    // value paired with key (null if key is absent)
    // cost: 1 + depth of node in tree
    public Value get(Key key)
    {
        Node x = root;
        while (x != null)
        {
            int cmp = key.compareTo(x.key);
            if      (cmp  < 0) x = x.left;
            else if (cmp  > 0) x = x.right;
            else if (cmp == 0) return x.val;
        }
        return null;
    }

    // remove key (and its value) from table
    public void delete(Key key)
    {
        root = delete(root, key);
    }

    // Hibbard deletion:
    //   Find successor x of t
    //   Delete Min of t's right subtree (but dont GC)
    //   put x in t's spot
    private Node delete(Node x, Key key)
    {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        // search for key
        if      (cmp  < 0) x.left = delete(x.left, key);
        else if (cmp  > 0) x.right = delete(x.right, key);
        else
        {
            // no right child
            if (x.right == null) return x.left;

            Node t = x;
            x = min(t.right);
            // replace with successor
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        // update subtree counts
        x.count = size(x.left) + size(x.right) + 1;
        return x;
    }

    // number of key-value pairs in the table
    public int size()
    {
        return size(root);
    }

    private int size(Node x)
    {
        if (x == null) return 0;
        return x.count;
    }

    // smallest key
    // left-most non-null node
    public Key min() { return null; }

    // largest key
    // right-most non-null node
    public Key max() { return null; }

    // largest key less than or equal to key
    public Key floor(Key key)
    {
        Node x = floor(root, key);
        if (x == null ) return null;
        return x.key;
    }

    private Node floor(Node x, Key key)
    {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);

        if (cmp == 0) return x;
        if (cmp  < 0) return floor(x.left, key);

        Node t = floor(x.right, key);
        if (t != null) return t;
        else           return x;
    }

    // smallest key greater than or equal to key
    Key ceiling(Key key) { return null; }

    // How many keys less than k?
    public int rank(Key key)
    {
        return rank(key, root);
    }

    private int rank(Key key, Node x)
    {
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if      (cmp  < 0) return rank(key, x.left);
        else if (cmp  > 0) return 1 + size(x.left) + rank(key, x.right);
        else               return size(x.left);
    }

    // delete smallest key
    public void deleteMin()
    {
        root = deleteMin(root);
    }

    private Node deleteMin(Node x)
    {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }

    // delete largest key
    public void deleteMax()
    {
        root = deleteMax(root);
    }

    private Node deleteMax(Node x)
    {
        if (x.right == null) return x.left;
        x.right = deleteMax(x.right);
        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }


    public Iterable<Key> keys()
    {
        Queue<Key> q = new Queue<Key>();
        inorder(root, q);
        return q;
    // all the keys in the table
    Iterable<Key> iterator() { return null; }
    }

    private void inorder(Node x, Queue<Key> q)
    {
        if (x == null) return;
        inorder(x.left, q);
        q.enqueue(x.key);
        inorder(x.right, q);
    }

}
