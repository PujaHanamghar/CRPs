package in.crm.main.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import in.crm.main.dao.RoleDao;
import in.crm.main.master.RoleMaster;
import in.crm.main.service.RoleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoleServiceImpl implements RoleService {

	private static final Logger logger = LogManager.getLogger(RoleServiceImpl.class);

	@Autowired
	private RoleDao roleDao;

	@Override
	public List<RoleMaster> getAllRoleService() {
		List<RoleMaster> allRoles = new ArrayList<>();
		try {
			logger.info("In GetAllRoleService");
			allRoles = (List<RoleMaster>) roleDao.findAll();
			logger.info("Out of GetAllRoleService");
		} catch (Exception e) {
			logger.error("CRP:" + e.getMessage(), e);
		}
		return allRoles;
	}

	@Override
	public RoleMaster getRoleServiceById(Integer roleId) {
		try {
			logger.info("In getRoleService");
			RoleMaster role = roleDao.findById(roleId).orElse(null);
			logger.info("Out of getRoleService");
			return role;
		} catch (Exception e) {
			logger.error("CRP:" + e.getMessage(), e);
		}
		return null;
	}

	@Override
	public Boolean addRoleService(RoleMaster roleMaster) {
		try {
			logger.info("In addService");
			roleDao.save(roleMaster);
			return true;
		} catch (Exception e) {
			logger.info("CRP:" + e.getMessage(), e);
			return false;
		}
	}

	@Override
	public Boolean updateRoleService(RoleMaster roleMaster) {

		try {
			logger.info("In updateService");
			RoleMaster role = roleDao.findById(roleMaster.getRoleId())
					.orElseThrow(() -> new RuntimeException("Role not found"));

			role.setRoleName(roleMaster.getRoleName());
			role.setRoledesc(roleMaster.getRoledesc());
			role.setRoleCanAdd(roleMaster.getRoleCanAdd());
			role.setRoleCanDelete(roleMaster.getRoleCanDelete());
			role.setRoleCanEdit(roleMaster.getRoleCanEdit());
			role.setRoleCanView(roleMaster.getRoleCanView());

			roleDao.save(role);
			logger.info("Out Of UpdateRoleService");
			return true;
		} catch (Exception e) {
			logger.error("CRP:" + e.getMessage(), e);
			return false;
		}
	}

	@Override
	public Boolean deleteRole(RoleMaster roleMaster) {
		try {
			logger.info("In DeleteService");
			RoleMaster role = roleDao.findById(roleMaster.getRoleId())
					.orElseThrow(() -> new RuntimeException("Role not fount"));
			roleDao.delete(role);
			logger.info("Out of DeleteRoleService");
			return true;
		} catch (Exception e) {
			logger.error("CRP:" + e.getMessage(), e);
			return false;
		}

	}

}
