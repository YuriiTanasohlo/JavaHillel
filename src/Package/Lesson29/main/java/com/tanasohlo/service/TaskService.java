package Package.Lesson29.main.java.com.tanasohlo.service;

import Package.Lesson29.main.java.com.tanasohlo.model.Employee;
import Package.Lesson29.main.java.com.tanasohlo.model.Task;

import java.math.BigDecimal;
import java.util.List;

public interface TaskService {
    Task create(String name, BigDecimal price);
    List<Task> findAll();
    List<Task> findAllByWorker(Employee employee);
}
