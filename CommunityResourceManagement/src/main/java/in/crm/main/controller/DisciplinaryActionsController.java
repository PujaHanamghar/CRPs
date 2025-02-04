package in.crm.main.controller;

import in.crm.main.master.DisciplinaryActionsMaster;
import in.crm.main.master.PostingHistoryMaster;
import in.crm.main.service.DisciplinaryActionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/DisciplinaryActions")
public class DisciplinaryActionsController {

    @Autowired
    private DisciplinaryActionsService disciplinaryActionsService;

    @PostMapping("/addDisciplinaryActions")

    public ResponseEntity<String> addDisciplinaryActions(@RequestBody DisciplinaryActionsMaster disciplinaryActionsMaster)
     {
        Boolean isAdded = disciplinaryActionsService.addDisciplinaryActionsService(disciplinaryActionsMaster);
        if(isAdded){
            return  new ResponseEntity<>("DisciplinaryActions added successfully !", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Failed to add DisciplinaryActions",HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateDisciplinaryActions/{disciplinaryActionId}")
    public ResponseEntity<String> updateDisciplinaryActions(@PathVariable("disciplinaryActionId") Integer disciplinaryActionId,@RequestBody DisciplinaryActionsMaster disciplinaryActionsMaster)
    {
        disciplinaryActionsMaster.setDisciplinaryActionId(disciplinaryActionId);

        Boolean isUpdated=disciplinaryActionsService.updateDisciplinaryActionsService(disciplinaryActionsMaster);
        if(isUpdated)
        {
            return new ResponseEntity<>("DisciplinaryActions updated successfully!",HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("Failed to update DisciplinaryActions",HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteDisciplinaryActions/{disciplinaryActionId}")
    public ResponseEntity<String> deleteDisciplinaryActions(@PathVariable("disciplinaryActionId") Integer disciplinaryActionId,@RequestBody DisciplinaryActionsMaster disciplinaryActionsMaster)
    {
        disciplinaryActionsService.getDisciplinaryActionsService(disciplinaryActionId);

        if(disciplinaryActionsMaster!= null)
        {
            Boolean isDeleted = disciplinaryActionsService.deleteDisciplinaryActionsService(disciplinaryActionsMaster);
            if(isDeleted)
            {
                return new ResponseEntity<>("DisciplinaryActions deleted successfully",HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("failed to delete DisciplinaryActions",HttpStatus.BAD_REQUEST);

    }
    @GetMapping("/getDisciplinaryActions/{disciplinaryActionId}")
    public ResponseEntity<DisciplinaryActionsMaster>getDisciplinaryActions(@PathVariable("disciplinaryActionId") Integer disciplinaryActionId)
    {
        DisciplinaryActionsMaster disciplinaryActionsMaster=disciplinaryActionsService.getDisciplinaryActionsService(disciplinaryActionId);

        if (disciplinaryActionsMaster !=null)
        {
            return new ResponseEntity<>(disciplinaryActionsMaster,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllDisciplinaryActions")
    public ResponseEntity<List<DisciplinaryActionsMaster>> getAllDisciplinaryActions()
    {
        List<DisciplinaryActionsMaster> allDisciplinaryActionsList = disciplinaryActionsService.getAllDisciplinaryActionsService();
        return new ResponseEntity<>(allDisciplinaryActionsList,HttpStatus.OK);
    }



}
