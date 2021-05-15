package web.host.dbadapter.dao;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@Table(name = "TBL_TASKS")
public class TaskDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ID")
    Integer taskId;

    @Column(name = "TASK_NAME")
    String taskName;

    @Column(name = "CREATION_DATE")
    Date creationDate;

    @PrePersist
    protected void prePersist(){
        if(this.creationDate  ==null){
            this.creationDate=new Date();
        }
    }
}
