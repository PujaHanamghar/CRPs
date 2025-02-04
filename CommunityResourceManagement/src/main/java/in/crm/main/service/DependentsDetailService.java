package in.crm.main.service;

import in.crm.main.master.DependentsDetailMaster;
import in.crm.main.master.DesignationMaster;

import java.util.List;

public interface DependentsDetailService {
    public Boolean addDependentsDetailService(DependentsDetailMaster dependentsDetailMaster);
    public Boolean updateDependentsDetailService(DependentsDetailMaster dependentsDetailMaster);
    public Boolean deleteDependentsDetailService(DependentsDetailMaster dependentsDetailMaster);

    public DependentsDetailMaster getDependentsDetailService(Integer dependentId);
    public List<DependentsDetailMaster> getAllDependentsDetailService();

}
