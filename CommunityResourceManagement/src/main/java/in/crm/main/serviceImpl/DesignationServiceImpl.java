package in.crm.main.serviceImpl;

import in.crm.main.dao.DesignationDAO;
import in.crm.main.master.DesignationMaster;
import in.crm.main.service.DesignationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class DesignationServiceImpl implements DesignationService {

    private static final Logger logger= LogManager.getLogger(DesignationServiceImpl.class);

    @Autowired
   private DesignationDAO designationDAO;

    @Override
    public Boolean addDesignationService(DesignationMaster designationMaster) {
        try {
            logger.info("In add DesignationService");
            designationDAO.save(designationMaster);
            logger.info("Out of addDesignationService");
            return true;
        }
        catch (Exception e)
        {
            logger.info("CRP: " + e.getMessage(), e);
            return  false;
        }
    }

    @Override
    public Boolean updateDesignationService(DesignationMaster designationMaster) {
       try{
       logger.info("In updateDesignationService");
       designationDAO.findById(designationMaster.getDesignationId());

       designationMaster.setDesignationName(designationMaster.getDesignationName());
       designationMaster.setDesignationDesc(designationMaster.getDesignationDesc());
       designationDAO.save(designationMaster);
       logger.info("Out of updateDesignationService");
       return true;
       }
       catch (Exception e) {
           logger.info("CRP: " + e.getMessage(), e);
           return false;
       }
    }

    @Override
    public Boolean deleteDesignationService(DesignationMaster designationMaster) {
        try {
            logger.info("In deleteDesignationService ");

            designationDAO.findById(designationMaster.getDesignationId());
            designationMaster.setDesignationName(designationMaster.getDesignationName());
            designationMaster.setDesignationDesc(designationMaster.getDesignationDesc());
            designationDAO.delete(designationMaster);

            return true;
        }
        catch(Exception e)
        {
            logger.info("CRP:"+e.getMessage(),e);
            return false;
        }
    }

    @Override
    public DesignationMaster getDesignationService(Integer designationId) {
        try {
            logger.info("In getDesignationService");
            DesignationMaster designationMaster=designationDAO.findById(designationId).orElse(null);
            logger.info("Out of getDesignationService ");
            return designationMaster;
        }
        catch (Exception e)
        {
            logger.info("CRP:"+e.getMessage(),e);
            return null;
        }

        }

    @Override
    public List<DesignationMaster> getAllDesignationService() {

        List<DesignationMaster> allDesignations = new ArrayList<>();
        try {
            logger.info("getAllDesignationService");
            allDesignations =(List<DesignationMaster>) designationDAO.findAll();
            logger.info("OutAllDesignationService");
        }
        catch (Exception e)
        {
            logger.error("CRP: "+e.getMessage());
        }
        return allDesignations;
    }
}
