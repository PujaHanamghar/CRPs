package in.crm.main.master;

import java.time.LocalDate;
//import java.util.List;

import jakarta.persistence.CascadeType;

//import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
//import jakarta.persistence.OneToMany;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.OneToMany;
//import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "profiles")
public class ProfilesMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer profileId;
	
	private String address;
	private LocalDate dob;
	private String gender;
	private LocalDate doj;
	private String department;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	private UserMaster userId;

	public Integer getProfileId() {
		return profileId;
	}

	public void setProfileId(Integer profileId) {
		this.profileId = profileId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDoj() {
		return doj;
	}

	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public UserMaster getUserId() {
		return userId;
	}

	public void setUserId(UserMaster userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "ProfilesMaster [profileId=" + profileId + ", address=" + address + ", dob=" + dob + ", gender=" + gender
				+ ", doj=" + doj + ", department=" + department + ", userId=" + userId + "]";
	}

	public ProfilesMaster(Integer profileId, String address, LocalDate dob, String gender, LocalDate doj,
			String department, UserMaster userId) {
		super();
		this.profileId = profileId;
		this.address = address;
		this.dob = dob;
		this.gender = gender;
		this.doj = doj;
		this.department = department;
		this.userId = userId;
	}

	public ProfilesMaster() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
