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

import in.crm.main.master.CityMaster;
import in.crm.main.service.CityService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;



@RequestMapping("/city")
@RestController
public class CityController {
	
	
	@Autowired
	CityService cityService;
	

	@PostMapping("/addCity")
	public ResponseEntity<String> addCity(@RequestBody @Valid  CityMaster cityMaster) {
		Boolean isAdded = cityService.addCityService(cityMaster);
		if (isAdded) {
			return new ResponseEntity<>("City added successfully!", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("Failed to add City.", HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/updatecity/{cityId}") public ResponseEntity<String>
	  updatecity(
	  
	  @PathVariable("cityId")
	  @Positive(message ="city ID must be positive") Integer cityId,
	  @RequestBody @Valid CityMaster cityMaster) {
		 cityMaster.setCityId(cityId);
			Boolean isUpdated = cityService.updateCityService(cityMaster);
			if (isUpdated) {
				return new ResponseEntity<>("City updated successfully!", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("City to update country.", HttpStatus.BAD_REQUEST);
			}
		}

		@DeleteMapping("/deletecity/{cityId}")
		public ResponseEntity<String> deletecity(
				@PathVariable("cityId") @Positive(message = "city ID must be positive") Integer cityId) {
			CityMaster cityMaster = cityService.getCityService(cityId);
			if (cityMaster != null) {
				Boolean isDeleted = cityService.deleteCityService(cityMaster);
				if (isDeleted) {
					return new ResponseEntity<>("cityId deleted successfully!", HttpStatus.OK);
				}
			}
			return new ResponseEntity<>("Failed to delete cityId.", HttpStatus.BAD_REQUEST);
		}

	@GetMapping("/getCity/{cityId}")
	public ResponseEntity<CityMaster> getcity(
			@PathVariable("cityId") @Positive(message = "city ID must be positive") Integer cityId) {
		CityMaster cityMaster = cityService.getCityService(cityId);
		if (cityMaster != null) {
			return new ResponseEntity<>(cityMaster, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/getAllCities")
	public ResponseEntity<List<CityMaster>> getAllCityCategories() {
		List<CityMaster> allCities;
		try {
			allCities = cityService.getAllCityService();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(allCities, HttpStatus.OK);
	}
}