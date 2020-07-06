package Package.Lesson17;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class RangeTest {

    @Test
    void size() {
        Range range = new Range();
        assertEquals(0, range.size());
        range.add(1);
        assertEquals(1, range.size());
        range.add(2);
        assertEquals(2, range.size());
    }

    @Test
    void isEmpty() {
        Range range = new Range();
        assertTrue(range.isEmpty());
        range.add(1);
        assertFalse(range.isEmpty());
    }

    @Test
    void contains() {
        Range<String> range = new Range();
        range.add("String1");
        assertTrue(range.contains("String1"));
        assertFalse(range.contains("String2"));
    }

    @Test
    void iterator() {
        Range<String> range = new Range();
        range.add("String1");
        range.add("String2");
        range.add("String3");
        Iterator<String> i = range.iterator();
        assertTrue(i.hasNext());
        assertEquals("String1", i.next());
        assertEquals("String2", i.next());
        assertTrue(i.hasNext());
        assertEquals("String3", i.next());
        assertFalse(i.hasNext());
    }

    @Test
    void toArray() {
        Range<String> range = new Range();
        range.add("String1");
        range.add("String2");
        range.add("String3");
        String[] expectedArray = new String[] {"String1", "String2","String3"};
        assertArrayEquals(expectedArray, range.toArray());
    }

    @Test
    void testToArray() {
        Range<String> range = new Range();
        range.add("String1");
        range.add("String2");
        range.add("String3");
        String[] arrayToArray = new String[4];
        String[] expectedArray = new String[] {"String1", "String2","String3", null};
        assertArrayEquals(expectedArray, range.toArray(arrayToArray));
        arrayToArray = new String[2];
        expectedArray = new String[] {"String1", "String2", "String3"};
        assertArrayEquals(expectedArray, range.toArray(arrayToArray));
        String[] toArray = range.toArray(arrayToArray);
        assertEquals(3, toArray.length);
    }

    @Test
    void add() {
        Range<String> range = new Range();
        assertFalse(range.contains("String1"));
        range.add("String1");
        assertTrue(range.contains("String1"));
    }

    @Test
    void remove() {
        Range<String> range = new Range();
        range.add("String1");
        assertTrue(range.contains("String1"));
        range.remove("String1");
        assertFalse(range.contains("String1"));
    }

    @Test
    void containsAll() {
        Range<String> range = new Range();
        range.add("String1");
        range.add("String2");
        range.add("String3");
        Range<String> rangeToBeAdded = new Range();
        rangeToBeAdded.add("String4");
        rangeToBeAdded.add("String5");
        range.addAll(rangeToBeAdded);
        assertTrue(range.containsAll(rangeToBeAdded));
        range.remove("String4");
        assertFalse(range.containsAll(rangeToBeAdded));
    }

    @Test
    void addAll() {
        Range<String> range = new Range();
        range.add("String1");
        range.add("String2");
        range.add("String3");
        Range<String> rangeToBeAdded = new Range();
        rangeToBeAdded.add("String4");
        rangeToBeAdded.add("String5");
        range.addAll(rangeToBeAdded);
        String[] expectedArray = new String[] {"String1", "String2","String3", "String4", "String5"};
        assertArrayEquals(expectedArray, range.toArray());
    }

    @Test
    void removeAll() {
        Range<String> range = new Range();
        range.add("String1");
        range.add("String2");
        range.add("String3");
        Range<String> rangeToBeAdded = new Range();
        rangeToBeAdded.add("String4");
        rangeToBeAdded.add("String5");
        range.addAll(rangeToBeAdded);
        String[] expectedArray = new String[] {"String1", "String2","String3", "String4", "String5"};
        assertArrayEquals(expectedArray, range.toArray());
    }

    @Test
    void retainAll() {
        Range<Integer> range = new Range();
        range.add(1);
        range.add(2);
        range.add(3);
        Range<Integer> rangeToBeRemoved = new Range();
        rangeToBeRemoved.add(1);
        rangeToBeRemoved.add(2);
        range.retainAll(rangeToBeRemoved);
        Integer[] expectedArray = new Integer[] {1, 2};
        assertArrayEquals(expectedArray, range.toArray());
    }

    @Test
    void clear() {
        Range<Integer> range = new Range();
        range.add(1);
        range.add(2);
        range.add(3);
        assertFalse(range.isEmpty());
        range.clear();
        assertTrue(range.isEmpty());
        assertEquals(0, range.size());
    }
}