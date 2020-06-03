package Package.Lesson10;

import java.util.Arrays;



public final class Lesson10 {
    public static void run(){
        startBlockTest("Initiating new LinkedList, test add(), toArray(), size(), isEmpty(), contains()");
        LinkedList linkedList = new LinkedList();
        System.out.println(linkedList.isEmpty());
        linkedList.add(1);
        System.out.println(linkedList.isEmpty());
        linkedList.add(2);
        linkedList.add(3);
        linkedList.remove(3);
        linkedList.add(3);
        System.out.println(Arrays.toString(linkedList.toArray()));
        System.out.println(linkedList.size());
        System.out.println(linkedList.contains(3));
        System.out.println(linkedList.contains(4));
        endBlockTest();

        startBlockTest("Test remove(), addAll(), removeAll(), clear()");
        linkedList.remove(3);
        System.out.println(Arrays.toString(linkedList.toArray()));
        LinkedList linkedList1 = new LinkedList();
        linkedList1.add(4);
        linkedList1.add(5);
        linkedList1.add(6);
        linkedList1.add(7);
        linkedList.addAll(linkedList1);
        System.out.println(Arrays.toString(linkedList.toArray()));
        linkedList.removeAll(linkedList1);
        System.out.println(Arrays.toString(linkedList.toArray()));
        linkedList.clear();
        System.out.println(Arrays.toString(linkedList.toArray()));
        endBlockTest();

        startBlockTest("Test retainAll(), containsAll(), toArray(o[])");
        linkedList.remove(3);
        System.out.println(Arrays.toString(linkedList.toArray()));
        LinkedList linkedList2 = new LinkedList();
        linkedList2.add(4);
        linkedList2.add(5);
        linkedList2.add(6);
        linkedList2.add(7);
        linkedList2.add(8);
        linkedList2.add(9);
        linkedList2.add(0);
        linkedList.addAll(linkedList2);
        System.out.println(Arrays.toString(linkedList.toArray()));
        linkedList.retainAll(linkedList1);
        System.out.println(Arrays.toString(linkedList.toArray()));
        LinkedList linkedList3 = new LinkedList();
        linkedList3.add(4);
        linkedList3.add(5);
        System.out.println(linkedList.containsAll(linkedList3));
        Object[] array = new Object[8];
        System.out.println(Arrays.toString(linkedList.toArray(array)));
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
