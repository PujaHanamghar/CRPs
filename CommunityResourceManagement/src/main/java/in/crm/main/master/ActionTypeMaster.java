package in.crm.main.master;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(name = "actiontype")
public class ActionTypeMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer actionTypeId;

    private String actionTypeName;
    private String actionTypeDesc;

    @Version  // ✅ Ensures optimistic locking to prevent update conflicts
    private Integer version;

    public Integer getActionTypeId() {
        return actionTypeId;
    }

    public void setActionTypeId(Integer actionTypeId) {
        this.actionTypeId = actionTypeId;
    }

    public String getActionTypeName() {
        return actionTypeName;
    }

    public void setActionTypeName(String actionTypeName) {
        this.actionTypeName = actionTypeName;
    }

    public String getActionTypeDesc() {
        return actionTypeDesc;
    }

    public void setActionTypeDesc(String actionTypeDesc) {
        this.actionTypeDesc = actionTypeDesc;
    }

    @Override
    public String toString() {
        return "ActionTypeMaster [actionTypeId=" + actionTypeId + ", actionTypeName=" + actionTypeName +
                ", actionTypeDesc=" + actionTypeDesc + "]";
    }

    public ActionTypeMaster() {
        super();
    }
}
