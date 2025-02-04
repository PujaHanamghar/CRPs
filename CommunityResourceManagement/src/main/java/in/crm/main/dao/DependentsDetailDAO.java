package in.crm.main.dao;

import in.crm.main.master.DependentsDetailMaster;
import org.springframework.data.repository.CrudRepository;

public interface DependentsDetailDAO extends CrudRepository<DependentsDetailMaster,Integer> {
}
