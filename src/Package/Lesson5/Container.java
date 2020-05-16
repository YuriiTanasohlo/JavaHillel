package Package.Lesson5;

public class Container {

    private int[] container;

    public Container() {
    }

    public Container(int[] container) {
        this.container = this.arrayCopy(container);
    }

    public enum type {
        ASC,
        DESC
    }

    public int[] getContainer() {
        return arrayCopy(container);
    }

    public void setContainer(int[] container) {
        this.container = container;
    }

    public void setElement(int value, int index) {
        this.container[index] = value;
    }

    public int getElement(int index) {
        return this.container[index];
    }

    public void addElement(int value) {
        addElement(value, container.length);
    }

    public void addElement(int value, int index) {
        int[] containerCopy = arrayCopy(container, container.length + 1);
        containerCopy[index] = value;
        for (int i = index; i < containerCopy.length - 1; i++) {
            containerCopy[i + 1] = container[i];
        }
        container = containerCopy;
    }

    public boolean hasElement(int value) {
        for (int element : container) {
            if (element == value) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(int value) {
        for (int i = 0; i < container.length; i++) {
            if (container[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public int length() {
        return this.container.length;
    }

    public void print() {
        String string = "";
        for (int i : container) {
            string += i + " ";
        }
        System.out.println("Container: " + string);
    }

    public void addContainer(Container container) {
        addContainer(container, this.container.length);
    }

    public void addContainer(Container container, int index) {
        int[] containerCopy = arrayCopy(this.container, this.container.length + container.length());
        int length = index + container.length();
        for (int i = index; i < length; i++) {
            containerCopy[i] = container.container[i - index];
        }
        for (int i = index + container.length(); i < containerCopy.length; i++) {
            containerCopy[i] = this.container[i - container.length()];
        }
        this.container = containerCopy;
    }

    public boolean isEqual(Container container) {
        if (this.container.length != container.length()) {
            return false;
        } else {
            for (int i = 0; i < this.container.length; i++) {
                if (this.container[i] != container.getElement(i)) {
                    return false;
                }
            }
            return true;
        }
    }

    //it's gonna be a quicksort algorithm
    public void sort() {
        quickSort(container, 0, container.length - 1);
    }

    private void quickSort(int[] arr, int start, int end) {

        int partition = partition(arr, start, end);

        if (partition - 1 > start) {
            quickSort(arr, start, partition - 1);
        }
        if (partition + 1 < end) {
            quickSort(arr, partition + 1, end);
        }
    }

    private int partition(int[] arr, int start, int end) {
        int pivot = arr[end];

        for (int i = start; i < end; i++) {
            if (arr[i] < pivot) {
                int temp = arr[start];
                arr[start] = arr[i];
                arr[i] = temp;
                start++;
            }
        }

        int temp = arr[start];
        arr[start] = pivot;
        arr[end] = temp;

        return start;
    }

    public void clean() {
        container = new int[]{};
    }

    private int[] arrayCopy(int[] array) {
        return arrayCopy(array, array.length);
    }

    private int[] arrayCopy(int[] array, int arrayLength) {
        int[] arrayCopy = new int[arrayLength];
        System.arraycopy(array, 0, arrayCopy, 0, array.length);
        return arrayCopy;
    }


}
