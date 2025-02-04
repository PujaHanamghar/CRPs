package in.crm.main.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.crm.main.dao.CityDAO;
import in.crm.main.master.CityMaster;
import in.crm.main.service.CityService;

@Service
public class CityServiceIMPL implements CityService {


	@Autowired
	CityDAO cityDAO;
	
	
	@Override
	public Boolean addCityService(CityMaster cityMaster) {
		try
		  {
			cityDAO.save(cityMaster);
			  return true; 
			  } 
		  catch (Exception e)
		  {
	  e.printStackTrace(); 
	  return false; } 
	}


	@Override
	public Boolean updateCityService(CityMaster cityMaster) {
		try
		  {
			  if(cityDAO.existsById(cityMaster.getCityId()))
			  {
				  cityDAO.save(cityMaster);
				  return true;
				  }
			  else
			  {
				  System.out.println("country not found for update."); 
				  return false; 
				  }
			  }
	  catch (Exception e) { e.printStackTrace(); 
	  return false; 
	  }
	}

	@Override
	public Boolean deleteCityService(CityMaster cityMaster) {
		 try 
		  {
			 cityDAO.deleteById(cityMaster.getCityId()); 
			  return true;
			  }
		  catch (Exception e) { e.printStackTrace(); return false; } 
		  }
	

	@Override
	public CityMaster getCityService(Integer cityId) {
		 try
		  {
			  return cityDAO.findById(cityId).orElse(null);
			  } catch
		  (Exception e) 
		  {
				  e.printStackTrace(); 
				  return null; 
				  }
	}

	@Override
	public List<CityMaster> getAllCityService() {
		try {
			return (List<CityMaster>) cityDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
