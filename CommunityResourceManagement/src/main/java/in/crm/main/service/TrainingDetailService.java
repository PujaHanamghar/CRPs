package in.crm.main.service;

import in.crm.main.master.TrainingDetailMaster;

import java.util.List;



public interface TrainingDetailService {

	public List<TrainingDetailMaster> getAllTrainingDetailService();
	public TrainingDetailMaster getTrainingDetailServiceById(Integer trainingId);
	public Boolean addTrainingDetailService(TrainingDetailMaster trainingDetailMaster);
	public Boolean updateTrainingDetailService(TrainingDetailMaster trainingDetailMaster);
	public Boolean deleteTrainingDetail(TrainingDetailMaster trainingDetailMaster);
}
