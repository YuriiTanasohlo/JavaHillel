import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Print {
    public void printWelcome()  {
        System.out.println("Welcome to Simple Calculator app!");
        System.out.println("It supports simple operations such as addition, subtraction, multiplication and division.");
        System.out.println("For tutorial please type \"t\". For exit please type \"q\".");
        System.out.println("Enjoy it :)");
    }

    public void printTutorial()  {
        System.out.println("Type your example and then press \"Enter\".");
        System.out.println("You can type example with simple operators and floating point numbers.");
        System.out.println("Please use char \"+\" for addition, \"-\" for subtraction, \"*\" for multiplication and \"\\\" for division.");
        System.out.println("You can type example with multiple operators");
        System.out.println("For example \"5*4.5+4\\3\"");
        System.out.println("For tutorial please type \"t\". For exit please type \"q\".");
    }

    public void printNullException()  {
        System.out.println("Something went wrong. Maybe the entered example is not valid");
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
