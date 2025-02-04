package in.crm.main.serviceImpl;

import in.crm.main.dao.MonthlyReportsDAO;
import in.crm.main.master.LeaveManagementMaster;
import in.crm.main.master.MonthlyReportsMaster;
import in.crm.main.service.MonthlyReportsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MonthlyReportsServiceImpl implements MonthlyReportsService {

    private static final Logger logger= LogManager.getLogger(MonthlyReportsServiceImpl.class);
    @Autowired
    MonthlyReportsDAO monthlyReportsDAO;


    @Override
    public Boolean addMonthlyReportService(MonthlyReportsMaster monthlyReportsMaster) {
        monthlyReportsDAO.save(monthlyReportsMaster);
        return true;
    }

    @Override
    public Boolean updateMonthlyReportService(MonthlyReportsMaster monthlyReportsMaster) {
        try {
            logger.info("In updateMonthlyReportService");
            monthlyReportsDAO.findById(monthlyReportsMaster.getReportId());
            monthlyReportsMaster.setUserId(monthlyReportsMaster.getUserId());
            monthlyReportsMaster.setReportMonth(monthlyReportsMaster.getReportMonth());
            monthlyReportsMaster.setReportDate(monthlyReportsMaster.getReportDate());
            monthlyReportsMaster.setRemarks(monthlyReportsMaster.getRemarks());
            monthlyReportsMaster.setStatus(monthlyReportsMaster.getStatus());

             monthlyReportsDAO.save(monthlyReportsMaster);

            logger.info("In updateMonthlyReportService");
            return true;
        } catch (RuntimeException e) {
            logger.info("CRP: " + e.getMessage(), e);
            return false;
        }

    }

    @Override
    public Boolean deleteMonthlyReportService(MonthlyReportsMaster monthlyReportsMaster) {
        try {
            logger.info("In deleteMonthlyReportService");
            monthlyReportsDAO.findById(monthlyReportsMaster.getReportId());
            monthlyReportsDAO.delete(monthlyReportsMaster);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }

    }

    @Override
    public MonthlyReportsMaster getMonthlyReportService(Integer reportId) {
        try {
            logger.info("In getMonthlyReportService");
            MonthlyReportsMaster monthlyReportsMaster=monthlyReportsDAO.findById(reportId).orElse(null);

            logger.info("Out of getMonthlyReportService");
            return monthlyReportsMaster;
        }
        catch (Exception e)
        {
            logger.info("CRP:"+e.getMessage(),e);
            return null;
        }

    }

    @Override
    public List<MonthlyReportsMaster> getAllMonthlyReportService() {
        List<MonthlyReportsMaster> allMonthlyReportMaster = new ArrayList<>();;

        try {
            logger.info(" In getAllMonthlyReportService");
            allMonthlyReportMaster=(List<MonthlyReportsMaster>) monthlyReportsDAO.findAll();
          ;
            logger.info(" Out Of getAllMonthlyReportService");
        }
        catch (Exception e)
        {
            logger.error("CRP: "+e.getMessage());
        }
        return allMonthlyReportMaster;
    }
    }
