package in.crm.main.master;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "qualification")
public class QualificationMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer qualificationId;
	
	private String qualificationName;
	
	private String qualificationDesc;

	public Integer getQualificationId() {
		return qualificationId;
	}

	public void setQualificationId(Integer qualificationId) {
		this.qualificationId = qualificationId;
	}

	public String getQualificationName() {
		return qualificationName;
	}

	public void setQualificationName(String qualificationName) {
		this.qualificationName = qualificationName;
	}

	public String getQualificationDesc() {
		return qualificationDesc;
	}

	public void setQualificationDesc(String qualificationDesc) {
		this.qualificationDesc = qualificationDesc;
	}

	@Override
	public String toString() {
		return "QualificationMaster [qualificationId=" + qualificationId + ", qualificationName=" + qualificationName
				+ ", qualificationDesc=" + qualificationDesc + "]";
	}

	public QualificationMaster(Integer qualificationId, String qualificationName, String qualificationDesc) {
		super();
		this.qualificationId = qualificationId;
		this.qualificationName = qualificationName;
		this.qualificationDesc = qualificationDesc;
	}

	public QualificationMaster() {
		super();
		
	}
	

}
