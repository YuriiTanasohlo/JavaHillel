package Package.Lesson29.main.java.com.tanasohlo.service;

import Package.Lesson29.main.java.com.tanasohlo.model.Employee;
import Package.Lesson29.main.java.com.tanasohlo.model.Task;
import Package.Lesson29.main.java.com.tanasohlo.repository.TaskRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class TaskServiceImpl implements TaskService {
    private TaskRepository taskRepository;
    private IDGenerator idGenerator;

    public TaskServiceImpl(TaskRepository taskRepository, IDGenerator idGenerator){
        this.taskRepository = taskRepository;
        this.idGenerator = idGenerator;
    }

    @Override
    public Task create(String name, BigDecimal price) {
        Task currentTask = new Task(name, price, idGenerator.generate());
        taskRepository.save(currentTask);
        return currentTask;
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public List<Task> findAllByWorker(Employee employee) {
        return findAll().stream().filter(task -> task.getAssignee().getId().equals(employee.getId())).collect(Collectors.toList());
    }
}
