import java.util.Scanner;

public class SimpleCalc {
    public void run(){
        System.out.print("Please input first number: ");
        Scanner input = new Scanner(System.in);
        double firstNum = Double.parseDouble(input.next());

        System.out.println("Your input " + firstNum + " as a first number.");

        System.out.print("Please input second number: ");
        input = new Scanner(System.in);
        double secondNum = Double.parseDouble(input.next());

        System.out.println("Your");
        System.out.println("Sum is " + (firstNum + secondNum));
        System.out.println("Difference is  " + (firstNum - secondNum));
        System.out.println("Multiplication is " + (firstNum * secondNum));
        System.out.println("Division is " + (firstNum / secondNum));
    }
}
