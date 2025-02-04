package in.crm.main.controller;

import in.crm.main.master.DependentsDetailMaster;
import in.crm.main.master.HonorariumManagementMaster;
import in.crm.main.service.DependentsDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/DependentsDetail")
public class DependentsDetailController {

    @Autowired
    private DependentsDetailService dependentsDetailService;


    @PostMapping("/addDependentsDetail")
    public ResponseEntity<String> addDependentsDetail(@RequestBody DependentsDetailMaster dependentsDetailMaster)
    {
        Boolean isAdded = dependentsDetailService.addDependentsDetailService(dependentsDetailMaster);
        if(isAdded){
            return  new ResponseEntity<>("DependentsDetails added successfully !", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Failed to add DependentsDetails",HttpStatus.BAD_REQUEST);
        }

    }


    @PutMapping("/updateDependentsDetail/{dependentId}")
    public ResponseEntity<String> updateDependentsDetail(@PathVariable("dependentId") Integer dependentId,@RequestBody DependentsDetailMaster dependentsDetailMaster)
    {
        dependentsDetailMaster.setDependentId(dependentId);
        Boolean isUpdated=dependentsDetailService.updateDependentsDetailService(dependentsDetailMaster);
        if(isUpdated)
        {
            return new ResponseEntity<>("Dependent Details updated successfully!",HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("Failed to update Dependent Details",HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("/deleteDependentsDetail/{dependentId}")
    public ResponseEntity<String> deleteDependentsDetail(@PathVariable("dependentId") Integer dependentId,@RequestBody DependentsDetailMaster dependentsDetailMaster)
    {
        dependentsDetailService.getDependentsDetailService(dependentId);
        if(dependentsDetailMaster!= null)
        {
            Boolean isDeleted = dependentsDetailService.deleteDependentsDetailService(dependentsDetailMaster);
            if(isDeleted)
            {
                return new ResponseEntity<>("DependentsDetail deleted successfully",HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("failed to delete DependentsDetail",HttpStatus.BAD_REQUEST);

    }


    @GetMapping("/getDependentsDetail/{dependentId}")
    public ResponseEntity<DependentsDetailMaster>getDependentsDetail(@PathVariable("dependentId") Integer dependentId)
    {
        DependentsDetailMaster dependentsDetailMaster=dependentsDetailService.getDependentsDetailService(dependentId);
        if (dependentsDetailMaster!=null)
        {
            return new ResponseEntity<>(dependentsDetailMaster,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/getAllDependentsDetail")
    public ResponseEntity<List<DependentsDetailMaster>> getAllDependentsDetail()
    {
        List<DependentsDetailMaster> allDependentsDetailMaster= dependentsDetailService.getAllDependentsDetailService();
        return new ResponseEntity<>(allDependentsDetailMaster,HttpStatus.OK);
    }





}


