package in.crm.main.controller;

import java.util.List;

import in.crm.main.master.DepartmentMaster;
import in.crm.main.service.DepartmentService;
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
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@GetMapping("/getAllDepartment")
	public ResponseEntity<List<DepartmentMaster>> getAllDepartments() {
		List<DepartmentMaster> allDepartments = departmentService.getAllDepartmentService();
		return new ResponseEntity<>(allDepartments, HttpStatus.OK);
	}

	@GetMapping("/getDepartment/{departmentId}")
	public ResponseEntity<DepartmentMaster> getDepartment(
			@PathVariable("departmentId") @Positive(message = "Despartment Id must be positive") Integer departmentId) {
		DepartmentMaster deptMaster = departmentService.getDepartmentServiceById(departmentId);
		if (deptMaster != null) {
			return new ResponseEntity<>(deptMaster, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/addDepartment")
	public ResponseEntity<String> addDepartment(@RequestBody @Valid DepartmentMaster departmentMaster) {
		Boolean isAdded = departmentService.addDepartmentService(departmentMaster);
		if (isAdded) {
			return new ResponseEntity<>("Department added Successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Failed to add Department", HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/updateDepartment/{departmentId}")
	public ResponseEntity<String> updateDepartment(
			@PathVariable("departmentId") @Positive(message = "Department ID must be positive") Integer departmentId,
			@RequestBody @Valid DepartmentMaster departmentMaster) {
		departmentMaster.setDepartmentId(departmentId);

		Boolean isUpdated = departmentService.updateDepartmentService(departmentMaster);
		if (isUpdated) {
			return new ResponseEntity<>("Department updated successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Failed to update Department", HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/deleteDepartment/{departmentId}")
	public ResponseEntity<String> deleteDepartment(
			@PathVariable("departmentId") @Positive(message = "Designation Id must be Positive") Integer departmentId) {
		try {
			DepartmentMaster departmentMaster = departmentService.getDepartmentServiceById(departmentId);
			if (departmentMaster != null) {
				Boolean isDeleted = departmentService.deleteDepartment(departmentMaster);
				if (isDeleted) {
					return new ResponseEntity<>("Department deleted successfully", HttpStatus.OK);
				}
			}
		} catch (Exception e) {
		}
		return new ResponseEntity<>("Failed to delete Department", HttpStatus.BAD_REQUEST);
	}

}
