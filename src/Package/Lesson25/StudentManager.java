package Package.Lesson25;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.HashSet;

public class StudentManager {
    private HashSet<Student> students = new HashSet();

    public void addStudent(Student student) {
        students.add(student);
    }

    public HashSet<Student> getStudentsFromDB() throws IOException {
        Gson gson = new Gson();
        Reader reader = new FileReader("C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\webapps\\students\\WEB-INF\\classes\\Package\\Lesson25\\students.json");
        Type setType = new TypeToken<HashSet<Student>>() {}.getType();
        students = gson.fromJson(reader, setType);
        reader.close();
        return students;
    }

    public void writeStudentsToDB() throws IOException {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Writer writer = new FileWriter("C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\webapps\\students\\WEB-INF\\classes\\Package\\Lesson25\\students.json");
        gson.toJson(students, writer);
        writer.flush();
        writer.close();

    }
}
