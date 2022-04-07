package callengineer;


public class BusinessTripStarted extends AbstractEvent {

    private Long id;
    private Long callId;
    private String status;

    public BusinessTripStarted(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long Id) {
        this.id = id;
    }
    public Long getCallId() {
        return callId;
    }

    public void setCallId(Long CallId) {
        this.callId = callId;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String Status) {
        this.status = status;
    }
}
