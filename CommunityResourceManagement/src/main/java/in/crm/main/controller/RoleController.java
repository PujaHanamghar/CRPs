package in.crm.main.controller;

import java.util.List;

import in.crm.main.master.RoleMaster;
import in.crm.main.service.RoleService;
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
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@GetMapping("/getAllRoles")
	public ResponseEntity<List<RoleMaster>> getAllRoles() {
		List<RoleMaster> allRoles = roleService.getAllRoleService();
		return new ResponseEntity<>(allRoles, HttpStatus.OK);
	}

	@GetMapping("/getRole/{roleId}")
	public ResponseEntity<RoleMaster> getRole(
			@PathVariable("roleId") @Positive(message = "Role Id must be Positive") Integer roleId) {
		RoleMaster roleMaster = roleService.getRoleServiceById(roleId);
		if (roleMaster != null) {
			return new ResponseEntity<>(roleMaster, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/addRole")
	public ResponseEntity<String> addRole(@RequestBody @Valid RoleMaster roleMaster) {
		Boolean isAdded = roleService.addRoleService(roleMaster);
		if (isAdded) {
			return new ResponseEntity<>("Role Added Successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Failed to add Role", HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/updateRole/{roleId}")
	public ResponseEntity<String> updateRole(
			@PathVariable("roleId") @Positive(message = "Role id must be Positive") Integer roleId,
			@RequestBody @Valid RoleMaster roleMaster) {
		roleMaster.setRoleId(roleId);
		Boolean IsUpdated = roleService.updateRoleService(roleMaster);
		if (IsUpdated) {
			return new ResponseEntity<>("Role Updated Successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Failed to update Role", HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/deleteRole/{roleId}")
	public ResponseEntity<String> deleteRole(
			@PathVariable("roleId") @Positive(message = "Role ID MUST BE POSITIVE") Integer roleId) {
		try {
			RoleMaster roleMaster = roleService.getRoleServiceById(roleId);
			if (roleMaster != null) {
				Boolean isDeleted = roleService.deleteRole(roleMaster);
				if (isDeleted) {
					return new ResponseEntity<>("Role Deleted Successfully", HttpStatus.OK);
				}
			}
		} catch (Exception e) {

		}
		return new ResponseEntity<>("Failed to delete role", HttpStatus.BAD_REQUEST);
	}
}
