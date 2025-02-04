package in.crm.main.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import in.crm.main.dao.NoticePeriodDao;
import in.crm.main.master.NoticePeriodMaster;
import in.crm.main.service.NoticePeriodService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class NoticePeriodServiceImpl implements NoticePeriodService {

	private static final Logger logger = LogManager.getLogger(DepartmentServiceImpl.class);

	@Autowired
	private NoticePeriodDao noticePeriodDao;

	@Override
	public List<NoticePeriodMaster> getAllNoticePeriodService() {
		List<NoticePeriodMaster> allPeriod = new ArrayList<>();
		try {
			logger.info("In getAllNoticePeriodService");
			allPeriod = (List<NoticePeriodMaster>) noticePeriodDao.findAll();
			logger.info("Out of getAllNoticePeriodService");
		} catch (Exception e) {
			logger.error("CRP:" + e.getMessage(), e);
		}
		return allPeriod;
	}

	@Override
	public NoticePeriodMaster getNoticePeriodServiceById(Integer noticePolicyId) {
		try {
			logger.info("In getNoticePeriodService");
			NoticePeriodMaster notice = noticePeriodDao.findById(noticePolicyId).orElse(null);
			logger.info("Out of getNoticePeriodService");
			return notice;
		} catch (Exception e) {
			logger.error("CRP:" + e.getMessage(), e);
		}
		return null;
	}

	@Override
	public Boolean addNoticePeriodService(NoticePeriodMaster noticePeriodMaster) {
		try {
			logger.info("In addService");
			noticePeriodDao.save(noticePeriodMaster);

			return true;
		} catch (Exception e) {
			logger.info("CRP:" + e.getMessage(), e);
			return false;
		}
	}

	@Override
	public Boolean updateNoticePeriodService(NoticePeriodMaster noticePeriodMaster) {
		try {
			logger.info("In updateService");
			NoticePeriodMaster notice = noticePeriodDao.findById(noticePeriodMaster.getNoticePolicyId())
					.orElseThrow(() -> new RuntimeException("NoticePeriod not found"));

			notice.setNoticePeriodDate(noticePeriodMaster.getNoticePeriodDate());
			notice.setNoticePeriodStatus(noticePeriodMaster.getNoticePeriodStatus());
			notice.setDepartmentId(noticePeriodMaster.getDepartmentId());
			notice.setRoleId(noticePeriodMaster.getRoleId());

			noticePeriodDao.save(notice);
			logger.info("Out of updateNoticePeriodService");
			return true;
		} catch (Exception e) {
			logger.error("CRP: " + e.getMessage(), e);
			return false;
		}
	}

	@Override
	public Boolean deleteNoticePeriod(NoticePeriodMaster noticePeriodMaster) {
		try {
			logger.info("In DeleteService");
			NoticePeriodMaster notice = noticePeriodDao.findById(noticePeriodMaster.getNoticePolicyId())
					.orElseThrow(() -> new RuntimeException("NoticePeriod not found"));
			noticePeriodDao.delete(notice);
			logger.info("Out of deleteNoticePeriodService");
			return true;
		} catch (Exception e) {
			logger.error("CRP:" + e.getMessage(), e);
			return false;
		}
	}
}
