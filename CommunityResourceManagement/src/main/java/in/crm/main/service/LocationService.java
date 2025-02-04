package in.crm.main.service;

import java.util.List;

import in.crm.main.master.LeaveManagementMaster;
import in.crm.main.master.LocationMaster;

public interface LocationService {
	
	public Boolean addLocationService(LocationMaster locationMaster);
	public Boolean updateLocationService(LocationMaster locationMaster);
	public Boolean deleteLocationService(LocationMaster locationMaster);
	
	public LocationMaster getLocationMasterService(Integer locationId);
	public List<LocationMaster> getAllLocationMaster();
	
}
