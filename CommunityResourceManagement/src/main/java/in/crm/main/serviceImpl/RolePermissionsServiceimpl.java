package in.crm.main.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import in.crm.main.dao.RolePermissionDao;
import in.crm.main.master.RolePermissionsMaster;
import in.crm.main.service.RolePermissionsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RolePermissionsServiceimpl implements RolePermissionsService {

	private static final Logger logger = LogManager.getLogger(DepartmentServiceImpl.class);
	
	@Autowired
	private RolePermissionDao rolePermissionDao;
	@Override
	public List<RolePermissionsMaster> getAllRolePermissionsService() {
		List<RolePermissionsMaster> allRole = new ArrayList<>();
		try {
			logger.info("In getAllRolePerService");
			allRole = (List<RolePermissionsMaster>) rolePermissionDao.findAll();
			logger.info("Out of getAllRolePerService");
		}catch (Exception e) {
			logger.error("CRP:" + e.getMessage(), e);
		}
		return allRole;
	}

	@Override
	public RolePermissionsMaster getRolePermissionsServiceById(Integer perId) {
		try {
			logger.info("In getRolePerService");
			RolePermissionsMaster rolePermission = rolePermissionDao.findById(perId).orElse(null);
			logger.info("Out of getRolePerService");
			return rolePermission;
		}catch (Exception e) {
			logger.error("CRP:" + e.getMessage(),e);
		}
		return null;
	}

	@Override
	public Boolean addRolePermissionsService(RolePermissionsMaster rolePermissionsMaster) {
		try {
			logger.info("In addService");
			rolePermissionDao.save(rolePermissionsMaster);
			
		  return true;
		} catch(Exception e){
			logger.info("CRP:" + e.getMessage(),e);
			return false;
		}
	}

	@Override
	public Boolean updateRolePermissionsService(RolePermissionsMaster rolePermissionsMaster) {
		try {
	        logger.info("In updateService");
	        RolePermissionsMaster roles = rolePermissionDao.findById(rolePermissionsMaster.getPerId())
	            .orElseThrow(() -> new RuntimeException("role not found"));

	        roles.setRole(rolePermissionsMaster.getRole());
	        roles.setModuleName(rolePermissionsMaster.getModuleName());
	        roles.setCanView(rolePermissionsMaster.getCanView());
	        roles.setCanEdit(rolePermissionsMaster.getCanEdit());
	        roles.setCanDelete(rolePermissionsMaster.getCanDelete());

	        rolePermissionDao.save(roles);
	        logger.info("Out of deleteRolesPermissionService");
	        return true;
	    } catch (Exception e) {
	        logger.error("CRP: " + e.getMessage(), e);
	        return false;
	    }
	}

	@Override
	public Boolean deleteRolePermissions(RolePermissionsMaster rolePermissionsMaster) {
		try {
			logger.info("In DeleteService");
			RolePermissionsMaster roles = rolePermissionDao.findById(rolePermissionsMaster.getPerId()).orElseThrow(() -> new RuntimeException("rolesPermission not found"));
			rolePermissionDao.delete(roles);
			logger.info("Out of deleteRolesPermissionService");
			return true;
		}catch (Exception e) {
			logger.error("CRP:" +e.getMessage(),e);
			return false;
		}
	}

}
