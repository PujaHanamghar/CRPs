package in.crm.main.controller;


import in.crm.main.master.LeaveManagementMaster;
import in.crm.main.master.MonthlyReportsMaster;
import in.crm.main.service.MonthlyReportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/MonthlyReports")
public class MonthlyReportsController {

    @Autowired
    private MonthlyReportsService monthlyReportsService;

    @PostMapping("/addMonthlyReports")
    public ResponseEntity<String> addMonthlyReports(@RequestBody MonthlyReportsMaster monthlyReportsMaster)
    {
        Boolean isAdded = monthlyReportsService.addMonthlyReportService(monthlyReportsMaster);
        if(isAdded){
            return  new ResponseEntity<>("Monthly Reports  added successfully !", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Failed to add LeaveManagement",HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("/updateMonthlyReports/{reportId}")
    public ResponseEntity<String> updateMonthlyReports(@PathVariable("reportId") Integer reportId,@RequestBody MonthlyReportsMaster monthlyReportsMaster)
    {
        monthlyReportsMaster.setReportId(reportId);

        Boolean isUpdated=monthlyReportsService.updateMonthlyReportService(monthlyReportsMaster);
        if(isUpdated)
        {
            return new ResponseEntity<>("Monthly Report updated successfully!",HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("Failed to update Monthly Report",HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteMonthlyReports/{reportId}")
    public ResponseEntity<String> deleteMonthlyReports(@PathVariable("reportId") Integer reportId,@RequestBody MonthlyReportsMaster monthlyReportsMaster)
    {
        monthlyReportsService.getMonthlyReportService(reportId);

        if(monthlyReportsMaster!= null)
        {
            Boolean isDeleted = monthlyReportsService.deleteMonthlyReportService(monthlyReportsMaster);
            if(isDeleted)
            {
                return new ResponseEntity<>("MonthlyReports deleted successfully",HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("failed to delete MonthlyReports",HttpStatus.BAD_REQUEST);
    }


    @GetMapping("/getMonthlyReports/{reportId}")
    public ResponseEntity<MonthlyReportsMaster>getLeaveManagement(@PathVariable("reportId") Integer reportId)
    {
        MonthlyReportsMaster monthlyReportsMaster=monthlyReportsService.getMonthlyReportService(reportId);
        if (monthlyReportsMaster!=null)
        {
            return new ResponseEntity<>(monthlyReportsMaster,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/getAllMonthlyReports")
    public ResponseEntity<List<MonthlyReportsMaster>> getAllMonthlyReports()
    {
        List<MonthlyReportsMaster> allMonthlyReportMaster= monthlyReportsService.getAllMonthlyReportService();
        return new ResponseEntity<>(allMonthlyReportMaster,HttpStatus.OK);
    }



}
