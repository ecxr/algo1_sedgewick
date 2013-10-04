/**
 * Ordered Symbol Table Interface
 *
 * Assumptions:
 * Keys stored in sorted order
 * Keys are Comparable.  Implement compareTo.
 * or
 * Keys are any generic type.   Use equals() to compare for quality
 * Use hashCode() to scramble key
 *
 * Created by sky on 10/3/13.
 */
public class OrderedST<Key extends Comparable<Key>, Value>
{
    // create a symbol table
    OrderedST() {}

    // put key-value pair into the table
    // remove key from table if the value is null
    void put(Key key, Value value) {}

    // value paired with key (null if key is absent)
    Value get(Key key) { return null; }

    // remove key (and its value) from table
    void delete(Key key)
    {
        // lazy version of delete relies on put of null value deletes key
        put(key, null);
    }

    // is there a value paired with the key?
    boolean contains(Key key)
    {
        return get(key) != null;
    }

    // number of key-value pairs in the table
    int size() { return 0; }

    // is the table empty?
    boolean isEmpty() { return true; }

    // smallest key
    Key min() { return null; }

    // largest key
    Key max() { return null; }

    // largest key less than or equal to key
    Key floor(Key key) { return null; }

    // smallest key greater than or equal to key
    Key ceiling(Key key) { return null; }

    // number of keys less than key
    int rank(Key key) { return 0; }

    // key of rank k
    Key rank(int k) { return null; }

    // delete smallest key
    void deleteMin() { }

    // delete largest key
    void deleteMax() { }

    // number of keys in [lo..hi]
    int size(Key lo, Key hi) { return 0; }

    // keys [lo..hi] in sorted order
    Iterable<Key> keys(Key lo, Key hi) { return null; }

    // all the keys in the table, in sorted order
    Iterable<Key> keys() { return null; }

    public static void main(String[] args)
    {
        ST<String, Integer> st = new ST<String, Integer>();
        for(int i = 0; !StdIn.isEmpty(); i++)
        {
            String key = StdIn.readString();
            st.put(key, i);
        }
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }
}
