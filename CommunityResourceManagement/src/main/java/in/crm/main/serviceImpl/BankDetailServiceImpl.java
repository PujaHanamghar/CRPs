package in.crm.main.serviceImpl;

import in.crm.main.dao.BankDetailDAO;
import in.crm.main.master.BankDetailMaster;
import in.crm.main.master.PostingHistoryMaster;
import in.crm.main.service.BankDetailService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankDetailServiceImpl implements BankDetailService {
     private static final Logger logger= LogManager.getLogger(BankDetailServiceImpl.class);

     @Autowired
     private BankDetailDAO bankDetailDAO;

    @Override
    public Boolean addBankDetailService(BankDetailMaster bankDetailMaster) {
        try{
            logger.info("In addBankDetailService");
            bankDetailDAO.save(bankDetailMaster);
            logger.info("Out of addBankDetailService");
            return true;
        }
        catch (Exception e)
        {
            logger.info("CRP: " + e.getMessage(), e);
            return false;
        }
            }

    @Override
    public Boolean updateBankDetailService(BankDetailMaster bankDetailMaster) {
        try {
           logger.info(("In updateBankDetailService"));
           bankDetailDAO.findById(bankDetailMaster.getBankDetailId());
           bankDetailMaster.setBankName(bankDetailMaster.getBankName());
           bankDetailMaster.setAadharNumber(bankDetailMaster.getAadharNumber());
           bankDetailMaster.setAccountNumber(bankDetailMaster.getAccountNumber());
           bankDetailMaster.setIfscCode(bankDetailMaster.getIfscCode());
           bankDetailMaster.setPanNumber(bankDetailMaster.getPanNumber());
           bankDetailDAO.save(bankDetailMaster);
            logger.info("In updateBankDetailService");
            return true;
        }
        catch (Exception e)
        {
            logger.info("CRP: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Boolean deleteBankDetailService(BankDetailMaster bankDetailMaster) {
        try {
            logger.info("In deleteBankDetailService");
            bankDetailDAO.findById(bankDetailMaster.getBankDetailId());
            bankDetailDAO.delete(bankDetailMaster);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    @Override
    public BankDetailMaster getBankDetailsService(Integer bankDetailId) {
        try {
            logger.info("In getBankDetailsService");
            BankDetailMaster bankDetailMaster=bankDetailDAO.findById(bankDetailId).orElse(null);
            logger.info("Out of getBankDetailsService");
            return bankDetailMaster;
        }
        catch (Exception e)
        {
            logger.info("CRP:"+e.getMessage(),e);
            return null;
        }
    }

    @Override
    public List<BankDetailMaster> getAllBankDetailsService() {
        List<BankDetailMaster> allBankingDetails=new ArrayList<>();
        try {
            logger.info(" In getAllBankDetailsService");
            allBankingDetails =(List<BankDetailMaster>) bankDetailDAO.findAll();
            logger.info(" Out Of getAllBankDetailsService");
        }
        catch (Exception e)
        {
            logger.error("CRP: "+e.getMessage());
        }
        return allBankingDetails;
    }
}
