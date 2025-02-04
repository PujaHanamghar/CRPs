package in.crm.main.service;

import in.crm.main.master.PotentialTraitsMaster;

import java.util.List;


public interface PotentialTraitsService {

	public List<PotentialTraitsMaster> getAllPotentialTraitsService();
	public PotentialTraitsMaster getPotentialTraitsServiceById(Integer pTraitsId);
	public Boolean addPotentialTraitsService(PotentialTraitsMaster potentialTraitsMaster);
	public Boolean updatePotentialTraitsService(PotentialTraitsMaster potentialTraitsMaster);
	public Boolean deletePotentialTraits(PotentialTraitsMaster potentialTraitsMaster);
}
