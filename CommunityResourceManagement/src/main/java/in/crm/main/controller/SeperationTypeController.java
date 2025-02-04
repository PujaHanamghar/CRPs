package in.crm.main.controller;

import java.util.List;

import in.crm.main.master.SeperationTypeMaster;
import in.crm.main.service.SeperationtypeService;
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
@RequestMapping("/seperationtype")
public class SeperationTypeController {
	
	@Autowired
	private SeperationtypeService seperationtypeService;
	
	@GetMapping("/getAllSeperationType")
	public ResponseEntity<List<SeperationTypeMaster>> getAllSeperationTypes() {
		List<SeperationTypeMaster> allSepType = seperationtypeService.getAllSepTypeService();
		return new ResponseEntity<>(allSepType, HttpStatus.OK);
	}

	@GetMapping("/getSeperationType/{sepTypeId}")
	public ResponseEntity<SeperationTypeMaster> getSeperationType(
			@PathVariable("sepTypeId") @Positive(message = "SeperationType Id must be positive") Integer sepTypeId) {
		SeperationTypeMaster seperation = seperationtypeService.getSepTypeServiceById(sepTypeId);
		if (seperation != null) {
			return new ResponseEntity<>(seperation, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/addSeperationtype")
	public ResponseEntity<String> addSeperationtype(@RequestBody @Valid SeperationTypeMaster seperationTypeMaster) {
		Boolean isAdded = seperationtypeService.addSepTypeService(seperationTypeMaster);
		if (isAdded) {
			return new ResponseEntity<>("SeperationType added Successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Failed to add SeperationType", HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/updateSeperation/{sepTypeId}")
	public ResponseEntity<String> updateSeperationType(
			@PathVariable("sepTypeId") @Positive(message = "SeperationType ID must be positive") Integer sepTypeId,
			@RequestBody @Valid SeperationTypeMaster seperationTypeMaster) {
		seperationTypeMaster.setSepTypeId(sepTypeId);

		Boolean isUpdated = seperationtypeService.updateSepTypeService(seperationTypeMaster);
		if (isUpdated) {
			return new ResponseEntity<>("SeperationType updated successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Failed to update SeperationType", HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/deleteSeperationType/{sepTypeId}")
	public ResponseEntity<String> deleteSeperationType(
			@PathVariable("sepTypeId") @Positive(message = "SeperationType Id must be Positive") Integer sepTypeId) {
		try {
			SeperationTypeMaster seperation = seperationtypeService.getSepTypeServiceById(sepTypeId);
			if (seperation != null) {
				Boolean isDeleted = seperationtypeService.deleteSepType(seperation);
				if (isDeleted) {
					return new ResponseEntity<>("SeperationType deleted successfully", HttpStatus.OK);
				}
			}
		} catch (Exception e) {
		}
		return new ResponseEntity<>("Failed to delete SeperationType", HttpStatus.BAD_REQUEST);
	}


}
