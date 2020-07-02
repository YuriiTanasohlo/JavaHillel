package Package.Lesson13;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

class MyTreeSetTest {
    static MyTreeSet myTreeSet = new MyTreeSet(new IntComparator());
    @BeforeAll
    static void fillTree() {
        myTreeSet.add(1);
        myTreeSet.add(0);
        myTreeSet.add(4);
        myTreeSet.add(3);
        myTreeSet.add(2);
        myTreeSet.add(5);
    }



    @Test
    void comparator(){
        MyTreeSet myTreeSetWithoutComparator = new MyTreeSet();
        class TestClass {}
        myTreeSetWithoutComparator.add(new TestClass());
        Exception exception = assertThrows(RuntimeException.class, () -> myTreeSetWithoutComparator.add(new TestClass()));
        assertEquals("The object is not comparable", exception.getMessage());
    }

    @Test
    void size() {
        assertEquals(6, myTreeSet.size());
    }

    @Test
    void isEmpty() {
        MyTreeSet myTreeSetForIsEmpty = new MyTreeSet(new IntComparator());
        assertTrue(myTreeSetForIsEmpty.isEmpty());
        myTreeSetForIsEmpty.add(1);
        assertFalse(myTreeSetForIsEmpty.isEmpty());
    }

    @Test
    void contains() {
        assertTrue(myTreeSet.contains(5));
        assertFalse(myTreeSet.contains(6));
        Exception exception = assertThrows(NullPointerException.class, () -> myTreeSet.contains(null));
        assertEquals("Null can't be an argument of method contains", exception.getMessage());
    }

    @Test
    void iterator() {
        Iterator myTreeSetIterator = myTreeSet.iterator();
        assertTrue(myTreeSetIterator.hasNext());
        assertEquals(0, myTreeSetIterator.next());
    }

    @Test
    void toArray() {
        MyTreeSet myTreeSet = new MyTreeSet(new IntComparator());
        TreeSet treeSet = fillMyTreeSet(20, 20, myTreeSet);
        assertArrayEquals(treeSet.toArray(), myTreeSet.toArray());
    }

    @Test
    void toSpecifiedArray() {
        Object[] specifiedArray = new Object[3];
        Object[] resultArray = myTreeSet.toArray(specifiedArray);
        assertEquals(3, specifiedArray.length);
        assertEquals(6, resultArray.length);
        specifiedArray = new Object[9];
        resultArray = myTreeSet.toArray(specifiedArray);
        assertEquals(9, resultArray.length);
    }

    @Test
    void add() {
        MyTreeSet myTreeSetForAdd = new MyTreeSet(new IntComparator());
        assertFalse(myTreeSetForAdd.contains(1));
        myTreeSetForAdd.add(1);
        assertTrue(myTreeSetForAdd.contains(1));
        Exception exception = assertThrows(NullPointerException.class, () -> myTreeSetForAdd.add(null));
        assertEquals("Null can't be an argument of method add", exception.getMessage());
    }

    @Test
    void remove() {
        MyTreeSet myTreeSetForRemove = new MyTreeSet(new IntComparator());
        myTreeSetForRemove.add(1);
        assertTrue(myTreeSetForRemove.contains(1));
        myTreeSetForRemove.remove(1);
        assertFalse(myTreeSetForRemove.contains(1));
        Exception exception = assertThrows(NullPointerException.class, () -> myTreeSetForRemove.remove(null));
        assertEquals("Null can't be an argument of method remove", exception.getMessage());
    }

    @Test
    void addAll() {
        MyTreeSet myTreeSet = new MyTreeSet(new IntComparator());
        MyTreeSet myTreeSetToAddAll = new MyTreeSet(new IntComparator());
        TreeSet treeSet = fillMyTreeSet(20, 20, myTreeSet);
        TreeSet treeSetToAddAll = fillMyTreeSet(10, 40, myTreeSetToAddAll);
        myTreeSet.addAll(myTreeSetToAddAll);
        treeSet.addAll(treeSetToAddAll);
        assertEquals(treeSet.toString(), myTreeSet.toString());
        Exception exception = assertThrows(NullPointerException.class, () -> myTreeSet.addAll(null));
        assertEquals("Null can't be an argument of method addAll", exception.getMessage());
    }

    @Test
    void clear() {
        MyTreeSet myTreeSet = new MyTreeSet(new IntComparator());
        TreeSet treeSet = new TreeSet(new IntComparator());

        myTreeSet.add(1);
        treeSet.add(1);

        myTreeSet.clear();
        treeSet.clear();

        assertEquals(treeSet.toString(), myTreeSet.toString());
    }

    @Test
    void removeAll() {
        MyTreeSet myTreeSet = new MyTreeSet(new IntComparator());
        MyTreeSet myTreeSetToRemoveAll = new MyTreeSet(new IntComparator());
        TreeSet treeSet = fillMyTreeSet(20, 20, myTreeSet);
        TreeSet treeSetToRemoveAll = fillMyTreeSet(10, 20, myTreeSetToRemoveAll);

        myTreeSet.removeAll(myTreeSetToRemoveAll);
        treeSet.removeAll(treeSetToRemoveAll);
        assertEquals(treeSet.toString(), myTreeSet.toString());
        Exception exception = assertThrows(NullPointerException.class, () -> myTreeSet.removeAll(null));
        assertEquals("Null can't be an argument of method removeAll", exception.getMessage());
    }

    @Test
    void removeAllAdditionalTest() {
        MyTreeSet myTreeSet = new MyTreeSet(new IntComparator());
        MyTreeSet myTreeSetToRemoveAll = new MyTreeSet(new IntComparator());
        TreeSet treeSet = new TreeSet(new IntComparator());
        TreeSet treeSetToRemoveAll = new TreeSet(new IntComparator());

        myTreeSet.add(0);
        myTreeSet.add(5);
        myTreeSet.add(14);
        myTreeSet.add(10);
        myTreeSet.add(18);
        myTreeSet.add(7);
        myTreeSet.add(8);
        myTreeSet.add(1);
        myTreeSet.add(4);
        myTreeSet.add(15);
        myTreeSet.add(19);
        myTreeSet.add(12);
        myTreeSet.add(2);


        treeSet.add(0);
        treeSet.add(5);
        treeSet.add(14);
        treeSet.add(10);
        treeSet.add(18);
        treeSet.add(7);
        treeSet.add(8);
        treeSet.add(1);
        treeSet.add(4);
        treeSet.add(15);
        treeSet.add(19);
        treeSet.add(12);
        treeSet.add(2);

        myTreeSetToRemoveAll.add(10);
        myTreeSetToRemoveAll.add(13);
        myTreeSetToRemoveAll.add(9);
        myTreeSetToRemoveAll.add(0);
        myTreeSetToRemoveAll.add(7);
        myTreeSetToRemoveAll.add(6);
        myTreeSetToRemoveAll.add(14);
        myTreeSetToRemoveAll.add(8);

        treeSetToRemoveAll.add(10);
        treeSetToRemoveAll.add(13);
        treeSetToRemoveAll.add(9);
        treeSetToRemoveAll.add(0);
        treeSetToRemoveAll.add(7);
        treeSetToRemoveAll.add(6);
        treeSetToRemoveAll.add(14);
        treeSetToRemoveAll.add(8);


//        System.out.println("myTreeSet: " + myTreeSet);
//        System.out.println("treeSet: " + treeSet);
//        System.out.println("myTreeSetToRemoveAll: " + myTreeSetToRemoveAll);
//        System.out.println("treeSetToRemoveAll: " + treeSetToRemoveAll);

        myTreeSet.removeAll(myTreeSetToRemoveAll);
        treeSet.removeAll(treeSetToRemoveAll);
        assertEquals(treeSet.toString(), myTreeSet.toString());
    }

    @Test
    void retainAll() {
        MyTreeSet myTreeSet = new MyTreeSet(new IntComparator());
        MyTreeSet myTreeSetToRetainAll = new MyTreeSet(new IntComparator());
        TreeSet treeSet = fillMyTreeSet(20, 20, myTreeSet);
        TreeSet treeSetToRemoveAll = fillMyTreeSet(10, 20, myTreeSetToRetainAll);

        myTreeSet.retainAll(myTreeSetToRetainAll);
        treeSet.retainAll(treeSetToRemoveAll);
        assertEquals(treeSet.toString(), myTreeSet.toString());

        Exception exception = assertThrows(NullPointerException.class, () -> myTreeSet.retainAll(null));
        assertEquals("Null can't be an argument of method retainAll", exception.getMessage());
    }

    @Test
    void containsAll() {
        MyTreeSet myTreeSetForContainsAll = new MyTreeSet(new IntComparator());
        myTreeSetForContainsAll.add(1);
        myTreeSetForContainsAll.add(3);
        myTreeSetForContainsAll.add(2);
        assertTrue(myTreeSet.containsAll(myTreeSetForContainsAll));
        myTreeSetForContainsAll.add(7);
        assertFalse(myTreeSet.containsAll(myTreeSetForContainsAll));
        Exception exception = assertThrows(NullPointerException.class, () -> myTreeSet.containsAll(null));
        assertEquals("Null can't be an argument of method containsAll", exception.getMessage());
    }

    @Test
    void testToString() {
        MyTreeSet randomMyTreeSet = new MyTreeSet(new IntComparator());
        TreeSet treeSetToCheck = fillMyTreeSet(20, 20, randomMyTreeSet);
        assertEquals(treeSetToCheck.toString(), randomMyTreeSet.toString());
    }

    private static TreeSet fillMyTreeSet(int amount, int diapason, MyTreeSet myTreeSet) {
//      feel MyTreeSet from argument and TreeSet with the same random number
//      returns TreeSet to have ability compare MyTreeSet with java TreeSet
        TreeSet checkTreeSet = new TreeSet(new IntComparator());
        for (int i = 0; i < amount; i++) {
            int currentNumber = (int) (Math.random() * diapason);
            myTreeSet.add(currentNumber);
            checkTreeSet.add(currentNumber);
        }
        return checkTreeSet;
    }
}