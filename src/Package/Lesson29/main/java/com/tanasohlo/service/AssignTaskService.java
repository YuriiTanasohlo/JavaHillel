package Package.Lesson29.main.java.com.tanasohlo.service;

import Package.Lesson29.main.java.com.tanasohlo.model.Employee;
import Package.Lesson29.main.java.com.tanasohlo.model.Task;

public interface AssignTaskService {
    Task assignTask(Employee employee, Task task);
}
