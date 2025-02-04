package in.crm.main.service;

import in.crm.main.master.NoticePeriodMaster;

import java.util.List;




public interface NoticePeriodService {

	public List<NoticePeriodMaster> getAllNoticePeriodService();
	public NoticePeriodMaster getNoticePeriodServiceById(Integer noticePolicyId);
	public Boolean addNoticePeriodService(NoticePeriodMaster noticePeriodMaster);
	public Boolean updateNoticePeriodService(NoticePeriodMaster noticePeriodMaster);
	public Boolean deleteNoticePeriod(NoticePeriodMaster noticePeriodMaster);

}
