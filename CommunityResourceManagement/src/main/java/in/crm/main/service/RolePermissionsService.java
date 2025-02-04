package in.crm.main.service;

import in.crm.main.master.RolePermissionsMaster;

import java.util.List;



public interface RolePermissionsService {

	public List<RolePermissionsMaster> getAllRolePermissionsService();
	public RolePermissionsMaster getRolePermissionsServiceById(Integer perId);
	public Boolean addRolePermissionsService(RolePermissionsMaster rolePermissionsMaster);
	public Boolean updateRolePermissionsService(RolePermissionsMaster rolePermissionsMaster);
	public Boolean deleteRolePermissions(RolePermissionsMaster rolePermissionsMaster);
}
