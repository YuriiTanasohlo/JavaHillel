package Package.Lesson20;

public final class QuickSort {
    public static int[] intSort(int[] arrayToBeSorted) {
        int[] returnArray = new int[arrayToBeSorted.length];
        System.arraycopy(arrayToBeSorted, 0, returnArray, 0, arrayToBeSorted.length);
        quickSort(returnArray, 0, returnArray.length - 1);
        return returnArray;
    }

    private static void quickSort(int[] arr, int start, int end) {

        int partition = partition(arr, start, end);

        if (partition - 1 > start) {
            quickSort(arr, start, partition - 1);
        }
        if (partition + 1 < end) {
            quickSort(arr, partition + 1, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
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
