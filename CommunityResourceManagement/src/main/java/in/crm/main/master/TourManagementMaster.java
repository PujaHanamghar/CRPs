package in.crm.main.master;



import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tourmanagement")

public class TourManagementMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Integer tourId;
	private String destination; 
	private Date startDate;
	private Date endDate;
	private String purpose;
	private String modeOfTravel;
	private  String budgetAllocated;
	private  String actualExpense;
	private  String expenseRemarks;
	private String status;
	public Integer getTourId() {
		return tourId;
	}
	public void setTourId(Integer tourId) {
		this.tourId = tourId;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getModeOfTravel() {
		return modeOfTravel;
	}
	public void setModeOfTravel(String modeOfTravel) {
		this.modeOfTravel = modeOfTravel;
	}
	public String getBudgetAllocated() {
		return budgetAllocated;
	}
	public void setBudgetAllocated(String budgetAllocated) {
		this.budgetAllocated = budgetAllocated;
	}
	public String getActualExpense() {
		return actualExpense;
	}
	public void setActualExpense(String actualExpense) {
		this.actualExpense = actualExpense;
	}
	public String getExpenseRemarks() {
		return expenseRemarks;
	}
	public void setExpenseRemarks(String expenseRemarks) {
		this.expenseRemarks = expenseRemarks;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "TourManagementMaster [tourId=" + tourId + ", destination=" + destination + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", purpose=" + purpose + ", modeOfTravel=" + modeOfTravel
				+ ", budgetAllocated=" + budgetAllocated + ", actualExpense=" + actualExpense + ", expenseRemarks="
				+ expenseRemarks + ", status=" + status + "]";
	}
	public TourManagementMaster(Integer tourId, String destination, Date startDate, Date endDate, String purpose,
			String modeOfTravel, String budgetAllocated, String actualExpense, String expenseRemarks, String status) {
		super();
		this.tourId = tourId;
		this.destination = destination;
		this.startDate = startDate;
		this.endDate = endDate;
		this.purpose = purpose;
		this.modeOfTravel = modeOfTravel;
		this.budgetAllocated = budgetAllocated;
		this.actualExpense = actualExpense;
		this.expenseRemarks = expenseRemarks;
		this.status = status;
	}
	public TourManagementMaster() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
