package Package.Calc;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Print {
    public void printWelcome()  {
        System.out.println("Welcome to Simple Calculator app!");
        System.out.println("It supports simple operations such as addition, subtraction, multiplication, division and exponentiation.");
        System.out.println("In addition you can use brackets for pointing parts of expressions to be calculated in priority.");
        System.out.println("For tutorial please type \"t\". For exit please type \"q\".");
        System.out.println("Enjoy it :)");
    }

    public void printTutorial()  {
        System.out.println("Type your example and then press \"Enter\".");
        System.out.println("You can type example with simple operators and floating point numbers.");
        System.out.println("Please use char \"+\" for addition, \"-\" for subtraction, \"*\" for multiplication \"/\" for division and \"^\" for exponentiation.");
        System.out.println("Please use char \"(\" as opened bracket and \")\" as closed bracket.");
        System.out.println("You can type expression with multiple operators");
        System.out.println("For example \"5*4.5+4/3^3\"");
        System.out.println("For tutorial please type \"t\". For exit please type \"q\".");
    }

    public void printResult(double result)  {
        System.out.println("Result : " + result);
    }


    public void printLog(String text) {
        Config config = new Config();
        if (config.isTestMode) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss ms");
            LocalDateTime now = LocalDateTime.now();
            System.out.println(dtf.format(now) + ": " + text);
        }
    }
}
