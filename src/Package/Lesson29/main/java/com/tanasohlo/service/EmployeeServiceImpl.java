package Package.Lesson29.main.java.com.tanasohlo.service;

import Package.Lesson29.main.java.com.tanasohlo.model.Employee;
import Package.Lesson29.main.java.com.tanasohlo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;
    private IDGenerator idGenerator;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, IDGenerator idGenerator){
        this.employeeRepository = employeeRepository;
        this.idGenerator = idGenerator;
    }


    @Override
    public Employee create(String name) {
        Employee currentEmployee = new Employee(name, idGenerator.generate());
        employeeRepository.save(currentEmployee);
        return currentEmployee;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findByName(String name) {
        return findAll().stream().filter(employee -> employee.getName().equals(name)).findFirst().get();
    }
}
