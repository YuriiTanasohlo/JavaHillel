package Package.Lesson4;

public class Student {
    int id;
    static int nextId = 1;
    String firstName;
    String lastName;
    int[] marks;
    boolean[] attendance;

    public Student() {
        this("anonymous", "anonymous");
    }

    public Student(String firstName, String lastName) {
        this(firstName, lastName, 10);
    }

    public Student(String firstName, String lastName, int numberOfLessons) {
        this.id = Student.nextId++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.marks = new int[numberOfLessons];
        this.attendance = new boolean[numberOfLessons];
    }
}
