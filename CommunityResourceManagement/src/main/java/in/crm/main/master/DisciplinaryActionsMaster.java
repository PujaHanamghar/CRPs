package in.crm.main.master;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="tblDisciplinaryActionsMaster")
public class DisciplinaryActionsMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int disciplinaryActionId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
    private LocalDate incidentDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
    private  LocalDate reportedDate;

    private String incidentDetail;
    private String actionTaken;
    private String  outcomes;
    private String token;
    private String remarks;
    private String status;

    public int getDisciplinaryActionId() {
        return disciplinaryActionId;
    }

    public void setDisciplinaryActionId(int disciplinaryActionId) {
        this.disciplinaryActionId = disciplinaryActionId;
    }

    public LocalDate getIncidentDate() {
        return incidentDate;
    }

    public void setIncidentDate(LocalDate incidentDate) {
        this.incidentDate = incidentDate;
    }

    public LocalDate getReportedDate() {
        return reportedDate;
    }

    public void setReportedDate(LocalDate reportedDate) {
        this.reportedDate = reportedDate;
    }

    public String getIncidentDetail() {
        return incidentDetail;
    }

    public void setIncidentDetail(String incidentDetail) {
        this.incidentDetail = incidentDetail;
    }

    public String getActionTaken() {
        return actionTaken;
    }

    public void setActionTaken(String actionTaken) {
        this.actionTaken = actionTaken;
    }

    public String getOutcomes() {
        return outcomes;
    }

    public void setOutcomes(String outcomes) {
        this.outcomes = outcomes;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
