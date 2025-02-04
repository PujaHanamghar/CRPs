package in.crm.main.master;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "noticeperiod")
public class NoticePeriodMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer noticePolicyId;
	private LocalDate noticePeriodDate;
	private String NoticePeriodStatus;
	private Integer roleId;
	private Integer departmentId;
	public Integer getNoticePolicyId() {
		return noticePolicyId;
	}
	public void setNoticePolicyId(Integer noticePolicyId) {
		this.noticePolicyId = noticePolicyId;
	}
	public LocalDate getNoticePeriodDate() {
		return noticePeriodDate;
	}
	public void setNoticePeriodDate(LocalDate noticePeriodDate) {
		this.noticePeriodDate = noticePeriodDate;
	}
	public String getNoticePeriodStatus() {
		return NoticePeriodStatus;
	}
	public void setNoticePeriodStatus(String noticePeriodStatus) {
		NoticePeriodStatus = noticePeriodStatus;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Integer getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
	@Override
	public String toString() {
		return "NoticePeriodMaster [noticePolicyId=" + noticePolicyId + ", noticePeriodDate=" + noticePeriodDate
				+ ", NoticePeriodStatus=" + NoticePeriodStatus + ", roleId=" + roleId + ", departmentId=" + departmentId
				+ "]";
	}
	public NoticePeriodMaster(Integer noticePolicyId, LocalDate noticePeriodDate, String noticePeriodStatus,
			Integer roleId, Integer departmentId) {
		super();
		this.noticePolicyId = noticePolicyId;
		this.noticePeriodDate = noticePeriodDate;
		NoticePeriodStatus = noticePeriodStatus;
		this.roleId = roleId;
		this.departmentId = departmentId;
	}
	public NoticePeriodMaster() {
		super();
		// TODO Auto-generated constructor stub
	}
}
