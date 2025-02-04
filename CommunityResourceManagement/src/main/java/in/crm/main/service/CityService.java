package in.crm.main.service;



import java.util.List;

import in.crm.main.master.CityMaster;

public interface CityService {
		

	  public Boolean addCityService(CityMaster cityMaster);
	  public Boolean updateCityService(CityMaster cityMaster);
	  public Boolean deleteCityService(CityMaster cityMaster);
	  public CityMaster getCityService(Integer cityId);
	  public List<CityMaster> getAllCityService();
	    
	
	
}
