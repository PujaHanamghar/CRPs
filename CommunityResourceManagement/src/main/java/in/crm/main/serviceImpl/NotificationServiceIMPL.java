package in.crm.main.serviceImpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.crm.main.dao.NotificationDAO;
import in.crm.main.master.NotificationMaster;
import in.crm.main.service.NotificationService;
@Service
public class NotificationServiceIMPL implements NotificationService {
	
	@Autowired
	NotificationDAO notificationDAO;
	
	
	@Override
	public Boolean addNotificationService(NotificationMaster notificationMaster) {
		try
		  {
			notificationDAO.save(notificationMaster);
			  return true; 
			  } 
		  catch (Exception e)
		  {
	  e.printStackTrace(); 
	  return false; } 
	}
	
	@Override
	public Boolean updateNotificationService(NotificationMaster notificationMaster) {
		try
		  {
			  if(notificationDAO.existsById(notificationMaster.getNotificationId()))
			  {
				  notificationDAO.save(notificationMaster);
				  return true;
				  }
			  else
			  {
				  System.out.println("notification not found for update."); 
				  return false; 
				  }
			  }
	  catch (Exception e) { e.printStackTrace(); 
	  return false; 
	  }
	}

	@Override
	public Boolean deleteNotificationService(NotificationMaster notificationMaster) {
		 try 
		  {
			 notificationDAO.deleteById(notificationMaster.getNotificationId()); 
			  return true;
			  }
		  catch (Exception e) { e.printStackTrace(); return false; } 
		  }

	@Override
	public NotificationMaster getNotificationService(Integer notificationId) {
		 try
		  {
			  return notificationDAO.findById(notificationId).orElse(null);
			  } catch
		  (Exception e) 
		  {
				  e.printStackTrace(); 
				  return null; 
				  }
	}

	@Override
	public List<NotificationMaster> getAllNotificationService() {
		try {
			return (List<NotificationMaster>) notificationDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	}


