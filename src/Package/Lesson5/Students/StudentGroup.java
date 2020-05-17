package Package.Lesson5.Students;


import java.util.Arrays;

public class StudentGroup {

    private Student[] students = new Student[0];
    private int defaultAmountOfStudents = 5;

    public void setRandomStudents(int amountOfStudents) {
        setRandomStudents(amountOfStudents, defaultAmountOfStudents);
    }

    public void setRandomStudents(int amountOfStudents, int amountOfLessons) {
        Student[] students = new Student[amountOfStudents];
        for (int i = 0; i < amountOfStudents; i++) {
            students[i] = new Student(randomName(), randomName(), amountOfLessons);
        }
        this.students = students;
    }

    public void addStudent(String firstName, String lastName) {
        addStudent(firstName, lastName, defaultAmountOfStudents);
    }

    public void addStudent(String firstName, String lastName, int amountOfLessons) {
        Student[] studentsCopy = new Student[students.length + 1];
        System.arraycopy(students, 0, studentsCopy, 0, students.length);
        students = studentsCopy;
        students[students.length - 1] = new Student(firstName, lastName, amountOfLessons);
    }

    public void deleteStudent(String firstName, String lastName) {
        deleteStudent(getIdByName(firstName, lastName));
    }

    public void deleteStudent(int id) {
        if (id > 0) {
            Student[] studentsCopy = new Student[students.length - 1];
            for (int i = 0, j = 0; i < students.length - 1; i++, j++) {
                if (students[i].getId() == id) {
                    i++;
                }
                studentsCopy[j] = students[i];
            }
            students = studentsCopy;
        }
    }

    public void setMark(String firstName, String lastName, int lesson, int mark) {
        setMark(getIdByName(firstName, lastName), lesson, mark);
    }

    public void setMark(int id, int lesson, int mark) {
        for (Student student : students) {
            if (student.getId() == id) {
                student.setMark(lesson - 1, mark);
                return;
            }
        }
    }

    public void setAttendance(String firstName, String lastName, int lesson) {
        setAttendance(getIdByName(firstName, lastName), lesson);
    }

    public void setAttendance(int id, int lesson) {
        for (Student student : students) {
            if (student.getId() == id) {
                student.setAttendance(lesson - 1);
                return;
            }
        }
    }

    public void printGroup() {
        System.out.println("Group Information:");
        System.out.println("--------------------");
        for (Student student : students) {
            System.out.print("Name: " + student.getFirstName() + " " + student.getLastName());
            System.out.print(". ID: " + student.getId());
            System.out.print(". Marks: " + Arrays.toString(student.getMarks()));
            System.out.println(". Attendance: " + Arrays.toString(student.getAttendance()));
        }
        System.out.println("--------------------");
    }

    public boolean hasStudent(String firstName, String lastName){
        return getIdByName(firstName, lastName) != -1;
    }

    public void clearGroup(){
        students = new Student[0];
    }

    public void sortGroup(){
        quickSort(students, 0, students.length - 1);
    }


    private void quickSort(Student[] students, int start, int end) {

        int partition = partition(students, start, end);

        if (partition - 1 > start) {
            quickSort(students, start, partition - 1);
        }
        if (partition + 1 < end) {
            quickSort(students, partition + 1, end);
        }
    }

    private int partition(Student[] students, int start, int end) {
        Student pivot = students[end];

        for (int i = start; i < end; i++) {
            if ((students[i].getFirstName()+students[i].getLastName()).compareTo(pivot.getFirstName()+pivot.getLastName()) < 0) {
                Student temp = students[start];
                students[start] = students[i];
                students[i] = temp;
                start++;
            }
        }

        Student temp = students[start];
        students[start] = pivot;
        students[end] = temp;

        return start;
    }

    private int getIdByName(String firstName, String lastName) {
        for (Student student : students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                return student.getId();
            }
        }
        return -1;
    }

    private String randomName() {
        String charString = "abcdefghijklmnopqrstuvwxyz";
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
}
