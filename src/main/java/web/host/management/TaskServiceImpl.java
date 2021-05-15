package web.host.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.host.dbadapter.repository.TaskRepository;
import web.host.mapper.WebHostMapper;
import web.host.model.Task;

import java.util.List;

@Service
public class TaskServiceImpl implements ITaskService{
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    WebHostMapper webHostMapper;

    @Override
    public List<Task> fetchAllTasks() {
        return webHostMapper.toTaskList(taskRepository.findAllByOrderByCreationDateAsc());
    }

    @Override
    public void deleteByTaskId(Integer taskId) {
        if (null !=taskId) {
            if(taskRepository.existsById(taskId)){
                taskRepository.deleteById(taskId);
            }
        }
    }

    @Override
    public void deleteAllTasks() {
        taskRepository.deleteAll();
    }

    @Override
    public Task createTask(Task task) {
        return webHostMapper.toTask(taskRepository.save(webHostMapper.toTaskDAO(task)));
    }
}
