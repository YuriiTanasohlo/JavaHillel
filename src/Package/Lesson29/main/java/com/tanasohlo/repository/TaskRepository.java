package Package.Lesson29.main.java.com.tanasohlo.repository;

import Package.Lesson29.main.java.com.tanasohlo.model.Task;

import java.util.List;

public interface TaskRepository {
    Task find(String id);

    Task save(Task task);

    List<Task> findAll();

    Task delete(String id);
}
