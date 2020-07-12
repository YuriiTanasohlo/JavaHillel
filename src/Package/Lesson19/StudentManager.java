package Package.Lesson19;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.HashSet;

public class StudentManager {
    HashSet<Student> students = new HashSet();

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student getStudentByName(String name) {
        for (Student student : students) {
            if (student.getName().equals(name)) {
                return student;
            }
        }
        return null;
    }

    public void readStudentsFromHDDByGSON() throws IOException {
        Gson gson = new Gson();
        Reader reader = new FileReader("C:\\Users\\Cat\\IdeaProjects\\JavaHillel\\src\\Package\\Lesson19\\students.json");
        Type setType = new TypeToken<HashSet<Student>>() {
        }.getType();
        students = gson.fromJson(reader, setType);
        reader.close();
    }

    public void readStudentsFromHDDBySerialisation() throws IOException, ClassNotFoundException {
        InputStream inputStream = new FileInputStream("C:\\Users\\Cat\\IdeaProjects\\JavaHillel\\src\\Package\\Lesson19\\students.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        students = (HashSet) objectInputStream.readObject();
        objectInputStream.close();

    }

    public void writeStudentsToHDDByGSON() throws IOException {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Writer writer = new FileWriter("C:\\Users\\Cat\\IdeaProjects\\JavaHillel\\src\\Package\\Lesson19\\students.json");
        gson.toJson(students, writer);
        writer.flush();
        writer.close();

    }

    public void writeStudentsToHDDBySerialisation() throws IOException {
        OutputStream outputStream = new FileOutputStream("C:\\Users\\Cat\\IdeaProjects\\JavaHillel\\src\\Package\\Lesson19\\students.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(students);
        objectOutputStream.flush();
        objectOutputStream.close();

    }
}
