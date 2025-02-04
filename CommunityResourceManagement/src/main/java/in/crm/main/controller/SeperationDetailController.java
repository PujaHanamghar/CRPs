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

import in.crm.main.master.PostingHistoryMaster;
import in.crm.main.master.SeperationDetailMaster;
import in.crm.main.service.SeperationDetailService;

@RestController
@RequestMapping("/SeperationDetail")
public class SeperationDetailController {
	

    @Autowired
    private SeperationDetailService seperationDetailService;

    @PostMapping("/addSeperationDetail")
    public ResponseEntity<String> addSeperationDetail(@RequestBody SeperationDetailMaster seperationDetailMaster)
    {
        Boolean isAdded = seperationDetailService.addSeperationDetailService(seperationDetailMaster);
        if(isAdded){
            return  new ResponseEntity<>("SeperationDetail added successfully !", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Failed to add SeperationDetail",HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateSeperationDetail/{seperationId}")
    public ResponseEntity<String> updateSeperationDetail(@PathVariable("seperationId") Integer seperationId,@RequestBody SeperationDetailMaster seperationDetailMaster)
    {
    	seperationDetailMaster.setSeperationId(seperationId);
        Boolean isUpdated=seperationDetailService.updateSeperationDetailService(seperationDetailMaster);
        if(isUpdated)
        {
            return new ResponseEntity<>("SeperationDetail updated successfully!",HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("Failed to update SeperationDetail",HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteSeperationDetail/{seperationId}")
    public ResponseEntity<String> deleteSeperationDetail(@PathVariable("seperationId") Integer seperationId,@RequestBody SeperationDetailMaster seperationDetailMaster)
    {
    	seperationDetailService.getSeperationDetailService(seperationId);
        if(seperationDetailMaster!= null)
        {
            Boolean isDeleted = seperationDetailService.deleteSeperationDetailService(seperationDetailMaster);
            if(isDeleted)
            {
                return new ResponseEntity<>("SeperationDetails deleted successfully",HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("failed to delete SeperationDetails",HttpStatus.BAD_REQUEST);

    }
    @GetMapping("/getSeperationDetail/{seperationId}")
    public ResponseEntity<SeperationDetailMaster>getSeperationDetail(@PathVariable("seperationId") Integer seperationId)
    {
    	SeperationDetailMaster seperationDetailMaster=seperationDetailService.getSeperationDetailService(seperationId);
        if (seperationDetailMaster !=null)
        {
            return new ResponseEntity<>(seperationDetailMaster,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllSeperationDetail")
    public ResponseEntity<List<SeperationDetailMaster>> getAllSeperationDetail()
    {
        List<SeperationDetailMaster> allSeperationDetail = seperationDetailService.getAllSeperationDetailService();
        return new ResponseEntity<>(allSeperationDetail,HttpStatus.OK);
    }
}
