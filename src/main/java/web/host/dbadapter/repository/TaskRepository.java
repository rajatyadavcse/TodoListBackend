package web.host.dbadapter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.host.dbadapter.dao.TaskDAO;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TaskDAO, Integer> {
    List<TaskDAO> findAllByOrderByCreationDateAsc();
    TaskDAO findTop1ByTaskName(String taskName);
}
