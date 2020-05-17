package Package.Lesson5.Students;

class Student {
    private int id;
    private static int nextId = 1;
    private String firstName;
    private String lastName;
    private int[] marks;
    private boolean[] attendance;

    Student(String firstName, String lastName, int numberOfLessons) {
        this.id = Student.nextId++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.marks = new int[numberOfLessons];
        this.attendance = new boolean[numberOfLessons];
    }

    int getId() {
        return id;
    }

    String getFirstName() {
        return firstName;
    }

    void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    String getLastName() {
        return lastName;
    }

    void setLastName(String lastName) {
        this.lastName = lastName;
    }

    int[] getMarks() {
        return arrayCopy(marks);
    }

    void setMark(int lesson, int mark){
        this.marks[lesson] = mark;
    }

    boolean[] getAttendance() {
        return arrayCopy(attendance);
    }

    void setAttendance(int lesson) {
        this.attendance[lesson] = true;
    }

    private int[] arrayCopy(int[] arrayToCopy){
        int[] getMarksCopy = new int[arrayToCopy.length];
        System.arraycopy(arrayToCopy, 0, getMarksCopy, 0, arrayToCopy.length);
        return getMarksCopy;
    }

    private boolean[] arrayCopy(boolean[] arrayToCopy){
        boolean[] getMarksCopy = new boolean[arrayToCopy.length];
        System.arraycopy(arrayToCopy, 0, getMarksCopy, 0, arrayToCopy.length);
        return getMarksCopy;
    }
}
