package web.host.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import web.host.management.ITaskService;
import web.host.model.Task;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin
@RestController
public class ToDoTaskController {

    @Autowired
    ITaskService taskService;

    @GetMapping("/todo/task/list")
    public List<Task> fetchAllTasks(){
        /*List<String> list=new ArrayList<>();
        taskService.fetchAllTasks().forEach(task -> {
            list.add(task.getTaskName());
        });*/
        return taskService.fetchAllTasks();
    }
    @GetMapping("/todo/task/create/{taskName}")
    public Task createTask(@PathVariable(required = true) String taskName){
        Task task =  new Task();
        task.setTaskName(taskName);
        return taskService.createTask(task);
    }
    @GetMapping("/todo/task/delete/{taskId}")
    public void deleteTask(@PathVariable(required = true) Integer taskId){
        taskService.deleteByTaskId(taskId);
    }
    @GetMapping("/todo/task/delete")
    public void deleteAllTasks(){
        taskService.deleteAllTasks();
    }

}
