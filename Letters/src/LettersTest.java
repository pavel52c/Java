import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Iterator;
import java.util.NoSuchElementException;


class LettersTest {
    @Test
    void size0() {
        Letters letters = new Letters("");
        Assertions.assertEquals(0, letters.size());
    }

    @Test
    void size() {
        Letters letters = new Letters("Acd ;!l '");
        Assertions.assertEquals(9, letters.size());
    }

    @Test
    void size1() {
        Letters letters = new Letters("Acd ; !l '");
        Assertions.assertEquals(10, letters.size());
    }

    @Test
    void size2() {
        Letters letters = new Letters("Acd ;!l   '");
        Assertions.assertEquals(11, letters.size());
    }

    @Test
    void size3() {
        Letters letters = new Letters("");
        Assertions.assertEquals(0, letters.size());
    }

    @Test
    void isEmpty() {
        Letters letters = new Letters();
        Assertions.assertEquals(true, letters.isEmpty());
    }

    @Test
    void isEmpty1() {
        Letters letters = new Letters("");
        Assertions.assertEquals(true, letters.isEmpty());
    }

    @Test
    void contains() {
        Letters letters = new Letters("Hello world!");
        Assertions.assertEquals(false, letters.contains('c'));

    }

    @Test
    void contains1() {
        Letters letters = new Letters("Hello world!");
        Assertions.assertEquals(true, letters.contains('!'));
    }

    @Test
    void iteratorRemove() {
        Letters letters = new Letters("");
        Iterator iter = letters.iterator();
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            iter.remove();
        });
    }

    @Test
    void iteratorRemove1() {
        Letters letters = new Letters("Hello world!");
        Iterator iter = letters.iterator();
        while (iter.hasNext()) {
            iter.next();
        }
        iter.remove();
        iter.remove();
        Assertions.assertEquals("Hello worl", letters.toString());
    }

    @Test
    void iteratorRemove2() {
        Letters letters = new Letters("Hello world");
        Iterator iter = letters.iterator();
        for (int i = 0; i < 4; i++)
            iter.next();
        iter.remove();
        iter.remove();
        Assertions.assertEquals("He world", letters.toString());
    }

    @Test
    void iteratorRemove3() {
        Letters letters = new Letters("Hello world");
        Iterator iter = letters.iterator();
        while (iter.hasNext()) {
            iter.next();
        }
        while (!letters.isEmpty())
            iter.remove();
        Assertions.assertEquals("", letters.toString());
    }

    @Test
    void iteratorRemove4() {
        Letters letters = new Letters("Hello world");
        Iterator iter = letters.iterator();
        iter.next();
        iter.remove();
        iter.next();
        iter.remove();
        Assertions.assertEquals("llo world", letters.toString());
    }

    @Test
    void iteratorRemove5() {
        Letters letters = new Letters("h");
        Iterator iter = letters.iterator();
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            iter.remove();
            iter.remove();
        });

    }

    @Test
    void iteratorNext() {
        Letters letters = new Letters("Hello world!");
        Iterator iter = letters.iterator();
        Assertions.assertEquals('H', iter.next());
    }

    @Test
    void iteratorNext1() {
        Letters letters = new Letters("H");
        Iterator iter = letters.iterator();
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            iter.next();iter.next();
        });
    }

    @Test
    void iteratorNext2() {
        Letters letters = new Letters("Hello world");
        Iterator iter = letters.iterator();
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            while (iter.hasNext())
                iter.next();
            iter.next();
        });
    }

    @Test
    void iteratorNext3() {
        Letters letters=new Letters("");
        Iterator iter = letters.iterator();
        Assertions.assertThrows(NoSuchElementException.class,()->{iter.next();});
    }

    @Test
    void add() {
        Letters letters = new Letters("Hello world!");
        letters.add('a');
        Assertions.assertEquals("Hello world!a", letters.toString());
    }

    @Test
    void add1() {
        Letters letters = new Letters("llo world!");
        letters.add('a');
        Assertions.assertEquals("llo world!a", letters.toString());
    }

    @Test
    void add2() {
        Letters letters = new Letters(" world!");
        letters.add('a');
        Assertions.assertEquals(" world!a", letters.toString());
    }

    @Test
    void remove() {
        Letters letters = new Letters("Hello world!");
        Assertions.assertEquals(false, letters.remove('a'));
    }

    @Test
    void remove1() {
        Letters letters = new Letters("Hello world!");
        Assertions.assertEquals(true, letters.remove('d'));
        Assertions.assertEquals("Hello worl!", letters.toString());
    }

    @Test
    void remove2() {
        Letters letters = new Letters("llo world!");
        Assertions.assertEquals(true, letters.remove('!'));
        Assertions.assertEquals("llo world", letters.toString());
    }

    @Test
    void containsAll() {
        Letters letters = new Letters("Hello world!");
        Letters letters1 = new Letters("lo world!");
        Assertions.assertEquals(true, letters.containsAll(letters1));

    }

    @Test
    void containsAll1() {
        Letters letters = new Letters("Hello world!");
        Letters letters1 = new Letters("lo world!");
        Assertions.assertEquals(false, letters1.containsAll(letters));

    }

    @Test
    void addAll() {
        Letters letters = new Letters("Hello ");
        Letters letters1 = new Letters("world!");
        letters.addAll(letters1);
        Assertions.assertEquals("Hello world!", letters.toString());
    }

    @Test
    void removeAll() {
        Letters letters = new Letters("Hello ");
        Letters letters1 = new Letters("world!");
        Assertions.assertEquals(true, letters.removeAll(letters1));
        Assertions.assertEquals("He ", letters.toString());
    }

    @Test
    void removeAll1() {
        Letters letters = new Letters("Hello ");
        Letters letters1 = new Letters("wqrd!");
        Assertions.assertEquals(true, letters.removeAll(letters1));
        Assertions.assertEquals("Hello ", letters.toString());
    }

    @Test
    void retainAll() {
        Letters letters = new Letters("Hello ");
        Letters letters1 = new Letters("wqrd!");
        Assertions.assertEquals(true, letters.retainAll(letters1));
        Assertions.assertEquals("", letters.toString());
    }

    @Test
    void retainAll1() {
        Letters letters = new Letters("Hewwl!lo ");
        Letters letters1 = new Letters("wqrd!");
        Assertions.assertEquals(true, letters.retainAll(letters1));
        Assertions.assertEquals("ww!", letters.toString());
    }

    @Test
    void clear() {
        Letters letters = new Letters("Hello world!");
        letters.clear();
        Assertions.assertEquals("", letters.toString());
        Assertions.assertEquals(0, letters.size());
    }

    @Test
    void clear1() {
        Letters letters = new Letters("");
        letters.clear();
        Assertions.assertEquals("", letters.toString());
        Assertions.assertEquals(0, letters.size());
    }

    @Test
    void testToString() {
        Letters letters = new Letters("Hello world!");
        Assertions.assertEquals("Hello world!", letters.toString());
    }

    @Test
    void testEquals() {
        Letters letters = new Letters("Hello world!");
        Letters letters1 = new Letters("Hello world!");
        Assertions.assertEquals(true, letters.equals(letters1));
    }

    @Test
    void testEquals1() {
        Letters letters = new Letters("Hello world!");
        Letters letters1 = letters;
        Assertions.assertEquals(true, letters.equals(letters1));
    }

    @Test
    void testEquals2() {
        Letters letters = new Letters("Hello world!");
        Letters letters1 = null;
        Assertions.assertEquals(false, letters.equals(letters1));
    }

    @Test
    void testEquals3() {
        Letters letters = new Letters("Hello world!");
        Letters letters1 = new Letters("Hello wrld!");
        Assertions.assertEquals(false, letters.equals(letters1));
    }
}