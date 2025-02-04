package in.crm.main.master;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tbldesignation")
public class DesignationMaster
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer designationId;
    private String designationName;
    private String designationDesc;

    public String getDesignationName() {
        return designationName;
    }

    public void setDesignationName(String designationName) {
        this.designationName = designationName;
    }

    public Integer getDesignationId() {
        return designationId;
    }

    public void setDesignationId(Integer designationId) {
        this.designationId = designationId;
    }

    public String getDesignationDesc() {
        return designationDesc;
    }

    public void setDesignationDesc(String designationDesc) {
        this.designationDesc = designationDesc;
    }
}
