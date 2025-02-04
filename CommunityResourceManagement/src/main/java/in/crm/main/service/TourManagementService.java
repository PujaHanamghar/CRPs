package in.crm.main.service;



import java.util.List;

import in.crm.main.master.TourManagementMaster;


public interface TourManagementService {
	  public Boolean addTourManagementService(TourManagementMaster tourManagementMaster);
	  public Boolean updateTourManagementService(TourManagementMaster tourManagementMaster);
	  public Boolean deleteTourManagementService(TourManagementMaster tourManagementMaster);
	  public TourManagementMaster getTourManagementService(Integer tourManagementId);
	  public List<TourManagementMaster> getAllTourManagementService();
	    
}
