package Package.Lesson13;


import java.util.Arrays;
import java.util.Iterator;

public class Lesson13 {


    public static void run(){

        startBlockTest("size() isEmpty() contains(Object object) add(Object object)");
        MyTreeSet myTreeSet = new MyTreeSet(new IntComparator());
        System.out.println("myTreeSet.isEmpty() " + myTreeSet.isEmpty());
        System.out.println("myTreeSet.size() " + myTreeSet.size());
        System.out.println("myTreeSet.add(1) " +  myTreeSet.add(1));
        System.out.println("myTreeSet.add(0) " +  myTreeSet.add(0));
        System.out.println("myTreeSet.add(4) " +  myTreeSet.add(4));
        System.out.println("myTreeSet.add(3) " +  myTreeSet.add(3));
        System.out.println("myTreeSet.add(2) " +  myTreeSet.add(2));
        System.out.println("myTreeSet.add(5) " +  myTreeSet.add(5));
        System.out.println("myTreeSet.isEmpty() " + myTreeSet.isEmpty());
        System.out.println("myTreeSet.size() " + myTreeSet.size());
        System.out.println("myTreeSet" + myTreeSet);
        System.out.println("myTreeSet.contains(7) " + myTreeSet.contains(7));
        System.out.println("myTreeSet.contains(5) " + myTreeSet.contains(5));
        endBlockTest();

        startBlockTest("iterator()");
        Iterator iterator = myTreeSet.iterator();
        System.out.println("iterator.hasNext() " + iterator.hasNext());
        System.out.println("iterator.next() " + iterator.next());
        System.out.println("iterator.next() " + iterator.next());
        System.out.println("iterator.next() " + iterator.next());
        System.out.println("iterator.next() " + iterator.next());
        System.out.println("iterator.next() " + iterator.next());
        System.out.println("iterator.hasNext() " + iterator.hasNext());
        System.out.println("iterator.next() " + iterator.next());
        System.out.println("iterator.hasNext() " + iterator.hasNext());
        endBlockTest();

        startBlockTest("toArray() toString() remove(Object object)");
        System.out.println("Arrays.toString(myTreeSet.toArray()) " + Arrays.toString(myTreeSet.toArray()));
        System.out.println("myTreeSet.remove(3) " + myTreeSet.remove(3));
        System.out.println("myTreeSet.remove(7) " + myTreeSet.remove(7));
        System.out.println("myTreeSet" + myTreeSet);
        endBlockTest();

        startBlockTest("addAll(Collection collection) removeAll(Collection collection) containsAll(Collection collection) retainAll(Collection collection) clear()");
        MyTreeSet myTreeSet1 = new MyTreeSet(new IntComparator());
        System.out.println("myTreeSet1.add(1) " +  myTreeSet1.add(6));

        System.out.println("myTreeSet1.add(7) " +  myTreeSet1.add(7));
        System.out.println("myTreeSet1.add(11) " +  myTreeSet1.add(11));
        System.out.println("myTreeSet1.add(9) " +  myTreeSet1.add(9));
        System.out.println("myTreeSet1.add(8) " +  myTreeSet1.add(8));
        System.out.println("myTreeSet1.add(10) " +  myTreeSet1.add(10));
        System.out.println("myTreeSet1.add(12) " +  myTreeSet1.add(12));
        System.out.println("myTreeSet1" + myTreeSet1);
        System.out.println("myTreeSet1.addAll(myTreeSet) " + myTreeSet1.addAll(myTreeSet));
        System.out.println("myTreeSet1.containsAll(myTreeSet)) " + myTreeSet1.containsAll(myTreeSet));
        System.out.println("myTreeSet1" + myTreeSet1);
        System.out.println("myTreeSet1.removeAll(myTreeSet)) " + myTreeSet1.removeAll(myTreeSet));
        System.out.println("myTreeSet1" + myTreeSet1);
        System.out.println("myTreeSet1.addAll(myTreeSet) " + myTreeSet1.addAll(myTreeSet));
        System.out.println("myTreeSet1.add(3) " +  myTreeSet1.add(3));
        System.out.println("myTreeSet1" + myTreeSet1);
        System.out.println("myTreeSet1.retainAll(myTreeSet)) " + myTreeSet1.retainAll(myTreeSet));
        System.out.println("myTreeSet1" + myTreeSet1);
        myTreeSet1.clear();
        System.out.println("myTreeSet1.clear()");
        System.out.println("myTreeSet1" + myTreeSet1);
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
