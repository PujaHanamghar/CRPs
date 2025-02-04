package in.crm.main.dao;

import in.crm.main.master.ProfilesMaster;
import org.springframework.data.repository.CrudRepository;



public interface ProfilesDao extends CrudRepository<ProfilesMaster, Integer>{

}
