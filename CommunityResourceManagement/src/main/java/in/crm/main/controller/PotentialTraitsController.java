package in.crm.main.controller;

import java.util.List;

import in.crm.main.master.PotentialTraitsMaster;
import in.crm.main.service.PotentialTraitsService;
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
@RequestMapping("/ptrait")
public class PotentialTraitsController {

	@Autowired
	private PotentialTraitsService potentialTraitsService;
	
	@GetMapping("/getAllPtraits")
	public ResponseEntity<List<PotentialTraitsMaster>> getAllPtraits() {
		List<PotentialTraitsMaster> allptraits = potentialTraitsService.getAllPotentialTraitsService();
		return new ResponseEntity<>(allptraits, HttpStatus.OK);
	}

	@GetMapping("/getPtrait/{pTraitId}")
	public ResponseEntity<PotentialTraitsMaster> getPtrait(
			@PathVariable("pTraitId") @Positive(message = "Ptrait Id must be positive") Integer pTraitId) {
		PotentialTraitsMaster ptrait = potentialTraitsService.getPotentialTraitsServiceById(pTraitId);
		if (ptrait != null) {
			return new ResponseEntity<>(ptrait, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/addPtrait")
	public ResponseEntity<String> addPtrait(@RequestBody @Valid PotentialTraitsMaster potentialTraitsMaster) {
		Boolean isAdded = potentialTraitsService.addPotentialTraitsService(potentialTraitsMaster);
		if (isAdded) {
			return new ResponseEntity<>("Ptrait added Successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Failed to add Ptrait", HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/updatePtrait/{pTraitId}")
	public ResponseEntity<String> updatePtrait(
			@PathVariable("pTraitId") @Positive(message = "Ptrait ID must be positive") Integer pTraitId,
			@RequestBody @Valid PotentialTraitsMaster potentialTraitsMaster) {
		potentialTraitsMaster.setpTraitId(pTraitId);

		Boolean isUpdated = potentialTraitsService.updatePotentialTraitsService(potentialTraitsMaster);
		if (isUpdated) {
			return new ResponseEntity<>("Ptrait updated successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Failed to update Ptrait", HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/deletePtrait/{pTraitId}")
	public ResponseEntity<String> deletePtrait(
			@PathVariable("pTraitId") @Positive(message = "Ptrait Id must be Positive") Integer pTraitId) {
		try {
			PotentialTraitsMaster ptrait = potentialTraitsService.getPotentialTraitsServiceById(pTraitId);
			if (ptrait != null) {
				Boolean isDeleted = potentialTraitsService.deletePotentialTraits(ptrait);
				if (isDeleted) {
					return new ResponseEntity<>("Ptrait deleted successfully", HttpStatus.OK);
				}
			}
		} catch (Exception e) {
		}
		return new ResponseEntity<>("Failed to delete Ptrait", HttpStatus.BAD_REQUEST);
	}

}
