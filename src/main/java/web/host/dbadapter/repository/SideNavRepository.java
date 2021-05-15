package web.host.dbadapter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.host.dbadapter.dao.SideNavDAO;

import java.util.List;
@Repository
public interface SideNavRepository extends JpaRepository<SideNavDAO, Integer> {
    public List<SideNavDAO> findByPage(String page);
}
