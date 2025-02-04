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

import in.crm.main.master.SocialCategoryMaster;
import in.crm.main.service.SocialCategoryService;
import jakarta.validation.constraints.Positive;

@RequestMapping("/socialcategory")
@RestController

public class SocialCategoryController {
	
	@Autowired
	SocialCategoryService socialCategoryService;
	
	@PostMapping("/addSocialCategory")
	public ResponseEntity<String> addSocialCategory(@RequestBody @Validated SocialCategoryMaster socialCategoryMaster) {
		Boolean isAdded = socialCategoryService.addSocialCategoryService(socialCategoryMaster);
		if (isAdded) {
			return new ResponseEntity<>("SocialCategory added successfully!", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("Failed to add SocialCategory.", HttpStatus.BAD_REQUEST);
		}
	}
	@PutMapping("/updatesocialCategory/{socialCategoryId}") public ResponseEntity<String>
	  updatesocialCategory(
	  
	  @PathVariable("socialCategoryId")
	  @Positive(message ="socialCategory ID must be positive") Integer socialCategoryId,
	  @RequestBody @Validated SocialCategoryMaster socialCategoryMaster) {
		 socialCategoryMaster.setSocialCategoryId(socialCategoryId);
			Boolean isUpdated = socialCategoryService.updateSocialCategoryService(socialCategoryMaster);
			if (isUpdated) {
				return new ResponseEntity<>("socialCategory updated successfully!", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("socialCategory to update socialCategory.", HttpStatus.BAD_REQUEST);
			}
		}

		@DeleteMapping("/deleteSocialCategory/{socialCategoryId}")
		public ResponseEntity<String> deleteSocialCategory(
				@PathVariable("socialCategoryId") @Positive(message = "SocialCategory ID must be positive") Integer socialCategoryId) {
			SocialCategoryMaster socialCategoryMaster = socialCategoryService.getSocialCategoryService(socialCategoryId);
			if (socialCategoryMaster != null) {
				Boolean isDeleted = socialCategoryService.deleteSocialCategoryService(socialCategoryMaster);
				if (isDeleted) {
					return new ResponseEntity<>("socialCategoryId deleted successfully!", HttpStatus.OK);
				}
			}
			return new ResponseEntity<>("Failed to delete socialCategoryId.", HttpStatus.BAD_REQUEST);
		}

	@GetMapping("/getSocialCategory/{socialCategoryId}")
	public ResponseEntity<SocialCategoryMaster> getSocialCategory(
			@PathVariable("socialCategoryId") @Positive(message = "SocialCategory ID must be positive") Integer socialCategoryId) {
		SocialCategoryMaster socialCategoryMaster = socialCategoryService.getSocialCategoryService(socialCategoryId);
		if (socialCategoryMaster != null) {
			return new ResponseEntity<>(socialCategoryMaster, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/getAllSocialCategories")
	public ResponseEntity<List<SocialCategoryMaster>> getAllSocialCategories() {
		List<SocialCategoryMaster> allSocialCategories;
		try {
			allSocialCategories = socialCategoryService.getAllSocialCategoryService();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(allSocialCategories, HttpStatus.OK);
	}
}

	


