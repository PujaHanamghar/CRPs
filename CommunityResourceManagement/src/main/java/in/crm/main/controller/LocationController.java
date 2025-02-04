package in.crm.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.crm.main.master.LeaveManagementMaster;
import in.crm.main.master.LocationMaster;
import in.crm.main.service.LocationService;

@RestController
@RequestMapping("/Location")
public class LocationController {
	
	@Autowired
	private LocationService locationservice;

    @PostMapping("/addLocation")
    public ResponseEntity<String> addLocation(@RequestBody LocationMaster locationMaster)
    {
    	Boolean isAdded = locationservice.addLocationService(locationMaster);
        if(isAdded){
            return  new ResponseEntity<>("location  added successfully !", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Failed to add location",HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("/updateLocation/{locationId}")
    public ResponseEntity<String> updateLocation(@PathVariable("locationId") Integer locationId,@RequestBody LocationMaster locationMaster)
    {
    	locationMaster.setLocationId(locationId);

        Boolean isUpdated=locationservice.updateLocationService(locationMaster);
        if(isUpdated)
        {
            return new ResponseEntity<>("Location  updated successfully!",HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("Failed to update location",HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteLocation/{locationId}")
    public ResponseEntity<String> deleteLocation(@PathVariable("locationId") Integer locationId,@RequestBody LocationMaster locationMaster)
    {
    	
    	locationservice.getLocationMasterService(locationId);	
     
        if(locationMaster!= null)
        {
            Boolean isDeleted = locationservice.deleteLocationService(locationMaster);
            if(isDeleted)
            {
                return new ResponseEntity<>("Location deleted successfully",HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("failed to delete Location",HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getLocation/{locationId}")
    public ResponseEntity<LocationMaster>getLocation(@PathVariable("locationId") Integer locationId)
    {
         LocationMaster locationMaster=locationservice.getLocationMasterService(locationId);
    	 if (locationMaster!=null)
        {
            return new ResponseEntity<>(locationMaster,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllLocation")
    public ResponseEntity<List<LocationMaster>> getAllLocation()
    {
        List<LocationMaster> allLocation= locationservice.getAllLocationMaster();
        return new ResponseEntity<>(allLocation,HttpStatus.OK);
    }



	

}
