package in.crm.main.master;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SeperationDetailMaster {
	
	
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int seperationId; 
	  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
    private LocalDate registrationDate;
	  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
    private LocalDate lastWorkingDay;
	private String typeOfSeperation;
	  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
	private LocalDate noticePeriodStartDate;
     private int noticePeriodDays;
     private String reason;
     private String ExitInterviewStatus;
     private String remarks;
	public int getSeperationId() {
		return seperationId;
	}
	public void setSeperationId(int seperationId) {
		this.seperationId = seperationId;
	}
	public LocalDate getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}
	public LocalDate getLastWorkingDay() {
		return lastWorkingDay;
	}
	public void setLastWorkingDay(LocalDate lastWorkingDay) {
		this.lastWorkingDay = lastWorkingDay;
	}
	public String getTypeOfSeperation() {
		return typeOfSeperation;
	}
	public void setTypeOfSeperation(String typeOfSeperation) {
		this.typeOfSeperation = typeOfSeperation;
	}
	public LocalDate getNoticePeriodStartDate() {
		return noticePeriodStartDate;
	}
	public void setNoticePeriodStartDate(LocalDate noticePeriodStartDate) {
		this.noticePeriodStartDate = noticePeriodStartDate;
	}
	public int getNoticePeriodDays() {
		return noticePeriodDays;
	}
	public void setNoticePeriodDays(int noticePeriodDays) {
		this.noticePeriodDays = noticePeriodDays;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getExitInterviewStatus() {
		return ExitInterviewStatus;
	}
	public void setExitInterviewStatus(String exitInterviewStatus) {
		ExitInterviewStatus = exitInterviewStatus;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


}
