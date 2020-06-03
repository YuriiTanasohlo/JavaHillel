package Package.Lesson10;


import java.util.Collection;
import java.util.Iterator;

public class LinkedList implements Collection {
    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private Node head;
    private Node tail;
    private int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean contains(Object object) {
        Node current = head;
        while (current != null) {
            if (current.getData().equals(object)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node current = head;
        for (int i = 0; current != null; i++) {
            array[i] = current.getData();
            current = current.getNext();

        }
        return array;
    }

    @Override
    public boolean add(Object object) {
        if (size == 0) {
            head = tail = new Node(object, null);
        } else {
            tail.setNext(new Node(object, null));
            tail = tail.getNext();
        }
        size++;

        return true;
    }

    @Override
    public boolean remove(Object object) {
        Node current = head;
        Node previous = null;
        while (current != null) {
            if (current.getData().equals(object)) {
                if (previous == null) {
                    head = head.getNext();
                } else {
                    if (current == tail) {
                        tail = previous;
                    }
                    previous.setNext(current.getNext());
                }
                size--;
                return true;
            }
            previous = current;
            current = current.getNext();
        }
        return false;
    }

    @Override
    public boolean addAll(Collection collection) {
        if (collection.size() == 0) return false;
        for (Object element : collection.toArray()) {
            add(element);
        }
        return true;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean retainAll(Collection collection) {
        Node current = head;
        size = 0;
        LinkedList linkedList = new LinkedList();
        while (current != null) {
            for (Object element : collection.toArray()) {
                if (current.getData().equals(element)) {
                    linkedList.add(element);
                    size++;
                }
            }
            current = current.getNext();
        }
        head = linkedList.head;
        return false;
    }

    @Override
    public boolean removeAll(Collection collection) {
        if (collection.size() == 0) return false;
        for (Object element : collection.toArray()) {
            remove(element);
        }
        return true;
    }

    @Override
    public boolean containsAll(Collection collection) {
        if (collection.size() == 0) return false;
        for (Object element : collection.toArray()) {
            if (!contains(element)) return false;
        }
        return true;
    }

    @Override
    public Object[] toArray(Object[] array) {
        if (array.length < size) return toArray();
        Node current = head;
        for (int i = 0; current != null; i++) {
            array[i] = current.getData();
            current = current.getNext();

        }
        return array;
    }
}
