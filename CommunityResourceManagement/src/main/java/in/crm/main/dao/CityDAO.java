package in.crm.main.dao;

import org.springframework.data.repository.CrudRepository;

import in.crm.main.master.CityMaster;

public interface CityDAO extends CrudRepository<CityMaster, Integer>{

}
