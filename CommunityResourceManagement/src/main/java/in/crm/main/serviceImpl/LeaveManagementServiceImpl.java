package in.crm.main.serviceImpl;

import in.crm.main.dao.LeaveManagementDAO;

import in.crm.main.master.HonorariumHistoryMaster;
import in.crm.main.master.LeaveManagementMaster;
import in.crm.main.service.LeaveManagementService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LeaveManagementServiceImpl implements LeaveManagementService {

    private static final Logger logger= LogManager.getLogger(LeaveManagementServiceImpl.class);
    @Autowired
    LeaveManagementDAO leaveManagementDAO;

    @Override
    public Boolean addLeaveManagementService(LeaveManagementMaster leaveManagementMaster) {
        leaveManagementDAO.save(leaveManagementMaster);
        return true;
         }


    @Override
    public Boolean updateLeaveManagementService(LeaveManagementMaster leaveManagementMaster) {
        try {
            logger.info("In updateLeaveManagementService");
            leaveManagementDAO.findById(leaveManagementMaster.getLeaveId());
            leaveManagementMaster.setUserId(leaveManagementMaster.getLeaveId());
            leaveManagementMaster.setLeaveType(leaveManagementMaster.getLeaveType());
            leaveManagementMaster.setStartDate(leaveManagementMaster.getStartDate());
            leaveManagementMaster.setEndDate(leaveManagementMaster.getEndDate());
            leaveManagementMaster.setStatus(leaveManagementMaster.getStatus());
            
            leaveManagementMaster.setAppliedDate(leaveManagementMaster.getAppliedDate());
            leaveManagementMaster.setApprovedBy(leaveManagementMaster.getApprovedBy());
            leaveManagementMaster.setReason(leaveManagementMaster.getReason());
            
            
            
             leaveManagementDAO.save(leaveManagementMaster);

            logger.info("In updateLeaveManagementService");
            return true;
        } catch (RuntimeException e) {
            logger.info("CRP: " + e.getMessage(), e);
            return false;
        }

    }

    @Override
    public Boolean deleteLeaveManagementService(LeaveManagementMaster leaveManagementMaster) {
        try {
            logger.info("In deleteLeaveManagementService");
            leaveManagementDAO.findById(leaveManagementMaster.getLeaveId());
            leaveManagementDAO.delete(leaveManagementMaster);
             return true;
        }
        catch (Exception e)
        {
            return false;
        }

    }

    @Override
    public LeaveManagementMaster getLeaveManagementService(Integer leaveId) {
        try {
            logger.info("In getLeaveManagementService");
            LeaveManagementMaster leaveManagementMaster=leaveManagementDAO.findById(leaveId).orElse(null);

            logger.info("Out of getLeaveManagementService");
            return leaveManagementMaster;
        }
        catch (Exception e)
        {
            logger.info("CRP:"+e.getMessage(),e);
            return null;
        }

    }

    @Override
    public List<LeaveManagementMaster> getAllLeaveManagementService() {
        List<LeaveManagementMaster> allLeaveManagementMaster = new ArrayList<>();;

        try {
            logger.info(" In getAllLeaveManagementService");
            allLeaveManagementMaster=(List<LeaveManagementMaster>) leaveManagementDAO.findAll();
            logger.info(" Out Of getAllLeaveManagementService");
        }
        catch (Exception e)
        {
            logger.error("CRP: "+e.getMessage());
        }
        return allLeaveManagementMaster;
    }
    }

