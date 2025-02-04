package in.crm.main.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.crm.main.dao.AttachmentDAO;
import in.crm.main.master.AttachmentMaster;
import in.crm.main.service.Attachmentservice;

@Service

public class AttachmentServiceIMPL implements Attachmentservice {

	@Autowired
	AttachmentDAO attachmentDAO;

	
	  @Override
	  public Boolean addAttachmentService(AttachmentMaster attachmentMaster) { 
		  try
		  {
			  attachmentDAO.save(attachmentMaster);
			  return true; 
			  } 
		  catch (Exception e)
		  {
	  e.printStackTrace(); 
	  return false; } 
		  }
	  
	  @Override 
	  public Boolean updateAttachmentService(AttachmentMaster attachmentMaster) 
	  {
		  try
		  {
			  if(attachmentDAO.existsById(attachmentMaster.getAttachmentId()))
			  {
				  attachmentDAO.save(attachmentMaster);
				  return true;
				  }
			  else
			  {
				  System.out.println("Attachment not found for update."); 
				  return false; 
				  }
			  }
	  catch (Exception e) { e.printStackTrace(); 
	  return false; }
		  }
	  
	  @Override 
	  public Boolean deleteAttachmentService(AttachmentMaster attachmentMaster) 
	  {
		  try 
		  {
			  attachmentDAO.deleteById(attachmentMaster.getAttachmentId()); 
			  return true;
			  }
		  catch (Exception e) { e.printStackTrace(); return false; } 
		  }
	  
	  @Override 
	  public AttachmentMaster getAttachmentService(Integer attachmentId){
		  try
		  {
			  return attachmentDAO.findById(attachmentId).orElse(null);
			  } catch
		  (Exception e) 
		  {
				  e.printStackTrace(); 
				  return null; 
				  }
		  }
	 
	@Override
	public List<AttachmentMaster> getAllAttachmentService() {
		try {
			return (List<AttachmentMaster>) attachmentDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
