package in.crm.main.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import in.crm.main.dao.PotentialTraitsDao;
import in.crm.main.master.PotentialTraitsMaster;
import in.crm.main.service.PotentialTraitsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PotentialTraitsServiceImpl implements PotentialTraitsService {

	private static final Logger logger = LogManager.getLogger(PotentialTraitsServiceImpl.class);

	@Autowired
	private PotentialTraitsDao potentialTraitsDao;

	@Override
	public List<PotentialTraitsMaster> getAllPotentialTraitsService() {
		List<PotentialTraitsMaster> allPTraits = new ArrayList<>();
		try {
			logger.info("In GetAllPtentialtraitsService");
			allPTraits = (List<PotentialTraitsMaster>) potentialTraitsDao.findAll();
			logger.info("Out of GetAllpotentialtraitsService");
		} catch (Exception e) {
			logger.error("CRP:" + e.getMessage(), e);
		}
		return allPTraits;
	}

	@Override
	public PotentialTraitsMaster getPotentialTraitsServiceById(Integer pTraitsId) {
		try {
			logger.info("In getpotenstialtraitsService");
			PotentialTraitsMaster ptraits = potentialTraitsDao.findById(pTraitsId).orElse(null);
			logger.info("Out of getPotentialTraitsService");
			return ptraits;
		} catch (Exception e) {
			logger.error("CRP:" + e.getMessage(), e);
		}
		return null;
	}

	@Override
	public Boolean addPotentialTraitsService(PotentialTraitsMaster potentialTraitsMaster) {
		try {
			logger.info("In addService");
			potentialTraitsDao.save(potentialTraitsMaster);
			return true;
		} catch (Exception e) {
			logger.info("CRP:" + e.getMessage(), e);
			return false;
		}
	}

	@Override
	public Boolean updatePotentialTraitsService(PotentialTraitsMaster potentialTraitsMaster) {
		try {
			logger.info("In updateService");
			PotentialTraitsMaster ptrait = potentialTraitsDao.findById(potentialTraitsMaster.getpTraitId())
					.orElseThrow(() -> new RuntimeException("Potentailtrait not found"));

			ptrait.setpTraitName(potentialTraitsMaster.getpTraitName());
			ptrait.setpDescription(potentialTraitsMaster.getpDescription());
			ptrait.setpMeasurementCriteria(potentialTraitsMaster.getpMeasurementCriteria());
			ptrait.setWeightage(potentialTraitsMaster.getWeightage());
			ptrait.setpScoreRange(potentialTraitsMaster.getpScoreRange());
			ptrait.setpTraitType(potentialTraitsMaster.getpTraitType());

			potentialTraitsDao.save(ptrait);
			logger.info("Out Of UpdatePotentialtraitsService");
			return true;
		} catch (Exception e) {
			logger.error("CRP:" + e.getMessage(), e);
			return false;
		}
	}

	@Override
	public Boolean deletePotentialTraits(PotentialTraitsMaster potentialTraitsMaster) {
		try {
			logger.info("In DeleteService");
			PotentialTraitsMaster ptraits = potentialTraitsDao.findById(potentialTraitsMaster.getpTraitId())
					.orElseThrow(() -> new RuntimeException("PtentialTraits not fount"));
			potentialTraitsDao.delete(ptraits);
			logger.info("Out of DeletePotentialtraitsService");
			return true;
		} catch (Exception e) {
			logger.error("CRP:" + e.getMessage(), e);
			return false;
		}

	}


}
