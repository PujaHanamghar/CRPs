package in.crm.main.serviceImpl;

import in.crm.main.dao.DependentsDetailDAO;
import in.crm.main.master.DependentsDetailMaster;
import in.crm.main.master.DesignationMaster;
import in.crm.main.master.HonorariumManagementMaster;
import in.crm.main.service.DependentsDetailService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DependentsDetailServiceImpl implements DependentsDetailService {

    private static final Logger logger= LogManager.getLogger(DependentsDetailServiceImpl.class);

    @Autowired
    private DependentsDetailDAO dependentsDetailDAO;

    @Override
    public Boolean addDependentsDetailService(DependentsDetailMaster dependentsDetailMaster) {
        dependentsDetailDAO.save(dependentsDetailMaster);
        return true;
    }

    @Override
    public Boolean updateDependentsDetailService(DependentsDetailMaster dependentsDetailMaster) {

        dependentsDetailDAO.findById(dependentsDetailMaster.getDependentId());
        dependentsDetailMaster.setName(dependentsDetailMaster.getName());
        dependentsDetailMaster.setDateOfBirth(dependentsDetailMaster.getDateOfBirth());
        dependentsDetailMaster.setGender(dependentsDetailMaster.getGender());
        dependentsDetailMaster.setStatus(dependentsDetailMaster.getStatus());
        dependentsDetailDAO.save(dependentsDetailMaster);
        return true;

    }

    @Override
    public Boolean deleteDependentsDetailService(DependentsDetailMaster dependentsDetailMaster) {

        try {
            logger.info("In deleteDependentsDetailService");
            dependentsDetailDAO.findById(dependentsDetailMaster.getDependentId());
            dependentsDetailDAO.delete(dependentsDetailMaster);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    @Override
    public DependentsDetailMaster getDependentsDetailService(Integer dependentId) {
        try {
            logger.info("In getDependentsDetailService");
            DependentsDetailMaster dependentsDetailMaster=dependentsDetailDAO.findById(dependentId).orElse(null);
            logger.info("Out of getDependentsDetailService");
            return dependentsDetailMaster;
        }
        catch (Exception e)
        {
            logger.info("CRP:"+e.getMessage(),e);
            return null;
        }
    }

    @Override
    public List<DependentsDetailMaster> getAllDependentsDetailService() {

        List<DependentsDetailMaster> allDependentsDetails = new ArrayList<>();
        try {
            logger.info(" In getAllDependentsDetailService");
            allDependentsDetails=(List<DependentsDetailMaster>) dependentsDetailDAO.findAll();
            logger.info(" Out Of getAllDependentsDetailService");
        }
        catch (Exception e)
        {
            logger.error("CRP: "+e.getMessage());
        }
        return allDependentsDetails;

    }
    }

