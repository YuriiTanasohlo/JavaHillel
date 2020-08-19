package Package.Lesson29.main.java.com.tanasohlo.service;

import Package.Lesson29.main.java.com.tanasohlo.model.Employee;
import Package.Lesson29.main.java.com.tanasohlo.model.Task;

public class AssignTaskServiceImpl implements AssignTaskService {
    @Override
    public Task assignTask(Employee employee, Task task) {
        task.setAssignee(employee);
        return task;
    }
}
