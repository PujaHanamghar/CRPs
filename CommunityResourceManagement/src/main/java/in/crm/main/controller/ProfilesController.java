package in.crm.main.controller;

import java.util.List;

import in.crm.main.master.ProfilesMaster;
import in.crm.main.service.ProfilesService;
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
@RequestMapping("/profile")
public class ProfilesController {
   
	@Autowired
	private ProfilesService profilesService;
	
	@GetMapping("/getAllProfiles")
	public ResponseEntity<List<ProfilesMaster>> getAllProfiles() {
		List<ProfilesMaster> allProfiles = profilesService.getAllProfilesService();
		return new ResponseEntity<>(allProfiles, HttpStatus.OK);
	}

	@GetMapping("/getProfiles/{profileId}")
	public ResponseEntity<ProfilesMaster> getProfiles(
			@PathVariable("profileId") @Positive(message = "Profile Id must be positive") Integer ProfileId) {
		ProfilesMaster profile = profilesService.getProfilesServiceById(ProfileId);
		if (profile != null) {
			return new ResponseEntity<>(profile, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/addProfile")
	public ResponseEntity<String> addProfiles(@RequestBody @Valid ProfilesMaster profilesMaster) {
		Boolean isAdded = profilesService.addProfilesService(profilesMaster);
		if (isAdded) {
			return new ResponseEntity<>("Profile added Successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Failed to add Profile", HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/updateProfiles/{profileId}")
	public ResponseEntity<String> updateProfiles(
			@PathVariable("profileId") @Positive(message = "Profile ID must be positive") Integer profileId,
			@RequestBody @Valid ProfilesMaster profilesMaster) {
		profilesMaster.setProfileId(profileId);

		Boolean isUpdated = profilesService.updateProfilesService(profilesMaster);
		if (isUpdated) {
			return new ResponseEntity<>("Profiles updated successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Failed to update Profiles", HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/deleteProfile/{profileId}")
	public ResponseEntity<String> deleteProfile(
			@PathVariable("profileId") @Positive(message = "Profile Id must be Positive") Integer profileId) {
		try {
			ProfilesMaster profile = profilesService.getProfilesServiceById(profileId);
			if (profile != null) {
				Boolean isDeleted = profilesService.deleteProfiles(profile);
				if (isDeleted) {
					return new ResponseEntity<>("Profile deleted successfully", HttpStatus.OK);
				}
			}
		} catch (Exception e) {
		}
		return new ResponseEntity<>("Failed to delete Profile", HttpStatus.BAD_REQUEST);
	}
}
