package Package.Lesson4;


public class Lesson4 {
    public void run() {
        Actions actions = new Actions();
        Student[] students = actions.initializeData(3);

        students = actions.setMark(students, 2, 5, 6);
        students = actions.setAttendance(students, 1, 5);
        students = actions.addStudent(students, "Ivan", "Ivanov");
        students = actions.deleteStudent(students, 2);
        students = actions.addStudent(students, "Peter", "Petrov");
        students = actions.addStudent(students, "Petar", "Petrov");
        students = actions.deleteStudent(students, actions.contains(students, "Peter", "Petrov"));
        actions.printInformation(students);

        actions.printInformation(students, actions.contains(students, "Ivanov"));
        students = actions.sortStudents(students);
        actions.printInformation(students);

        students = actions.cleanGroup();
        students = actions.addStudent(students, "Ivan", "Ivanov");
        actions.printInformation(students);
    }
}
