package in.crm.main.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import in.crm.main.dao.UserDao;
import in.crm.main.master.UserMaster;
import in.crm.main.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceimpl implements UserService {

	private static final Logger logger = LogManager.getLogger(UserServiceimpl.class);

	@Autowired
	private UserDao userDao;

	@Override
	public List<UserMaster> getAllUserService() {
		List<UserMaster> allUsers = new ArrayList<>();
		try {
			logger.info("In getAllDepartmentService");
			allUsers = (List<UserMaster>) userDao.findAll();
			logger.info("Out of getAllUserService");
		} catch (Exception e) {
			logger.error("CRP:" + e.getMessage(), e);
		}
		return allUsers;
	}

	@Override
	public UserMaster getUserServiceById(Integer userId) {
		try {
			logger.info("In getUserService");
			UserMaster userMaster = userDao.findById(userId).orElse(null);
			logger.info("Out of getUserService");
			return userMaster;
		} catch (Exception e) {
			logger.error("CRP:" + e.getMessage(), e);
		}
		return null;
	}

	@Override
	public Boolean addUserService(UserMaster userMaster) {
		try {
			logger.info("In addService");
			userDao.save(userMaster);

			return true;
		} catch (Exception e) {
			logger.info("CRP:" + e.getMessage(), e);
			return false;
		}
	}

	@Override
	public Boolean updateUserService(UserMaster userMaster) {
		try {
			logger.info("In updateService");
			UserMaster user = userDao.findById(userMaster.getUserId())
					.orElseThrow(() -> new RuntimeException("User not found"));

			user.setUserName(userMaster.getUserName());
			user.setDesignation(userMaster.getDesignation());
			user.setEmail(userMaster.getEmail());
			user.setPhoneNo(userMaster.getPhoneNo());
			user.setDateOfJoining(userMaster.getDateOfJoining());
			user.setRole(userMaster.getRole());
			user.setStatus(userMaster.getStatus());
			user.setManagerId(userMaster.getManagerId());

			userDao.save(user);
			logger.info("Out of UpdateUserService");
			return true;
		} catch (Exception e) {
			logger.error("CRP: " + e.getMessage(), e);
			return false;
		}
	}

	@Override
	public Boolean deleteUser(UserMaster userMaster) {
		try {
			logger.info("In DeleteService");
			UserMaster user = userDao.findById(userMaster.getUserId())
					.orElseThrow(() -> new RuntimeException("Department not found"));
			userDao.delete(user);
			logger.info("Out of deleteUserService");
			return true;
		} catch (Exception e) {
			logger.error("CRP:" + e.getMessage(), e);
			return false;
		}
	}

}
