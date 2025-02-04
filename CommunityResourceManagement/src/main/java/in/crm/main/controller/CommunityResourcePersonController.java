package in.crm.main.controller;


import in.crm.main.master.CommunityResourcePersonMaster;
import in.crm.main.master.DesignationMaster;
import in.crm.main.service.CommunityResourcePersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/CommunityResourcePerson")
public class CommunityResourcePersonController {

    @Autowired
    private CommunityResourcePersonService communityResourcePersonService;

    @PostMapping("/addCommunityResourcePerson")
    public ResponseEntity<String> addCommunityResourcePerson(@RequestBody CommunityResourcePersonMaster communityResourcePersonMaster) {
        Boolean isAdded = communityResourcePersonService.addCrmService(communityResourcePersonMaster);

        return (isAdded ? new ResponseEntity<>("CommunityResourcePerson added successfully", HttpStatus.CREATED) :
                new ResponseEntity<>("Failed to add CommunityResourcePerson.", HttpStatus.BAD_REQUEST));

    }

    @PutMapping("/updateCommunityResourcePerson/{crpId}")
    public ResponseEntity<String> updateCommunityResourcePerson(@PathVariable("crpId") Integer crpId, @RequestBody CommunityResourcePersonMaster communityResourcePersonMaster) {
        communityResourcePersonMaster.setCrpId(crpId);
        Boolean isUpdated = communityResourcePersonService.updateCrmService(communityResourcePersonMaster);
        if (isUpdated) {
            return new ResponseEntity<>("CRP updated ducessfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("CRP NOT updated ducessfully", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteCommunityResourcePerson/{crpId}")
    public ResponseEntity<String> deleteCommunityResourcePerson(@PathVariable("crpId") Integer crpId,@RequestBody CommunityResourcePersonMaster communityResourcePersonMaster) {
        communityResourcePersonService.getCrmService(crpId);
        if (communityResourcePersonMaster != null) {
            Boolean isDeleted = communityResourcePersonService.deleteCrmService(communityResourcePersonMaster);
            if (isDeleted) {
                return new ResponseEntity<>("CRP deleted successfully", HttpStatus.OK);

            }
        }
        return new ResponseEntity<>("Failed to delete CRP.",HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/getCommunityResourcePerson/{crpId}")
    public ResponseEntity<CommunityResourcePersonMaster> getCommunityResourcePerson(@PathVariable("crpId") Integer crpId)
    {
        CommunityResourcePersonMaster communityResourcePersonMaster=communityResourcePersonService.getCrmService(crpId);
       if (communityResourcePersonMaster !=null)
       {
           return new ResponseEntity<>(communityResourcePersonMaster,HttpStatus.OK);
       }
       else {
           return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
       }

    }

    @GetMapping("/getAllCommunityResourcePerson")
    public ResponseEntity<List<CommunityResourcePersonMaster>>  getAllCommunityResourcePerson()
    {
        List<CommunityResourcePersonMaster> allCommunityResourcePerson=communityResourcePersonService.getAllCrmService();
        return new ResponseEntity<>(allCommunityResourcePerson,HttpStatus.OK);
    }



}




