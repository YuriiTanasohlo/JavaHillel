package Package.Lesson2;

import java.util.Arrays;
import java.util.Scanner;

public class Average {

    public void twoNumbersInAverage() {
        System.out.println("Please input two numbers delimited with 'space'");
        System.out.println("For example '5 6'");
        Scanner input = new Scanner(System.in);
        String stringNumbers = input.nextLine();

        String[] arrayOfStringNumbers = stringNumbers.split("\\s+");



        System.out.println("In average: " + ((Double.parseDouble(arrayOfStringNumbers[0]) + Double.parseDouble(arrayOfStringNumbers[1])) / 2) + "\n");
    }

    public void multipleNumbersInAverage() {

        System.out.println("Please input several numbers delimited with 'space'");
        System.out.println("For example '5 6'");
        Scanner input = new Scanner(System.in);
        String stringNumbers = input.nextLine();

        String[] arrayOfStringNumbers = stringNumbers.split("\\s+");

        double sum = 0;
        int i = 0;
        while (i < arrayOfStringNumbers.length) {
            sum += Double.parseDouble(arrayOfStringNumbers[i]);
            i++;
        }

        System.out.println("In average: " + sum / i + "\n");
    }
}
