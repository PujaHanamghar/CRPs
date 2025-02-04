package in.crm.main.master;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="country")
public class StateMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Integer stateID;
	private String stateName;
	private String stateDesc;
	public Integer getStateID() {
		return stateID;
	}
	public void setStateID(Integer stateID) {
		this.stateID = stateID;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getStateDesc() {
		return stateDesc;
	}
	public void setStateDesc(String stateDesc) {
		this.stateDesc = stateDesc;
	}
	@Override
	public String toString() {
		return "StateMaster [stateID=" + stateID + ", stateName=" + stateName + ", stateDesc=" + stateDesc + "]";
	}
	public StateMaster(Integer stateID, String stateName, String stateDesc) {
		super();
		this.stateID = stateID;
		this.stateName = stateName;
		this.stateDesc = stateDesc;
	}
	public StateMaster() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
