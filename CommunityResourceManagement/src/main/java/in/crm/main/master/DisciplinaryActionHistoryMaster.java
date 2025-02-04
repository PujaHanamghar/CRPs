package in.crm.main.master;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tblDisciplinaryActionHistoryMaster")
public class DisciplinaryActionHistoryMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int disciplinaryActionHistoryId;
    private int actionId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
    private LocalDate changeDate;

    private String changeDesc;

    public int getDisciplinaryActionHistoryId() {
        return disciplinaryActionHistoryId;
    }

    public void setDisciplinaryActionHistoryId(int disciplinaryActionHistoryId) {
        this.disciplinaryActionHistoryId = disciplinaryActionHistoryId;
    }

    public int getActionId() {
        return actionId;
    }

    public void setActionId(int actionId) {
        this.actionId = actionId;
    }

    public LocalDate getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(LocalDate changeDate) {
        this.changeDate = changeDate;
    }

    public String getChangeDesc() {
        return changeDesc;
    }

    public void setChangeDesc(String changeDesc) {
        this.changeDesc = changeDesc;
    }
}
