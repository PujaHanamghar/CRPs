package in.crm.main.service;

import in.crm.main.master.QualificationMaster;

import java.util.List;



public interface QualificationService {

	public List<QualificationMaster> getAllQualificationService();
	public QualificationMaster getQualificationServcieById(Integer qualificationId);
	public Boolean addQualificationService(QualificationMaster qualificationMaster);
	public Boolean updateQualificationService(QualificationMaster qualificationMaster);
	public Boolean deleteQualificationService(QualificationMaster qualificationMaster);
}
