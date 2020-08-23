package Package.Lesson27;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StreamTest {
    @Test
    void getSortedListOfNameOfStudentsList() {
        Stream stream = new Stream();

        List<Student> studentsList = new ArrayList<Student>();
        studentsList.add(new Student("Petrov"));
        studentsList.add(new Student("Sidorov"));
        studentsList.add(new Student("Ivanov"));
        studentsList.add(new Student("Pantelevanov"));
        studentsList.add(new Student("Ishakova"));
        studentsList.add(new Student("Petrosianov"));


        List<String> names = stream.getSortedListOfNameOfStudentsList(studentsList);
        assertTrue(names.contains("PANTELEVANOV"));
        assertTrue(names.contains("PETROSIANOV"));
        assertFalse(names.contains("PETROV"));
        assertFalse(names.contains("Petrov"));
        assertFalse(names.contains("Sidorov"));
        assertFalse(names.contains("Ivanov"));
        assertFalse(names.contains("Pantelevanov"));
        assertFalse(names.contains("Ishakova"));
        assertFalse(names.contains("Petrosianov"));
    }
}