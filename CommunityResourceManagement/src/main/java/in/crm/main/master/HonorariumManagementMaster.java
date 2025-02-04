package in.crm.main.master;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity()
@Table(name="tblHonorariumManagementMaster")
public class HonorariumManagementMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int honorariumId;
    private int honorariumAmount;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
    private LocalDate honorariumPaymentDate;
    private String honorariumPaymentMethod;
    private String honorariumPaymentStatus;

    public int getHonorariumId() {
        return honorariumId;
    }

    public void setHonorariumId(int honorariumId) {
        this.honorariumId = honorariumId;
    }

    public int getHonorariumAmount() {
        return honorariumAmount;
    }

    public void setHonorariumAmount(int honorariumAmount) {
        this.honorariumAmount = honorariumAmount;
    }

    public LocalDate getHonorariumPaymentDate() {
        return honorariumPaymentDate;
    }

    public void setHonorariumPaymentDate(LocalDate honorariumPaymentDate) {
        this.honorariumPaymentDate = honorariumPaymentDate;
    }

    public String getHonorariumPaymentMethod() {
        return honorariumPaymentMethod;
    }

    public void setHonorariumPaymentMethod(String honorariumPaymentMethod) {
        this.honorariumPaymentMethod = honorariumPaymentMethod;
    }

    public String getHonorariumPaymentStatus() {
        return honorariumPaymentStatus;
    }

    public void setHonorariumPaymentStatus(String honorariumPaymentStatus) {
        this.honorariumPaymentStatus = honorariumPaymentStatus;
    }
}
