package in.crm.main.service;

import in.crm.main.master.UserMaster;

import java.util.List;


public interface UserService {

	public List<UserMaster> getAllUserService();
	public UserMaster getUserServiceById(Integer userId);
	public Boolean addUserService(UserMaster userMaster);
	public Boolean updateUserService(UserMaster userMaster);
	public Boolean deleteUser(UserMaster userMaster);
}
