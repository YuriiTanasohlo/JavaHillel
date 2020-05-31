package Package.Lesson9;

public class IntCollection {
    private int[] numbers = new int[0];
    private int size;
    private boolean isSorted;


    public IntCollection(int[] numbers) {
        this.numbers = numbers;
        size = numbers.length;
        isSorted = false;
    }

    public boolean sort() {
        quickSort(numbers, 0, size - 1);
        isSorted = true;
        return true;
    }

    public boolean find(int number) {
        if (isSorted) {
            return findSorted(number);
        } else {
            for (int i = 0; i < size; i++) {
                if (numbers[i] == number) {
                    System.out.println("Amount of iterations: " + i);
                    return true;
                }
            }
        }
        return false;
    }

    private boolean findSorted(int number) {
        int min = 0;
        int max = size;
        int current;
        while (true) {
            if(max - min <= 1) return false;
            current = (max + min) / 2;
            System.out.println("current position: " + current + ", min position: "
                    + min + ", max position: " + max + ", current value: " + numbers[current]);
            if (numbers[current] == number) {
                return true;
            } else if (numbers[current] > number) {
                max = current;
            } else if (numbers[current] < number) {
                min = current;
            }
        }
    }

    public int[] getNumbers() {
        int[] arrayCopy = new int[size];
        System.arraycopy(numbers, 0, arrayCopy, 0, size);
        return arrayCopy;
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

}
