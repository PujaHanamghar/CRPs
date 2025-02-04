package in.crm.main.controller;

import java.util.List;

import in.crm.main.master.NoticePeriodMaster;
import in.crm.main.service.NoticePeriodService;
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
@RequestMapping("/noticeperiod")
public class NoticePeriodController {
	
	@Autowired
	private NoticePeriodService noticePeriodService;


	@GetMapping("/getAllNoticePeriods")
	public ResponseEntity<List<NoticePeriodMaster>> getAllNoticePerods() {
		List<NoticePeriodMaster> allNotice = noticePeriodService.getAllNoticePeriodService();
		return new ResponseEntity<>(allNotice, HttpStatus.OK);
	}

	@GetMapping("/getNotice/{noticePolicyId}")
	public ResponseEntity<NoticePeriodMaster> getNotice(
			@PathVariable("noticePolicyId") @Positive(message = "NoticePeriod Id must be positive") Integer noticePolicyId) {
		NoticePeriodMaster notice = noticePeriodService.getNoticePeriodServiceById(noticePolicyId);
		if (notice != null) {
			return new ResponseEntity<>(notice, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/addNotice")
	public ResponseEntity<String> addNotice(@RequestBody @Valid NoticePeriodMaster noticePeriodMaster) {
		Boolean isAdded = noticePeriodService.addNoticePeriodService(noticePeriodMaster);
		if (isAdded) {
			return new ResponseEntity<>("Notice added Successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Failed to add Notice", HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/updateNotice/{noticePolicyId}")
	public ResponseEntity<String> updateNotice(
			@PathVariable("noticePolicyId") @Positive(message = "Notice ID must be positive") Integer noticePolicyId,
			@RequestBody @Valid NoticePeriodMaster noticePeriodMaster) {
		noticePeriodMaster.setNoticePolicyId(noticePolicyId);

		Boolean isUpdated = noticePeriodService.updateNoticePeriodService(noticePeriodMaster);
		if (isUpdated) {
			return new ResponseEntity<>("Notice updated successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Failed to update Notice", HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/deleteNotice/{noticePolicyId}")
	public ResponseEntity<String> deleteNotice(
			@PathVariable("noticePolicyId") @Positive(message = "Notice Id must be Positive") Integer noticePolicyId) {
		try {
			NoticePeriodMaster notice = noticePeriodService.getNoticePeriodServiceById(noticePolicyId);
			if (notice != null) {
				Boolean isDeleted = noticePeriodService.deleteNoticePeriod(notice);
				if (isDeleted) {
					return new ResponseEntity<>("notice deleted successfully", HttpStatus.OK);
				}
			}
		} catch (Exception e) {
		}
		return new ResponseEntity<>("Failed to delete notice", HttpStatus.BAD_REQUEST);
	}

}
