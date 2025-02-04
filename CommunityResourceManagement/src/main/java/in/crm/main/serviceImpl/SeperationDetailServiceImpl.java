package in.crm.main.serviceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonFormat;

import in.crm.main.dao.PostingHistoryDAO;
import in.crm.main.dao.SeperationDetailDAO;
import in.crm.main.master.PostingHistoryMaster;
import in.crm.main.master.SeperationDetailMaster;
import in.crm.main.service.SeperationDetailService;

@Service
public class SeperationDetailServiceImpl implements SeperationDetailService{
	
	 private static final Logger logger= LogManager.getLogger(SeperationDetailServiceImpl.class);

	    @Autowired
	    private SeperationDetailDAO seperationDetailDAO;


	@Override
	public Boolean addSeperationDetailService(SeperationDetailMaster seperationDetailMaster) {
        try {
            logger.info("In addSeperationDetailService");
            seperationDetailDAO.save(seperationDetailMaster);
            logger.info("Out of addSeperationDetailService");
            return true;
        }
        catch (Exception e)
        {
            logger.info("CRP: " + e.getMessage(), e);
          return false;
        }

	}

	@Override
	public Boolean updateSeperationDetailService(SeperationDetailMaster seperationDetailMaster) {
		  try {
	            logger.info("In updateSeperationDetailService");
	            
	            seperationDetailDAO.findById(seperationDetailMaster.getSeperationId());
	            
	       
	            seperationDetailMaster.setRegistrationDate(seperationDetailMaster.getRegistrationDate());
	            seperationDetailMaster.setLastWorkingDay(seperationDetailMaster.getLastWorkingDay());
	            seperationDetailMaster.setTypeOfSeperation(seperationDetailMaster.getTypeOfSeperation());
	            seperationDetailMaster.setNoticePeriodStartDate(seperationDetailMaster.getNoticePeriodStartDate());
	            seperationDetailMaster.setNoticePeriodDays(seperationDetailMaster.getNoticePeriodDays());
	            
	            seperationDetailMaster.setReason(seperationDetailMaster.getReason());
	            seperationDetailMaster.setExitInterviewStatus(seperationDetailMaster.getExitInterviewStatus());
	            seperationDetailMaster.setRemarks(seperationDetailMaster.getRemarks());
	            
	            seperationDetailDAO.save(seperationDetailMaster);
	            logger.info("In updateSeperationDetailService");
	            return true;
	        }
	        catch (Exception e)
	        {
	            logger.info("CRP: " + e.getMessage(), e);
	            return false;
	        }

	}

	@Override
	public Boolean deleteSeperationDetailService(SeperationDetailMaster seperationDetailMaster) {
		 try {
	            logger.info("In deleteSeperationDetailService");
	            seperationDetailDAO.findById(seperationDetailMaster.getSeperationId());
	            seperationDetailDAO.delete(seperationDetailMaster);
	            return true;
	        }
	        catch (Exception e)
	        {
	            return false;
	        }

	}

	@Override
	public SeperationDetailMaster getSeperationDetailService(Integer seperationId) {
		try {
		       logger.info("In getSeperationDetailService");
		       SeperationDetailMaster seperationDetailMaster=seperationDetailDAO.findById(seperationId).orElse(null);
		       logger.info("Out of getSeperationDetailService");
		       return seperationDetailMaster;
		    }
		   catch (Exception e)
		   {
		       logger.info("CRP:"+e.getMessage(),e);
		    return null;
		    }


	}

	@Override
	public List<SeperationDetailMaster> getAllSeperationDetailService() {
		List<SeperationDetailMaster> allSeperationDetails=new ArrayList<>();
        try {
            logger.info(" In getAllSeperationDetailService");
            allSeperationDetails =(List<SeperationDetailMaster>) seperationDetailDAO.findAll();
            logger.info(" Out Of getAllSeperationDetailService");
        }
        catch (Exception e)
        {
            logger.error("CRP: "+e.getMessage());
        }
         return allSeperationDetails;
    }
	}


