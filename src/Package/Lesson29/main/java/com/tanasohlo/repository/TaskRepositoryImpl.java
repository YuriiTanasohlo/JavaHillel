package Package.Lesson29.main.java.com.tanasohlo.repository;

import Package.Lesson29.main.java.com.tanasohlo.model.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TaskRepositoryImpl implements TaskRepository{
    private Map<String, Task> taskByID = new HashMap<>();

    @Override
    public Task find(String id) {
        return taskByID.get(id);
    }

    @Override
    public Task save(Task task) {
        taskByID.put(task.getId(), task);
        return task;
    }

    @Override
    public List<Task> findAll() {
        return new ArrayList<>(taskByID.values());
    }

    @Override
    public Task delete(String id) {
        return taskByID.remove(id);
    }
}
