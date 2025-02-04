package in.crm.main.dao;



import org.springframework.data.repository.CrudRepository;

import in.crm.main.master.TourManagementMaster;

public interface TournManagementDAO extends CrudRepository<TourManagementMaster, Integer>{

}
