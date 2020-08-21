package Package.Lesson27;

import java.util.ArrayList;
import java.util.List;

public class Lesson27 {
    public static void run(){
        Stream stream = new Stream();

        List<Student> studentsList = new ArrayList<Student>();
        studentsList.add(new Student("Petrov"));
        studentsList.add(new Student("Sidorov"));
        studentsList.add(new Student("Ivanov"));
        studentsList.add(new Student("Pantelevanov"));
        studentsList.add(new Student("Ishakova"));
        studentsList.add(new Student("Petrosianov"));


        stream.getSortedListOfNameOfStudentsList(studentsList);


    }
}
