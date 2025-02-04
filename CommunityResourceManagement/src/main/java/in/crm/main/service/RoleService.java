package in.crm.main.service;

import in.crm.main.master.RoleMaster;

import java.util.List;



public interface RoleService {

	public List<RoleMaster> getAllRoleService();
	public RoleMaster getRoleServiceById(Integer roleId);
	public Boolean addRoleService(RoleMaster roleMaster);
	public Boolean updateRoleService(RoleMaster roleMaster);
	public Boolean deleteRole(RoleMaster roleMaster);
}
