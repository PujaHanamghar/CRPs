package in.crm.main.dao;

import in.crm.main.master.DepartmentMaster;
import org.springframework.data.repository.CrudRepository;


//This is Dao
public interface DepartmentDao extends CrudRepository<DepartmentMaster, Integer>{


}
