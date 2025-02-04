package in.crm.main.serviceImpl;

import in.crm.main.dao.DisciplinaryActionsDAO;
import in.crm.main.master.DisciplinaryActionsMaster;
import in.crm.main.master.PostingHistoryMaster;
import in.crm.main.service.DisciplinaryActionsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DisciplinaryActionsServiceImpl implements DisciplinaryActionsService {

    private static final Logger logger= LogManager.getLogger(DisciplinaryActionsServiceImpl.class);

         @Autowired
        private DisciplinaryActionsDAO disciplinaryActionsDAO;

    @Override
    public Boolean addDisciplinaryActionsService(DisciplinaryActionsMaster disciplinaryActionsMaster) {

        try {
            logger.info("In addDisciplinaryActionsService");
            disciplinaryActionsDAO.save(disciplinaryActionsMaster);
            logger.info("Out of addDisciplinaryActionsService");
            return true;
        }
        catch (Exception e)
        {
            logger.info("CRP: " + e.getMessage(), e);
            return false;
        }

    }

    @Override
    public Boolean updateDisciplinaryActionsService(DisciplinaryActionsMaster disciplinaryActionsMaster) {
        try {
            logger.info("In updateDisciplinaryActionsService");
            disciplinaryActionsDAO.findById(disciplinaryActionsMaster.getDisciplinaryActionId());
            disciplinaryActionsMaster.setIncidentDate(disciplinaryActionsMaster.getIncidentDate());
            disciplinaryActionsMaster.setIncidentDetail(disciplinaryActionsMaster.getIncidentDetail());
            disciplinaryActionsMaster.setReportedDate(disciplinaryActionsMaster.getReportedDate());
            disciplinaryActionsMaster.setActionTaken(disciplinaryActionsMaster.getActionTaken());
            disciplinaryActionsMaster.setOutcomes(disciplinaryActionsMaster.getOutcomes());
            disciplinaryActionsMaster.setToken(disciplinaryActionsMaster.getToken());
            disciplinaryActionsMaster.setRemarks(disciplinaryActionsMaster.getRemarks());

            disciplinaryActionsDAO.save(disciplinaryActionsMaster);

            logger.info("In updateDisciplinaryActionsService");
            return true;
        }
        catch (Exception e)
        {
            logger.info("CRP: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Boolean deleteDisciplinaryActionsService(DisciplinaryActionsMaster disciplinaryActionsMaster) {
        try {
            logger.info("In deleteDisciplinaryActionsService");
            disciplinaryActionsDAO.findById(disciplinaryActionsMaster.getDisciplinaryActionId());
            disciplinaryActionsDAO.delete(disciplinaryActionsMaster);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    @Override
    public DisciplinaryActionsMaster getDisciplinaryActionsService(Integer disciplinaryActionId) {
        try {
            logger.info("In getDisciplinaryActionsService");
            DisciplinaryActionsMaster disciplinaryActionsMaster=disciplinaryActionsDAO.findById(disciplinaryActionId).orElse(null);
             logger.info("Out of getDisciplinaryActionsService");
            return disciplinaryActionsMaster;
        }
        catch (Exception e)
        {
            logger.info("CRP:"+e.getMessage(),e);
            return null;
        }


    }

    @Override
    public List<DisciplinaryActionsMaster> getAllDisciplinaryActionsService() {

        List<DisciplinaryActionsMaster>  allDisciplinaryActionsList=new ArrayList<>();
        try {
            logger.info(" In getAllDisciplinaryActionsService");

            allDisciplinaryActionsList =(List<DisciplinaryActionsMaster>) disciplinaryActionsDAO.findAll() ;

            logger.info(" Out Of getAllDisciplinaryActionsService");
        }
        catch (Exception e)
        {
            logger.error("CRP: "+e.getMessage());
        }
        return allDisciplinaryActionsList;
    }
    }

