package in.crm.main.controller;

import in.crm.main.master.HonorariumHistoryMaster;
import in.crm.main.master.HonorariumManagementMaster;
import in.crm.main.service.HonorariumHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("HonorariumHistory")
public class HonorariumHistoryController {

    @Autowired
    private HonorariumHistoryService honorariumHistoryService;


    @PostMapping("/addHonorariumHistory")
    public ResponseEntity<String> addHonorariumHistory(@RequestBody HonorariumHistoryMaster honorariumHistoryMaster)
    {
        Boolean isAdded = honorariumHistoryService.addHonorariumHistoryService(honorariumHistoryMaster);
        if(isAdded){
            return  new ResponseEntity<>("HonorariumHistory added successfully !", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Failed to add HonorariumHistory",HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("/updateHonorariumHistory/{hid}")
    public ResponseEntity<String> updateHonorariumHistory(@PathVariable("hid") Integer hid,@RequestBody HonorariumHistoryMaster honorariumHistoryMaster)
    {
        honorariumHistoryMaster.setHid(hid);
        Boolean isUpdated=honorariumHistoryService.updateHonorariumHistoryService(honorariumHistoryMaster);
        if(isUpdated)
        {
            return new ResponseEntity<>("HonorariumHistoryMaster updated successfully!",HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("Failed to update HonorariumHistoryMaster",HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteHonorariumHistory/{hid}")
    public ResponseEntity<String> deleteHonorariumHistory(@PathVariable("hid") Integer hid,@RequestBody HonorariumHistoryMaster honorariumHistoryMaster)
    {
        honorariumHistoryService.getHonorariumHistoryService(hid);
        if(honorariumHistoryMaster!= null)
        {
            Boolean isDeleted = honorariumHistoryService.deleteHonorariumHistoryService(honorariumHistoryMaster);
            if(isDeleted)
            {
                return new ResponseEntity<>("HonorariumHistory deleted successfully",HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("failed to delete HonorariumHistory",HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getHonorariumHistory/{hid}")
    public ResponseEntity<HonorariumHistoryMaster>getHonorariumHistory(@PathVariable("hid") Integer hid)
    {
        HonorariumHistoryMaster honorariumHistoryMaster=honorariumHistoryService.getHonorariumHistoryService(hid);
        if (honorariumHistoryMaster!=null)
        {
            return new ResponseEntity<>(honorariumHistoryMaster,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }



    @GetMapping("/getAllHonorariumHistory")
    public ResponseEntity<List<HonorariumHistoryMaster>> getAllHonorariumHistory()
    {
        List<HonorariumHistoryMaster> allHonorariumHistory= honorariumHistoryService.getAllHonorariumHistoryService();
        return new ResponseEntity<>(allHonorariumHistory,HttpStatus.OK);
    }






}












