//package com.sts.Controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import com.sts.Master.StateMaster;
//import com.sts.Service.StateService;
//
//import jakarta.validation.Valid;
//import jakarta.validation.constraints.Positive;
//
//@RestController
//@RequestMapping("state")
//
//public class StateController {
//
//	@Autowired
//	StateService stateService;
//
//	@PostMapping("/addState")
//	public ResponseEntity<String> addState(@RequestBody @Valid StateMaster stateMaster) {
//		Boolean isAdded = stateService.addStateService(stateMaster);
//		if (isAdded) {
//			return new ResponseEntity<>("State added successfully!", HttpStatus.CREATED);
//		} else {
//			return new ResponseEntity<>("Failed to add State.", HttpStatus.BAD_REQUEST);
//		}
//	}
//
//	@PutMapping("/updatestate/{stateId}")
//	public ResponseEntity<String> updatestate(
//
//			@PathVariable("stateId") @Positive(message = "state ID must be positive") Integer stateId,
//			@RequestBody @Valid StateMaster stateMaster) {
//		stateMaster.setStateID(stateId);
//		Boolean isUpdated = stateService.updateStateService(stateMaster);
//		if (isUpdated) {
//			return new ResponseEntity<>("state updated successfully!", HttpStatus.OK);
//		} else {
//			return new ResponseEntity<>("state to update state.", HttpStatus.BAD_REQUEST);
//		}
//	}
//
//	@DeleteMapping("/deletestate/{stateId}")
//	public ResponseEntity<String> deletestate(
//			@PathVariable("stateId") @Positive(message = "state ID must be positive") Integer stateId) {
//		StateMaster stateMaster = stateService.getStateService(stateId);
//		if (stateMaster != null) {
//			Boolean isDeleted = stateService.deleteStateService(stateMaster);
//			if (isDeleted) {
//				return new ResponseEntity<>("state deleted successfully!", HttpStatus.OK);
//			}
//		}
//		return new ResponseEntity<>("Failed to delete state.", HttpStatus.BAD_REQUEST);
//	}
//
//	@GetMapping("/getState/{stateId}")
//	public ResponseEntity<StateMaster> getstate(
//			@PathVariable("stateId") @Positive(message = "state ID must be positive") Integer stateId) {
//		StateMaster stateMaster = stateService.getStateService(stateId);
//		if (stateMaster != null) {
//			return new ResponseEntity<>(stateMaster, HttpStatus.OK);
//		} else {
//			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//		}
//	}
//
//	@GetMapping("/getAllStates")
//	public ResponseEntity<List<StateMaster>> getAllStateCategories() {
//		List<StateMaster> allStates;
//		try {
//			allStates = stateService.getAllStateService();
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		return new ResponseEntity<>(allStates, HttpStatus.OK);
//	}
//
//}
