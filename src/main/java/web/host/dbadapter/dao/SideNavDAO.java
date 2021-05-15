package web.host.dbadapter.dao;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name="TBL_SIDENAV_CONTENT")
@Data
public class SideNavDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ID")
    Integer id;

    @Column(name = "PAGE")
    String page;

    @Column(name = "CONTENT")
    String content;
}
