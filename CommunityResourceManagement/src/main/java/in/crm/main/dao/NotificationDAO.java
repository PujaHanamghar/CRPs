package in.crm.main.dao;
import org.springframework.data.repository.CrudRepository;

import in.crm.main.master.NotificationMaster;

public interface NotificationDAO extends CrudRepository<NotificationMaster, Integer>{

}
