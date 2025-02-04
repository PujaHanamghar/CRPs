package in.crm.main.controller;


import in.crm.main.master.DesignationMaster;
import in.crm.main.service.DesignationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Designation")
public class DesignationController {

    @Autowired
    private DesignationService designationService;

    @PostMapping("/addDesignation")
    public ResponseEntity<String> addDesignation(@RequestBody DesignationMaster designationMaster)
    {
        Boolean isAdded = designationService.addDesignationService(designationMaster);
        if(isAdded){
            return  new ResponseEntity<>("Designation added successfully !", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Failed to add Designation",HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateDesignation/{designationId}")
    public ResponseEntity<String> updateDesignation(@PathVariable("designationId") Integer designationId, @RequestBody DesignationMaster designationMaster)
    {
        designationMaster.setDesignationId(designationId);
      Boolean isUpdated = designationService.updateDesignationService(designationMaster);
        if(isUpdated)
        {
         return new ResponseEntity<>("Designation updated successfully!",HttpStatus.OK);
        }
        else
        {
         return new ResponseEntity<>("Failed to update Designation",HttpStatus.BAD_REQUEST);
        }
    }

        @DeleteMapping("/deleteDesignation/{designationId}")
    public ResponseEntity<String> deleteDesignation(@PathVariable("designationId") Integer designationId, @RequestBody DesignationMaster designationMaster)
    {
              designationService.getDesignationService(designationId);
              if(designationMaster != null)
              {
                  Boolean isDeleted = designationService.deleteDesignationService(designationMaster);
                  if(isDeleted)
                  {
                      return new ResponseEntity<>("Designation deleted successfully",HttpStatus.OK);
                  }
              }
              return new ResponseEntity<>("failed to delete Designation",HttpStatus.BAD_REQUEST);

    }
      @GetMapping("/getDesignation/{designationId}")
       public ResponseEntity<DesignationMaster>getDesignation(@PathVariable("designationId") Integer designationId)
       {
           DesignationMaster designationMaster=designationService.getDesignationService(designationId);
           if (designationMaster !=null)
           {
               return new ResponseEntity<>(designationMaster,HttpStatus.OK);
           }
           else {
               return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
           }
       }

       @GetMapping("/getAllDesignation")
       public ResponseEntity<List<DesignationMaster>> getAllDesignations()
       {
           List<DesignationMaster> allDesignations = designationService.getAllDesignationService();
           return new ResponseEntity<>(allDesignations,HttpStatus.OK);
       }


}
