package Package.Lesson2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class DepositCalculator {

    public static double roundMoneyToCent(double value) {
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public void run() {

        String ANSI_RESET = "\u001B[0m";
        String ANSI_GREEN = "\u001B[32m";


        System.out.println("Please input " + ANSI_GREEN + "amount of deposit money (UAH)" + ANSI_RESET + ", "
                + ANSI_GREEN + "annual interest rate (percents)" + ANSI_RESET + " and " + ANSI_GREEN + "deposit term (years)" + ANSI_RESET);
        System.out.println("Use coma as delimiter. For example: 100000,10,5");
        Scanner input = new Scanner(System.in);
        String stringParams= input.nextLine();
        String[] stringParamsInArray = stringParams.split(",");

        double depositMoney = Double.parseDouble(stringParamsInArray[0]);
        double annualInterestRate = Double.parseDouble(stringParamsInArray[1]);
        double years = Double.parseDouble(stringParamsInArray[2]);

        double eachYearAmountOfMoney = depositMoney;
        for(int i = 0; i < years; i++){
            eachYearAmountOfMoney += ((eachYearAmountOfMoney * annualInterestRate) / 100);
            eachYearAmountOfMoney = roundMoneyToCent(eachYearAmountOfMoney);
            System.out.println(i + " year you'll get " + eachYearAmountOfMoney + " UAH.");
        }
        System.out.println("Final profit will be " + roundMoneyToCent(eachYearAmountOfMoney - depositMoney) + " UAH\n");
    }
}
