package web.host.dbadapter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.host.dbadapter.dao.LinksDAO;

import java.util.List;

@Repository
public interface LinksRepository extends JpaRepository<LinksDAO, Integer> {
    List<LinksDAO> findByType(String type);
}
