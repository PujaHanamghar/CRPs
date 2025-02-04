package in.crm.main.master;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class UserMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	private String userName;
	private String designation;
	private String email;
	private String phoneNo;
	private LocalDate dateOfJoining;
	private String role;
	private String status;
	private Integer managerId;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getManagerId() {
		return managerId;
	}
	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}
	@Override
	public String toString() {
		return "UserMaster [userId=" + userId + ", userName=" + userName + ", designation=" + designation + ", email="
				+ email + ", phoneNo=" + phoneNo + ", dateOfJoining=" + dateOfJoining + ", role=" + role + ", status="
				+ status + ", managerId=" + managerId + "]";
	}
	public UserMaster(Integer userId, String userName, String designation, String email, String phoneNo,
			LocalDate dateOfJoining, String role, String status, Integer managerId) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.designation = designation;
		this.email = email;
		this.phoneNo = phoneNo;
		this.dateOfJoining = dateOfJoining;
		this.role = role;
		this.status = status;
		this.managerId = managerId;
	}
	public UserMaster() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
//	@OneToOne
//    @JoinColumn(name = "roleId")
//    private RoleMaster role;
//	
//	
//	@OneToOne(mappedBy = "user")
//	private List<ProfilesMaster> profile;
//	
//	@OneToMany(mappedBy = "profileMaster")
//	private List<UserMaster> users;

}
