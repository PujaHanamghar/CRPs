package in.crm.main.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import in.crm.main.dao.TrainingDetailDao;
import in.crm.main.master.TrainingDetailMaster;
import in.crm.main.service.TrainingDetailService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class TrainingDetailserviceImpl implements TrainingDetailService {
		
		private static final Logger logger = LogManager.getLogger(TrainingDetailserviceImpl.class);
		
		@Autowired
		private TrainingDetailDao trDetailDao;

		@Override
		public List<TrainingDetailMaster> getAllTrainingDetailService() {
			List<TrainingDetailMaster> alltrainingDetails = new ArrayList<>();
			try {
				logger.info("In getAllTrainingDetailService");
				alltrainingDetails = (List<TrainingDetailMaster>) trDetailDao.findAll();
				logger.info("Out of getAllTrainingDetailService");
			}catch (Exception e) {
				logger.error("CRP:" + e.getMessage(), e);
			}
			return alltrainingDetails;
		
		}

		@Override
		public TrainingDetailMaster getTrainingDetailServiceById(Integer trainingId) {
			try {
				logger.info("In getTrainingDetailService");
				TrainingDetailMaster trainingMaster = trDetailDao.findById(trainingId).orElse(null);
				logger.info("Out of getTrainingDetailService");
				return trainingMaster;
			}catch (Exception e) {
				logger.error("CRP:" + e.getMessage(),e);
			}
			return null;
		}

		@Override
		public Boolean addTrainingDetailService(TrainingDetailMaster trainingDetailMaster) {
			try {
				logger.info("In addService");
				trDetailDao.save(trainingDetailMaster);
				
			  return true;
			} catch(Exception e){
				logger.info("CRP:" + e.getMessage(),e);
				return false;
			}
		}

		@Override
		public Boolean updateTrainingDetailService(TrainingDetailMaster trainingDetailMaster) {
			 try {
			        logger.info("In updateService");
			        TrainingDetailMaster training = trDetailDao.findById(trainingDetailMaster.getTrainingId())
			            .orElseThrow(() -> new RuntimeException("TrainingDetail not found"));

			        training.setTrainingName(trainingDetailMaster.getTrainingName());
			        training.setTrainingStartDate(trainingDetailMaster.getTrainingStartDate());
			        training.setTrainingEndDate(trainingDetailMaster.getTrainingEndDate());
			        training.setTrainingProvider(trainingDetailMaster.getTrainingProvider());
			        training.setRemark(trainingDetailMaster.getRemark());

			        trDetailDao.save(training);
			        logger.info("Out of UpdateTrainingDetailService");
			        return true;
			    } catch (Exception e) {
			        logger.error("CRP: " + e.getMessage(), e);
			        return false;
			    }
		}

		@Override
		public Boolean deleteTrainingDetail(TrainingDetailMaster trainingDetailMaster) {
			try {
				logger.info("In UpdateService");
				TrainingDetailMaster training = trDetailDao.findById(trainingDetailMaster.getTrainingId()).orElseThrow(() -> new RuntimeException("TrainingDetail not found"));
				trDetailDao.delete(training);
				logger.info("Out of deleteTrainingDetailService");
				return true;
			}catch (Exception e) {
				logger.error("CRP:" +e.getMessage(),e);
				return false;
			}
		}

}
