package in.crm.main.service;
	import java.util.List;

import in.crm.main.master.AppraisalsMaster;

	public interface AppraisalsService {
	    Boolean addAppraisals(AppraisalsMaster appraisalsMaster);
	    Boolean updateAppraisals(AppraisalsMaster appraisalsMaster);
	    Boolean deleteAppraisals(Integer appraisalsId);
	    AppraisalsMaster getAppraisalsById(Integer appraisalsId);
	    List<AppraisalsMaster> getAllAppraisals();
	}


