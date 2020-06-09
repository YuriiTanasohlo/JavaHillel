package Package.Lesson11;

import java.util.Iterator;
import java.util.ListIterator;

public final class Lesson11 {
    public static void run(){
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        myLinkedList.add(5);
        Iterator iterator = myLinkedList.iterator();
        Iterator iterator1 = myLinkedList.iterator();
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator1.next());
//        System.out.println(myLinkedList.iterator().next());
//        System.out.println(myLinkedList.iterator().next());
        System.out.println(myLinkedList);
        myLinkedList.remove((Object)2);
        System.out.println(myLinkedList);

        ListIterator listIterator = myLinkedList.listIterator(1);
        System.out.println(listIterator.nextIndex());
        System.out.println(listIterator.next());
        System.out.println(listIterator.next());
        System.out.println(listIterator.next());
    }
}
