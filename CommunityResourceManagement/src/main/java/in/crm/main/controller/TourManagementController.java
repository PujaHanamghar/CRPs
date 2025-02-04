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

import in.crm.main.master.TourManagementMaster;
import in.crm.main.service.TourManagementService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
@RestController
@RequestMapping("/tourmanagement")


public class TourManagementController {
	
	
	@Autowired
	 TourManagementService  tourManagementService;
	
	@PostMapping("/addTourManagement")
	public ResponseEntity<String> addTourManagement(@RequestBody @Valid   TourManagementMaster  tourManagementMaster) {
		Boolean isAdded = tourManagementService.addTourManagementService(tourManagementMaster);
		if (isAdded) {
			return new ResponseEntity<>("tourManagement added successfully!", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("Failed to add tourManagement.", HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/updatetourManagement/{tourManagementId}") public ResponseEntity<String>
	  updatetourManagement(
	  
	  @PathVariable("tourManagementId")
	  @Positive(message ="tourManagement ID must be positive") Integer tourId,
	  @RequestBody @Valid TourManagementMaster tourManagementMaster) {
		tourManagementMaster.setTourId(tourId);
			Boolean isUpdated = tourManagementService.updateTourManagementService(tourManagementMaster);
			if (isUpdated) {
				return new ResponseEntity<>("tourManagement updated successfully!", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("tourManagement to update country.", HttpStatus.BAD_REQUEST);
			}
		}

		@DeleteMapping("/deletetourManagement/{tourId}")
		public ResponseEntity<String> deletetourManagement(
				@PathVariable("tourId") @Positive(message = "tourManagement ID must be positive") Integer tourId) {
			TourManagementMaster tourManagementMaster = tourManagementService.getTourManagementService(tourId);
			if (tourManagementMaster != null) {
				Boolean isDeleted = tourManagementService.deleteTourManagementService(tourManagementMaster);
				if (isDeleted) {
					return new ResponseEntity<>("tourManagement deleted successfully!", HttpStatus.OK);
				}
			}
			return new ResponseEntity<>("Failed to delete tourManagement.", HttpStatus.BAD_REQUEST);
		}

	@GetMapping("/getTourManagement/{tourManagementId}")
	public ResponseEntity<TourManagementMaster> gettourManagement(
			@PathVariable("tourManagementId") @Positive(message = "tourManagement ID must be positive") Integer tourManagementId) {
		TourManagementMaster tourManagementMaster = tourManagementService.getTourManagementService(tourManagementId);
		if (tourManagementMaster != null) {
			return new ResponseEntity<>(tourManagementMaster, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/getAllTourManagements")
	public ResponseEntity<List<TourManagementMaster>> getAllSocialCategories() {
		List<TourManagementMaster> allTourManagements;
		try {
			allTourManagements = tourManagementService.getAllTourManagementService();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(allTourManagements, HttpStatus.OK);
	}

}
