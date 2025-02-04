package in.crm.main.controller;


import java.util.List;

import in.crm.main.master.QualificationMaster;
import in.crm.main.service.QualificationService;
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


import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

@RestController
@RequestMapping("/qualification")
public class QualificationController {

	@Autowired
	private QualificationService qualificationService;
	
	@GetMapping("/getAllQualification")
	public ResponseEntity<List<QualificationMaster>> getAllQualifications(){
		List<QualificationMaster> allQualification = qualificationService.getAllQualificationService();
		return new ResponseEntity<>(allQualification, HttpStatus.OK);
	}
	
	
	@GetMapping("/getQualification/{qualificationId}")
	public ResponseEntity<QualificationMaster> getQualification(@PathVariable("qualificationId") @Positive(message = "Qualification ID be positive") Integer qualificationId){
		QualificationMaster qualificationMaster = qualificationService.getQualificationServcieById(qualificationId);
		if(qualificationMaster != null) {
			return new ResponseEntity<>(qualificationMaster, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/addQualification")
	public ResponseEntity<String> addQualification(@RequestBody @Valid QualificationMaster qualificationMaster){
		Boolean isAdded = qualificationService.addQualificationService(qualificationMaster);
		if(isAdded) {
			return new ResponseEntity<>("Qualification added successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Failed to add Qualification", HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@PutMapping("/updateQualification/{qualificationId}")
	public ResponseEntity<String> updateQualification(@PathVariable("qualificationId") @Positive(message = "Qualification Id must be positive") Integer qualificationId,
			@RequestBody @Valid QualificationMaster qualificationMaster){
		qualificationMaster.setQualificationId(qualificationId);
		Boolean isUpdated = qualificationService.addQualificationService(qualificationMaster);
		if(isUpdated) {
			return new ResponseEntity<>("Qualification updated successfully",HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Failed to update Qualification", HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@DeleteMapping("/deleteQualificaton/{qualificationId}")
	public ResponseEntity<String> deleteQualification(
			@PathVariable("qualificationId") @Positive(message = "Qualification Id must be Positive") Integer qualificationId){
		try {
			QualificationMaster qualificationMaster = qualificationService.getQualificationServcieById(qualificationId);
			if(qualificationMaster != null) {
				Boolean isDeleted = qualificationService.deleteQualificationService(qualificationMaster);
				if(isDeleted) {
					return new ResponseEntity<>("Qualificaton deleted successfully",HttpStatus.OK);
				}
			}
		}catch(Exception e) {
			
		}return new ResponseEntity<>("Failed to delete Qualification", HttpStatus.BAD_REQUEST);
	}
}
