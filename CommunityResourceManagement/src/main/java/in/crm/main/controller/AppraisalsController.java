package in.crm.main.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.crm.main.master.AppraisalsMaster;
import in.crm.main.service.AppraisalsService;
import jakarta.validation.constraints.Positive;

@RequestMapping("/appraisals")
@RestController
public class AppraisalsController {

    @Autowired
    private AppraisalsService appraisalsService;

    @PostMapping("/add")
    public ResponseEntity<String> addAppraisals(@RequestBody @Validated AppraisalsMaster appraisalsMaster) {
        Boolean isAdded = appraisalsService.addAppraisals(appraisalsMaster);
        if (isAdded) {
            return new ResponseEntity<>("Appraisal added successfully!", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to add appraisal.", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{appraisalsId}")
    public ResponseEntity<String> updateAppraisals(
            @PathVariable("appraisalsId") @Positive Integer appraisalsId,
            @RequestBody @Validated AppraisalsMaster appraisalsMaster) {

        appraisalsMaster.setAppraisalsId(appraisalsId);
        Boolean isUpdated = appraisalsService.updateAppraisals(appraisalsMaster);

        if (isUpdated) {
            return new ResponseEntity<>("Appraisal updated successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to update appraisal.", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{appraisalsId}")
    public ResponseEntity<String> deleteAppraisals(@PathVariable("appraisalsId") @Positive Integer appraisalsId) {
        Boolean isDeleted = appraisalsService.deleteAppraisals(appraisalsId);
        if (isDeleted) {
            return new ResponseEntity<>("Appraisal deleted successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to delete appraisal.", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get/{appraisalsId}")
    public ResponseEntity<AppraisalsMaster> getAppraisals(@PathVariable("appraisalsId") @Positive Integer appraisalsId) {
        AppraisalsMaster appraisalsMaster = appraisalsService.getAppraisalsById(appraisalsId);
        return new ResponseEntity<>(appraisalsMaster, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<AppraisalsMaster>> getAllAppraisals() {
        return new ResponseEntity<>(appraisalsService.getAllAppraisals(), HttpStatus.OK);
    }
}
