package in.crm.main.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import in.crm.main.dao.ProfilesDao;
import in.crm.main.master.ProfilesMaster;
import in.crm.main.service.ProfilesService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProfilesServiceimpl implements ProfilesService {
	
	private static final Logger logger = LogManager.getLogger(ProfilesServiceimpl.class);
	
	
	@Autowired
	private ProfilesDao profilesDao;

	@Override
	public List<ProfilesMaster> getAllProfilesService() {
		List<ProfilesMaster> allProfiles = new ArrayList<>();
		try {
			logger.info("In getAllProfilesService");
			allProfiles = (List<ProfilesMaster>) profilesDao.findAll();
			logger.info("Out of getAllProfilesService");
		}catch (Exception e) {
			logger.error("CRP:" + e.getMessage(), e);
		}
		return allProfiles;
	}

	@Override
	public ProfilesMaster getProfilesServiceById(Integer profileId) {
		try {
			logger.info("In getProfileService");
			ProfilesMaster profiles = profilesDao.findById(profileId).orElse(null);
			logger.info("Out of getProfileService");
			return profiles;
		}catch (Exception e) {
			logger.error("CRP:" + e.getMessage(),e);
		}
		return null;
	}

	@Override
	public Boolean addProfilesService(ProfilesMaster profilesMaster) {
		try {
			logger.info("In addService");
			profilesDao.save(profilesMaster);
			
		  return true;
		} catch(Exception e){
			logger.info("CRP:" + e.getMessage(),e);
			return false;
		}
	}

	@Override
	public Boolean updateProfilesService(ProfilesMaster profilesMaster) {
		try {
	        logger.info("In updateService");
	        ProfilesMaster profiles = profilesDao.findById(profilesMaster.getProfileId())
	            .orElseThrow(() -> new RuntimeException("profiles not found"));

	        profiles.setUserId(profilesMaster.getUserId());
	        profiles.setAddress(profilesMaster.getAddress());
	        profiles.setDob(profilesMaster.getDob());
	        profiles.setGender(profilesMaster.getGender());
	        profiles.setDoj(profilesMaster.getDoj());
	        profiles.setDepartment(profilesMaster.getDepartment());

	        profilesDao.save(profiles);
	        logger.info("Out of deleteprofilesService");
	        return true;
	    } catch (Exception e) {
	        logger.error("CRP: " + e.getMessage(), e);
	        return false;
	    }
	}

	@Override
	public Boolean deleteProfiles(ProfilesMaster profilesMaster) {
		try {
			logger.info("In DeleteService");
			ProfilesMaster profile = profilesDao.findById(profilesMaster.getProfileId()).orElseThrow(() -> new RuntimeException("Profile not found"));
			profilesDao.delete(profile);
			logger.info("Out of deleteProfilesService");
			return true;
		}catch (Exception e) {
			logger.error("CRP:" +e.getMessage(),e);
			return false;
		}
	}

}
