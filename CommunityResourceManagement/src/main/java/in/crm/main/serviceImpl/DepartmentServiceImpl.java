package in.crm.main.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import in.crm.main.dao.DepartmentDao;
import in.crm.main.master.DepartmentMaster;
import in.crm.main.service.DepartmentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class DepartmentServiceImpl implements DepartmentService {

	
	private static final Logger logger = LogManager.getLogger(DepartmentServiceImpl.class);
	
	@Autowired
	private DepartmentDao departmentDao;

	@Override
	public List<DepartmentMaster> getAllDepartmentService() {
		List<DepartmentMaster> allDepartments = new ArrayList<>();
		try {
			logger.info("In getAllDepartmentService");
			allDepartments = (List<DepartmentMaster>) departmentDao.findAll();
			logger.info("Out of getAllDepartmentService");
		}catch (Exception e) {
			logger.error("CRP:" + e.getMessage(), e);
		}
		return allDepartments;
	}

	@Override
	public DepartmentMaster getDepartmentServiceById(Integer departmentId) {
		try {
			logger.info("In getDepartmentService");
			DepartmentMaster departmentMaster = departmentDao.findById(departmentId).orElse(null);
			logger.info("Out of getDesignationService");
			return departmentMaster;
		}catch (Exception e) {
			logger.error("CRP:" + e.getMessage(),e);
		}
		return null;
	}

	@Override
	public Boolean addDepartmentService(DepartmentMaster departmentMaster) {
		try {
			logger.info("In addService");
			departmentDao.save(departmentMaster);
			
		  return true;
		} catch(Exception e){
			logger.info("CRP:" + e.getMessage(),e);
			return false;
		}
		
	}

	@Override
	public Boolean updateDepartmentService(DepartmentMaster departmentMaster) {
		 try {
		        logger.info("In updateService");
		        DepartmentMaster department = departmentDao.findById(departmentMaster.getDepartmentId())
		            .orElseThrow(() -> new RuntimeException("Department not found"));

		        department.setDeparntmentName(departmentMaster.getDeparntmentName());
		        department.setDepartmentDesc(departmentMaster.getDepartmentDesc());

		        departmentDao.save(department);
		        logger.info("Out of updateDepartmentService");
		        return true;
		    } catch (Exception e) {
		        logger.error("CRP: " + e.getMessage(), e);
		        return false;
		    }
		
	}

	@Override
	public Boolean deleteDepartment(DepartmentMaster departmentMaster) {
		try {
			logger.info("In DeleteService");
			DepartmentMaster department = departmentDao.findById(departmentMaster.getDepartmentId()).orElseThrow(() -> new RuntimeException("Department not found"));
			departmentDao.delete(department);
			logger.info("Out of deleteDepartmentService");
			return true;
		}catch (Exception e) {
			logger.error("CRP:" +e.getMessage(),e);
			return false;
		}
	
	}

	


}
