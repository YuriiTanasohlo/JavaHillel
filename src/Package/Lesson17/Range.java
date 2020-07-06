package Package.Lesson17;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class Range<E> implements Collection<E> {

    private E[] range;
    private int size;

    public Range() {
        range = (E[]) new Object[0];
        size = 0;
    }

    public Range(E[] range) {
        this.range = range;
        size = range.length;
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
    public boolean contains(Object o) {
        return find(o) != -1;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int next = 0;

            @Override
            public boolean hasNext() {
                return next < size;
            }

            @Override
            public E next() {
                E nextE = range[next];
                next++;
                return nextE;
            }
        };
    }

    @Override
    public E[] toArray() {
        E[] rangeCopy = (E[]) new Object[size];
        System.arraycopy(range, 0, rangeCopy, 0, size);
        return rangeCopy;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length >= size) {
            System.arraycopy(range, 0, a, 0, size);
            return a;
        } else {
            return toArray(Arrays.copyOf(a, size));
        }
    }


    @Override
    public boolean add(E e) {
        if (size < range.length + 1) {
            increaseCollection();
        }
        range[size] = e;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = find(o);
        if (index != -1) {
            remove(index);
            clean();
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        if (c.size() == 0) return false;
        for (int i = 0; i < c.size(); i++) {
            int index = find(c.toArray()[i]);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection c) {
        if (c.size() == 0) {
            return false;
        }
        if (c.size() > range.length - size) {
            increaseCollection(c.size());
        }
        System.arraycopy(c.toArray(), 0, range, size, c.size());
        size += c.size();
        return true;
    }

    @Override
    public boolean removeAll(Collection c) {
        if (c.size() == 0) return false;
        boolean success = false;
        for (int i = 0; i < c.size(); i++) {
            int index = find(c.toArray()[i]);
            while (index != -1) {
                remove(index);
                success = true;
                index = find(c.toArray()[i]);
            }
        }
        clean();
        return success;
    }

    @Override
    public boolean retainAll(Collection c) {
        boolean success = false;
        for (E e : range) {
            if (!c.contains(e)) {
                remove(e);
                success = true;
            }
        }
        return success;
    }

    @Override
    public void clear() {
        range = (E[]) new Object[0];
        size = 0;
    }


    private void clean() {
        for (int i = size; i < range.length; i++) {
            range[i] = null;
        }
    }

    private void remove(int index) {
        size--;
        System.arraycopy(range, index + 1, range, index, size - index);
    }

    private int find(Object object) {
        for (int i = 0; i < size; i++) {
            if (range[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    private void increaseCollection() {
        E[] rangeCopy = (E[]) new Object[(int) ((range.length + 1) * 1.5)];
        System.arraycopy(range, 0, rangeCopy, 0, size);
        range = rangeCopy;
    }

    private void increaseCollection(int length) {
        E[] rangeCopy = (E[]) new Object[range.length + length];
        System.arraycopy(range, 0, rangeCopy, 0, size);
        range = rangeCopy;
    }
}
