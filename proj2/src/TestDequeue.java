/**
 * Created by sky on 9/14/13.
 */

public class TestDequeue
{
    public static void main(String[] args) {
        Deque<String> deck = new Deque<String>();

        String str = null;
        deck.addFirst("foo");
        str = deck.removeLast();
        deck.addFirst("baz");
        deck.addFirst("bar");
        str = deck.removeLast();
        str = deck.removeLast();
        deck.addFirst("baz");
        deck.addFirst("bar");
        deck.addFirst("foo");
        str = deck.removeLast();
        str = deck.removeLast();
        str = deck.removeLast();
        deck.addLast("glorp");
        deck.addFirst("baz");
        deck.addFirst("bar");
        deck.addFirst("foo");
        str = deck.removeLast();
        str = deck.removeLast();
        str = deck.removeLast();
        str = deck.removeLast();
        deck.addLast("glorp");
        deck.addFirst("baz");
        str = deck.removeLast();
        deck.addFirst("bar");
        deck.addFirst("foo");
        str = deck.removeLast();
        str = deck.removeLast();
        str = deck.removeLast();
    }
}

