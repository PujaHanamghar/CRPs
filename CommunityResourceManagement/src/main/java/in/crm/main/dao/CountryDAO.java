package in.crm.main.dao;
import org.springframework.data.repository.CrudRepository;

import in.crm.main.master.CountryMaster;

public interface CountryDAO extends CrudRepository<CountryMaster, Integer>{

}
