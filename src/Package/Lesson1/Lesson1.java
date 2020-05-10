package Package.Lesson1;

import Package.Calc.Calc;


public class Lesson1 {
    public void run() {
// just first action
        System.out.println("Hello\n");

// home task "create facebook"
        Facebook facebook = new Facebook();
        facebook.createFacebook();


// home task "calculator"
        SimpleCalc simpleCalc = new SimpleCalc();
        simpleCalc.run();
    }
}