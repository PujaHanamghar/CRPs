package in.crm.main.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import in.crm.main.dao.SeperationTypeDao;
import in.crm.main.master.SeperationTypeMaster;
import in.crm.main.service.SeperationtypeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SeperationTypeServiceImpl implements SeperationtypeService {
	
	private static final Logger logger = LogManager.getLogger(DepartmentServiceImpl.class);

	@Autowired
	private SeperationTypeDao seperationTypeDao;

	@Override
	public List<SeperationTypeMaster> getAllSepTypeService() {
		List<SeperationTypeMaster> allSepType = new ArrayList<>();
		try {
			logger.info("In getAllSeperationTypeService");
			allSepType = (List<SeperationTypeMaster>) seperationTypeDao.findAll();
			logger.info("Out of getAllSeperationTypeService");
		}catch (Exception e) {
			logger.error("CRP:" + e.getMessage(), e);
		}
		return allSepType;
	}

	@Override
	public SeperationTypeMaster getSepTypeServiceById(Integer sepTypeId) {
		try {
			logger.info("In getSeperationtypeService");
			SeperationTypeMaster sepetation = seperationTypeDao.findById(sepTypeId).orElse(null);
			logger.info("Out of getSeperationTypeService");
			return sepetation;
		}catch (Exception e) {
			logger.error("CRP:" + e.getMessage(),e);
		}
		return null;
	}

	@Override
	public Boolean addSepTypeService(SeperationTypeMaster seperationTypeMaster) {
		try {
			logger.info("In addService");
			seperationTypeDao.save(seperationTypeMaster);
			
		  return true;
		} catch(Exception e){
			logger.info("CRP:" + e.getMessage(),e);
			return false;
		}
	}

	@Override
	public Boolean updateSepTypeService(SeperationTypeMaster seperationTypeMaster) {
		 try {
		        logger.info("In updateService");
		        SeperationTypeMaster seperation = seperationTypeDao.findById(seperationTypeMaster.getSepTypeId())
		            .orElseThrow(() -> new RuntimeException("SeperationType not found"));

		        seperation.setSepTypeName(seperationTypeMaster.getSepTypeName());
		        seperation.setSepStatus(seperationTypeMaster.getSepStatus());
		        seperation.setSepTypeDesc(seperationTypeMaster.getSepTypeDesc());

		        seperationTypeDao.save(seperation);
		        logger.info("Out of updateSeperationtypeService");
		        return true;
		    } catch (Exception e) {
		        logger.error("CRP: " + e.getMessage(), e);
		        return false;
		    }
	}

	@Override
	public Boolean deleteSepType(SeperationTypeMaster seperationTypeMaster) {
		try {
			logger.info("In DeleteService");
			SeperationTypeMaster seperation = seperationTypeDao.findById(seperationTypeMaster.getSepTypeId()).orElseThrow(() -> new RuntimeException("Seperationtype not found"));
			seperationTypeDao.delete(seperation);
			logger.info("Out of deleteSeperationTypeService");
			return true;
		}catch (Exception e) {
			logger.error("CRP:" +e.getMessage(),e);
			return false;
		}
	}
}
