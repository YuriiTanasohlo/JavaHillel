package Package.Lesson26;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static jdk.nashorn.internal.objects.NativeMath.round;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleFuncTest {

    @Test
    void mean() {
        List<Double> numbers = new ArrayList<>();

        int iterations = 100;
        double min = -100.0;
        double max = 100.0;
        double expectedResult = 0;
        for (int i = 0; i < iterations; i++) {
            double randomDouble = (Math.random() * ((max - min) + 1)) + min;
            numbers.add(randomDouble);
            expectedResult += randomDouble;
        }
        expectedResult /= iterations;

        assertEquals(round(SimpleFunc.mean(numbers), 4), round(expectedResult, 4));
    }

    @Test
    void sumOfSquaresOfEvenNumbers() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(4);
        numbers.add(3);
        numbers.add(2);

        assertEquals(SimpleFunc.sumOfSquaresOfEvenNumbers(numbers), 20);
    }
}