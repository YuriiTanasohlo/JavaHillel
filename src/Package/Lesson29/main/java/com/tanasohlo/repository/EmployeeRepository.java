package Package.Lesson29.main.java.com.tanasohlo.repository;

import Package.Lesson29.main.java.com.tanasohlo.model.Employee;

import java.util.List;

public interface EmployeeRepository {
    Employee find(String id);

    Employee save(Employee employee);

    List<Employee> findAll();

    Employee delete(String id);
}
