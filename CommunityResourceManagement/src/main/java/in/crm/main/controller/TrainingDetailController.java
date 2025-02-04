package in.crm.main.controller;


import java.util.List;

import in.crm.main.master.TrainingDetailMaster;
import in.crm.main.service.TrainingDetailService;
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
@RequestMapping("/trainingDetail")
public class TrainingDetailController {

	@Autowired
	private TrainingDetailService trDetailService;

	@GetMapping("/getAllTrainings")
	public ResponseEntity<List<TrainingDetailMaster>> getAllTrainigDetails() {
		List<TrainingDetailMaster> allTrDetails = trDetailService.getAllTrainingDetailService();
		return new ResponseEntity<>(allTrDetails, HttpStatus.OK);
	}

	@GetMapping("/getTrainingDetail/{trainingId}")
	public ResponseEntity<TrainingDetailMaster> getTrainingDetail(
			@PathVariable("trainingId") @Positive(message = "TrainingDetail Id must be positive") Integer trainingId) {
		TrainingDetailMaster trDetailMaster = trDetailService.getTrainingDetailServiceById(trainingId);
		if (trDetailMaster != null) {
			return new ResponseEntity<>(trDetailMaster, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/addTraining")
	public ResponseEntity<String> addTraining(@RequestBody @Valid TrainingDetailMaster trainingdetailMaster) {
		Boolean isAdded = trDetailService.addTrainingDetailService(trainingdetailMaster);
		if (isAdded) {
			return new ResponseEntity<>("TrainingDetail added Successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Failed to add TrainingDetail", HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/updateTraining/{trainingId}")
	public ResponseEntity<String> updatetraining(
			@PathVariable("trainingId") @Positive(message = "Designation ID must be positive") Integer trainingId,
			@RequestBody @Valid TrainingDetailMaster trainingdetailMaster) {
		trainingdetailMaster.setTrainingId(trainingId);

		Boolean isUpdated = trDetailService.updateTrainingDetailService(trainingdetailMaster);
		if (isUpdated) {
			return new ResponseEntity<>("TrainingDetail updated successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Failed to update TrainingDetail", HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/deleteTrinings/{trainingId}")
	public ResponseEntity<String> deleteTrinings(
			@PathVariable("trainingId") @Positive(message = "TrainingDetail Id must be Positive") Integer trainingId) {
		try {
			TrainingDetailMaster trDetailMaster = trDetailService.getTrainingDetailServiceById(trainingId);
			if (trDetailMaster != null) {
				Boolean isDeleted = trDetailService.deleteTrainingDetail(trDetailMaster);
				if (isDeleted) {
					return new ResponseEntity<>("TrainingDetail deleted successfully", HttpStatus.OK);
				}
			}
		} catch (Exception e) {
		}
		return new ResponseEntity<>("Failed to delete TrainingDetail", HttpStatus.BAD_REQUEST);
	}

}
