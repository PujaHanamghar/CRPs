package in.crm.main.dao;

import in.crm.main.master.UserMaster;
import org.springframework.data.repository.CrudRepository;



public interface UserDao extends CrudRepository<UserMaster, Integer>{

}
