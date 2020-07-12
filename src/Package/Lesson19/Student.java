package Package.Lesson19;

import java.io.Serializable;
import java.util.Arrays;

public class Student implements Serializable {
    private String name;
    private int age;
    private boolean[] attendance;
    private int[] marks;

    public Student(String name, int age, int countOfLessons) {
        this.name = name;
        this.age = age;
        this.attendance = new boolean[countOfLessons];
        this.marks = new int[countOfLessons];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean[] getAttendance() {
        return attendance;
    }

    public void setAttendance(boolean attendance, int lesson) {
        this.attendance[lesson] = attendance;
    }

    public int[] getMarks() {
        return marks;
    }

    public void setMarks(int mark, int lesson) {
        this.marks[lesson] = mark;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", attendance=" + Arrays.toString(attendance) +
                ", marks=" + Arrays.toString(marks) +
                '}';
    }
}
