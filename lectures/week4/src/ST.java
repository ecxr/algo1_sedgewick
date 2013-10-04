/**
 * Symbol Table Interface
 *
 * Assumptions:
 * Keys are Comparable.  Implement compareTo.
 * or
 * Keys are any generic type.   Use equals() to compare for quality
 * Use hashCode() to scramble key
 *
 * Created by sky on 10/3/13.
 */
public class ST<Key, Value>
{
    // create a symbol table
    ST() {}

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

    // is the table empty?
    boolean isEmpty() { return true; }

    // number of key-value pairs in the table
    int size() { return 0; }

    // all the keys in the table
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
