package Package.Lesson8;

import java.util.Collection;
import java.util.Iterator;


public class HillelCollection implements Collection {
    private Object[] collection;
    private int size;

    public HillelCollection() {
        this(new Object[0]);
        size = 0;
    }

    public HillelCollection(Object[] collection) {
        this.collection = collection;
        size = collection.length;
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
        return find(object) != -1;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return collectionCopy();
    }

    @Override
    public Object[] toArray(Object[] objects) {
        if (objects.length > collection.length) {
            return collectionCopy(objects);
        } else {
            return toArray();
        }
    }

    @Override
    public boolean add(Object object) {
        if (size < collection.length + 1) {
            increaseCollection();
        }
        collection[size] = object;
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
    public boolean containsAll(Collection collection) {
        if (collection.size() == 0) return false;
        for (int i = 0; i < collection.size(); i++) {
            int index = find(((HillelCollection) collection).getElement(i));
            if (index == -1) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection collection) {
        if (collection.size() == 0) {
            return false;
        }
        if (collection.size() > this.collection.length - size) {
            increaseCollection(collection.size());
        }
        System.arraycopy(collection.toArray(), 0,this.collection , size, collection.size());
        size += collection.size();
        return true;
    }

    @Override
    public boolean removeAll(Collection collection) {
        if (collection.size() == 0) return false;
        boolean success = false;
        for (int i = 0; i < collection.size(); i++) {
            int index = find(collection.toArray()[i]);
            while (index != -1) {
                remove(index);
                success = true;
                index = find(collection.toArray()[i]);
            }
        }
        clean();
        return success;
    }

    @Override
    public boolean retainAll(Collection collection) {
        if (collection.size() == 0) return false;
        int j = 0;
        Object[] collectionCopy = new Object[collection.size()];

        for (int i = 0; i < collection.size(); i++) {
            if (find(collection.toArray()[i]) != -1) {
                collectionCopy[j] = collection.toArray()[i];
                j++;
            }
        }
        size = j;
        this.collection = collectionCopy;
        return j != 0;
    }

    @Override
    public void clear() {
        collection = new Object[0];
        size = 0;
    }

    public Object getElement(int element) {
        if (element < size) {
            return collection[element];
        } else {
            return null;
        }
    }

    private void clean() {
        for (int i = size; i < collection.length; i++) {
            collection[i] = null;
        }
    }

    private void remove(int index) {
        size--;
        System.arraycopy(collection, index + 1, collection, index, size - index);
    }

    private int find(Object object) {
        for (int i = 0; i < size; i++) {
            if (collection[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    private Object[] collectionCopy() {
        Object[] collectionCopy = new Object[size];
        System.arraycopy(collection, 0, collectionCopy, 0, size);
        return collectionCopy;
    }

    private Object[] collectionCopy(Object[] objects) {
        System.arraycopy(collection, 0, objects, 0, size);
        return objects;
    }

    private void increaseCollection() {
        Object[] collectionCopy = new Object[(int) ((collection.length + 1) * 1.5)];
        System.arraycopy(collection, 0, collectionCopy, 0, size);
        collection = collectionCopy;
    }

    private void increaseCollection(int length) {
        Object[] collectionCopy = new Object[collection.length + length];
        System.arraycopy(collection, 0, collectionCopy, 0, size);
        collection = collectionCopy;
    }
}
