package in.crm.main.service;

import in.crm.main.master.ProfilesMaster;

import java.util.List;


public interface ProfilesService {

	public List<ProfilesMaster> getAllProfilesService();
	public ProfilesMaster getProfilesServiceById(Integer profileId);
	public Boolean addProfilesService(ProfilesMaster profilesMaster);
	public Boolean updateProfilesService(ProfilesMaster profilesMaster);
	public Boolean deleteProfiles(ProfilesMaster profilesMaster);
}
