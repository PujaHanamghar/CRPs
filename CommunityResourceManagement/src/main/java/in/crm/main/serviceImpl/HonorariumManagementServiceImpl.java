package in.crm.main.serviceImpl;

import in.crm.main.dao.HonorariumManagementDAO;
import in.crm.main.master.HonorariumManagementMaster;
import in.crm.main.master.PostingHistoryMaster;
import in.crm.main.service.HonorariumManagementService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HonorariumManagementServiceImpl implements HonorariumManagementService {

    private static final Logger logger= LogManager.getLogger(HonorariumManagementServiceImpl.class);
    @Autowired
    private HonorariumManagementDAO honorariumManagementDAO;

    @Override
    public Boolean addHonorariumManagementService(HonorariumManagementMaster honorariumManagementMaster) {
        honorariumManagementDAO.save(honorariumManagementMaster);
        return true;
    }

    @Override
    public Boolean updateHonorariumManagementService(HonorariumManagementMaster honorariumManagementMaster) {
        try {
           logger.info("In updateHonorariumManagementService");
             honorariumManagementDAO.findById(honorariumManagementMaster.getHonorariumId());
            honorariumManagementMaster.setHonorariumAmount(honorariumManagementMaster.getHonorariumAmount());
            honorariumManagementMaster.setHonorariumPaymentDate(honorariumManagementMaster.getHonorariumPaymentDate());
            honorariumManagementMaster.setHonorariumPaymentStatus(honorariumManagementMaster.getHonorariumPaymentStatus());
            honorariumManagementMaster.setHonorariumPaymentMethod(honorariumManagementMaster.getHonorariumPaymentMethod());
            honorariumManagementDAO.save(honorariumManagementMaster);
            logger.info("In updateHonorariumManagementService");
            return true;
        } catch (RuntimeException e) {
            logger.info("CRP: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Boolean deleteHonorariumManagementService(HonorariumManagementMaster honorariumManagementMaster) {
        try {
            logger.info("In deleteHonorariumManagementService");
            honorariumManagementDAO.findById(honorariumManagementMaster.getHonorariumId());
            honorariumManagementDAO.delete(honorariumManagementMaster);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    @Override
    public HonorariumManagementMaster getHonorariumManagementService(Integer honorariumId) {
        try {
            logger.info("In getHonorariumManagementService");
            HonorariumManagementMaster honorariumManagementMaster=honorariumManagementDAO.findById(honorariumId).orElse(null);
            logger.info("Out of getHonorariumManagementService");
            return honorariumManagementMaster;
        }
        catch (Exception e)
        {
            logger.info("CRP:"+e.getMessage(),e);
            return null;
        }
    }

    @Override
    public List<HonorariumManagementMaster> getAllHonorariumManagementService() {
        List<HonorariumManagementMaster> allHonorariumManagementMaster=new ArrayList<>();
        try {
            logger.info(" In getAllHonorariumManagementService");
            allHonorariumManagementMaster=(List<HonorariumManagementMaster>) honorariumManagementDAO.findAll();
            logger.info(" Out Of getAllHonorariumManagementService");
        }
        catch (Exception e)
        {
            logger.error("CRP: "+e.getMessage());
        }
        return allHonorariumManagementMaster;

    }
}
