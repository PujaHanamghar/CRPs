package in.crm.main.service;



import java.util.List;

import in.crm.main.master.NotificationMaster;
public interface NotificationService {
	 public Boolean addNotificationService(NotificationMaster notificationMaster);
	  public Boolean updateNotificationService(NotificationMaster notificationMaster);
	  public Boolean deleteNotificationService(NotificationMaster notificationMaster);
	  public NotificationMaster getNotificationService(Integer notificationId);
	  public List<NotificationMaster> getAllNotificationService();
	    

}
