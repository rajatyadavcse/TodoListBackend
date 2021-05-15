package web.host.management;

import web.host.model.Task;

import java.util.List;

public interface ITaskService {
    List<Task> fetchAllTasks();
    void deleteByTaskId(Integer taskId);
    void deleteAllTasks();
    Task createTask(Task task);
}
