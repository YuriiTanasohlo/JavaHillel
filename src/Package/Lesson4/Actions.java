package Package.Lesson4;

import java.util.Arrays;

public class Actions {

    final String charString = "abcdefghijklmnopqrstuvwxyz";

    public String randomIdentifier() {
        int lexiconLength = charString.length();
        int maxNameLength = 10;
        int minNameLength = 5;
        int rangeNameLength = maxNameLength - minNameLength + 1;
        int nameLength = (int) (Math.random() * rangeNameLength) + minNameLength;
        String name = "";
        for (int i = 0; i < nameLength; i++) {
            int letterPosition = (int) (Math.random() * lexiconLength);
            if (i == 0) {
                name += Character.toUpperCase(charString.charAt(letterPosition));
            } else {
                name += charString.charAt(letterPosition);
            }
        }
        return name;
    }

    public Student[] initializeData(int amount) {
        Student[] students = new Student[amount];
        for (int i = 0; i < amount; i++) {
            students[i] = new Student(randomIdentifier(), randomIdentifier());
        }
        return students;
    }

    public Student[] cleanGroup() {
        return new Student[0];
    }


    public void printInformation(Student[] students) {
        int amountOfStudents = students.length;
        System.out.println("Information about students:");
        for (int i = 0; i < amountOfStudents; i++) {
            System.out.println("------------------------------------------------------");
            printInformation(students[i]);
        }
        System.out.println("\n\n");
    }

    public void printInformation(Student[] students, int id) {
        for (int i = 0; i < students.length; i++) {
            if(students[i].id == id){
                printInformation(students[i]);
                return;
            }
        }
    }

    public void printInformation(Student student) {
        System.out.println("ID: " + student.id);
        System.out.println("Name: " + student.lastName + " " + student.firstName);
        System.out.println("Marks: " + Arrays.toString(student.marks));
        System.out.println("Attendance: " + Arrays.toString(student.attendance));
    }

    public Student[] setMark(Student[] students, int id, int mark, int lesson) {
        Student[] studentsCopy = new Student[students.length];
        System.arraycopy(students, 0, studentsCopy, 0, students.length);
        studentsCopy[id - 1].marks[lesson - 1] = mark;
        return studentsCopy;
    }

    public Student[] setAttendance(Student[] students, int id, int lesson) {
        Student[] studentsCopy = new Student[students.length];
        System.arraycopy(students, 0, studentsCopy, 0, students.length);
        studentsCopy[id - 1].attendance[lesson - 1] = true;
        return studentsCopy;
    }

    public Student[] deleteStudent(Student[] students, String lastName) {
        Student[] studentsCopy = new Student[students.length - 1];
        return deleteStudent(studentsCopy, contains(studentsCopy, lastName));
    }

    public Student[] deleteStudent(Student[] students, int id) {
        Student[] studentsCopy = new Student[students.length - 1];
//        printInformation(studentsCopy);
        for (int i = 0, j = 0; i < students.length; i++) {
            if (students[i].id == id) {
                continue;
            } else {
                studentsCopy[j++] = students[i];
            }
        }
        return studentsCopy;
    }

    public Student[] addStudent(Student[] students, String firstName, String lastName) {
        Student[] studentsCopy = new Student[students.length + 1];
        System.arraycopy(students, 0, studentsCopy, 0, students.length);
        studentsCopy[students.length] = new Student(firstName, lastName);
        return studentsCopy;
    }

    public int contains(Student[] students, String firstName, String lastName) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].firstName.equals(firstName) && students[i].lastName.equals(lastName)) {
                return students[i].id;
            }
        }
        return -1;
    }

    public int contains(Student[] students, String lastName) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].lastName.equals(lastName)) {
                return students[i].id;
            }
        }
        return -1;
    }

    public Student[] sortStudents(Student[] students){
        Student[] studentsCopy = new Student[students.length];
        System.arraycopy(students, 0, studentsCopy, 0, students.length);

        int studentsCount = studentsCopy.length;

        for (int i = 0; i < studentsCount - 1; i++) {
            for (int j = i + 1; j < studentsCount; j++) {
                if ((studentsCopy[i].lastName+studentsCopy[i].firstName).compareTo((studentsCopy[j].lastName+studentsCopy[j].firstName)) > 0) {
                    Student temp = studentsCopy[i];
                    studentsCopy[i] = studentsCopy[j];
                    studentsCopy[j] = temp;
                }
            }
        }

        return studentsCopy;
    }
}
