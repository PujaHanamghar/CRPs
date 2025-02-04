package in.crm.main.master;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ptraits")
public class PotentialTraitsMaster {


	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pTraitId;
	private String pTraitName;
	private String pDescription;
	private String pMeasurementCriteria;
	private String weightage;
	private String pScoreRange;
	private String pTraitType;
	public Integer getpTraitId() {
		return pTraitId;
	}
	public void setpTraitId(Integer pTraitId) {
		this.pTraitId = pTraitId;
	}
	public String getpTraitName() {
		return pTraitName;
	}
	public void setpTraitName(String pTraitName) {
		this.pTraitName = pTraitName;
	}
	public String getpDescription() {
		return pDescription;
	}
	public void setpDescription(String pDescription) {
		this.pDescription = pDescription;
	}
	public String getpMeasurementCriteria() {
		return pMeasurementCriteria;
	}
	public void setpMeasurementCriteria(String pMeasurementCriteria) {
		this.pMeasurementCriteria = pMeasurementCriteria;
	}
	public String getWeightage() {
		return weightage;
	}
	public void setWeightage(String weightage) {
		this.weightage = weightage;
	}
	public String getpScoreRange() {
		return pScoreRange;
	}
	public void setpScoreRange(String pScoreRange) {
		this.pScoreRange = pScoreRange;
	}
	public String getpTraitType() {
		return pTraitType;
	}
	public void setpTraitType(String pTraitType) {
		this.pTraitType = pTraitType;
	}
	@Override
	public String toString() {
		return "PotentialTraitsMaster [pTraitId=" + pTraitId + ", pTraitName=" + pTraitName + ", pDescription=" + pDescription
				+ ", pMeasurementCriteria=" + pMeasurementCriteria + ", weightage=" + weightage + ", pScoreRange="
				+ pScoreRange + ", pTraitType=" + pTraitType + "]";
	}
	public PotentialTraitsMaster(Integer pTraitId, String pTraitName, String pDescription, String pMeasurementCriteria,
			String weightage, String pScoreRange, String pTraitType) {
		super();
		this.pTraitId = pTraitId;
		this.pTraitName = pTraitName;
		this.pDescription = pDescription;
		this.pMeasurementCriteria = pMeasurementCriteria;
		this.weightage = weightage;
		this.pScoreRange = pScoreRange;
		this.pTraitType = pTraitType;
	}
	public PotentialTraitsMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

}
