package Package.Lesson27;

import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Stream {

    public List<String> getSortedListOfNameOfStudentsList(List<Student> students){



        return students.stream().sorted(Comparator.comparing(Student::getName)).filter(
                student -> {
                    Pattern pattern = Pattern.compile("[aeiou]");
                    Matcher matcher = pattern.matcher(student.getName());
                    int count = 0;
                    while (matcher.find()) {
                        count++;
                    }
                    return count > 3;
                }
        ).map(Student::getName).map(String::toUpperCase).collect(Collectors.toList());
    }

    private int vowelCounter(String name){
        Pattern pattern = Pattern.compile("[aeiou]");
        Matcher matcher = pattern.matcher(name);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }
}
