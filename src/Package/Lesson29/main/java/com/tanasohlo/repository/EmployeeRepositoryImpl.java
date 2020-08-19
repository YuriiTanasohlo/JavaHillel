package Package.Lesson29.main.java.com.tanasohlo.repository;

import Package.Lesson29.main.java.com.tanasohlo.model.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeRepositoryImpl implements EmployeeRepository{

    private Map<String, Employee> employeeByID= new HashMap<>();

    @Override
    public Employee find(String id) {
        return employeeByID.get(id);
    }

    @Override
    public Employee save(Employee employee) {
        employeeByID.put(employee.getId(), employee);
        return employee;
    }

    @Override
    public List<Employee> findAll() {
        return new ArrayList<>(employeeByID.values());
    }

    @Override
    public Employee delete(String id) {
        return employeeByID.remove(id);
    }
}
