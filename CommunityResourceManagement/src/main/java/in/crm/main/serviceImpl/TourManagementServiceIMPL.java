package in.crm.main.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.crm.main.dao.TournManagementDAO;
import in.crm.main.master.TourManagementMaster;
import in.crm.main.service.TourManagementService;

@Service
public class TourManagementServiceIMPL implements TourManagementService {

	@Autowired
	TournManagementDAO tourManagementDAO;
	
	
	@Override
	public Boolean addTourManagementService(TourManagementMaster tourManagementMaster) {
		try
		  {
			tourManagementDAO.save(tourManagementMaster);
			  return true; 
			  } 
		  catch (Exception e)
		  {
	  e.printStackTrace(); 
	  return false; } 
	}

	

	@Override
	public Boolean updateTourManagementService(TourManagementMaster tourManagementMaster) {
		try
		  {
			  if(tourManagementDAO.existsById(tourManagementMaster.getTourId()))
			  {
				  tourManagementDAO.save(tourManagementMaster);
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
	public Boolean deleteTourManagementService(TourManagementMaster tourManagementMaster) {
		 try 
		  {
			 tourManagementDAO.deleteById(tourManagementMaster.getTourId()); 
			  return true;
			  }
		  catch (Exception e) { e.printStackTrace(); return false; } 
		  }
	

	@Override
	public TourManagementMaster getTourManagementService(Integer TourId) {
		try
		  {
			  return tourManagementDAO.findById(TourId).orElse(null);
			  } catch
		  (Exception e) 
		  {
				  e.printStackTrace(); 
				  return null; 
				  }
	}
	

	@Override
	public List<TourManagementMaster> getAllTourManagementService() {
		try {
			return (List<TourManagementMaster>) tourManagementDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
