package in.crm.main.master;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "seperation")
public class SeperationTypeMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sepTypeId;
	private String sepTypeName;
	private String sepTypeDesc;
	private String SepStatus;
	public Integer getSepTypeId() {
		return sepTypeId;
	}
	public void setSepTypeId(Integer sepTypeId) {
		this.sepTypeId = sepTypeId;
	}
	public String getSepTypeName() {
		return sepTypeName;
	}
	public void setSepTypeName(String sepTypeName) {
		this.sepTypeName = sepTypeName;
	}
	public String getSepTypeDesc() {
		return sepTypeDesc;
	}
	public void setSepTypeDesc(String sepTypeDesc) {
		this.sepTypeDesc = sepTypeDesc;
	}
	public String getSepStatus() {
		return SepStatus;
	}
	public void setSepStatus(String sepStatus) {
		SepStatus = sepStatus;
	}
	public SeperationTypeMaster(Integer sepTypeId, String sepTypeName, String sepTypeDesc, String sepStatus) {
		super();
		this.sepTypeId = sepTypeId;
		this.sepTypeName = sepTypeName;
		this.sepTypeDesc = sepTypeDesc;
		SepStatus = sepStatus;
	}
	@Override
	public String toString() {
		return "SeperationTypeMaster [sepTypeId=" + sepTypeId + ", sepTypeName=" + sepTypeName + ", sepTypeDesc="
				+ sepTypeDesc + ", SepStatus=" + SepStatus + "]";
	}
	public SeperationTypeMaster() {
		super();
		// TODO Auto-generated constructor stub
	}
}
