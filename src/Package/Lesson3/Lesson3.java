package Package.Lesson3;

import java.util.Arrays;

public class Lesson3 {
    public void run(){
        Students students = new Students();

        Object[] myClassGroup = students.defaultInitiateClassGroup();
        myClassGroup = students.addNewStudent("Georg", myClassGroup);
        myClassGroup = students.addMark("Georg", 5, myClassGroup);

        System.out.println(Arrays.toString(((int[][])myClassGroup[1])[10]));
    }
}
