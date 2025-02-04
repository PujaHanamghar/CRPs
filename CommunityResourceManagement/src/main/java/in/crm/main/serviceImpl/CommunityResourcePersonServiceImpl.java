package in.crm.main.serviceImpl;

import in.crm.main.dao.CommunityResourcePersonDAO;
import in.crm.main.master.CommunityResourcePersonMaster;
import in.crm.main.service.CommunityResourcePersonService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommunityResourcePersonServiceImpl implements CommunityResourcePersonService {
    private static final Logger logger = LogManager.getLogger(CommunityResourcePersonServiceImpl.class);

    @Autowired
    private CommunityResourcePersonDAO communityResourcePersonDAO;

    @Override
    public Boolean addCrmService(CommunityResourcePersonMaster communityResourceMaster) {
        try {
            logger.info("In add CommunityResourcePersonMaster");


            communityResourcePersonDAO.save(communityResourceMaster);
            logger.info("Out of CommunityResourcePersonMaster");
            return true;
        } catch (Exception e) {
            logger.info("IMS: " + e.getMessage(), e);
            return false;
        }
    }
@Override
public Boolean updateCrmService(CommunityResourcePersonMaster communityResourceMaster) {
    try{
        logger.info("In updateCrmService");
        communityResourcePersonDAO.findById(communityResourceMaster.getCrpId()).orElseThrow(()-> new RuntimeException("Designation not found"));
        communityResourceMaster.setCrpFirstName(communityResourceMaster.getCrpFirstName());
        communityResourceMaster.setCrpMiddleName(communityResourceMaster.getCrpMiddleName());
        communityResourceMaster.setCrpLastName(communityResourceMaster.getCrpLastName());
        communityResourceMaster.setCrpDateOfBirth(communityResourceMaster.getCrpDateOfBirth());
        communityResourceMaster.setCrpQualification(communityResourceMaster.getCrpQualification());
        communityResourceMaster.setCrpYearOfExperience((communityResourceMaster.getCrpYearOfExperience()));
        communityResourceMaster.setCrpAddress(communityResourceMaster.getCrpAddress());
        communityResourceMaster.setCrpEmailId(communityResourceMaster.getCrpEmailId());
        communityResourceMaster.setCrpMobileNo(communityResourceMaster.getCrpMobileNo());
        communityResourceMaster.setCrpBloodGroup(communityResourceMaster.getCrpBloodGroup());
        communityResourceMaster.setCrpUID(communityResourceMaster.getCrpUID());
        communityResourceMaster.setCrpDepartment(communityResourceMaster.getCrpDepartment());
        communityResourceMaster.setCrpDesignation(communityResourceMaster.getCrpDesignation());
        communityResourceMaster.setCrpJobRole(communityResourceMaster.getCrpJobRole());
        communityResourceMaster.setCrpLocation(communityResourceMaster.getCrpLocation());
        communityResourceMaster.setCrpDateOfJoining(communityResourceMaster.getCrpDateOfJoining());
        communityResourceMaster.setCrpSelectionCategory(communityResourceMaster.getCrpSelectionCategory());
        communityResourceMaster.setCrpSocialCategory(communityResourceMaster.getCrpSocialCategory());
        communityResourceMaster.setCrpPostingHistory(communityResourceMaster.getCrpPostingHistory());

        communityResourcePersonDAO.save(communityResourceMaster);

        logger.info("out of updateCrmService");
        return true;
    }
    catch(Exception e)
    {
        logger.info("CRP:" +e.getMessage(),e);
      return false;
    }
    }
   @Override
    public Boolean deleteCrmService(CommunityResourcePersonMaster communityResourcePersonMaster)
    {

        try{
            logger.info("In delete CrmService:");
            communityResourcePersonDAO.findById(communityResourcePersonMaster.getCrpId());

            communityResourcePersonDAO.delete(communityResourcePersonMaster);
            logger.info("out of delete CrmService:");
            return true;
        }
        catch (Exception e)
        {
            logger.info("CRP: "+e.getMessage(),e);
            return false;
        }

    }

    @Override
    public CommunityResourcePersonMaster getCrmService(Integer crpId) {
        try {
            logger.info("In getCrmService");
            CommunityResourcePersonMaster communityResourcePersonMaster=communityResourcePersonDAO.findById(crpId).orElse(null);
            logger.info(" Out of getCrmService");
            return communityResourcePersonMaster;
        } catch (Exception e) {
            logger.info("CRM:"+e.getMessage(),e);
            return null;
        }
    }

    @Override
    public List<CommunityResourcePersonMaster> getAllCrmService() {
        List<CommunityResourcePersonMaster> allCrm = new ArrayList<>();
        try {
            logger.info("In getAllCrmService");
            allCrm=(List<CommunityResourcePersonMaster>) communityResourcePersonDAO.findAll();
            logger.info("out of getAllCrmService");
        }
      catch (Exception e)
      {
          logger.info("CRM: "+e.getMessage(),e);
      }
            return allCrm;
      }

}
