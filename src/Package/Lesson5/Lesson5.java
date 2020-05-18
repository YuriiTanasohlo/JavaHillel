package Package.Lesson5;

import Package.Lesson5.Students.StudentGroup;

import java.util.Arrays;

public class Lesson5 {
    public void runContainer(){
//        initiating test data
        int[] myArray = {4,5,7};
        int[] myArray1 = {11,12,14};
        int[] myArray2 = {15,16,17};
        Container container = new Container();
        Container container1 = new Container(myArray1);

//        check setContainer
        container.print();
        container.setContainer(myArray);
        container.print();
        container1.setContainer(myArray2);

//        check print
        container.print();

//        check setElement
        container.setElement(9, 2);
        System.out.println("getElement: " + container.getElement(2));
        container.setElement(8, 2);

//        check getContainer
        System.out.println("getContainer: " + Arrays.toString(container.getContainer()));

//        check addElement
        container.addElement(155);
        container.addElement(4,1);
        container.print();

//        check hasElement
        System.out.println("hasElement: " + container.hasElement(155));
        System.out.println("hasElement: " + container.hasElement(156));

//        check length
        System.out.println("length: " + container.length());

//        check indexOf
        System.out.println("indexOf: " + container.indexOf(155));

//        check addContainer
        container.addContainer(container1, 2);
        container.print();
        container.addContainer(container1);
        container.print();

//        check isEqual
        Container container2 = new Container(myArray1);
        Container container3 = new Container(myArray1);
        System.out.println("isEqual: " + container2.isEqual(container3));
        container3.setElement(3,2);
        container2.print();
        container3.print();
        System.out.println("isEqual: " + container2.isEqual(container3));

//        check clean
        container3.clean();
        container3.print();

//        check sort
        container.sort();
        container.print();
    }

    public void runStudents(){
        StudentGroup studentGroup = new StudentGroup();

        studentGroup.setRandomStudents(2);
        studentGroup.addStudent("Peter", "Petrov");
        studentGroup.addStudent("Ivan", "Ivanov", 6);

        studentGroup.setMark("Ivan", "Ivanov", 4, 4);
        studentGroup.setMark(3, 4, 4);

        studentGroup.setAttendance("Ivan", "Ivanov", 4);
        studentGroup.setAttendance("Peter", "Petrov", 1);

        studentGroup.printGroup();
        studentGroup.deleteStudent("Peter", "Petrov");
        studentGroup.printGroup();

        studentGroup.addStudent("Peter", "Petrov");
        System.out.println("hasStudent Peter Petrov? " + studentGroup.hasStudent("Peter", "Petrov"));

        studentGroup.clearGroup();
        studentGroup.printGroup();

        studentGroup.setRandomStudents(9);
        studentGroup.addStudent("Petea", "Petrov");
        studentGroup.addStudent("Peter", "Petrof");
        studentGroup.printGroup();
        studentGroup.sortGroup();
        studentGroup.printGroup();
    }


}
