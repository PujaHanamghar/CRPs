package in.crm.main.dao;

import in.crm.main.master.DesignationMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface DesignationDAO extends CrudRepository<DesignationMaster,Integer>
{


}
