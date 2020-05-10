package Package.Lesson3;

import java.util.Arrays;
import java.util.Scanner;

public class Calculation {
    public int digitSum(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public void pointAffiliationDefiner(){
        int[] coordinates = new int[6];

        System.out.print("Please input coordinates of the start point of the rectangle in format (X Y): ");
        Scanner input = new Scanner(System.in);
        coordinates[0] = input.nextInt();
        coordinates[3] = input.nextInt();
        System.out.print("Please input coordinates of the end point of the rectangle in format (X Y): ");
        input = new Scanner(System.in);
        coordinates[2] = input.nextInt();
        coordinates[5] = input.nextInt();
        System.out.print("Please input coordinates of the point in format (X Y): ");
        input = new Scanner(System.in);
        coordinates[1] = input.nextInt();
        coordinates[4] = input.nextInt();

        if(isInRectangle(coordinates)){
            System.out.println("The point is in the rectangle.");
        } else {
            System.out.println("The point is out of the rectangle.");
        }
    }

    public boolean isInRectangle(int[] coordinates) {
        if (coordinates[0] <= coordinates[1] && coordinates[1] <= coordinates[2] && coordinates[3] <= coordinates[4] && coordinates[4] <= coordinates[5]) {
            return true;
        } else {
            return false;
        }
    }
}
