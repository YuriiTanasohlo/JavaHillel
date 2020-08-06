package Package.Lesson25;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;

import static java.lang.Integer.parseInt;

public class StudentsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String html = "<h1>Students</h1><table><thead><tr><th>Name</th><th>Age</th></tr></thead><tbody>";

        StudentManager studentManager = new StudentManager();
        HashSet<Student> students = studentManager.getStudentsFromDB();

        Iterator<Student> i = students.iterator();
        while (i.hasNext()) {
            Student currentStudent = i.next();
            html += "<tr><td>" + currentStudent.getName() + "</td><td>" + currentStudent.getAge() + "</td></tr>";
        }

        html += "</tbody>";

        html += "<form name=\"addStudent\" method=\"post\" action=\"StudentsServlet\"> Name: <input type=\"text\" name=\"name\"/> <br/> Age: <input type=\"number\" name=\"age\"/> <br/> <input type=\"submit\" value=\"Add\" /> </form>";
        PrintWriter printWriter = resp.getWriter();
        printWriter.write(html);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        int age = parseInt(req.getParameter("age"));

        StudentManager studentManager = new StudentManager();
        studentManager.getStudentsFromDB();

        Student newStudent = new Student(name, age);

        studentManager.addStudent(newStudent);

        studentManager.writeStudentsToDB();


        resp.sendRedirect(req.getContextPath() + "/");
    }
}

