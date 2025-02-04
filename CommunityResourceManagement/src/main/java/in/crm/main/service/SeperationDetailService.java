package in.crm.main.service;

import java.util.List;

import in.crm.main.master.PostingHistoryMaster;
import in.crm.main.master.SeperationDetailMaster;

public interface SeperationDetailService 
{
	 public Boolean addSeperationDetailService(SeperationDetailMaster seperationDetailMaster);
	 public Boolean updateSeperationDetailService(SeperationDetailMaster seperationDetailMaster);
	 public Boolean deleteSeperationDetailService(SeperationDetailMaster seperationDetailMaster);
	    
	    
	    public SeperationDetailMaster getSeperationDetailService(Integer seperationId);
	    public List<SeperationDetailMaster> getAllSeperationDetailService();
	
}
