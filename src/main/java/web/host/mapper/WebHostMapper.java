package web.host.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import web.host.dbadapter.dao.LinksDAO;
import web.host.dbadapter.dao.SideNavDAO;
import web.host.dbadapter.dao.TaskDAO;
import web.host.model.LinksRequest;
import web.host.model.SideNavRequest;
import web.host.model.Task;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface WebHostMapper {
    SideNavRequest toSideNavRequest(SideNavDAO sideNavDAO);
    LinksRequest toLinksRequest(LinksDAO linksDAO);
    SideNavDAO toSideNavDAO(SideNavRequest sideNavRequest);
    LinksDAO toLinksDAO(LinksRequest linksRequest);
    TaskDAO toTaskDAO(Task task);
    List<Task> toTaskList(List<TaskDAO> taskDAOList);
    Task toTask(TaskDAO taskDAO);

}
