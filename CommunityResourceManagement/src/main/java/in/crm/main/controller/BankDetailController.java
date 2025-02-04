package in.crm.main.controller;

import in.crm.main.master.BankDetailMaster;
import in.crm.main.master.DependentsDetailMaster;
import in.crm.main.service.BankDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/BankDetails")
public class BankDetailController {

    @Autowired
    private BankDetailService bankDetailService;


    @PostMapping("/addBankDetails")
    public ResponseEntity<String> addBankDetails(@RequestBody BankDetailMaster bankDetailMaster)
    {
        Boolean isAdded = bankDetailService.addBankDetailService(bankDetailMaster);
        if(isAdded){
            return  new ResponseEntity<>("BankDetails added successfully !", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Failed to add BankDetails",HttpStatus.BAD_REQUEST);
        }

    }


    @PutMapping("/updateBankDetails/{bankDetailId}")
    public ResponseEntity<String> updateBankDetails(@PathVariable("bankDetailId") Integer bankDetailId,@RequestBody BankDetailMaster bankDetailMaster)
    {
        bankDetailMaster.setBankDetailId(bankDetailId);
        Boolean isUpdated=bankDetailService.updateBankDetailService(bankDetailMaster);
        if(isUpdated)
        {
            return new ResponseEntity<>("Bank Details updated successfully!",HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("Failed to update Bank Details",HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteBankDetails/{bankDetailId}")
    public ResponseEntity<String> deleteBankDetails(@PathVariable("bankDetailId") Integer bankDetailId,@RequestBody BankDetailMaster bankDetailMaster)
    {
        bankDetailService.getBankDetailsService(bankDetailId);

        if(bankDetailMaster!= null)
        {
            Boolean isDeleted = bankDetailService.deleteBankDetailService(bankDetailMaster);
            if(isDeleted)
            {
                return new ResponseEntity<>("BankDetail deleted successfully",HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("failed to delete BankDetail",HttpStatus.BAD_REQUEST);

    }


    @GetMapping("/getBankDetails/{bankDetailId}")
    public ResponseEntity<BankDetailMaster>getBankDetails(@PathVariable("bankDetailId") Integer bankDetailId)
    {
        BankDetailMaster bankDetailMaster=bankDetailService.getBankDetailsService(bankDetailId);
        if (bankDetailMaster!=null)
        {
            return new ResponseEntity<>(bankDetailMaster,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/getAllBankDetails")
    public ResponseEntity<List<BankDetailMaster>> getAllBankDetails()
    {
        List<BankDetailMaster> allBankDetailMaster=bankDetailService.getAllBankDetailsService();
        return new ResponseEntity<>(allBankDetailMaster,HttpStatus.OK);
    }




}
