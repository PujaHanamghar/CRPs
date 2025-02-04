package in.crm.main.controller;

import in.crm.main.master.DisciplinaryActionHistoryMaster;
import in.crm.main.master.PostingHistoryMaster;
import in.crm.main.service.DisciplinaryActionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/DisciplinaryActionHistory")
public class DisciplinaryActionHistoryController {

    @Autowired
    private DisciplinaryActionHistoryService disciplinaryActionHistoryService;


    @PostMapping("/addDisciplinaryActionHistory")
    public ResponseEntity<String> addDisciplinaryActionHistory(@RequestBody DisciplinaryActionHistoryMaster disciplinaryActionHistoryMaster) {
        Boolean isAdded = disciplinaryActionHistoryService.addDisciplinaryActionHistoryService(disciplinaryActionHistoryMaster);
        if (isAdded) {
            return new ResponseEntity<>("DisciplinaryActionHistory added successfully !", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to add DisciplinaryActionHistory", HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("/updateDisciplinaryActionHistory/{disciplinaryActionHistoryId}")
    public ResponseEntity<String> updateDisciplinaryActionHistory(@PathVariable("disciplinaryActionHistoryId") Integer disciplinaryActionHistoryId, @RequestBody DisciplinaryActionHistoryMaster disciplinaryActionHistoryMaster) {
        disciplinaryActionHistoryMaster.setDisciplinaryActionHistoryId(disciplinaryActionHistoryId);
        Boolean isUpdated = disciplinaryActionHistoryService.updateDisciplinaryActionHistoryService(disciplinaryActionHistoryMaster);
        if (isUpdated) {
            return new ResponseEntity<>("DisciplinaryActionHistory updated successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to update DisciplinaryActionHistory", HttpStatus.BAD_REQUEST);
        }
    }

        @DeleteMapping("/deleteDisciplinaryActionHistory/{disciplinaryActionHistoryId}")
        public ResponseEntity<String> deleteDisciplinaryActionHistory(@PathVariable("disciplinaryActionHistoryId") Integer disciplinaryActionHistoryId,@RequestBody DisciplinaryActionHistoryMaster disciplinaryActionHistoryMaster)
        {
            disciplinaryActionHistoryService.getDisciplinaryActionHistoryService(disciplinaryActionHistoryId);

            if(disciplinaryActionHistoryMaster!= null)
            {
                Boolean isDeleted = disciplinaryActionHistoryService.deleteDisciplinaryActionHistoryService(disciplinaryActionHistoryMaster);
                if(isDeleted)
                {
                    return new ResponseEntity<>("DisciplinaryActionHistory deleted successfully",HttpStatus.OK);
                }
            }
            return new ResponseEntity<>("failed to delete DisciplinaryActionHistory",HttpStatus.BAD_REQUEST);

        }
    @GetMapping("/getDisciplinaryActionHistory/{disciplinaryActionHistoryId}")
    public ResponseEntity<DisciplinaryActionHistoryMaster>getDisciplinaryActionHistory(@PathVariable("disciplinaryActionHistoryId") Integer disciplinaryActionHistoryId)
    {
        DisciplinaryActionHistoryMaster disciplinaryActionHistoryMaster=disciplinaryActionHistoryService.getDisciplinaryActionHistoryService(disciplinaryActionHistoryId);

        if (disciplinaryActionHistoryMaster !=null)
        {
            return new ResponseEntity<>(disciplinaryActionHistoryMaster,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/getAllDisciplinaryActionHistory")
    public ResponseEntity<List<DisciplinaryActionHistoryMaster>> getAllDisciplinaryActionHistory()
    {
        List<DisciplinaryActionHistoryMaster> allDisciplinaryActionHistory = disciplinaryActionHistoryService.getAllDisciplinaryActionHistoryService();
        return new ResponseEntity<>(allDisciplinaryActionHistory,HttpStatus.OK);
    }


}
