package in.crm.main.service;


import in.crm.main.dao.MonthlyReportsDAO;
import in.crm.main.master.LeaveManagementMaster;
import in.crm.main.master.MonthlyReportsMaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MonthlyReportsService {


public Boolean addMonthlyReportService(MonthlyReportsMaster monthlyReportsMaster);
public Boolean updateMonthlyReportService(MonthlyReportsMaster monthlyReportsMaster);
public Boolean deleteMonthlyReportService(MonthlyReportsMaster monthlyReportsMaster);

public MonthlyReportsMaster getMonthlyReportService(Integer reportId);
public List<MonthlyReportsMaster> getAllMonthlyReportService();


}
