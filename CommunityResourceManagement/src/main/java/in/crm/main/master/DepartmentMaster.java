package in.crm.main.master;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "department")
public class DepartmentMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer departmentId;
	private String deparntmentName;
	private String departmentDesc;
	
	public DepartmentMaster() {
		super();
		
	}
	public DepartmentMaster(Integer departmentId, String deparntmentName, String departmentDesc) {
		super();
		this.departmentId = departmentId;
		this.deparntmentName = deparntmentName;
		this.departmentDesc = departmentDesc;
		
	}
	@Override
	public String toString() {
		return "DepartmentMaster [departmentId=" + departmentId + ", deparntmentName=" + deparntmentName
				+ ", departmentDesc=" + departmentDesc +  "]";
	}
	public Integer getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
	public String getDeparntmentName() {
		return deparntmentName;
	}
	public void setDeparntmentName(String deparntmentName) {
		this.deparntmentName = deparntmentName;
	}
	public String getDepartmentDesc() {
		return departmentDesc;
	}
	public void setDepartmentDesc(String departmentDesc) {
		this.departmentDesc = departmentDesc;
	}
	

}
