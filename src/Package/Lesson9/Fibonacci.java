package Package.Lesson9;

import java.math.BigInteger;

public class Fibonacci {
    public static String determineElement(int iThNumber) {
        if (iThNumber == 1) {
            return "0";
        } else if (iThNumber == 2) {
            return "1";
        } else {
            BigInteger previous = new BigInteger("0");
            BigInteger current = new BigInteger("1");
            BigInteger temp;
            for (int i = 1; i < iThNumber; i++) {
                temp = current;
                current = previous.add(current);
                previous = temp;
            }
            return current.toString();
        }
    }
}
