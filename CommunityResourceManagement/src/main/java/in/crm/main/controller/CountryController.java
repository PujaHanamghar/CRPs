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

import in.crm.main.master.CountryMaster;
import in.crm.main.service.CountryService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

@RequestMapping("/country")
@RestController

public class CountryController {
	
	@Autowired
	CountryService countryService;
	
	@PostMapping("/addCountry")
	public ResponseEntity<String> addCountry(@RequestBody @Valid  CountryMaster countryMaster) {
		Boolean isAdded = countryService.addCountryService(countryMaster);
		if (isAdded) {
			return new ResponseEntity<>("Country added successfully!", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("Failed to add Country.", HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/updatecountry/{countryId}") public ResponseEntity<String>
	  updatecountry(
	  
	  @PathVariable("countryId")
	  @Positive(message ="country ID must be positive") Integer countryId,
	  @RequestBody @Validated CountryMaster countryMaster) {
		 countryMaster.setCountryId(countryId);
			Boolean isUpdated = countryService.updateCountryService(countryMaster);
			if (isUpdated) {
				return new ResponseEntity<>("country updated successfully!", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("country to update country.", HttpStatus.BAD_REQUEST);
			}
		}

		@DeleteMapping("/deletecountry/{countryId}")
		public ResponseEntity<String> deletecountry(
				@PathVariable("countryId") @Positive(message = "country ID must be positive") Integer countryId) {
			CountryMaster countryMaster = countryService.getCountryService(countryId);
			if (countryMaster != null) {
				Boolean isDeleted = countryService.deleteCountryService(countryMaster);
				if (isDeleted) {
					return new ResponseEntity<>("countryId deleted successfully!", HttpStatus.OK);
				}
			}
			return new ResponseEntity<>("Failed to delete countryId.", HttpStatus.BAD_REQUEST);
		}

	@GetMapping("/getCountry/{countryId}")
	public ResponseEntity<CountryMaster> getcountry(
			@PathVariable("countryId") @Positive(message = "country ID must be positive") Integer countryId) {
		CountryMaster countryMaster = countryService.getCountryService(countryId);
		if (countryMaster != null) {
			return new ResponseEntity<>(countryMaster, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/getAllCountries")
	public ResponseEntity<List<CountryMaster>> getAllSocialCategories() {
		List<CountryMaster> allCountries;
		try {
			allCountries = countryService.getAllCountryService();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(allCountries, HttpStatus.OK);
	}
}
