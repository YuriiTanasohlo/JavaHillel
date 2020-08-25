package Package.Lesson26;

import java.math.BigDecimal;
import java.util.List;

public class SimpleFunc {
    static public Double mean(List<Double> numbers) {

        if(numbers.size() == 0){
            throw new IllegalArgumentException("List shouldn't be empty");
        }

        BigDecimal sum = BigDecimal.valueOf(0);
        for (Double number : numbers) {
            sum = sum.add(BigDecimal.valueOf(number));
        }
        return sum.divide(BigDecimal.valueOf(numbers.size() * 1.0)).doubleValue();
    }

    static public int sumOfSquaresOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream().map(n -> n * n).filter(n -> n % 2 == 0).mapToInt(n -> n).sum();
    }
}
