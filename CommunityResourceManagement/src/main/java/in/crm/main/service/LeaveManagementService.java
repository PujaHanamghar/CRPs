package in.crm.main.service;

import in.crm.main.master.HonorariumHistoryMaster;
import in.crm.main.master.LeaveManagementMaster;

import java.util.List;

public interface LeaveManagementService {


    public Boolean addLeaveManagementService(LeaveManagementMaster leaveManagementMaster);
    public Boolean updateLeaveManagementService(LeaveManagementMaster leaveManagementMaster);
    public Boolean deleteLeaveManagementService(LeaveManagementMaster leaveManagementMaster);

    public LeaveManagementMaster getLeaveManagementService(Integer leaveId);
    public List<LeaveManagementMaster> getAllLeaveManagementService();

}
