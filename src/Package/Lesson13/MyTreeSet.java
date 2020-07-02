package Package.Lesson13;

import java.util.*;

public class MyTreeSet implements Set {

    private int size;
    private Node root;
    private Comparator comparator;

    public MyTreeSet() {
        root = null;
        size = 0;
        this.comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Comparable) o1).compareTo(o2);
            }
        };
    }

    public void setComparator(Comparator comparator) {
        this.comparator = comparator;
    }

    public MyTreeSet(Comparator comparator) {
        root = null;
        size = 0;
        this.comparator = comparator;

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
        if(size == 0) {
            return false;
        }
        return find(object, root) != null;
    }


    @Override
    public Iterator iterator() {
        return new Iterator() {

            private Node current;


            @Override
            public boolean hasNext() {
                if (current == null) {
                    return size > 0;
                }
                return findNext(root) != null;
            }

            @Override
            public Object next() {
                if (current == null) {
                    current = getFirst(root);
                    return current.data;
                }
                Node next = findNext(root);
                current = next;
                return next.data;
            }

            private Node findNext(Node node) {
                int compared = comparator.compare(node.data, current.data);
                if (compared == 0 && node.right == null) {
                    return null;
                } else if (compared > 0) {
                    if (node.left != null) {
                        Node findLeftNode = findNext(node.left);
                        return findLeftNode == null ? node : findLeftNode;
                    } else {
                        return node;
                    }
                } else {
                    return findNext(node.right);
                }
            }
        };
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        Iterator iterator = this.iterator();
        for (int i = 0; i < size; i++) {
            array[i] = iterator.next();
        }
        return array;
    }

    @Override
    public boolean add(Object object) {
        Node newNode = new Node(object);
        boolean isAdded;
        if (root == null) {
            root = newNode;
            isAdded = true;
        } else {
            isAdded = add(object, root);
        }
        if(isAdded) {
            size++;
        }
        return isAdded;
    }

    @Override
    public boolean remove(Object object) {

        if(find(object, root) == null){
            return false;
        }

        delete(root, object);
        size--;

        return true;
    }

    private Node delete(Node node, Object object) {
        if (node == null) return null;

        if (comparator.compare(object, node.data) < 0) {
            node.left = delete(node.left, object);
        } else if (comparator.compare(object, node.data) > 0) {
            node.right = delete(node.right, object);
        } else {
            if (node.left == null && node.right == null) {
                return null;
            } else if (node.left == null) {
                if(node.equals(root)){
                    root = node.right;
                }
                return node.right;
            } else if (node.right == null) {
                if(node.equals(root)){
                    root = node.left;
                }
                return node.left;
            } else {
                Node firstRightNode = getFirst(node.right);
                node.data = firstRightNode.data;
                node.right = delete(node.right, firstRightNode.data);
            }
        }
        return node;

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
        root = null;
        size = 0;
    }

    @Override
    public boolean removeAll(Collection collection) {
        if (collection.size() == 0) return false;
        boolean isRemovedAll = true;
        for (Object element : collection.toArray()) {
            if (!remove(element)) {
                isRemovedAll = false;
            }
            ;
        }
        return isRemovedAll;
    }

    @Override
    public boolean retainAll(Collection collection) {
        if (collection.size() == 0) return false;
        MyTreeSet retainedMyTreeSet = new MyTreeSet(comparator);
        for (Object element : collection.toArray()) {
            if (contains(element)) {
                retainedMyTreeSet.add(element);
            }
        }
        this.root = retainedMyTreeSet.root;
        this.size = retainedMyTreeSet.size;
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
    public Object[] toArray(Object[] objects) {
        if (objects.length < size) {
            return toArray();
        } else {
            Iterator iterator = this.iterator();
            for (int i = 0; i < size; i++) {
                objects[i] = iterator.next();
            }
            return objects;
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }

    private boolean add(Object object, Node node) {
        int compared = comparator.compare(node.data, object);
        if (compared == 0) {
            return false;
        } else if (compared > 0) {
            if (node.left == null) {
                node.left = new Node(object);
                return true;
            } else {
                return add(object, node.left);
            }
        } else {
            if (node.right == null) {
                node.right = new Node(object);
                return true;
            } else {
                return add(object, node.right);
            }
        }
    }

    private Node find(Object object, Node node) {
        int compared = comparator.compare(node.data, object);
        if (compared == 0) {
            return node;
        } else if (compared > 0 && node.left != null) {
            return find(object, node.left);
        } else if (node.right != null) {
            return find(object, node.right);
        } else {
            return null;
        }
    }

    private Node getFirst(Node node) {
        return node.left == null ? node : getFirst(node.left);
    }

    private static class Node {
        Object data;
        Node left;
        Node right;

        public Node(Object data) {
            this.data = data;
        }
    }
}
