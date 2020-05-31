package Package.Lesson9;

import java.util.Arrays;

public final class Lesson9 {
    public static void run(){
        int[] numbers = new int[100];
        for (int i = 0; i < 100; i++) {
            numbers[i] = randomNumber();
        }
        IntCollection intCollection = new IntCollection(numbers);
        System.out.println(Arrays.toString(intCollection.getNumbers()));

        startBlockTest("test find() for not sorted array");
        System.out.println(intCollection.find(15));
        endBlockTest();

        startBlockTest("test find() for sorted array");
        intCollection.sort();
        System.out.println(intCollection.find(15));
        endBlockTest();

        startBlockTest("test fibonacci");
        System.out.println(Fibonacci.determineElement(56));
        System.out.println(Fibonacci.determineElement(300));
        endBlockTest();
    }

    private static int randomNumber(){
        return (int) (Math.random() * 100);
    }


    private static void startBlockTest(String message) {
        printMessage(message);
    }

    private static void endBlockTest() {
        printMessage("test ended");
    }

    private static void printMessage(String message) {
        System.out.print("------------ ");
        System.out.print(message);
        System.out.println(" ------------");
    }
}
