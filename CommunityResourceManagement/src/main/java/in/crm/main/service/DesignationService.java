package in.crm.main.service;

import in.crm.main.master.DesignationMaster;

import java.util.List;

public interface DesignationService  {


    public Boolean addDesignationService(DesignationMaster designationMaster);
    public Boolean updateDesignationService(DesignationMaster designationMaster);
    public Boolean deleteDesignationService(DesignationMaster designationMaster);
    public DesignationMaster getDesignationService(Integer designationId);
    public List<DesignationMaster> getAllDesignationService();
}
