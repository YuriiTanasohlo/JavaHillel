package Package.Calc;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
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
                Pattern p = Pattern.compile("\\d+\\.\\d+|\\d+|\\*|\\/|\\+|\\-");
                Matcher m = p.matcher(exampleString);
                String cleanedExample = "";
                while (m.find()) {
                    cleanedExample += m.group();
                }
                print.printLog("Cleaned example : " + cleanedExample);

// creating objects of operators and operands
                List<String> operators = new <String>LinkedList();
                List<Double> operands = new <Double>LinkedList();

//parsing operators
                p = Pattern.compile("\\*|\\/|\\+|\\-");
                m = p.matcher(cleanedExample);
                while (m.find()) {
                    operators.add(m.group());
                }

//parsing operands
                p = Pattern.compile("\\d+\\.\\d+|\\d+");
                m = p.matcher(cleanedExample);

                while (m.find()) {
                    operands.add(Double.parseDouble(m.group()));
                }

                print.printLog("Operators count : " + operators.size());
                print.printLog("Operands count: " + operands.size());


//check if the parsed data is valid
                if (operators.size() < 1 || operators.size() + 1 != operands.size()) {
//
                    print.printNullException();
                } else {

//calculation
                    while (operators.size() > 0) {
                        print.printLog("Main iteration");
                        int a = 0;
                        while (a < operators.size()) {
                            print.printLog("Second lay iteration");
                            print.printLog("Operators : " + operators);
                            print.printLog("Operands : " + operands);
                            print.printLog("A : " + a);
                            print.printLog("Operators count : " + operators.size());

                            if (operators.get(a).equals("*")) {
                                operands.set(a, operands.get(a) * operands.get(a + 1));
                                operands.remove(a + 1);
                                operators.remove(a);
                            } else if (operators.get(a).equals("/")) {
                                operands.set(a, operands.get(a) / operands.get(a + 1));
                                operands.remove(a + 1);
                                operators.remove(a);
                            } else if (a + 1 < operators.size()) {
                                if (operators.get(a).equals("+") && !(operators.get(a + 1).equals("*") || operators.get(a + 1).equals("/"))) {
                                    print.printLog("Central calc block is working " + operators.get(a + 1).equals("*") + " " + operators.get(a + 1).equals("/"));
                                    operands.set(a, operands.get(a) + operands.get(a + 1));
                                    operands.remove(a + 1);
                                    operators.remove(a);

                                } else if (operators.get(a).equals("-") && !(operators.get(a + 1).equals("*") || operators.get(a + 1).equals("/"))) {
                                    print.printLog("Central calc block is working " + operators.get(a + 1).equals("*") + " " + operators.get(a + 1).equals("/"));
                                    operands.set(a, operands.get(a) - operands.get(a + 1));
                                    operands.remove(a + 1);
                                    operators.remove(a);
                                } else {
                                    a++;
                                }
                            } else {
                                if (operators.get(a).equals("+")) {
                                    operands.set(a, operands.get(a) + operands.get(a + 1));
                                    operands.remove(a + 1);
                                    operators.remove(a);
                                } else if (operators.get(a).equals("-")) {
                                    operands.set(a, operands.get(a) - operands.get(a + 1));
                                    operands.remove(a + 1);
                                    operators.remove(a);
                                } else {
                                    a++;
                                }


                            }
                        }
                    }
//result
                    print.printResult(operands.get(0));
                }
            }
        }
    }
}
