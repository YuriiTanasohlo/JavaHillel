package Package.Lessons12;


import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

public final class Lesson12 {


    public static void run(){

        startBlockTest("size() isEmpty()");
        MyArrayList myArrayList = new MyArrayList();
        System.out.println("isEmpty() " + myArrayList.isEmpty());
        myArrayList.add(10);
        System.out.println("isEmpty() " + myArrayList.isEmpty());
        myArrayList.add(20);
        System.out.println("size() " + myArrayList.size());
        myArrayList.add(30);
        myArrayList.add(40);
        myArrayList.add(50);
        System.out.println("isEmpty() " + myArrayList.isEmpty());
        System.out.println("size() " + myArrayList.size());
        endBlockTest();

        startBlockTest("contains(Object object)");
        System.out.println("contains() " + myArrayList.contains(3));
        System.out.println("contains() " + myArrayList.contains(6));
        endBlockTest();

        startBlockTest("Iterator()");
        Iterator iterator = myArrayList.iterator();
        Iterator iterator1 = myArrayList.iterator();
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
        System.out.println("Arrays.toString(myArrayList.toArray()) " + Arrays.toString(myArrayList.toArray()));
        endBlockTest();

        startBlockTest("add(Object object) remove(Object object)");
        MyArrayList myArrayList1 = new MyArrayList();
        System.out.println("myArrayList1 " + myArrayList1);
        System.out.println(".add(6) " + myArrayList1.add(60));
        System.out.println("myArrayList1 " + myArrayList1);
        System.out.println(".add(7) " + myArrayList1.add(70));
        System.out.println("myArrayList1 " + myArrayList1);
        System.out.println(".remove((Object)6) " + myArrayList1.remove((Object)6));
        System.out.println(".remove((Object)9) " + myArrayList1.remove((Object)9));
        System.out.println("myArrayList1 " + myArrayList1);
        System.out.println(".add(8) " + myArrayList1.add(80));
        System.out.println("myArrayList1 " + myArrayList1);
        endBlockTest();

        startBlockTest("containsAll(Collection collection) addAll(Collection collection) addAll(int index, Collection collection)");
        System.out.println("myArrayList " + myArrayList);
        System.out.println("myArrayList.containsAll(myArrayList1) " + myArrayList.containsAll(myArrayList1));
        System.out.println("myArrayList.addAll(myArrayList1) " + myArrayList.addAll(myArrayList1));
        System.out.println("myArrayList " + myArrayList);
        System.out.println("myArrayList.containsAll(myArrayList1) " + myArrayList.containsAll(myArrayList1));
        System.out.println("myArrayList.remove((Object)7) " + myArrayList.remove((Object)7));
        System.out.println("myArrayList " + myArrayList);
        System.out.println("myArrayList.containsAll(myArrayList1) " + myArrayList.containsAll(myArrayList1));
        System.out.println("myArrayList.addAll(myArrayList1) " + myArrayList.addAll(1, myArrayList1));
        System.out.println("myArrayList " + myArrayList);
        endBlockTest();

        startBlockTest("clear()");
        System.out.println("myArrayList1 " + myArrayList1);
        myArrayList1.clear();
        System.out.println("myArrayList1 " + myArrayList1);
        System.out.println("myArrayList1.contains(8)) " + myArrayList1.contains(8));
        endBlockTest();

        startBlockTest("get(int index) set(int index, Object element) add(int index, Object element) remove(int index)");
        System.out.println("myArrayList " + myArrayList);
        System.out.println("myArrayList.get(0) " + myArrayList.get(0));
        System.out.println("myArrayList.get(1) " + myArrayList.get(1));
        System.out.println("myArrayList.set(1, 15) " + myArrayList.set(1, 15));
        myArrayList.add(1, 16);
        System.out.println("myArrayList after myArrayList.add(1, 16) " + myArrayList);
        System.out.println("myArrayList.remove(1) " + myArrayList.remove(1));
        System.out.println("myArrayList " + myArrayList);
        endBlockTest();

        startBlockTest("indexOf(Object object)");
        System.out.println("myArrayList " + myArrayList);
        System.out.println("myArrayList.indexOf(0) " + myArrayList.indexOf(0));
        System.out.println("myArrayList.indexOf(15) " + myArrayList.indexOf(15));
        myArrayList.add(5, 15);
        System.out.println("myArrayList " + myArrayList);
        System.out.println("myArrayList.lastIndexOf(15) after myArrayList.add(5, 15) " + myArrayList.lastIndexOf(15));
        endBlockTest();

        startBlockTest("listIterator()");
        myArrayList.remove(0);
        myArrayList.remove(0);
        myArrayList.remove(0);
        myArrayList.remove(0);
        myArrayList.remove(0);
        myArrayList.remove(0);
        System.out.println("myArrayList " + myArrayList);
        ListIterator listIterator = myArrayList.listIterator();
        ListIterator listIterator1 = myArrayList.listIterator();
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
        System.out.println("myArrayList after remove()" + myArrayList);
        listIterator.set(90);
        System.out.println("myArrayList after set(90)" + myArrayList);
        listIterator.add(100);
        System.out.println("myArrayList after add(100)" + myArrayList);
        endBlockTest();

        startBlockTest("listIterator(1)");
        ListIterator listIterator2 = myArrayList.listIterator(1);
        System.out.println("listIterator2.next() " + listIterator2.next());
        endBlockTest();

        startBlockTest("subList() retainAll()");
        listIterator.add(110);
        listIterator.add(120);
        MyArrayList myArrayList2 = (MyArrayList)myArrayList.subList(2, 5);
        System.out.println("myArrayList " + myArrayList);
        System.out.println("myArrayList2 " + myArrayList2);
        System.out.println("myArrayList.retainAll(myArrayList2) " + myArrayList.retainAll(myArrayList2));
        System.out.println("myArrayList " + myArrayList);
        System.out.println("myArrayList2.remove(120) " + myArrayList2.remove((Object)120));
        System.out.println("myArrayList.removeAll(myArrayList2) " + myArrayList.removeAll(myArrayList2));
        System.out.println("myArrayList " + myArrayList);
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
