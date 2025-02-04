package in.crm.main.master;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "tblCrpMaster")
public class CommunityResourcePersonMaster 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int crpId;

	private int crpCode;
	private String crpFirstName;
	private String crpMiddleName;
	private String crpLastName;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
	private LocalDate crpDateOfBirth;
	private  String crpQualification;
	private String crpYearOfExperience;

	private String crpAddress;
	private String crpEmailId;
	private int crpMobileNo;
	private String crpBloodGroup;

	private String crpUID;
	private String crpDepartment;
	private String crpDesignation;
	private String crpJobRole;

	private String crpLocation;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
	private LocalDate crpDateOfJoining;
	private String crpSocialCategory;

	private String crpSelectionCategory;
	private String crpPostingHistory;


	public int getCrpId() {
		return crpId;
	}

	public void setCrpId(int crpId) {
		this.crpId = crpId;
	}

	public int getCrpCode() {
		return crpCode;
	}

	public void setCrpCode(int crpCode) {
		this.crpCode = crpCode;
	}

	public String getCrpFirstName() {
		return crpFirstName;
	}

	public void setCrpFirstName(String crpFirstName) {
		this.crpFirstName = crpFirstName;
	}

	public String getCrpMiddleName() {
		return crpMiddleName;
	}

	public void setCrpMiddleName(String crpMiddleName) {
		this.crpMiddleName = crpMiddleName;
	}

	public String getCrpLastName() {
		return crpLastName;
	}

	public void setCrpLastName(String crpLastName) {
		this.crpLastName = crpLastName;
	}

	public LocalDate getCrpDateOfBirth() {
		return crpDateOfBirth;
	}

	public void setCrpDateOfBirth(LocalDate crpDateOfBirth) {
		this.crpDateOfBirth = crpDateOfBirth;
	}

	public String getCrpQualification() {
		return crpQualification;
	}

	public void setCrpQualification(String crpQualification) {
		this.crpQualification = crpQualification;
	}

	public String getCrpYearOfExperience() {
		return crpYearOfExperience;
	}

	public void setCrpYearOfExperience(String crpYearOfExperience) {
		this.crpYearOfExperience = crpYearOfExperience;
	}

	public String getCrpAddress() {
		return crpAddress;
	}

	public void setCrpAddress(String crpAddress) {
		this.crpAddress = crpAddress;
	}

	public String getCrpEmailId() {
		return crpEmailId;
	}

	public void setCrpEmailId(String crpEmailId) {
		this.crpEmailId = crpEmailId;
	}

	public int getCrpMobileNo() {
		return crpMobileNo;
	}

	public void setCrpMobileNo(int crpMobileNo) {
		this.crpMobileNo = crpMobileNo;
	}

	public String getCrpBloodGroup() {
		return crpBloodGroup;
	}

	public void setCrpBloodGroup(String crpBloodGroup) {
		this.crpBloodGroup = crpBloodGroup;
	}

	public String getCrpUID() {
		return crpUID;
	}

	public void setCrpUID(String crpUID) {
		this.crpUID = crpUID;
	}

	public String getCrpDepartment() {
		return crpDepartment;
	}

	public void setCrpDepartment(String crpDepartment) {
		this.crpDepartment = crpDepartment;
	}

	public String getCrpDesignation() {
		return crpDesignation;
	}

	public void setCrpDesignation(String crpDesignation) {
		this.crpDesignation = crpDesignation;
	}

	public String getCrpJobRole() {
		return crpJobRole;
	}

	public void setCrpJobRole(String crpJobRole) {
		this.crpJobRole = crpJobRole;
	}

	public String getCrpLocation() {
		return crpLocation;
	}

	public void setCrpLocation(String crpLocation) {
		this.crpLocation = crpLocation;
	}

	public LocalDate getCrpDateOfJoining() {
		return crpDateOfJoining;
	}

	public void setCrpDateOfJoining(LocalDate crpDateOfJoining) {
		this.crpDateOfJoining = crpDateOfJoining;
	}

	public String getCrpSocialCategory() {
		return crpSocialCategory;
	}

	public void setCrpSocialCategory(String crpSocialCategory) {
		this.crpSocialCategory = crpSocialCategory;
	}

	public String getCrpSelectionCategory() {
		return crpSelectionCategory;
	}

	public void setCrpSelectionCategory(String crpSelectionCategory) {
		this.crpSelectionCategory = crpSelectionCategory;
	}

	public String getCrpPostingHistory() {
		return crpPostingHistory;
	}

	public void setCrpPostingHistory(String crpPostingHistory) {
		this.crpPostingHistory = crpPostingHistory;
	}
}

