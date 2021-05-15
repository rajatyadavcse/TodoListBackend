package web.host.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import web.host.dbadapter.dao.TaskDAO;
import web.host.model.Task;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface WebHostMapper {
    TaskDAO toTaskDAO(Task task);
    List<Task> toTaskList(List<TaskDAO> taskDAOList);
    Task toTask(TaskDAO taskDAO);

}
