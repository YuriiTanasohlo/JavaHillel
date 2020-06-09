package Package.Lesson11;


import java.util.*;

public class MyLinkedList implements List {

    private int size;
    private Node first;
    private Node last;
    private Node nextNode;

    public MyLinkedList() {
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object object) {
        for (Object currentObject : this) {
            if (currentObject.equals(object)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {

            private Node nextNode = first;

            @Override
            public boolean hasNext() {
                return nextNode != null;
            }

            @Override
            public Object next() {
                Object result = nextNode.data;
                nextNode = nextNode.next;
                return result;
            }
        };
    }

    @Override
    public Object[] toArray() {
        ListIterator listIterator = listIterator();
        Object[] objects = new Object[size];
        while (listIterator.hasNext()) {
            objects[listIterator.nextIndex()] = listIterator.next();
        }
        return objects;
    }

    @Override
    public boolean add(Object object) {
        if (size == 0) {
            first = last = nextNode = new Node(object, null, null);
        } else {
            last.next = new Node(object, null, last);
            last = last.next;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object object) {
        ListIterator listIterator = listIterator();

        while (listIterator.hasNext()) {
            if (listIterator.next().equals(object)) {
                listIterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection collection) {
        return collection.containsAll(this);
    }

    @Override
    public boolean addAll(Collection collection) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return new ListIterator() {

            private Node nextNode = first;
            private int index = 0;

            @Override
            public boolean hasNext() {
                return nextNode != null;
            }

            @Override
            public Object next() {
                Object result = nextNode.data;
                nextNode = nextNode.next;
                index++;
                return result;
            }

            @Override
            public boolean hasPrevious() {
                return nextNode != first;
            }

            @Override
            public Object previous() {
                nextNode = nextNode.previous;
                index--;
                return nextNode.data;
            }

            @Override
            public int nextIndex() {
                return index;
            }

            @Override
            public int previousIndex() {
                return index - 1;
            }

            @Override
            public void remove() {
                if (nextNode == null) {
                    last.previous.next = null;
                    last.previous = last;
                } else if (nextNode.previous != null && nextNode.previous.previous != null) {
                    nextNode.previous.previous.next = nextNode;
                    nextNode.previous = nextNode.previous.previous;
                } else if (nextNode.previous != null) {
                    nextNode.previous = null;
                    first = nextNode;
                }
                size--;
            }

            @Override
            public void set(Object object) {
                nextNode.data = object;
            }

            @Override
            public void add(Object object) {
                if (hasPrevious() && nextNode.next != null) {
                    nextNode.previous.next = nextNode.previous = new Node(object, nextNode, nextNode.previous);
                } else if (!hasPrevious()) {
                    nextNode.previous = first = new Node(object, nextNode, null);
                } else {
                    nextNode.previous = nextNode.previous.next = new Node(object, nextNode, nextNode.previous);
                }
                size++;
            }
        };
    }

    @Override
    public ListIterator listIterator(int index) {
        ListIterator listIterator = listIterator();
        while (listIterator.hasNext()) {
            if (listIterator.nextIndex() == index) {
                return listIterator;
            }
            listIterator.next();
        }
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        ListIterator listIterator = listIterator(fromIndex);
        MyLinkedList myLinkedList = new MyLinkedList();
        while (listIterator.nextIndex() < toIndex) {
            myLinkedList.add(listIterator.next());
        }
        return myLinkedList;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] objects) {
        if (objects.length > size) {
            ListIterator listIterator = listIterator();
            while (listIterator.hasNext()) {
                objects[listIterator.nextIndex()] = listIterator.next();
            }
            return objects;
        } else {
            return toArray();
        }
    }

    @Override
    public String toString() {
        Iterator iterator = iterator();
        String array = "";
        while (iterator.hasNext()) {
            array += (iterator.next() + " ");
        }
        return array;
    }

    private static class Node {
        private Object data;
        private Node next;
        private Node previous;

        public Node(Object data, Node next, Node previous) {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }
    }


}
