package Package.Lesson29.main.java.com.tanasohlo.service;

import Package.Lesson29.main.java.com.tanasohlo.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee create(String name);
    Employee findByName(String name);
    List<Employee> findAll();
}
