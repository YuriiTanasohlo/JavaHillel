import Calc.Calc;

public class Lesson {
    public static void main(String[] args) {
// just first action
        System.out.println("Hello\n");

// home task "create facebook"
        Facebook facebook = new Facebook();
        facebook.createFacebook();


// home task "calculator"
        SimpleCalc simpleCalc = new SimpleCalc();
        simpleCalc.run();

// more complicated version of calculator
/*
v0.1.1

testing done:
- smoke testing

known issues:
- doesn't work with negative numbers. For example -4*4 doesn't work

spent time:
~ 10h

not optimized
not secured
*/
        Calc calc = new Calc();
        calc.runCalc();
    }
}