package Package.Lesson11;

import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

public final class Lesson11 {
    public static void run(){

        startBlockTest("size() isEmpty()");
        MyLinkedList myLinkedList = new MyLinkedList();
        System.out.println("isEmpty() " + myLinkedList.isEmpty());
        myLinkedList.add(1);
        System.out.println("isEmpty() " + myLinkedList.isEmpty());
        myLinkedList.add(2);
        System.out.println("size() " + myLinkedList.size());
        myLinkedList.add(3);
        myLinkedList.add(4);
        myLinkedList.add(5);
        System.out.println("isEmpty() " + myLinkedList.isEmpty());
        System.out.println("size() " + myLinkedList.size());
        endBlockTest();

        startBlockTest("contains(Object object)");
        System.out.println("contains() " + myLinkedList.contains(3));
        System.out.println("contains() " + myLinkedList.contains(6));
        endBlockTest();

        startBlockTest("Iterator()");
        Iterator iterator = myLinkedList.iterator();
        Iterator iterator1 = myLinkedList.iterator();
        System.out.println("iterator.next() " + iterator.next());
        System.out.println("iterator.next() " + iterator.next());
        System.out.println("iterator1.next() " + iterator1.next());
        System.out.println("iterator.hasNext() " + iterator.hasNext());
        System.out.println("iterator.next() " + iterator.next());
        System.out.println("iterator.next() " + iterator.next());
        System.out.println("iterator.hasNext() " + iterator.hasNext());
        System.out.println("iterator.next() " + iterator.next());
        System.out.println("iterator.hasNext() " + iterator.hasNext());
        endBlockTest();

        startBlockTest("toArray()");
        System.out.println("Arrays.toString(myLinkedList.toArray()) " + Arrays.toString(myLinkedList.toArray()));
        endBlockTest();

        startBlockTest("add(Object object) remove(Object object)");
        MyLinkedList myLinkedList1 = new MyLinkedList();
        System.out.println("myLinkedList1 " + myLinkedList1);
        System.out.println(".add(6) " + myLinkedList1.add(6));
        System.out.println("myLinkedList1 " + myLinkedList1);
        System.out.println(".add(7) " + myLinkedList1.add(7));
        System.out.println("myLinkedList1 " + myLinkedList1);
        System.out.println(".remove((Object)6) " + myLinkedList1.remove((Object)6));
        System.out.println(".remove((Object)9) " + myLinkedList1.remove((Object)9));
        System.out.println("myLinkedList1 " + myLinkedList1);
        System.out.println(".add(8) " + myLinkedList1.add(8));
        System.out.println("myLinkedList1 " + myLinkedList1);
        endBlockTest();

        startBlockTest("containsAll(Collection collection) addAll(Collection collection) addAll(int index, Collection collection)");
        System.out.println("myLinkedList " + myLinkedList);
        System.out.println("myLinkedList.containsAll(myLinkedList1) " + myLinkedList.containsAll(myLinkedList1));
        System.out.println("myLinkedList.addAll(myLinkedList1) " + myLinkedList.addAll(myLinkedList1));
        System.out.println("myLinkedList " + myLinkedList);
        System.out.println("myLinkedList.containsAll(myLinkedList1) " + myLinkedList.containsAll(myLinkedList1));
        System.out.println("myLinkedList.remove((Object)7) " + myLinkedList.remove((Object)7));
        System.out.println("myLinkedList " + myLinkedList);
        System.out.println("myLinkedList.containsAll(myLinkedList1) " + myLinkedList.containsAll(myLinkedList1));
        System.out.println("myLinkedList.addAll(myLinkedList1) " + myLinkedList.addAll(0, myLinkedList1));
        System.out.println("myLinkedList " + myLinkedList);
        endBlockTest();

        startBlockTest("clear()");
        System.out.println("myLinkedList1 " + myLinkedList1);
        myLinkedList1.clear();
        System.out.println("myLinkedList1 " + myLinkedList1);
        System.out.println("myLinkedList1.contains(8)) " + myLinkedList1.contains(8));
        endBlockTest();

        startBlockTest("get(int index) set(int index, Object element) add(int index, Object element) remove(int index)");
        System.out.println("myLinkedList " + myLinkedList);
        System.out.println("myLinkedList.get(0) " + myLinkedList.get(0));
        System.out.println("myLinkedList.get(1) " + myLinkedList.get(1));
        System.out.println("myLinkedList.set(1, 15) " + myLinkedList.set(1, 15));
        myLinkedList.add(1, 16);
        System.out.println("myLinkedList after myLinkedList.add(1, 16) " + myLinkedList);
        System.out.println("myLinkedList.remove(1) " + myLinkedList.remove(1));
        System.out.println("myLinkedList " + myLinkedList);
        endBlockTest();

        startBlockTest("indexOf(Object object)");
        System.out.println("myLinkedList " + myLinkedList);
        System.out.println("myLinkedList.indexOf(0) " + myLinkedList.indexOf(0));
        System.out.println("myLinkedList.indexOf(15) " + myLinkedList.indexOf(15));
        myLinkedList.add(5, 15);
        System.out.println("myLinkedList " + myLinkedList);
        System.out.println("myLinkedList.lastIndexOf(15) after myLinkedList.add(5, 15) " + myLinkedList.lastIndexOf(15));
        endBlockTest();

        startBlockTest("listIterator()");
        myLinkedList.remove(0);
        myLinkedList.remove(0);
        myLinkedList.remove(0);
        myLinkedList.remove(0);
        myLinkedList.remove(0);
        myLinkedList.remove(0);
        System.out.println("myLinkedList " + myLinkedList);
        ListIterator listIterator = myLinkedList.listIterator();
        ListIterator listIterator1 = myLinkedList.listIterator();
        System.out.println("listIterator.hasNext() " + listIterator.hasNext());
        System.out.println("listIterator.next() " + listIterator.next());
        System.out.println("listIterator.next() " + listIterator.next());
        System.out.println("listIterator.hasNext() " + listIterator.hasNext());
        System.out.println("listIterator1.next() " + listIterator1.next());
        System.out.println("listIterator.next() " + listIterator.next());
        System.out.println("listIterator.hasNext() " + listIterator.hasNext());
        System.out.println("listIterator.hasPrevious() " + listIterator.hasPrevious());
        System.out.println("listIterator.previous() " + listIterator.previous());
        System.out.println("listIterator.previous() " + listIterator.previous());
        System.out.println("listIterator.hasPrevious() " + listIterator.hasPrevious());
        System.out.println("listIterator.nextIndex() " + listIterator.nextIndex());
        System.out.println("listIterator.previousIndex() " + listIterator.previousIndex());
        System.out.println("listIterator.previous() " + listIterator.previous());
        System.out.println("listIterator.hasPrevious() " + listIterator.hasPrevious());
        System.out.println("listIterator.next() " + listIterator.next());
        listIterator.remove();
        System.out.println("myLinkedList after remove()" + myLinkedList);
        listIterator.set(9);
        System.out.println("myLinkedList after set(9)" + myLinkedList);
        listIterator.add(10);
        System.out.println("myLinkedList after add(10)" + myLinkedList);
        endBlockTest();

        startBlockTest("listIterator(1)");
        ListIterator listIterator2 = myLinkedList.listIterator(1);
        System.out.println("listIterator2.next() " + listIterator2.next());
        endBlockTest();

        startBlockTest("subList() retainAll()");
        listIterator.add(11);
        listIterator.add(12);
        MyLinkedList myLinkedList2 = (MyLinkedList)myLinkedList.subList(2, 5);
        System.out.println("myLinkedList " + myLinkedList);
        System.out.println("myLinkedList2 " + myLinkedList2);
        System.out.println("myLinkedList.retainAll(myLinkedList2) " + myLinkedList.retainAll(myLinkedList2));
        System.out.println("myLinkedList " + myLinkedList);
        System.out.println("myLinkedList2.remove(12) " + myLinkedList2.remove((Object)12));
        System.out.println("myLinkedList.removeAll(myLinkedList2) " + myLinkedList.removeAll(myLinkedList2));
        System.out.println("myLinkedList " + myLinkedList);
        endBlockTest();

    }

    private static void startBlockTest(String message) {
        printMessage(message);
    }

    private static void endBlockTest() {
        printMessage("test ended");
    }

    private static void printMessage(String message) {
        System.out.print("------------ ");
        System.out.print(message);
        System.out.println(" ------------");
    }
}
