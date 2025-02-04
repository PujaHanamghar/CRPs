package in.crm.main.master;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "kpi")
public class KpiMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer kpiId;
	private String kpiName;
	private String kpiDesc;
	private String kpiMeasurementCriteria;
	private Integer weightage;
	private Integer targetValue;
	private LocalDate deadline;
	private String category;
	public Integer getKpiId() {
		return kpiId;
	}
	public void setKpiId(Integer kpiId) {
		this.kpiId = kpiId;
	}
	public String getKpiName() {
		return kpiName;
	}
	public void setKpiName(String kpiName) {
		this.kpiName = kpiName;
	}
	public String getKpiDesc() {
		return kpiDesc;
	}
	public void setKpiDesc(String kpiDesc) {
		this.kpiDesc = kpiDesc;
	}
	public String getKpiMeasurementCriteria() {
		return kpiMeasurementCriteria;
	}
	public void setKpiMeasurementCriteria(String kpiMeasurementCriteria) {
		this.kpiMeasurementCriteria = kpiMeasurementCriteria;
	}
	public Integer getWeightage() {
		return weightage;
	}
	public void setWeightage(Integer weightage) {
		this.weightage = weightage;
	}
	public Integer getTargetValue() {
		return targetValue;
	}
	public void setTargetValue(Integer targetValue) {
		this.targetValue = targetValue;
	}
	public LocalDate getDeadline() {
		return deadline;
	}
	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "KpiMaster [kpiId=" + kpiId + ", kpiName=" + kpiName + ", kpiDesc=" + kpiDesc
				+ ", kpiMeasurementCriteria=" + kpiMeasurementCriteria + ", weightage=" + weightage + ", targetValue="
				+ targetValue + ", deadline=" + deadline + ", category=" + category + "]";
	}
	public KpiMaster(Integer kpiId, String kpiName, String kpiDesc, String kpiMeasurementCriteria,
			Integer weightage, Integer targetValue, LocalDate deadline, String category) {
		super();
		this.kpiId = kpiId;
		this.kpiName = kpiName;
		this.kpiDesc = kpiDesc;
		this.kpiMeasurementCriteria = kpiMeasurementCriteria;
		this.weightage = weightage;
		this.targetValue = targetValue;
		this.deadline = deadline;
		this.category = category;
	}
	public KpiMaster() {
		super();
		// TODO Auto-generated constructor stub
	}


}
