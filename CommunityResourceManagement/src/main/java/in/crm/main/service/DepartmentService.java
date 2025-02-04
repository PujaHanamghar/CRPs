package in.crm.main.service;

import in.crm.main.master.DepartmentMaster;

import java.util.List;



public interface DepartmentService {

	public List<DepartmentMaster> getAllDepartmentService();
	public DepartmentMaster getDepartmentServiceById(Integer departmentId);
	public Boolean addDepartmentService(DepartmentMaster departmentMaster);
	public Boolean updateDepartmentService(DepartmentMaster departmentMaster);
	public Boolean deleteDepartment(DepartmentMaster departmentMaster);
}
