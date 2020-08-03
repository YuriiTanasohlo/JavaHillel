package Package.Calc;

import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Calc {
    public void runCalc() {
        Print print = new Print();
        print.printWelcome();

        boolean exit = false;
        while (!exit) {


            Scanner input = new Scanner(System.in);
            String exampleString = input.nextLine();

// recognizing the type of operation
            if (exampleString.equals("q")) {
                exit = true;
            } else if (exampleString.equals("t")) {
                print.printTutorial();
            } else {

//  clean the example string from wrong chars

                String cleanedExample = formatExpression(exampleString);
                print.printLog("Cleaned example : " + cleanedExample);
                String rpn = expressionToRPN(cleanedExample);
                print.printLog("RPN : " + rpn);

                print.printResult(PRNtoAnswer(rpn));

            }
        }
    }

    private static String formatExpression(String expression) {
//        (^-)?\\d+\\.?\\d* -  negative number on the beginning of the string, or just numbers on any position of the string (numbers can be floating point number)
//        |\\(\\-\\d+\\.?\\d* - or negative numbers after opened bracket
//        |\\*|\\/|\\+|\\-|\\(|\\)|\\^ - or different operands
        Pattern p = Pattern.compile("(^-)?\\d+\\.?\\d*|\\(\\-\\d+\\.?\\d*|\\*|\\/|\\+|\\-|\\(|\\)|\\^");
        Matcher m = p.matcher(expression);
        String formattedExpression = "";
        while (m.find()) {
            if (m.group().length() > 1) {
//                to add zero to negative operands like: -5-(-5) -> 0-5-(0-5)
                if (m.group().charAt(0) == '-') {
                    formattedExpression += ('0' + m.group());
                } else if (m.group().charAt(0) == '(' && m.group().charAt(1) == '-') {
                    formattedExpression += ("(0" + m.group().substring(1));
                }
            } else {
                formattedExpression += m.group();
            }
        }


        return formattedExpression;
    }

    private static double PRNtoAnswer(String RPN) {
        String operand = "";
        Stack<Double> stack = new Stack<>();

        int RPNLength = RPN.length();

        for (int i = 0; i < RPNLength; i++) {
            if (RPN.charAt(i) == ' ') {
                continue;
            } else if (getPriority(RPN.charAt(i)) == 0) {
                while (RPN.charAt(i) != ' ' && getPriority(RPN.charAt(i)) == 0) {
                    operand += RPN.charAt(i++);
                    if (i == RPNLength) {
                        break;
                    }
                }
                stack.push(Double.parseDouble(operand));
                operand = "";
            }

            if (getPriority(RPN.charAt(i)) > 1) {
                double a = stack.pop();
                double b = stack.pop();

                switch (RPN.charAt(i)) {
                    case '+':
                        stack.push(b + a);
                        break;
                    case '-':
                        stack.push(b - a);
                        break;
                    case '*':
                        stack.push(b * a);
                        break;
                    case '/':
                        stack.push(b / a);
                        break;
                    case '^':
                        stack.push(Math.pow(b, a));
                        break;
                    default:
                        break;
                }

            }
        }
        return stack.pop();
    }

    private static String expressionToRPN(String expression) {
        String current = "";
        Stack<Character> stack = new Stack<>();
        int priority;
        int expressionLength = expression.length();

        for (int i = 0; i < expressionLength; i++) {
            priority = getPriority(expression.charAt(i));

            if (priority == 0) {
                current += expression.charAt(i);
            } else if (priority == 1) {
                stack.push(expression.charAt(i));
            } else if (priority > 1) {
                current += " ";
                while (!stack.empty()) {
                    if (getPriority(stack.peek()) >= priority) {
                        current += stack.pop();
                    } else {
                        break;
                    }
                }
                stack.push(expression.charAt(i));

            } else if (priority == -1) {
                current += " ";
                while (getPriority(stack.peek()) != 1) {
                    current += stack.pop();
                }
                stack.pop();
            }
        }
        while (!stack.empty()) {
            current += stack.pop();
        }
        return current;
    }

    private static int getPriority(char token) {
        int i;
        switch (token) {
            case '^':
                i = 4;
                break;
            case '*':
            case '/':
                i = 3;
                break;
            case '+':
            case '-':
                i = 2;
                break;
            case '(':
                i = 1;
                break;
            case ')':
                i = -1;
                break;
            default:
                i = 0;
        }
        return i;
    }
}
