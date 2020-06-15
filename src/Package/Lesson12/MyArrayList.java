package Package.Lesson12;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyArrayList implements List {

    private int size;
    private Object[] list;

    public MyArrayList() {
        this.size = 0;
        this.list = new Object[0];
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
        return find(object) == -1;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {

            private int next = 0;

            @Override
            public boolean hasNext() {
                return next < size;
            }

            @Override
            public Object next() {
                Object nextObject = list[next];
                next++;
                return nextObject;
            }
        };
    }

    @Override
    public Object[] toArray() {
        return listCopy();
    }

    @Override
    public boolean add(Object object) {
        if (size < list.length + 1) {
            increaseList();
        }
        list[size] = object;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object object) {
        int index = find(object);
        if (index != -1) {
            remove(index);
            clean();
            return true;
        }
        return false;
    }

    @Override
    public boolean addAll(Collection collection) {
        if (collection.size() == 0) {
            return false;
        }
        if (collection.size() > list.length - size) {
            increaseList(collection.size());
        }
        System.arraycopy(collection.toArray(), 0, list, size, collection.size());
        size += collection.size();
        return true;
    }

    @Override
    public boolean addAll(int index, Collection collection) {
        if (collection.size() == 0) return false;

        if (collection.size() > list.length - size) {
            increaseList(collection.size());
        }

        System.arraycopy(list, index, list, index + collection.size(), size - index);
        System.arraycopy(collection.toArray(), 0, list, index, collection.size());
        size += collection.size();
        return true;
    }

    @Override
    public void clear() {
        size = 0;
        list = new Object[0];
    }

    @Override
    public Object get(int index) {
        return list[index];
    }

    @Override
    public Object set(int index, Object element) {
        Object currentElement = list[index];
        list[index] = element;
        return currentElement;
    }

    @Override
    public void add(int index, Object element) {
        if (size < list.length + 1) {
            increaseList();
        }

        System.arraycopy(list, index, list, index + 1, size - index);
        list[index] = element;
        size ++;
    }

    @Override
    public Object remove(int index) {
        Object returnObject = list[index];
        size--;
        System.arraycopy(list, index + 1, list, index, size - index);
        clean();
        return returnObject;
    }

    @Override
    public int indexOf(Object object) {
        return find(object);
    }

    @Override
    public int lastIndexOf(Object object) {
        int currentIndex = 0;
        int lastIndex = -1;
        while (currentIndex != -1){
            currentIndex = find(currentIndex + 1, object);
            if(currentIndex != -1){
                lastIndex = currentIndex;
            }
        }
        return lastIndex;
    }

    @Override
    public ListIterator listIterator() {
        return new ListIterator() {
            private int next = 0;

            @Override
            public boolean hasNext() {
                return next < size;
            }

            @Override
            public Object next() {
                Object nextObject = list[next];
                next++;
                return nextObject;
            }

            @Override
            public boolean hasPrevious() {
                return next > 0;
            }

            @Override
            public Object previous() {
                Object previousObject = list[next-1];
                next--;
                return previousObject;
            }

            @Override
            public int nextIndex() {
                return next;
            }

            @Override
            public int previousIndex() {
                return next - 1;
            }

            @Override
            public void remove() {
                System.arraycopy(list, next + 1, list, next, size - next);
                size--;
            }

            @Override
            public void set(Object object) {
                list[next] = object;
            }

            @Override
            public void add(Object object) {
                if (size < list.length + 1) {
                    increaseList();
                }
                list[size] = object;
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
        List subList = new MyArrayList();
        while (listIterator.nextIndex() < toIndex){
            subList.add(listIterator.next());
        }
        return subList;
    }

    @Override
    public boolean retainAll(Collection collection) {
        ListIterator listIterator = listIterator();
        MyArrayList myArrayList = new MyArrayList();
        while (listIterator.hasNext()) {
            Object currentElement = listIterator.next();
            for (Object element : collection.toArray()) {
                if (currentElement.equals(element)) myArrayList.add(element);
            }
        }
        size = myArrayList.size;
        list = myArrayList.toArray();
        return true;
    }

    @Override
    public boolean removeAll(Collection collection) {
        if (collection.size() == 0) return false;

        boolean isRemovedAll = true;
        for (Object element : collection.toArray()) {
            if (!remove(element)) isRemovedAll = false;
        }
        return isRemovedAll;
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
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public String toString() {
        if (size == 0) return "[]";
        String result = "[";
        for (int i = 0; i < size; i++) {
            result += list[i] + ", ";
        }
        result = result.substring(0, result.length() - 2);
        result += "]";
        return result;
    }

    private void clean() {
        for (int i = size; i < list.length; i++) {
            list[i] = null;
        }
    }

    private int find(Object object) {
        return find(0, object);
    }

    private int find(int index, Object object) {
        for (int i = index; i < size; i++) {
            if (list[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    private Object[] listCopy() {
        Object[] listCopy = new Object[size];
        System.arraycopy(list, 0, listCopy, 0, size);
        return listCopy;
    }

    private Object[] listCopy(Object[] objects) {
        System.arraycopy(list, 0, objects, 0, size);
        return objects;
    }

    private void increaseList() {
        Object[] listCopy = new Object[(int) ((list.length + 1) * 1.5)];
        System.arraycopy(list, 0, listCopy, 0, size);
        list = listCopy;
    }

    private void increaseList(int length) {
        Object[] listCopy = new Object[list.length + length];
        System.arraycopy(list, 0, listCopy, 0, size);
        list = listCopy;
    }
}
