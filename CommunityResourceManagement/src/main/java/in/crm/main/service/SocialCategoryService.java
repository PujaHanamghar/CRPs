package in.crm.main.service;



import java.util.List;

import in.crm.main.master.SocialCategoryMaster;

public interface SocialCategoryService {
	 public Boolean addSocialCategoryService(SocialCategoryMaster socialCategoryMaster);
	  public Boolean updateSocialCategoryService(SocialCategoryMaster socialCategoryMaster);
	  public Boolean deleteSocialCategoryService(SocialCategoryMaster socialCategoryMaster);
	  public SocialCategoryMaster getSocialCategoryService(Integer socialCategoryId);
	  public List<SocialCategoryMaster> getAllSocialCategoryService();
}
