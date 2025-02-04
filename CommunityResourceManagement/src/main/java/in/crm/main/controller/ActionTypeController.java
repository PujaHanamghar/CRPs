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

import in.crm.main.master.ActionTypeMaster;
import in.crm.main.service.ActionTypeService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

@RestController
@RequestMapping("/actionType")
public class ActionTypeController {

    @Autowired
    private ActionTypeService actionTypeService;
 
    
    @PostMapping("/addActionType")
	public ResponseEntity<String> addActionType(@RequestBody @Valid  ActionTypeMaster actionTypeMaster) {
		Boolean isAdded = actionTypeService.addActionTypeService(actionTypeMaster);
		if (isAdded) {
			return new ResponseEntity<>("ActionType added successfully!", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("Failed to add ActionType.", HttpStatus.BAD_REQUEST);
		}
	}
    @PutMapping("/updateactionType/{actionTypeId}") public ResponseEntity<String>
	  updateactionType(
	  
	  @PathVariable("actionTypeId")
	  @Positive(message ="actionType ID must be positive") Integer actionTypeId,
	  @RequestBody @Valid ActionTypeMaster actionTypeMaster) {
    	actionTypeMaster.setActionTypeId(actionTypeId);
			Boolean isUpdated = actionTypeService.updateActionTypeService(actionTypeMaster);
			if (isUpdated) {
				return new ResponseEntity<>("actionType updated successfully!", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("actionType to update country.", HttpStatus.BAD_REQUEST);
			}
    }
		
    @DeleteMapping("/deleteactionType/{actionTypeId}")
			public ResponseEntity<String> deleteactionType(
					@PathVariable("actionTypeId") @Positive(message = "actionType ID must be positive") Integer actionTypeId) {
    	ActionTypeMaster actionTypeMaster = actionTypeService.getActionTypeService(actionTypeId);
				if (actionTypeMaster != null) {
					Boolean isDeleted = actionTypeService.deleteActionTypeService(actionTypeMaster);
					if (isDeleted) {
						return new ResponseEntity<>("actionTypeId deleted successfully!", HttpStatus.OK);
					}
				}
				return new ResponseEntity<>("Failed to delete actionTypeId.", HttpStatus.BAD_REQUEST);
			}

    @GetMapping("/get/{actionTypeId}")
    public ResponseEntity<ActionTypeMaster> getActionType(
            @PathVariable("actionTypeId") @Positive(message = "ActionType ID must be positive") Integer actionTypeId) {
        ActionTypeMaster actionTypeMaster = actionTypeService.getActionTypeService(actionTypeId);
        if (actionTypeMaster != null) {
            return new ResponseEntity<>(actionTypeMaster, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ActionTypeMaster>> getAllActionTypes() {
        List<ActionTypeMaster> allActionTypes;
        try {
            allActionTypes = actionTypeService.getAllActionTypeService();
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(allActionTypes, HttpStatus.OK);
    }
}
