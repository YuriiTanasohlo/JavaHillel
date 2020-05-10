package Package.Lesson3;

import java.util.Arrays;

public class Lesson3 {
    public void run(){
        Calculation calculation = new Calculation();
        System.out.println(calculation.digitSum(10001130));
        calculation.pointAffiliationDefiner();

        studentsTest();
    }
    public void studentsTest(){

        // testing
        Students students = new Students();

        Object[] myClassGroup = students.defaultInitiateClassGroup();
        myClassGroup = students.addNewStudent("Georg", myClassGroup);

        System.out.println(Arrays.toString(((int[][])myClassGroup[1])[10]));
        Object[] myClassGroup1 = students.addMark("Georg", 5, myClassGroup);
        myClassGroup1 = students.updateMark("Georg", 5, 5,  myClassGroup1);

        System.out.println(Arrays.toString(((int[][])myClassGroup1[1])[10]));
        System.out.println(Arrays.toString(((int[][])myClassGroup[1])[10]));

        myClassGroup1 = students.sortGroupByLastName(myClassGroup1);

        students.printClassGroup(myClassGroup1);

        myClassGroup1 = students.clearClassGroup(myClassGroup1);
        myClassGroup1 = students.addNewStudent("Georg", myClassGroup1);
        myClassGroup1 = students.addMark("Georg", 5, myClassGroup1);
        students.printClassGroup(myClassGroup1);
    }
}
