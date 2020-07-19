package Package.Lesson20;

import java.util.Arrays;

public class Sum {
    private final int[] list;

    public Sum(int[] list) {
//        sorting the array during initiation the class
        if (list.length < 2) throw new IllegalArgumentException();
        this.list = QuickSort.intSort(list);
    }

    public int[] getIndexesOfSum(int sum) {
//        returns indexes of sorted array if found
        int steps = 0;
        if (sum > list[0] && list[0] + list[1] <= sum) {
            for (int i = 0; i < list.length; i++) {
                for (int j = 0; j < list.length; j++) {
                    steps++;
                    if (list[i] + list[j] == sum) {
                        System.out.println("steps: " + steps);
                        return new int[]{i, j};
                    } else if (list[i] + list[j] > sum) {
                        break;
                    }
                }
            }
        }
        System.out.println("steps: " + steps);
        return null;
    }

    public int getNumber(int index){
        return list[index];
    }

    @Override
    public String toString() {
        return "Sum{" +
                "list=" + Arrays.toString(list) +
                '}';

    }
}
