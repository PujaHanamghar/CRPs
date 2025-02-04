package in.crm.main.dao;

import in.crm.main.master.RolePermissionsMaster;
import org.springframework.data.repository.CrudRepository;


public interface RolePermissionDao extends CrudRepository<RolePermissionsMaster, Integer>{

}
