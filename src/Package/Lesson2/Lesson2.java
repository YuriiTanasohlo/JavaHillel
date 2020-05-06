//lesson 2 v0.1

package Package.Lesson2;

public class Lesson2 {

    public void run() {
//        task 0
        SimpleCalc2 simpleCalc2 = new SimpleCalc2();
        simpleCalc2.run();

//        task 1-2
        Average average = new Average();
        average.twoNumbersInAverage();
        average.multipleNumbersInAverage();

//        task 3
        DepositCalculator depositCalculator = new DepositCalculator();
        depositCalculator.run();

//        task 4: a-c
        Draw draw = new Draw();
        draw.rectangle();
        draw.envelope();
        draw.chess();

//        task 5-7
        NumberTypeDefiner numberTypeDefiner = new NumberTypeDefiner();
        numberTypeDefiner.isEvenDefiner();
        numberTypeDefiner.isPrimeDefiner();
        numberTypeDefiner.defineMultipleOfNumbers();

    }

}
