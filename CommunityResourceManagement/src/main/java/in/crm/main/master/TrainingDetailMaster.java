package in.crm.main.master;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "trainingDetail")
public class TrainingDetailMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer trainingId;
	private String trainingName;
	private LocalDate trainingStartDate;
	private LocalDate trainingEndDate;
	private String trainingProvider;
	private String remark;
	public Integer getTrainingId() {
		return trainingId;
	}
	public void setTrainingId(Integer trainingId) {
		this.trainingId = trainingId;
	}
	public String getTrainingName() {
		return trainingName;
	}
	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}
	public LocalDate getTrainingStartDate() {
		return trainingStartDate;
	}
	public void setTrainingStartDate(LocalDate trainingStartDate) {
		this.trainingStartDate = trainingStartDate;
	}
	public LocalDate getTrainingEndDate() {
		return trainingEndDate;
	}
	public void setTrainingEndDate(LocalDate trainingEndDate) {
		this.trainingEndDate = trainingEndDate;
	}
	public String getTrainingProvider() {
		return trainingProvider;
	}
	public void setTrainingProvider(String trainingProvider) {
		this.trainingProvider = trainingProvider;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "TrainingDetailMaster [trainingId=" + trainingId + ", trainingName=" + trainingName + ", trainingStartDate="
				+ trainingStartDate + ", trainingEndDate=" + trainingEndDate + ", trainingProvider=" + trainingProvider
				+ ", remark=" + remark + "]";
	}
	public TrainingDetailMaster(Integer trainingId, String trainingName, LocalDate trainingStartDate,
			LocalDate trainingEndDate, String trainingProvider, String remark) {
		super();
		this.trainingId = trainingId;
		this.trainingName = trainingName;
		this.trainingStartDate = trainingStartDate;
		this.trainingEndDate = trainingEndDate;
		this.trainingProvider = trainingProvider;
		this.remark = remark;
	}
	public TrainingDetailMaster() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
