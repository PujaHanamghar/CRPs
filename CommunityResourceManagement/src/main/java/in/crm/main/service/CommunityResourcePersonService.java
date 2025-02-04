package in.crm.main.service;

import java.io.IOException;
import java.util.List;

import in.crm.main.master.CommunityResourcePersonMaster;
import org.springframework.web.multipart.MultipartFile;


public interface CommunityResourcePersonService
{
	public Boolean addCrmService(CommunityResourcePersonMaster communityResourceMaster);

	public Boolean updateCrmService(CommunityResourcePersonMaster communityResourceMaster);


	public Boolean deleteCrmService(CommunityResourcePersonMaster communityResourceMaster);

	public CommunityResourcePersonMaster getCrmService (Integer crmDetailsId );

	public List<CommunityResourcePersonMaster> getAllCrmService();

}
