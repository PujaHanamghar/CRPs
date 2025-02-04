package in.crm.main.dao;

import in.crm.main.master.LeaveManagementMaster;

import org.springframework.data.repository.CrudRepository;

public interface LeaveManagementDAO extends CrudRepository<LeaveManagementMaster,Integer> {

}
