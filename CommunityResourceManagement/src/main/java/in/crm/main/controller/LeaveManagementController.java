package in.crm.main.controller;

import in.crm.main.master.HonorariumHistoryMaster;
import in.crm.main.master.LeaveManagementMaster;
import in.crm.main.service.LeaveManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/LeaveManagement")
public class LeaveManagementController {

    @Autowired
    private LeaveManagementService leaveManagementService;

    @PostMapping("/addLeaveManagement")
    public ResponseEntity<String> addLeaveManagement(@RequestBody LeaveManagementMaster leaveManagementMaster)
    {
        Boolean isAdded = leaveManagementService.addLeaveManagementService(leaveManagementMaster);
        if(isAdded){
            return  new ResponseEntity<>("LeaveManagement added successfully !", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Failed to add LeaveManagement",HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("/updateLeaveManagement/{leaveId}")
    public ResponseEntity<String> updateLeaveManagement(@PathVariable("leaveId") Integer leaveId,@RequestBody LeaveManagementMaster leaveManagementMaster)
    {
        leaveManagementMaster.setLeaveId(leaveId);

        Boolean isUpdated=leaveManagementService.updateLeaveManagementService(leaveManagementMaster);
        if(isUpdated)
        {
            return new ResponseEntity<>("LeaveManagement updated successfully!",HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("Failed to update LeaveManagement",HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteLeaveManagement/{leaveId}")
    public ResponseEntity<String> deleteLeaveManagement(@PathVariable("leaveId") Integer leaveId,@RequestBody LeaveManagementMaster leaveManagementMaster)
    {
        leaveManagementService.getLeaveManagementService(leaveId);

        if(leaveManagementMaster!= null)
        {
            Boolean isDeleted = leaveManagementService.deleteLeaveManagementService(leaveManagementMaster);
            if(isDeleted)
            {
                return new ResponseEntity<>("LeaveManagement deleted successfully",HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("failed to delete LeaveManagement",HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getLeaveManagement/{leaveId}")
    public ResponseEntity<LeaveManagementMaster>getLeaveManagement(@PathVariable("leaveId") Integer leaveId)
    {
        LeaveManagementMaster leaveManagementMaster=leaveManagementService.getLeaveManagementService(leaveId);
        if (leaveManagementMaster!=null)
        {
            return new ResponseEntity<>(leaveManagementMaster,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllLeaveManagement")
    public ResponseEntity<List<LeaveManagementMaster>> getAllLeaveManagement()
    {
        List<LeaveManagementMaster> allLeaveManagement= leaveManagementService.getAllLeaveManagementService();
        return new ResponseEntity<>(allLeaveManagement,HttpStatus.OK);
    }



}
