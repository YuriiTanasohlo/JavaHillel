package Package.Lesson20;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


class SumTest {

    @Test
    void getIndexesOfSum() {
        int[] testList = {15, 3, 7, 10};
        Sum sum = new Sum(testList);
        System.out.println(sum.toString());


        int[] indexes = sum.getIndexesOfSum(18);

        assertArrayEquals(new int[]{0, 3}, indexes);
        assertEquals(3, sum.getNumber(indexes[0]));
        assertEquals(15, sum.getNumber(indexes[1]));

        System.out.println(indexes[0] + ", " + indexes[1]);
    }
}