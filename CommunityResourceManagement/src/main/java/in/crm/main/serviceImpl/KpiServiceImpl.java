package in.crm.main.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import in.crm.main.dao.KpiDao;
import in.crm.main.master.KpiMaster;
import in.crm.main.service.KpiService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class KpiServiceImpl implements KpiService {
	
	private static final Logger logger = LogManager.getLogger(KpiServiceImpl.class);

	@Autowired
	private KpiDao kpiDao;
	
	@Override
	public List<KpiMaster> getAllKpiService() {
		List<KpiMaster> allKpis = new ArrayList<>();
		try {
			logger.info("In getAllKpiService");
			allKpis = (List<KpiMaster>) kpiDao.findAll();
			logger.info("Out of getAllKpiService");
		}catch (Exception e) {
			logger.error("CRP:" + e.getMessage(), e);
		}
		return allKpis;
		
	}

	@Override
	public KpiMaster getKpiServiceById(Integer kpiId) {
		try {
			logger.info("In geKpiService");
			KpiMaster kpiMaster = kpiDao.findById(kpiId).orElse(null);
			logger.info("Out of getKpiService");
			return kpiMaster;
		}catch (Exception e) {
			logger.error("CRP:" + e.getMessage(),e);
		}
		return null;
	}

	@Override
	public Boolean addKpiService(KpiMaster kpiMaster) {
		try {
			logger.info("In addService");
			kpiDao.save(kpiMaster);
			
		  return true;
		} catch(Exception e){
			logger.info("CRP:" + e.getMessage(),e);
			return false;
		}
	}

	@Override
	public Boolean updateKpiService(KpiMaster kpiMaster) {
		try {
	        logger.info("In updateService");
	        KpiMaster kpi = kpiDao.findById(kpiMaster.getKpiId())
	            .orElseThrow(() -> new RuntimeException("KPI not found"));

	        kpi.setKpiName(kpiMaster.getKpiName());
	        kpi.setKpiDesc(kpiMaster.getKpiDesc());
	        kpi.setKpiMeasurementCriteria(kpiMaster.getKpiMeasurementCriteria());
	        kpi.setWeightage(kpiMaster.getWeightage());
	        kpi.setTargetValue(kpiMaster.getTargetValue());
	        kpi.setDeadline(kpiMaster.getDeadline());
	        kpi.setCategory(kpiMaster.getCategory());

	        kpiDao.save(kpi);
	        logger.info("Out of UpdateKpiService");
	        return true;
	    } catch (Exception e) {
	        logger.error("CRP: " + e.getMessage(), e);
	        return false;
	    }
	}

	@Override
	public Boolean deleteKpi(KpiMaster kpiMaster) {
		try {
			logger.info("In DeleteService");
			KpiMaster kpi = kpiDao.findById(kpiMaster.getKpiId()).orElseThrow(() -> new RuntimeException("KPI not found"));
			kpiDao.delete(kpi);
			logger.info("Out of deleteKpiService");
			return true;
		}catch (Exception e) {
			logger.error("CRP:" +e.getMessage(),e);
			return false;
		}
	
	}


}
