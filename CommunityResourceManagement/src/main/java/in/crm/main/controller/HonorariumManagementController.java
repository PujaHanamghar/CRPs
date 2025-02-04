package in.crm.main.controller;

import in.crm.main.master.HonorariumManagementMaster;
import in.crm.main.master.PostingHistoryMaster;
import in.crm.main.service.HonorariumManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/HonorariumManagement")
public class HonorariumManagementController {

    @Autowired
    private HonorariumManagementService honorariumManagementService;

    @PostMapping("/addHonorariumManagement")
    public ResponseEntity<String> addHonorariumManagement(@RequestBody HonorariumManagementMaster honorariumManagementMaster)
    {
        Boolean isAdded = honorariumManagementService.addHonorariumManagementService(honorariumManagementMaster);
        if(isAdded){
            return  new ResponseEntity<>("HonorariumManagementMaster added successfully !", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Failed to add HonorariumManagementMaster",HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateHonorariumManagement/{honorariumId}")
    public ResponseEntity<String> updateHonorariumManagement(@PathVariable("honorariumId") Integer honorariumId,@RequestBody HonorariumManagementMaster honorariumManagementMaster)
    {
        honorariumManagementMaster.setHonorariumId(honorariumId);
        Boolean isUpdated=honorariumManagementService.updateHonorariumManagementService(honorariumManagementMaster);
        if(isUpdated)
        {
            return new ResponseEntity<>("HonorariumManagementMaster updated successfully!",HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("Failed to update HonorariumManagementMaster",HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteHonorariumManagement/{honorariumId}")
    public ResponseEntity<String> deleteHonorariumManagement(@PathVariable("honorariumId") Integer honorariumId,@RequestBody HonorariumManagementMaster honorariumManagementMaster)
      {
          honorariumManagementService.getHonorariumManagementService(honorariumId);
        if(honorariumManagementMaster!= null)
        {
            Boolean isDeleted = honorariumManagementService.deleteHonorariumManagementService(honorariumManagementMaster);
            if(isDeleted)
            {
                return new ResponseEntity<>("HonorariumManagement deleted successfully",HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("failed to delete HonorariumManagement",HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/getHonorariumManagement/{honorariumId}")
    public ResponseEntity<HonorariumManagementMaster>getHonorariumManagement(@PathVariable("honorariumId") Integer honorariumId)
    {
        HonorariumManagementMaster honorariumManagementMaster=honorariumManagementService.getHonorariumManagementService(honorariumId);
        if (honorariumManagementMaster!=null)
        {
            return new ResponseEntity<>(honorariumManagementMaster,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllHonorariumManagement")
    public ResponseEntity<List<HonorariumManagementMaster>> getAllHonorariumManagement()
    {
        List<HonorariumManagementMaster> allHonorariumManagement= honorariumManagementService.getAllHonorariumManagementService();
        return new ResponseEntity<>(allHonorariumManagement,HttpStatus.OK);
    }







}
