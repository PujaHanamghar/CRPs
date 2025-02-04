package in.crm.main.serviceImpl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.crm.main.dao.SocialCategoryDAO;
import in.crm.main.master.SocialCategoryMaster;
import in.crm.main.service.SocialCategoryService;

@Service
public class SocialCategoryServiceIMPL implements SocialCategoryService {

	@Autowired
	SocialCategoryDAO socialcategoryDAO;
	
	@Override
	public Boolean addSocialCategoryService(SocialCategoryMaster socialCategoryMaster) {
		 try
		  {
			 socialcategoryDAO.save(socialCategoryMaster);
			  return true; 
			  } 
		  catch (Exception e)
		  {
	  e.printStackTrace(); 
	  return false; } 
	}

	@Override
	public Boolean updateSocialCategoryService(SocialCategoryMaster socialCategoryMaster) {
		  try
		  {
			  if(socialcategoryDAO.existsById(socialCategoryMaster.getSocialCategoryId()))
			  {
				  socialcategoryDAO.save(socialCategoryMaster);
				  return true;
				  }
			  else
			  {
				  System.out.println("Attachment not found for update."); 
				  return false; 
				  }
			  }
	  catch (Exception e) { e.printStackTrace(); 
	  return false; 
	  }
	}

	@Override
	public Boolean deleteSocialCategoryService(SocialCategoryMaster socialCategoryMaster) {
		  try 
		  {
			  socialcategoryDAO.deleteById(socialCategoryMaster.getSocialCategoryId()); 
			  return true;
			  }
		  catch (Exception e) { e.printStackTrace(); return false; } 
		  }
	
	@Override
	public SocialCategoryMaster getSocialCategoryService(Integer socialCategoryId) {
		 try
		  {
			  return socialcategoryDAO.findById(socialCategoryId).orElse(null);
			  } catch
		  (Exception e) 
		  {
				  e.printStackTrace(); 
				  return null; 
				  }
	}

	@Override
	public List<SocialCategoryMaster> getAllSocialCategoryService() {
		try {
			return (List<SocialCategoryMaster>) socialcategoryDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
