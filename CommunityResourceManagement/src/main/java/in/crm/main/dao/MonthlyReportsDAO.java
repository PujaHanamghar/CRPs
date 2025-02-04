package in.crm.main.dao;

import in.crm.main.master.MonthlyReportsMaster;
import org.springframework.data.repository.CrudRepository;

public interface MonthlyReportsDAO extends CrudRepository<MonthlyReportsMaster,Integer> {


}
