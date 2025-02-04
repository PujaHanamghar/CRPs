package in.crm.main.serviceImpl;

import in.crm.main.dao.HonorariumHistoryDAO;
import in.crm.main.master.HonorariumHistoryMaster;
import in.crm.main.master.HonorariumManagementMaster;
import in.crm.main.service.HonorariumHistoryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HonorariumHistoryServiceImpl implements HonorariumHistoryService {

    private static final Logger logger= LogManager.getLogger(HonorariumHistoryServiceImpl.class);

    @Autowired
    HonorariumHistoryDAO honorariumHistoryDAO;


    @Override
    public Boolean addHonorariumHistoryService(HonorariumHistoryMaster honorariumHistoryMaster) {
       honorariumHistoryDAO.save(honorariumHistoryMaster);
         return true;
    }
    @Override
    public Boolean updateHonorariumHistoryService(HonorariumHistoryMaster honorariumHistoryMaster) {
        try {
            logger.info("In updateHonorariumHistoryService");
            honorariumHistoryDAO.findById(honorariumHistoryMaster.getHid());
            honorariumHistoryMaster.setUserid(honorariumHistoryMaster.getUserid());
            honorariumHistoryMaster.setAmount(honorariumHistoryMaster.getAmount());
            honorariumHistoryMaster.setRemarks(honorariumHistoryMaster.getRemarks());
            honorariumHistoryMaster.setPaymentDate(honorariumHistoryMaster.getPaymentDate());
            honorariumHistoryMaster.setStatus(honorariumHistoryMaster.getStatus());
            honorariumHistoryMaster.setTransactionID(honorariumHistoryMaster.getTransactionID());
            honorariumHistoryMaster.setPaymentMode(honorariumHistoryMaster.getPaymentMode());
            honorariumHistoryDAO.save(honorariumHistoryMaster);
            logger.info("In updateHonorariumHistoryService");
            return true;
        } catch (RuntimeException e) {
            logger.info("CRP: " + e.getMessage(), e);
            return false;
        }
    }


    @Override
    public Boolean deleteHonorariumHistoryService(HonorariumHistoryMaster honorariumHistoryMaster) {
        try {
            logger.info("In deleteHonorariumHistoryService");
            honorariumHistoryDAO.findById(honorariumHistoryMaster.getHid());
            honorariumHistoryDAO.delete(honorariumHistoryMaster);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }


    @Override
    public HonorariumHistoryMaster getHonorariumHistoryService(Integer hid) {
        try {
            logger.info("In getHonorariumHistoryService");
            HonorariumHistoryMaster honorariumHistoryMaster=honorariumHistoryDAO.findById(hid).orElse(null);
            logger.info("Out of getHonorariumHistoryService");
            return honorariumHistoryMaster;
        }
        catch (Exception e)
        {
            logger.info("CRP:"+e.getMessage(),e);
            return null;
        }

    }

    @Override
    public List<HonorariumHistoryMaster> getAllHonorariumHistoryService() {
        List<HonorariumHistoryMaster> allHonorariumHistoryMaster= new ArrayList<>();

        try {
            logger.info(" In getAllHonorariumHistoryService");
            allHonorariumHistoryMaster=(List<HonorariumHistoryMaster>) honorariumHistoryDAO.findAll();
            logger.info(" Out Of getAllHonorariumHistoryService");
        }
        catch (Exception e)
        {
            logger.error("CRP: "+e.getMessage());
        }
        return allHonorariumHistoryMaster;
    }
}
