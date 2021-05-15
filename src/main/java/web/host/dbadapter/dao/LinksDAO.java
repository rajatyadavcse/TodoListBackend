package web.host.dbadapter.dao;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TBL_HOSTING_LINKS")
@Data
public class LinksDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    Integer id;

    @Column(name = "TYPE")
    String type;

    @Column(name = "LINK")
    String link;


}
