package in.crm.main.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.crm.main.dao.CountryDAO;
import in.crm.main.master.CountryMaster;
import in.crm.main.service.CountryService;
@Service
public class CountryServiceIMPL implements CountryService {
	
	@Autowired
	CountryDAO countryDAO;
	
	@Override
	public Boolean addCountryService(CountryMaster countryMaster) {
		try
		  {
			countryDAO.save(countryMaster);
			  return true; 
			  } 
		  catch (Exception e)
		  {
	  e.printStackTrace(); 
	  return false; } 
	}

	@Override
	public Boolean updateCountryService(CountryMaster countryMaster) {
		try
		  {
			  if(countryDAO.existsById(countryMaster.getCountryId()))
			  {
				  countryDAO.save(countryMaster);
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
	public Boolean deleteCountryService(CountryMaster countryMaster) {
		 try 
		  {
			  countryDAO.deleteById(countryMaster.getCountryId()); 
			  return true;
			  }
		  catch (Exception e) { e.printStackTrace(); return false; } 
		  }

	@Override
	public CountryMaster getCountryService(Integer countryId) {
		 try
		  {
			  return countryDAO.findById(countryId).orElse(null);
			  } catch
		  (Exception e) 
		  {
				  e.printStackTrace(); 
				  return null; 
				  }
	}

	@Override
	public List<CountryMaster> getAllCountryService() {
		try {
			return (List<CountryMaster>) countryDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
