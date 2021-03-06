package callengineer;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;


@Entity
@Table(name="EngineerManagement_table")
public class EngineerManagement  {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Long callId;

    private String status;


    @PostPersist
    public void onPostPersist(){
        BusinessTripStarted businessTripStarted = new BusinessTripStarted();
        businessTripStarted.setCallId(this.getCallId());
        businessTripStarted.setStatus(this.getStatus());
        BeanUtils.copyProperties(this, businessTripStarted);
        businessTripStarted.publishAfterCommit();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getCallId() {
        return callId;
    }

    public void setCallId(Long callId) {
        this.callId = callId;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    



}
