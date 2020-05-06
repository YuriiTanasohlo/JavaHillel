package Package.Lesson2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleCalc2 {


    public void run() {

        String ANSI_RESET = "\u001B[0m";
        String ANSI_BLACK = "\u001B[30m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_YELLOW = "\u001B[33m";
        String ANSI_BLUE = "\u001B[34m";
        String ANSI_PURPLE = "\u001B[35m";
        String ANSI_CYAN = "\u001B[36m";
        String ANSI_WHITE = "\u001B[37m";


        System.out.println("Please input your example in way: " + ANSI_GREEN + "operand" + ANSI_RESET + " + "
                + ANSI_GREEN + "operator" + ANSI_RESET + " + " + ANSI_GREEN + "second operand" + ANSI_RESET + ".");
        System.out.println("Please use char " + ANSI_GREEN + "+" + ANSI_RESET + " for addition, " + ANSI_GREEN + "-"
                + ANSI_RESET + " for subtraction, " + ANSI_GREEN + "*" + ANSI_RESET + " for multiplication and "
                + ANSI_GREEN + "/" + ANSI_RESET + " for division.");
        System.out.println("For example: " + ANSI_GREEN + "4+6" + ANSI_RESET + ".");
        System.out.println("Please do not use spaces.");

        boolean isCorrectExample = false;

        while (!isCorrectExample) {
            Scanner input = new Scanner(System.in);
            String example = input.nextLine();


            Pattern pattern = Pattern.compile("^(\\d+\\.\\d+|\\d+)(\\*|\\/|\\+|\\-)(\\d+\\.\\d+|\\d+)$");
            Matcher matcher = pattern.matcher(example);

            if (matcher.find()) {
                isCorrectExample = true;

                double firstOperand = Double.parseDouble(matcher.group(1));
                double secondOperand = Double.parseDouble(matcher.group(3));
                String operator = matcher.group(2);


                double result;
                boolean isError = false;
                switch (operator) {
                    case "+":
                        result = firstOperand + secondOperand;
                        break;
                    case "-":
                        result = firstOperand - secondOperand;
                        break;
                    case "*":
                        result = firstOperand * secondOperand;
                        break;
                    case "/":
                        result = firstOperand / secondOperand;
                        break;
                    default:
                        isError = true;
                        result = 0;

                }
                if (!isError) {
                    System.out.println(result);
                } else {
                    System.out.println("An error has occurred!");
                }
            } else {
                System.out.println("Enter correct example");
            }
        }
        System.out.println("\n");
    }
}

