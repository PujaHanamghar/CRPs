package in.crm.main.serviceImpl;

import in.crm.main.dao.DisciplinaryActionHistoryDAO;
import in.crm.main.master.DisciplinaryActionHistoryMaster;
import in.crm.main.master.PostingHistoryMaster;
import in.crm.main.service.DisciplinaryActionHistoryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DisciplinaryActionHistoryServiceImpl implements DisciplinaryActionHistoryService {

    private static final Logger logger= LogManager.getLogger(DisciplinaryActionHistoryServiceImpl.class);
    @Autowired
    private DisciplinaryActionHistoryDAO disciplinaryActionHistoryDAO;

    @Override
    public Boolean addDisciplinaryActionHistoryService(DisciplinaryActionHistoryMaster disciplinaryActionHistoryMaster) {

        try {
            logger.info("In addDisciplinaryActionHistoryService");
            disciplinaryActionHistoryDAO.save(disciplinaryActionHistoryMaster);
            logger.info("Out of addDisciplinaryActionHistoryService");
            return true;
        }
        catch (Exception e)
        {
            logger.info("CRP: " + e.getMessage(), e);
            return false;
        }
 }

    @Override
    public Boolean updateDisciplinaryActionHistoryService(DisciplinaryActionHistoryMaster disciplinaryActionHistoryMaster) {
        try {
            logger.info("In updateDisciplinaryActionHistoryService");

            disciplinaryActionHistoryDAO.findById(disciplinaryActionHistoryMaster.getDisciplinaryActionHistoryId());
            disciplinaryActionHistoryMaster.setActionId((disciplinaryActionHistoryMaster.getActionId()));
            disciplinaryActionHistoryMaster.setChangeDate(disciplinaryActionHistoryMaster.getChangeDate());
            disciplinaryActionHistoryMaster.setChangeDesc(disciplinaryActionHistoryMaster.getChangeDesc());

            disciplinaryActionHistoryDAO.save(disciplinaryActionHistoryMaster);

            logger.info("In updateDisciplinaryActionHistoryService");
            return true;
        }
        catch (Exception e)
        {
            logger.info("CRP: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Boolean deleteDisciplinaryActionHistoryService(DisciplinaryActionHistoryMaster disciplinaryActionHistoryMaster) {
        try {
            logger.info("In deleteDisciplinaryActionHistoryService");
            disciplinaryActionHistoryDAO.findById(disciplinaryActionHistoryMaster.getDisciplinaryActionHistoryId());
            disciplinaryActionHistoryDAO.delete(disciplinaryActionHistoryMaster);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    @Override
    public DisciplinaryActionHistoryMaster getDisciplinaryActionHistoryService(Integer disciplinaryActionHistoryId) {
        try {
            logger.info("In getDisciplinaryActionHistoryService");
            DisciplinaryActionHistoryMaster disciplinaryActionHistoryMaster=disciplinaryActionHistoryDAO.findById(disciplinaryActionHistoryId).orElse(null);
            logger.info("Out of getDisciplinaryActionHistoryService");
            return disciplinaryActionHistoryMaster;
        }
        catch (Exception e)
        {
            logger.info("CRP:"+e.getMessage(),e);
            return null;
        }

    }

    @Override
    public List<DisciplinaryActionHistoryMaster> getAllDisciplinaryActionHistoryService() {
        List<DisciplinaryActionHistoryMaster> allDisciplinaryActionHistory=new ArrayList<>();
        try {
            logger.info(" In getAllDisciplinaryActionHistoryService");
            allDisciplinaryActionHistory =(List<DisciplinaryActionHistoryMaster>) disciplinaryActionHistoryDAO.findAll();
            logger.info(" Out Of getAllDisciplinaryActionHistoryService");
        }
        catch (Exception e)
        {
            logger.error("CRP: "+e.getMessage());
        }
        return allDisciplinaryActionHistory;
    }
    }




