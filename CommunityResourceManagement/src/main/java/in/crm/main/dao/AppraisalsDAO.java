package in.crm.main.dao;
import org.springframework.data.repository.CrudRepository;

import in.crm.main.master.AppraisalsMaster;

public interface AppraisalsDAO extends CrudRepository<AppraisalsMaster, Integer> {
}
