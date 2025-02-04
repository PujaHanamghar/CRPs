package in.crm.main.controller;

import java.util.List;

import in.crm.main.master.RolePermissionsMaster;
import in.crm.main.service.RolePermissionsService;
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
@RequestMapping("/rolepermission")
public class RolePermissionController {
	
	@Autowired
	private RolePermissionsService rolePermissionsService;
	
	@GetMapping("/getAllRolesPermission")
	public ResponseEntity<List<RolePermissionsMaster>> getAllRolesPer() {
		List<RolePermissionsMaster> allroles = rolePermissionsService.getAllRolePermissionsService();
		return new ResponseEntity<>(allroles, HttpStatus.OK);
	}

	@GetMapping("/getRolesPer/{perId}")
	public ResponseEntity<RolePermissionsMaster> getRolesPermission(
			@PathVariable("perId") @Positive(message = "RolesPermission Id must be positive") Integer perId) {
		RolePermissionsMaster roles = rolePermissionsService.getRolePermissionsServiceById(perId);
		if (roles != null) {
			return new ResponseEntity<>(roles, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/addRolePermission")
	public ResponseEntity<String> addRolePermission(@RequestBody @Valid RolePermissionsMaster rolePermissionsMaster) {
		Boolean isAdded = rolePermissionsService.addRolePermissionsService(rolePermissionsMaster);
		if (isAdded) {
			return new ResponseEntity<>("RolesPermission added Successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Failed to add RolesPermission", HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/updateRolesPer/{perId}")
	public ResponseEntity<String> updateRolesPermission(
			@PathVariable("perId") @Positive(message = "RolesPermission ID must be positive") Integer perId,
			@RequestBody @Valid RolePermissionsMaster rolePermissionsMaster) {
		rolePermissionsMaster.setPerId(perId);

		Boolean isUpdated = rolePermissionsService.updateRolePermissionsService(rolePermissionsMaster);
		if (isUpdated) {
			return new ResponseEntity<>("RolesPermission updated successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Failed to update RolesPermission", HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/deleteRolesPermission/{perId}")
	public ResponseEntity<String> deleteRolesPermission(
			@PathVariable("perId") @Positive(message = "RolePermission Id must be Positive") Integer perId) {
		try {
			RolePermissionsMaster roles = rolePermissionsService.getRolePermissionsServiceById(perId);
			if (roles != null) {
				Boolean isDeleted = rolePermissionsService.deleteRolePermissions(roles);
				if (isDeleted) {
					return new ResponseEntity<>("RolePermission deleted successfully", HttpStatus.OK);
				}
			}
		} catch (Exception e) {
		}
		return new ResponseEntity<>("Failed to delete RolePermission", HttpStatus.BAD_REQUEST);
	}


}
