package in.crm.main.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.crm.main.dao.LocationMasterDAO;
import in.crm.main.master.LeaveManagementMaster;
import in.crm.main.master.LocationMaster;
import in.crm.main.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService {

	private static final Logger logger=LogManager.getLogger(LocationServiceImpl.class);
	
	@Autowired
	private LocationMasterDAO locationMasterDAO;
	@Override
	public Boolean addLocationService(LocationMaster locationMaster) {
		
		locationMasterDAO.save(locationMaster);
		return true;
	}

	@Override
	public Boolean updateLocationService(LocationMaster locationMaster) {
		
		try {
            logger.info("In updateLocationService");
            locationMasterDAO.findById(locationMaster.getLocationId());
            locationMaster.setLocationName(locationMaster.getLocationName());
            locationMaster.setLocationDesc(locationMaster.getLocationDesc());
            
            locationMasterDAO.save(locationMaster);
           
            logger.info("In updateLocationService");
            return true;
        } catch (RuntimeException e) {
            logger.info("CRP: " + e.getMessage(), e);
            return false;
        }
	}

	@Override
	public Boolean deleteLocationService(LocationMaster locationMaster) {
		
		try {
            logger.info("In deleteLeaveManagementService");
            locationMasterDAO.findById(locationMaster.getLocationId());
            locationMasterDAO.delete(locationMaster);
             return true;
        }
        catch (Exception e)
        {
            return false;
        }
		
	}

	@Override
	public LocationMaster getLocationMasterService(Integer locationId) {
		try {
            logger.info("In getLocationMasterService");
            LocationMaster locationMaster=locationMasterDAO.findById(locationId).orElse(null);
             logger.info("Out of getLocationMasterService");
            
            return locationMaster;
        }
        catch (Exception e)
        {
            logger.info("CRP:"+e.getMessage(),e);
            return null;
        }

	}

	@Override
	public List<LocationMaster> getAllLocationMaster() {
		 
		List<LocationMaster> allLocationMaster = new ArrayList<>();
	        try {
	            logger.info(" In getAllLocationMaster");
	            allLocationMaster=(List<LocationMaster>) locationMasterDAO.findAll();
	            logger.info(" Out Of getAllLocationMaster");
	        }
	        catch (Exception e)
	        {
	            logger.error("CRP: "+e.getMessage());
	        }
	        return allLocationMaster;
	    }

	}


