package Package.Lesson10;

public class Node {
    private Object data;
    private Node next;

    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Object getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setData(Object object) {
        this.data = object;
    }

    public void setNext(Node next) {
        this.next = next;
    }


}
