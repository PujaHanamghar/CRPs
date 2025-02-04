package in.crm.main.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import in.crm.main.dao.QualificationDao;
import in.crm.main.master.QualificationMaster;
import in.crm.main.service.QualificationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class QualificationServiceImpl implements QualificationService {
	
	private static final Logger logger = LogManager.getLogger(QualificationServiceImpl.class);

	@Autowired
	private QualificationDao qualificationDao;
	
	@Override
	public List<QualificationMaster> getAllQualificationService() {
		List<QualificationMaster> allQualifications = new ArrayList<>();
		try {
			logger.info("In getAllQualificationService");
			allQualifications = (List<QualificationMaster>) qualificationDao.findAll();
			logger.info("Out of getAllQualificationServices");
		}catch (Exception e) {
			logger.info("CRP" + e.getMessage(),e);
		}
		
		return allQualifications;
	}

	@Override
	public QualificationMaster getQualificationServcieById(Integer qualificationId) {
		try {
			logger.info("In getQualificationService");
			QualificationMaster qualificationMaster = qualificationDao.findById(qualificationId).orElse(null);
			logger.info("Out of getQualificationService");
			return qualificationMaster;
		}catch (Exception e) {
			logger.error("CRP:" + e.getMessage(),e);
		}
		return null;
		
	}

	@Override
	public Boolean addQualificationService(QualificationMaster qualificationMaster) {
		try {
			logger.info("In addService");
			qualificationDao.save(qualificationMaster);
			
		  return true;
		} catch(Exception e){
			logger.info("CRP:" + e.getMessage(),e);
			return false;
		}
	}

	
	@Override
	public Boolean updateQualificationService(QualificationMaster qualificationMaster) {
		try {
			logger.info("In UpdateService");
			QualificationMaster quali = qualificationDao.findById(qualificationMaster.getQualificationId())
					.orElseThrow(() -> new RuntimeException("Qualification not found"));
			
			quali.setQualificationName(qualificationMaster.getQualificationName());
			quali.setQualificationDesc(qualificationMaster.getQualificationDesc());
			
			qualificationDao.save(quali);
			logger.info("Out of update Qualification com.crp.service");
			return true;
		} catch (Exception e) {
			logger.error("CRP:" + e.getMessage());
			return false;
		}
	
	}


	@Override
	public Boolean deleteQualificationService(QualificationMaster qualificationMaster) {
		try {
			logger.info("In DeleteService");
			QualificationMaster quali = qualificationDao.findById(qualificationMaster.getQualificationId()).orElseThrow(() -> new RuntimeException("qualification not found"));
	        qualificationDao.delete(quali);
	        logger.info("out of deleteQualificationService");
	        return true;
		} catch (Exception e) {
			logger.error("CRP:" + e.getMessage(), e);
			return false;
		}
	
	}


}
