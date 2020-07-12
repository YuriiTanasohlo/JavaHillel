package Package.Lesson19;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentManagerTest {

    private static int countOfStudents = 10000;

    @Test
    void readStudentsFromHDDByGSON() throws IOException, ClassNotFoundException {
        StudentManager studentManager = new StudentManager();
        generateTestStudents(studentManager, countOfStudents);
        Student student = new Student("Ivanov", 24, 2);
        student.setAttendance(true, 0);
        student.setAttendance(false, 1);
        student.setMarks(4, 0);
        student.setMarks(9, 1);
        studentManager.addStudent(student);
        studentManager.writeStudentsToHDDByGSON();

        long startTime = System.currentTimeMillis();
        studentManager.readStudentsFromHDDByGSON();
        long endTime = System.currentTimeMillis();
        System.out.println("Time for writeStudentsToHDDByGSON: " + (endTime - startTime) + " ms for " + countOfStudents + " students");

        assertEquals(student.getName(), studentManager.getStudentByName("Ivanov").getName());
        assertEquals(student.getAge(), studentManager.getStudentByName("Ivanov").getAge());
        assertArrayEquals(student.getAttendance(), studentManager.getStudentByName("Ivanov").getAttendance());
        assertArrayEquals(student.getMarks(), studentManager.getStudentByName("Ivanov").getMarks());
    }

    @Test
    void readStudentsFromHDDBySerialisation() throws IOException, ClassNotFoundException {
        StudentManager studentManager = new StudentManager();
        generateTestStudents(studentManager, countOfStudents);
        Student student = new Student("Ivanov", 24, 2);
        student.setAttendance(true, 0);
        student.setAttendance(false, 1);
        student.setMarks(4, 0);
        student.setMarks(9, 1);
        studentManager.addStudent(student);
        studentManager.writeStudentsToHDDBySerialisation();

        long startTime = System.currentTimeMillis();
        studentManager.readStudentsFromHDDBySerialisation();
        long endTime = System.currentTimeMillis();
        System.out.println("Time for writeStudentsToHDDByGSON: " + (endTime - startTime) + " ms for " + countOfStudents + " students");

        assertEquals(student.getName(), studentManager.getStudentByName("Ivanov").getName());
        assertEquals(student.getAge(), studentManager.getStudentByName("Ivanov").getAge());
        assertArrayEquals(student.getAttendance(), studentManager.getStudentByName("Ivanov").getAttendance());
        assertArrayEquals(student.getMarks(), studentManager.getStudentByName("Ivanov").getMarks());
    }

    @Test
    void writeStudentsToHDDByGSON() throws IOException {
        StudentManager studentManager = new StudentManager();
        generateTestStudents(studentManager, countOfStudents);
        Student student = new Student("Ivanov", 24, 2);
        student.setAttendance(true, 0);
        student.setAttendance(false, 1);
        student.setMarks(4, 0);
        student.setMarks(9, 1);
        studentManager.addStudent(student);

        long startTime = System.currentTimeMillis();
        studentManager.writeStudentsToHDDByGSON();
        long endTime = System.currentTimeMillis();
        System.out.println("Time for writeStudentsToHDDByGSON: " + (endTime - startTime) + " ms for " + countOfStudents + " students");
    }

    @Test
    void writeStudentsToHDDBySerialisation() throws IOException {
        StudentManager studentManager = new StudentManager();
        generateTestStudents(studentManager, countOfStudents);
        Student student = new Student("Ivanov", 24, 2);
        student.setAttendance(true, 0);
        student.setAttendance(false, 1);
        student.setMarks(4, 0);
        student.setMarks(9, 1);
        studentManager.addStudent(student);

        long startTime = System.currentTimeMillis();
        studentManager.writeStudentsToHDDBySerialisation();
        long endTime = System.currentTimeMillis();
        System.out.println("Time for writeStudentsToHDDBySerialisation: " + (endTime - startTime) + " ms for " + countOfStudents + " students");
    }

    private void generateTestStudents(StudentManager studentManager, int countOfStudents) {
        for (int i = 0; i < countOfStudents; i++) {
            studentManager.addStudent(StudentGenerator.generator());
        }
    }
}