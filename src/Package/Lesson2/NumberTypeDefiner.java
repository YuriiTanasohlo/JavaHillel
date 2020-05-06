package Package.Lesson2;

import java.util.Scanner;

public class NumberTypeDefiner {
    public void isEvenDefiner() {
        System.out.println("Enter an integer number. For example 5 or 11");
        Scanner input = new Scanner(System.in);
        int number = Integer.parseInt(input.nextLine());
        if (number % 2 == 0) {
            System.out.println("This is an even number.");
        } else {
            System.out.println("This is an odd number.");
        }
        System.out.println("\n");
    }

    public void isPrimeDefiner() {
        System.out.println("Enter an integer number from 1 to 1 000 000");


        Scanner input = new Scanner(System.in);
        int number = Integer.parseInt(input.nextLine());

        if (number == 1) {
            System.out.println(number + " - is a prime number.");
        } else if (number > 1 && number <= 1000000) {

            boolean isDefined = false;
            int i = 2;
            int limit = number / 2;

            while (i <= limit) {
                if (number % i == 0) {
                    isDefined = true;
                    System.out.println(number + " - is not a prime number.");
                    break;
                } else {
                    i++;
                }
            }
            if (!isDefined) {
                System.out.println(number + " - is a prime number.");
            }
        } else {
            System.out.println("Wrong entering.");
        }
        System.out.println("\n");
    }

    public void defineMultipleOfNumbers() {
        System.out.println("Enter an integer number from 1 to 1 000 000");

        Scanner input = new Scanner(System.in);
        int number = Integer.parseInt(input.nextLine());

        if (number > 0 && number <= 1000000) {

            boolean isDefined = false;

            int limit = number / 2;

            System.out.print("Number " + number + " is multiple to: ");

            for (int i = 1; i <= limit; i++) {
                if (number % i == 0) {
                    System.out.print(i + " ");
                    isDefined = true;
                }
                i++;

            }
            if(!isDefined){
                System.out.println("No such numbers.");
            }
        } else {
            System.out.println("Wrong entering.");
        }
        System.out.println("\n");
    }
}
