package in.crm.main.master;

import java.sql.Blob;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name="attachment")
public class AttachmentMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer attachmentId;
	@Lob
	private Blob educationCertificates;
	@Lob
	private Blob experienceCertificates;
	@Lob
	private Blob photo;
	@Lob
	private Blob signature;
	
	
	public Integer getAttachmentId() {
		return attachmentId;
	}
	public void setAttachmentId(Integer attachmentId) {
		this.attachmentId = attachmentId;
	}
	public Blob getEducationCertificates() {
		return educationCertificates;
	}
	public void setEducationCertificates(Blob educationCertificates) {
		this.educationCertificates = educationCertificates;
	}
	public Blob getExperienceCertificates() {
		return experienceCertificates;
	}
	public void setExperienceCertificates(Blob experienceCertificates) {
		this.experienceCertificates = experienceCertificates;
	}
	public Blob getPhoto() {
		return photo;
	}
	public void setPhoto(Blob photo) {
		this.photo = photo;
	}
	public Blob getSignature() {
		return signature;
	}
	public void setSignature(Blob signature) {
		this.signature = signature;
	}
	@Override
	public String toString() {
		return "AttachmentMaster [attachmentId=" + attachmentId + ", educationCertificates=" + educationCertificates
				+ ", experienceCertificates=" + experienceCertificates + ", photo=" + photo + ", signature=" + signature
				+ "]";
	}
	public AttachmentMaster(Integer attachmentId, Blob educationCertificates, Blob experienceCertificates, Blob photo,
			Blob signature) {
		super();
		this.attachmentId = attachmentId;
		this.educationCertificates = educationCertificates;
		this.experienceCertificates = experienceCertificates;
		this.photo = photo;
		this.signature = signature;
	}
	public AttachmentMaster() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
