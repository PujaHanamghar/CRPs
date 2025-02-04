package in.crm.main.service;

import in.crm.main.master.SeperationTypeMaster;

import java.util.List;





public interface SeperationtypeService {

	public List<SeperationTypeMaster> getAllSepTypeService();
	public SeperationTypeMaster getSepTypeServiceById(Integer sepTypeId);
	public Boolean addSepTypeService(SeperationTypeMaster seperationTypeMaster);
	public Boolean updateSepTypeService(SeperationTypeMaster seperationTypeMaster);
	public Boolean deleteSepType(SeperationTypeMaster seperationTypeMaster);

}
