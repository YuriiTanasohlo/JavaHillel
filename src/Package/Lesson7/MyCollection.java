package Package.Lesson7;

public final class MyCollection {
    private Object[] collection;
    private int size;

    public MyCollection() {
        this(new Object[1]);
        size = 0;
    }

    public MyCollection(Object[] collection) {
        this.collection = collection;
        size = collection.length;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object object) {
        return find(object) != -1;
    }

    public boolean add(Object object) {
        if (size < collection.length + 1) {
            increaseCollection();
        }
        collection[size] = object;
        size++;
        return true;
    }

    public boolean remove(Object object) {
        int index = find(object);
        if (index != -1) {
            remove(index);
            clean();
            return true;
        }
        return false;
    }

    public boolean addAll(MyCollection collection) {
        if (collection.size == 0) {
            return false;
        }
        if (collection.size > this.collection.length - size) {
            increaseCollection(collection.size);
        }
        for (int i = size; i < size + collection.size; i++) {
            this.collection[i] = collection.getElement(i - size);
        }
        size += collection.size;
        return true;
    }

    public void clear() {
        collection = new Object[1];
        size = 0;
    }

    public boolean retainAll(MyCollection collection) {
        if (collection.size == 0) return false;
        int j = 0;
        Object[] collectionCopy = new Object[collection.size];

        for (int i = 0; i < collection.size; i++) {
            if (find(collection.getElement(i)) != -1) {
                collectionCopy[j] = collection.getElement(i);
                j++;
            }
        }
        size = j;
        this.collection = collectionCopy;
        return j != 0;
    }

    public boolean removeAll(MyCollection collection) {
        if (collection.size == 0) return false;
        boolean success = false;
        for (int i = 0; i < collection.size; i++) {
            int index = find(collection.getElement(i));
            if (index != -1) {
                remove(index);
                success = true;
            }
        }
        clean();
        return success;
    }

    public boolean containsAll(MyCollection collection){
        if (collection.size == 0) return false;
        for (int i = 0; i < collection.size; i++) {
            int index = find(collection.getElement(i));
            if (index == -1) {
                return false;
            }
        }
        return true;
    }

    public Object getElement(int element) {
        if (element < size) {
            return collection[element];
        } else {
            return null;
        }
    }

    private void clean(){
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
